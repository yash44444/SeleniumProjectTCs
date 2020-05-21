package com.training.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIExcelRead {

	public static List<List<Object>> getExcelContent(String fileName, String sheetname) {
		List<List<Object>> list = new ArrayList<List<Object>>();

		try {
			System.out.println("File Name Got " + fileName);
			FileInputStream file = new FileInputStream(new File(fileName));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheet(sheetname);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				List<Object> tempList = new ArrayList<Object>();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:
						tempList.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_STRING:
						tempList.add(cell.getStringCellValue());
						break;
					}

				}

				list.add(tempList);

			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
//		String fileName = "C:\\Users\\YashuVerma\\Desktop\\data.xlsx";
//		String sheetname = "UNF064";
//		String sheetname = "UNF065";
//		String sheetname = "UNF066";
//
//		 for (List<Object> temp : getExcelContent(fileName, sheetname)) {
//			 System.out.println(temp.get(0) + "," + temp.get(1));   
		}
	}


