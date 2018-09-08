package com.test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Test {
public static void main(String[] args) {
	byte[] buffer = new byte[1024];
	 
	try{

		FileOutputStream fos = new FileOutputStream("D:\\MyFile.zip");
		ZipOutputStream zos = new ZipOutputStream(fos);
		for(int i=1;i<=5;i++){
		ZipEntry ze= new ZipEntry("spy"+i+".log");
		zos.putNextEntry(ze);
		FileInputStream in = new FileInputStream("D:\\spy.log");

		int len;
		while ((len = in.read(buffer)) > 0) {
			zos.write(buffer, 0, len);
		}
		
		in.close();
		}
		zos.closeEntry();

		//remember close it
		zos.close();

		System.out.println("Done");

	}catch(IOException ex){
	   ex.printStackTrace();
	}
}
}
