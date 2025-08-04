package com.lld.refactor_martin;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class Invoice {
    String customer;
    List<Performance> performances;
}

class Performance {
    String playID;
    int audience;
}

class Play {
    String name;
    String type;
}

public class StatementGenerator {

    public static String statement(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder("Statement for " + invoice.customer + "\n");

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : invoice.performances) {
            Play play = plays.get(perf.playID);
            int thisAmount = 0;

            switch (play.type) {
                case "tragedy":
                    thisAmount = 40000;
                    if (perf.audience > 30) {
                        thisAmount += 1000 * (perf.audience - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (perf.audience > 20) {
                        thisAmount += 10000 + 500 * (perf.audience - 20);
                    }
                    thisAmount += 300 * perf.audience;
                    break;
                default:
                    throw new RuntimeException("Unknown type: " + play.type);
            }

            // add volume credits
            volumeCredits += Math.max(perf.audience - 30, 0);
            if ("comedy".equals(play.type)) {
                volumeCredits += Math.floorDiv(perf.audience, 5);
            }

            // print line for this order
            result.append(String.format("  %s: %s (%d seats)\n", play.name, format.format(thisAmount / 100.0), perf.audience));
            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(format.format(totalAmount / 100.0)).append("\n");
        result.append("You earned ").append(volumeCredits).append(" credits\n");

        return result.toString();
    }
}
