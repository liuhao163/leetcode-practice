package com.ericliu.practice.toy.io;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Author: liuhaoeric
 * Create time: 2019/09/16
 * Description:
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer orgBuffer = ByteBuffer.allocateDirect(1024);
        orgBuffer.put("liuhao".getBytes());
        System.out.println("orgBuffer init allocate =" + orgBuffer);


        orgBuffer.flip();

        ByteBuffer newBuffer = orgBuffer.slice();
        System.out.println("newBuffer init slice =" + newBuffer);

        System.out.println("============");
        byte[] stringNew = new byte[newBuffer.limit()];
        newBuffer.get(stringNew);
        System.out.println("read new buffer " + new String(stringNew));
        newBuffer.clear();
        newBuffer.put("lzh".getBytes());


//        orgBuffer.flip();
        byte[] stringOrg = new byte[orgBuffer.limit()];
        orgBuffer.get(stringOrg);
        System.out.println("read org buffer " + new String(stringOrg));

        newBuffer.clear();
        newBuffer.put("zuihao".getBytes());
        newBuffer.flip();
        stringNew = new byte[newBuffer.limit()];
        newBuffer.get(stringNew);
        System.out.println("read new buffer " + new String(stringNew));


        System.out.println("newBuffer after flip=" + newBuffer);
        System.out.println("orgBuffer after flip=" + orgBuffer);
    }
}
