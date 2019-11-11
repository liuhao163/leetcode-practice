package com.ericliu.practice.toy.redis;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @Author: liuhaoeric
 * Create time: 2019/10/08
 * Description:
 */
public class RedisBit {

    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis("10.96.94.2", 6379);
        Boolean value = jedis.getbit("lhbitmap", 10);
        System.out.println(value);

        String v = jedis.get("lhbitmap");
        Long c = jedis.bitcount("lhbitmap");
        System.out.println(c);
        Long pos = jedis.bitpos("lhbitmap", true);
        System.out.println(pos);


    }
}
