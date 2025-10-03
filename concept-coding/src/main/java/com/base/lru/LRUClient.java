package com.base.lru;

/**
 * Hello world!
 *
 */
public class LRUClient
{
    public static void main( String[] args )
    {
        LRUMain<String, String> client=new LRUMain<>(3);
        client.put("1","A");
        client.put("2","B");
        client.put("3","C");
        client.put("4","D");
        System.out.println(client.get("4"));
    }
}
