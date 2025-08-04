package com.lld;

import com.lld.decorator.Beverage;
import com.lld.decorator.Expresso;
import com.lld.decorator.Mocha;
import com.lld.decorator.Soy;
import com.lld.observer.*;
import com.lld.strategy.Duck;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Duck shreya=new Duck();
        shreya.setValue(10);
        System.out.println(shreya.getValue());
        implementDecorator(shreya);
        System.out.println(shreya.getValue());
    }



    public static void implementDecorator(Duck shreya){
//        shreya=new Duck();
        shreya.setValue(20);
        //Expresso with double mocha and soy

        Beverage beverage=new Expresso();
        beverage=new Mocha(beverage);
        beverage=new Mocha(beverage);
        beverage=new Soy(beverage);

        System.out.println(beverage.cost());
    }


    public static void implementObserver(){
        Weather weather=new Weather();
        Observer observer1=new FirstDis();
        weather.subscribe(observer1);
        Observer observer2=new SecondDis();
        weather.subscribe(observer2);
        Observer observer3=new ThirdDis();
        weather.subscribe(observer3);

        weather.update(32,40,100);
    }
}
