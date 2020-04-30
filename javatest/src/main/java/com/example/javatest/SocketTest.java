package com.example.javatest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketTest {
    public static void main(String[] args) {
        String[] arr = new String[]{
                "54921850",
                "946E1D50",
                "34A80D50",
                "00FF2306",
                "B0AA3006",
                "30D93706"};
        for (String str:arr) {
            testSocket(str);
        }

    }

    public static void testSocket(String deviceCode){
        try {
            String codeStr = "4920200430105500|UA"+deviceCode+"|UBC2243A001234714F2E170001|CP1,50e5493498e4|";
            //链接Socket
            Socket socket = new Socket("39.101.141.244", 9000);
            System.out.println("socket is connect = " + socket.isConnected());
            //判断是否连接成功
            if (socket.isConnected()) {
                //如果连接成功发送一条示例
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(codeStr.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                //获取服务器返回的数据
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String response = bufferedReader.readLine();
                System.out.println("response result = " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception = " + e.getMessage());
        }
    }
}
