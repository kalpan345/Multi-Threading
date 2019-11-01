package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fileWrite implements Runnable {
	
	private fileData filedata;

	public fileWrite(fileData filedata) {
		this.filedata=filedata;
	}

	@Override
	public void run() 
	{
		try 
		{
			int i=filedata.getLineofcode();
			String string=filedata.getLoc();
			final String FILE_NAME = "D:/file write/a.xlsx";
			InputStream inp;
			inp = new FileInputStream(FILE_NAME);
			Workbook wb = WorkbookFactory.create(inp); 
			Sheet sheet = wb.getSheetAt(0); 
			Row row1 = sheet.createRow(0);
			Cell cell2 = row1.createCell(0);
			cell2.setCellValue("Lines of code:");
			Cell cell3 = row1.createCell(1);
			cell3.setCellValue("Location: ");
			int num = sheet.getLastRowNum();
			Row row = sheet.createRow(++num);
			Cell cell = row.createCell(0);
			cell.setCellValue(i);
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(string);
			FileOutputStream fileOut = new FileOutputStream(FILE_NAME); 
			wb.write(fileOut); 
			fileOut.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();} 
		catch (IOException e) {
			e.printStackTrace();}
		catch (InvalidFormatException e) {
			e.printStackTrace();}
}}