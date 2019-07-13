package com.xiaoyue.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Response {

	private Socket client;//客户端
	private final String blank = " ";
	private final String CRLN = "\r\n";
	private StringBuilder textPart;//响应体
	private int messageSize;//响应主体长度。
	private StringBuilder resonpseInfo;//响应头，行
	private ServerSocket serverSocket;

//	private ServerSocket client;
	
//	public Response() {
//		
//	}

	public Response() throws Exception {
		try {
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
		client = this.serverSocket.accept();
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

	}

	public void printWriter(String string) {
		textPart = new StringBuilder();
//		textPart.append("<html>");
//		textPart.append("<head>");
//		textPart.append("<title>");
//		textPart.append("服务器响应");
//		textPart.append("</title>");
//		textPart.append("</head>");
//		textPart.append("<body>");
//		textPart.append("手写服务器响应数据123。");
//		textPart.append("</body>");
//		textPart.append("</html>");
		textPart.append(string);
		messageSize = textPart.toString().getBytes().length;
		System.out.println(messageSize);
	}

	public void responseHttpWrite() throws Exception {
		resonpseInfo = new StringBuilder();

		// 响应行
		resonpseInfo.append("HTTP/1.1").append(blank).append(200).append(blank).append("OK").append(CRLN);
		// 响应体
		resonpseInfo.append("Server:").append(blank).append("NWS_STSOC_JR1").append(CRLN);
		resonpseInfo.append("Date:").append(new Date()).append(CRLN);
		resonpseInfo.append("Content-Type:txt/html").append(CRLN);
		resonpseInfo.append("Content-Length:").append(blank).append(messageSize).append(CRLN).append(CRLN);

		// 正文
		resonpseInfo.append(textPart.toString());
		OutputStream outputStream2 = client.getOutputStream();
		BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(outputStream2));
		bw1.write(resonpseInfo.toString());
		bw1.flush();
	}
}
