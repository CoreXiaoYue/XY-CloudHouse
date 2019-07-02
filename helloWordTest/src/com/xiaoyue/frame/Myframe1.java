package com.xiaoyue.frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Myframe1 extends Frame{
	private Button send;//发送按钮
	private TextArea sendText;//发送内容
	private TextField sendField;//IP地址
	private Button clear;//清屏
	private Button log;//聊天记录
	private Button shack;//震动
	private TextArea viewText;//聊天内容
	private BufferedOutputStream bos;//字节缓冲区
	private DatagramSocket ds1;//socket套接字
	private DatagramSocket ds2;//socket套接字
	private BufferedInputStream bis;//读取聊天记录的流
	


	public Myframe1() {
		init();//初始化窗口。
		panelTop();//聊天内容框和发送内容框。
		panelSouth();//南边panel组建。
		event();//关闭窗口。
		new ReceiveMessage().start();//启动接收信息线程。
	}

	/**
	 * 顶部组件
	 */
	private void panelTop() {
		Panel top = new Panel();//聊天内容和编辑内容界面
		viewText = new TextArea();//聊天类容区
		sendText = new TextArea(5,1);//编辑发送区
//		viewText.setEnabled(false);//不可编辑
		sendText.setFont(new Font("ddd", Font.PLAIN, 20));//字体设置
		top.setLayout(new BorderLayout());
		top.add(viewText,BorderLayout.CENTER);
		top.add(sendText,BorderLayout.SOUTH);
		this.add(top,BorderLayout.CENTER);//加入主窗体
	}

	/**
	 * 初始化窗体大小
	 */
	public void init() {
		this.setTitle("正在与岳俊江聊天");//窗体标题
		this.setLocation(500, 100);//位置
		this.setVisible(true);//显示
		this.setSize(450, 600);//宽高
		try {
			bos = new BufferedOutputStream(new FileOutputStream("message2.txt",true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 事件监听
	 */
	private void event() {
		//关闭聊天窗口
		this.addWindowListener(new WindowAdapter() {//窗口关闭监听
			@Override
			public void windowClosing(WindowEvent e) {
					ds1.close();
					System.exit(0);
			}
		});
		//发送聊天内容
		send.addActionListener(new ActionListener() {//发送按钮监听
			
			@Override
			public void actionPerformed(ActionEvent e) {
						try {
							send();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			}
		});
		//清空聊天内容
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		//查看聊天记录
		log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
						try {
							seelog();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			}		
		});
		
	}


	/**
	 * 查看聊天记录
	 * @throws IOException 
	 */
	private void seelog() throws IOException {
		 bis = new BufferedInputStream(new FileInputStream("message2.txt"));
		int len;
		byte[] by=new byte[8192];
		while((len = bis.read(by)) != -1) {
			String logs=new String(by, 0, len);
			viewText.setText(new String(by, "utf-8"));
		}
		bis.close();
	}

	/**
	 * 清除聊天内容。
	 */
	protected void clear() {
		viewText.setText("");//设置聊天区内容为空。
	}

	/**
	 * 获取文本框内容发送。
	 * @throws IOException 
	 */
	protected void send() throws IOException {
		String message=sendText.getText();//获取sendText文本框内容。
		String sendTime = sendTime();//获取当前时间。
		String ip=sendField.getText();//获取sendField组件内容
		String str = sendTime+"你发送给"+ip+"\r\n"+message+"\r\n\r\n";
		viewText.append(str);//聊天窗口显示发送的内容
		bos.write(str.getBytes("utf-8"));
		bos.flush();
		sendText.setText("");
		ds1 = new DatagramSocket();
		DatagramPacket dp = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getByName("127.0.0.1"),9999);
		ds1.send(dp);
	}




	/**
	 * @return 返回当前时间
	 */
	private String sendTime() {
		Date now = new Date();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		return simp.format(now);
		
	}

	/**
	 * 底部组件：ip,四个按钮组件
	 */
	public void panelSouth() {
		Panel panel = new Panel();
		sendField = new TextField(15);
		sendField.setText("127.0.0.1");
		send = new Button("发送");
		clear = new Button("清屏");
		log = new Button("记录");
		shack = new Button("震动");
		panel.add(sendField);
		panel.add(send);
		panel.add(clear);
		panel.add(log);
		panel.add(shack);
		this.add(panel, BorderLayout.SOUTH);
	}


	public static void main(String[] args) {
			new Myframe1();
	}

class ReceiveMessage extends Thread{
	

	@Override
	public void run() {
		try {
			ds2 = new DatagramSocket(6666);
			DatagramPacket dp = new DatagramPacket(new byte[8192], 8192);
			while(true) {//不停的接收消息
				ds2.receive(dp);//获取数据包
				int length = dp.getLength();//数据大小
				String ip = dp.getAddress().getHostAddress();//发送者的IP地址
				int port = dp.getPort();//发送者的端口号
				byte[] data = dp.getData();//数据转换成字节数组。
				String str = "端口:"+port+",IP:"+ip+sendTime()+"岳俊江发来消息\r\n"+new String(data, 0, length)+"\r\n\r\n";
				viewText.append(str);
				bos.write(str.getBytes("utf-8"));
				bos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		ds.close();
	}
}
	
}
