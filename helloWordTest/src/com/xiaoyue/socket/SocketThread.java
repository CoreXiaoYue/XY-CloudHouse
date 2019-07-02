package com.xiaoyue.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class SocketThread {

	public static void main(String[] args) {
			new Receive().start();
			new Send().start();
	}

}
class Receive extends Thread{
	@Override
	public void run() {
		try {
			DatagramSocket ds = new DatagramSocket(6666);//创建Socket套接字,并设置端口号。
			DatagramPacket dp = new DatagramPacket(new byte[1024], 1024) ;//创建仓库存放接收的数据。
				while(true) {
					ds.receive(dp);//使用socket接收数据
					byte[] data = dp.getData();//获取接受到的数据，放入字节数组。
					int length = dp.getLength();//获取数据的大小。
					int port = dp.getPort();//获取发送者的端口号。
					String hostAddress = dp.getAddress().getHostAddress();
					System.out.println("端口："+port+",IP:"+hostAddress+new Date()+"\r\n"+new String(data, 0, length)+"\r\n\r\n");//打印数据。
				}
//			ds.close();//关闭Socket套接字
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Send extends Thread{
	@Override
	public void run() {
		try {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}