package com.zzb;

import com.suning.mpmp.pptv.utils.Constant;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNio {
    private static long TIME_STEP = 1;
    private static int SIZE_STEP = 30;

    public static void main(String[] args) throws Exception {
        testNio();
        testBio();
    }

    public static void testBio(){
        StopWatch watch = new StopWatch();
        watch.start();
        // 从本地服务器读取文件
        // IO流
        BufferedInputStream bufferedInputStream = null;
        BufferedReader bufferedReader = null;
        FileInputStream fileInput = null;
        InputStreamReader inputStream = null;

        /** start update by tmz 20160510 **/
        try {
            /** 2.流对象读取文件 */
            fileInput = new FileInputStream(new File("D:\\testBio.txt"));
            bufferedInputStream = new BufferedInputStream(fileInput);
            inputStream = new InputStreamReader(bufferedInputStream, Constant.ENCODE_GBK);
            bufferedReader = new BufferedReader(inputStream, SIZE_STEP);// 1M缓存
            long count = 0;
            while (bufferedReader.ready()) {
                bufferedReader.readLine();
                count++;
//                System.out.println("bio：" + lineContent);
            }
            System.out.println("总数："+count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bufferedInputStream);
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(fileInput);
            IOUtils.closeQuietly(inputStream);
        }

        System.out.println("bio耗时：" + watch.getTime()/TIME_STEP);
    }

    // nio
    public static void testNio() throws Exception{
        StopWatch watch = new StopWatch();
        watch.start();

        //指定读取文件所在位置
        File file = new File("D:\\testNio.txt");
        FileChannel fileChannel = new RandomAccessFile(file,"r").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        //使用temp字节数组用于存储不完整的行的内容
        byte[] temp = new byte[0];
        while(fileChannel.read(byteBuffer) != -1) {
            byte[] bs = new byte[byteBuffer.position()];
            byteBuffer.flip();
            byteBuffer.get(bs);
            byteBuffer.clear();
            int startNum=0;
            //判断是否出现了换行符，注意这要区分LF-\n,CR-\r,CRLF-\r\n,这里判断\n
            boolean isNewLine = false;
            for(int i=0;i < bs.length;i++) {
                if(bs[i] == 10) {
                    isNewLine = true;
                    startNum = i;
                }
            }

            if(isNewLine) {
                //如果出现了换行符，将temp中的内容与换行符之前的内容拼接
                byte[] toTemp = new byte[temp.length+startNum];
                System.arraycopy(temp,0,toTemp,0,temp.length);
                System.arraycopy(bs,0,toTemp,temp.length,startNum);
                new String(toTemp);

                //将换行符之后的内容(去除换行符)存到temp中
                temp = new byte[bs.length-startNum-1];
                System.arraycopy(bs,startNum+1,temp,0,bs.length-startNum-1);
                //使用return即为单行读取，不打开即为全部读取
//                return;
            } else {
                //如果没出现换行符，则将内容保存到temp中
                byte[] toTemp = new byte[temp.length + bs.length];
                System.arraycopy(temp, 0, toTemp, 0, temp.length);
                System.arraycopy(bs, 0, toTemp, temp.length, bs.length);
                temp = toTemp;
            }
        }
        if(temp.length>0) {
            System.out.println(new String(temp));
        }

        System.out.println("nio耗时：" + watch.getTime()/TIME_STEP);
    }
}
