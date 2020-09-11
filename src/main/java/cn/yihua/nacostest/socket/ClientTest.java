package cn.yihua.nacostest.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) throws IOException {
        Socket socket  = new Socket("127.0.0.1",9977);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);
        while (true){
            String str = scanner.nextLine();
            if("exit".equals(str)){
                break;
            }
            str+="\n";
            bufferedWriter.write(str);
            bufferedWriter.flush();
        }
        socket.close();
    }
}
