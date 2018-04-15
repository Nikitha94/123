package com.nikitha.automation.properties;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesDemo 
{

	public static void main(String[] args) throws IOException 
	{
		File file = new File("F:\\selenium\\Automation\\abc.txt");
		boolean b = file.createNewFile();
		if(b)
			System.out.println("file is created");
		else
			System.out.println("return existing file");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("java");
		bw.newLine();
		bw.write("selenium");
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.write("practice");
		bw.newLine();
		bw.write(123);
		bw.flush();
		
		int filecount=0;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while(br.ready())
		{
		System.out.println(br.readLine());
		filecount++;
		}
		System.out.println("no of files:" +filecount);
	}

}
