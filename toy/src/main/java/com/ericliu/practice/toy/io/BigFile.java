package com.ericliu.practice.toy.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: liuhaoeric
 * Create time: 2019/09/05
 * Description:
 */
public class BigFile {
    private int capacity;
    private AtomicInteger wrotePosition = new AtomicInteger(0);
    private FileChannel fileChannel;
    private MappedByteBuffer mappedByteBuffer;

    public BigFile(String filePath, int capacity) throws IOException {
        this.capacity = capacity;
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        fileChannel = randomAccessFile.getChannel();
        mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, capacity);
    }

    public void append(byte[] content) {
        mappedByteBuffer.put(content, 0, content.length);
        int p = this.wrotePosition.addAndGet(content.length);
    }

}
