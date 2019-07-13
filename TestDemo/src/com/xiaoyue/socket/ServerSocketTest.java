package com.xiaoyue.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.spi.LocaleNameProvider;


public class ServerSocketTest {
	
	private ServerSocket serverSocket;
	

	public static void main(String[] args) throws Exception {
		ServerSocketTest serverSocketTest = new ServerSocketTest();
		serverSocketTest.start();
		serverSocketTest.receiv();
		
	}
	//启动服务器
	public void start() throws Exception {
			serverSocket = new ServerSocket(9991);
			System.out.println("服务器启动成功");
			
	}
	//接收数据
	public void receiv() throws Exception {
		
			Socket client = serverSocket.accept();
			InputStream is = client.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new FileWriter("HttpTest.txt"));
			
			StringBuilder sbStream = new StringBuilder();
			String readLine;
			while((readLine = br.readLine()) !=null) {
				bw.write(readLine);
				bw.newLine();
				sbStream.append(readLine+"\r\n");
			}
			bw.close();
			System.out.println(sbStream);

			StringBuilder context = new StringBuilder();
			context.append("<html>");
			context.append("<head>");
			context.append("<title>");
			context.append("服务器响应");
			context.append("</title>");
			context.append("</head>");
			context.append("<body>");
			context.append("手写服务器响应数据123。1211");
			context.append("</body>");
			context.append("</html>");
			int size = context.toString().getBytes().length;
			/*
			 * HTTP/1.1 200 OK
			 * Server: NWS_STSOC_JR1 
			 * Date: Fri, 24May 2019 14:00:06 GMT 
			 * Content-Type:video/mp2t 
			 * Content-Length: 168260
			 */
			StringBuilder resonpseInfo = new StringBuilder();
			String blank=" ";
			String CRLN = "\r\n";
			//响应行
			resonpseInfo.append("HTTP/1.1").append(blank).append(200).append(blank).append("OK").append(CRLN);
			//响应体
			resonpseInfo.append("Server:").append(blank).append("NWS_STSOC_JR1").append(CRLN);
			resonpseInfo.append("Date:").append(new Date()).append(CRLN);
			resonpseInfo.append("Content-Type:txt/html").append(CRLN);
			resonpseInfo.append("Content-Length:").append(blank).append(size).append(CRLN).append(CRLN);
			
			//正文
			resonpseInfo.append(context.toString());
			OutputStream outputStream2 = client.getOutputStream();
			BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(outputStream2));
			bw1.write(resonpseInfo.toString());
			bw1.flush();
			bw1.close();
			serverSocket.close();
	}
	public void stop() {
		
	}
}
