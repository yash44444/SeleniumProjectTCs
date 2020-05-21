package com.training.dataproviders;

import java.util.List;
import org.testng.annotations.DataProvider;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public static Object[][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins();

		Object[][] result = new Object[list.size()][];
		int count = 0;
		for (LoginBean temp : list) {
			Object[] obj = new Object[2];
			obj[0] = temp.getUserName();
			obj[1] = temp.getPassword();

			result[count++] = obj;
		}

		return result;
	}

	/*
	 * @DataProvider(name = "excel-inputs") public static Object[][] getExcelData(){
	 * String fileName ="D:\\Software\\elearninglogin.xlsx";
	 * 
	 * List<List<Object>> retVal= ApachePOIExcelRead.getExcelContent(fileName);
	 * System.out.println("size" + retVal.size());
	 * 
	 * Object[][] result = new Object[retVal.size()][retVal.size()]; int count=0;
	 * 
	 * for(List<Object> temp : retVal){ if(temp!=null){ Object[] obj = new
	 * Object[2]; System.out.println(temp.get(0)); System.out.println(temp.get(1));
	 * 
	 * obj[0]= temp.get(0); obj[1]= temp.get(1);
	 * 
	 * result[count ++]= obj; } } return result;
	 * 
	 * 
	 * }
	 */

	@DataProvider(name = "input1")
	public static Object[][] getExcelData_UNF064() {
		String fileName = "C:\\Users\\YashuVerma\\Desktop\\data.xlsx";
		String sheetname = "UNF064";

		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName, sheetname);
		System.out.println("size is " + retVal.size());

		Object[][] result = new Object[retVal.size()][retVal.size()];

		int count = 0;

		for (List<Object> temp : retVal) {
			if (temp != null) {
				Object[] obj = new Object[5];

				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				System.out.println(temp.get(3));
				System.out.println(temp.get(4));

				obj[0] = temp.get(0);
				obj[1] = temp.get(1);
				obj[2] = temp.get(2);
				obj[3] = temp.get(3);
				obj[4] = temp.get(4);

				result[count++] = obj;
			}
		}
		return result;

	}

	@DataProvider(name = "input2")
	public static Object[][] getExcelData_UNF065() {
		String fileName = "C:\\Users\\YashuVerma\\Desktop\\data.xlsx";
		String sheetname = "UNF065";

		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName, sheetname);
		System.out.println("size is " + retVal.size());

		Object[][] result = new Object[retVal.size()][retVal.size()];

		int count = 0;

		for (List<Object> temp : retVal) {
			if (temp != null) {
				Object[] obj = new Object[6];

				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				System.out.println(temp.get(3));
				System.out.println(temp.get(4));
				System.out.println(temp.get(5));

				obj[0] = temp.get(0);
				obj[1] = temp.get(1);
				obj[2] = temp.get(2);
				obj[3] = temp.get(3);
				obj[4] = temp.get(4);
				obj[5] = temp.get(5);

				result[count++] = obj;
			}
		}
		return result;

	}

	@DataProvider(name = "input3")
	public static Object[][] getExcelData_UNF066() {
		String fileName = "C:\\Users\\YashuVerma\\Desktop\\data.xlsx";
		String sheetname = "UNF066";

		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName, sheetname);
		System.out.println("size is " + retVal.size());

		Object[][] result = new Object[retVal.size()][retVal.size()];

		int count = 0;

		for (List<Object> temp : retVal) {
			if (temp != null) {
				Object[] obj = new Object[6];

				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				System.out.println(temp.get(3));
				System.out.println(temp.get(4));
				System.out.println(temp.get(5));
			
				obj[0] = temp.get(0);
				obj[1] = temp.get(1);
				obj[2] = temp.get(2);
				obj[3] = temp.get(3);
				obj[4] = temp.get(4);
				obj[5] = temp.get(5);
				

				result[count++] = obj;
			}
		}
		return result;

	}

	@DataProvider(name = "xls-inputs")
	public static Object[][] getXLSData() {

		return new ReadExcel().getExcelData("C:\\Users\\YashuVerma\\Desktop\\data.xlsx", "UNF064");
	}
}
