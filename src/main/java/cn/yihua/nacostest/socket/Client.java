package cn.yihua.nacostest.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",7890);
        OutputStream outputStream = socket.getOutputStream();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<10000;i++){
            sb.append("aou");
        }
        byte[] data = sb.toString().getBytes();
        int a =data.length;
        int b = a>>16;
        int c = a - (b<<16);
        int d = c>>8;
        int e = c-(d<<8);
        outputStream.write(b);
        outputStream.write(d);
        outputStream.write(e);
        outputStream.write(data);
        outputStream.flush();
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len ;
        while ((len=inputStream.read(buff))!=-1){
            baos.write(buff,0,len);
        }
        System.out.println("server result:"+new String(baos.toByteArray()));
        inputStream.close();
        socket.close();
    }
}
