package cn.yihua.nacostest.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSocket {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(9977);
        while (true){
        Socket socket = serverSocket.accept();
        executorService.execute(()->{
            try {
                socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String string;
                while ((string = bufferedReader.readLine()) != null) {
                    System.out.println(string);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        }


    }
}
