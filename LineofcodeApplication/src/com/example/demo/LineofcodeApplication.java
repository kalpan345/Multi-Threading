package com.example.demo;

public class LineofcodeApplication
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread t1=new Thread(new fileReader(args[1],args[0]),"A");
		t1.start();
		t1.join();
		System.out.println("Excel sheet has been updated.");
}}