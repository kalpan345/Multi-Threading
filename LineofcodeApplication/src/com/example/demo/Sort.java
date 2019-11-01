package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort implements Runnable{
	private String[] x;
	private int[] linecount;
	private int size;
	private int min;
	public Sort(String[] x, int[] linecount, int size, int min) {
		// TODO Auto-generated method stub
		this.x=x;
		this.linecount=linecount;
		this.size=size;
		this.min=min;
	}
	
	@Override
	public void run() 
	{
		List<fileData> list = new ArrayList<fileData>();
		for(int i=0;i<size;i++)
		{
			list.add(new fileData(linecount[i],x[i]));
		}
		Collections.sort(list, Collections.reverseOrder());
		for (fileData p : list){
			if(p.getLineofcode()>min) {
				Thread t3=new Thread(new fileWrite(p),"A");
				t3.start();
				try {
					t3.join();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();}
}}}}