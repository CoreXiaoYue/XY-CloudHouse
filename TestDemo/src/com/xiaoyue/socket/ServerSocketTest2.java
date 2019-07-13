package com.xiaoyue.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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


public class ServerSocketTest2 {
	

	public static void main(String[] args) {
		ServerSocketTest2 serverSocketTest = new ServerSocketTest2();
		try {
			serverSocketTest.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//启动服务器
	public void start() throws Exception {
			Response response = new Response();
			response.printWriter("<html>");
			response.printWriter("<head>");
			response.printWriter("<title>");
			response.printWriter("服务器响应");
			response.printWriter("</title>");
			response.printWriter("</head>");
			response.printWriter("<body>");
			response.printWriter("手写服务器响应数据123。");
			response.printWriter("</body>");
			response.printWriter("<html>");
			System.out.println("服务器启动成功");
			response.responseHttpWrite();
			
			receiv();
	}
	//接收数据
	public void receiv() {
		
	}
	public void stop() {
		
	}
}
