package cn.yihua.nacostest.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7890);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        int a = inputStream.read();
        if(a==-1){
            return;
        }
        int b = inputStream.read();
        if(b==-1){
            return;
        }
        int c = inputStream.read();
        if(c==-1){
            return;
        }
        int len = (a<<16)+(b<<8)+c;
        byte[] buff = new byte[len];
        inputStream.read(buff,0,len);
        String str = new String(buff);
        System.out.println("result:"+str);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("world".getBytes());
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
