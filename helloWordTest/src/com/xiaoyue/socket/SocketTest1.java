package com.xiaoyue.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest1 {

	public static void main(String[] args) throws Exception {
//			Test1();
			Scanner sc = new Scanner(System.in);//创建键盘输入对象。
			DatagramSocket ds = new DatagramSocket();//创建socket套接字
			while(true) {//创建循环不断接收键盘录入，发送数据
				String message = sc.nextLine();//读取一行数据
				if(message.equals("exit")) {//如果输入的是exit
					break;//就跳出循环。
				}else {
					DatagramPacket dp = new DatagramPacket(message.getBytes(), //创建数据包对象，封装要发送的数据及端口，地址
							message.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
					ds.send(dp);//将包发送出去。
				}
			}
			ds.close();//关闭套接字
	
	}

	public static void Test1() throws SocketException, UnknownHostException, IOException {
		String message = "你好！";//要发送的数据
		DatagramSocket ds = new DatagramSocket();//创建socket套接字
		DatagramPacket dp = new DatagramPacket(message.getBytes(), //创建数据包对象，封装要发送的数据及端口，地址
				message.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
		ds.send(dp);//将包发送出去。
		ds.close();//关闭socket套接字
	}

}
