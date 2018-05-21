package cn.zd.netty.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 15-AK on 2018/5/20.
 */
public class TraditionalSocketDemo01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(777);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("=========继续等待客户端输入=======");
                InputStream inputStream = socket.getInputStream();
                System.out.println("==========客户端有输入==============");

                byte[] b = new byte[1024];
                while (true) {
                    int length = inputStream.read(b);
                    if (length != -1) {
                        String info = new String(b, 0, length, "UTF-8");
                        System.out.println("==========客户端有输入==============info:" + info);
                    } else {
                        System.out.println("==========客户端有输入完毕=============");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }
    }
}
