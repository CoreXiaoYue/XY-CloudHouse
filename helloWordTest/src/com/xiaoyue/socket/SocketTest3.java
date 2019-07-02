package com.xiaoyue.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Date;

public class SocketTest3 {

	public static void main(String[] args) throws IOException {
//			test1();
			DatagramSocket ds = new DatagramSocket(6666);//创建Socket套接字,并设置端口号。
			DatagramPacket dp = new DatagramPacket(new byte[1024], 1024) ;//创建仓库存放接收的数据。
				while(true) {
					ds.receive(dp);//使用socket接收数据
					byte[] data = dp.getData();//获取接受到的数据，放入字节数组。
					int length = dp.getLength();//获取数据的大小。
					int port = dp.getPort();//获取发送者的端口号。
					String hostAddress = dp.getAddress().getHostAddress();
					System.out.println("端口:"+port+",IP:"+hostAddress+new String(data, 0, length)+new Date());//打印数据。
				}
//				ds.close();//关闭Socket套接字
	}

	public static void test1() throws SocketException, IOException {
		DatagramSocket ds = new DatagramSocket(6666);//创建Socket套接字,并设置端口号。
		DatagramPacket dp = new DatagramPacket(new byte[1024], 1024) ;//创建仓库存放接收的数据。
			while(true) {
				ds.receive(dp);//使用socket接收数据
				byte[] data = dp.getData();//获取接受到的数据，放入字节数组。
				int length = dp.getLength();//获取数据的大小。
				System.out.println(new String(data, 0, length));//打印数据。
			}
//			ds.close();//关闭Socket套接字
	}

}
