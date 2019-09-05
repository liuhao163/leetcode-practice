package com.ericliu.practice.toy.io;


import java.io.IOException;

/**
 * @Author: liuhaoeric
 * Create time: 2019/09/03
 * Description:
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        BigFile bigFile=new BigFile("/Users/didi/Desktop/mmp.txt",1024*100);
        bigFile.append("liuhao".getBytes());
        bigFile.append("\n".getBytes());
        bigFile.append("lijunfeng".getBytes());
    }
}
