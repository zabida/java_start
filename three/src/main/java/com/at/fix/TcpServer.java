package com.at.fix;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TcpServer extends Thread{
    private ServerSocket serverSocket;

    public TcpServer() {}
    public TcpServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void run(){
        while (true) {
            try {
                System.out.println("等待远程连接, 端口号：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址 : " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接：" + server.getLocalSocketAddress() + "\nbye");
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket time out");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TcpServer tcpServer = new TcpServer(1234);
        tcpServer.start();
    }
}
