package com.example.demo;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class fileReader implements Runnable {
	private String path;
	private String lim;
	
	public fileReader() {}
	public fileReader(String lim, String path) {
		this.path = path;
		this.lim = lim;
	}
	
	@Override
	public void run() {
		try{
			int min=Integer.parseInt(lim);
			Stream<Path> walk = Files.walk(Paths.get(path));
			List<String> result=walk.map(x -> x.toString()).filter(f -> f.endsWith(".java")).collect(Collectors.toList());
			String[] x = result.toArray(new String[0]);
			int size = result.size();
			int[] linecount=new int[size];
			for(int i=0;i<size;i++) {
				int counter = 0;
				File file =new File(x[i]);
				FileReader fr;
				fr = new FileReader(file);
				LineNumberReader lnr = new LineNumberReader(fr);
				while (lnr.readLine() != null)
				{
					counter++;
				}
				linecount[i]=counter;
				lnr.close();
			}
			Thread t2=new Thread(new Sort(x,linecount,size,min),"A");
			t2.start();
			t2.join();
			walk.close();
		}
		catch (Exception e) {
			e.printStackTrace();}
	}
}
