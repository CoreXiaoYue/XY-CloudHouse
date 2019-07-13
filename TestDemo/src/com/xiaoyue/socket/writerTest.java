package com.xiaoyue.socket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class writerTest {
public static void main(String[] args) throws Exception {
	Writer writer = new FileWriter("httpTest.txt");
	writer.write("123");
	writer.close();
}
}
