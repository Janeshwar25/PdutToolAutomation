package myproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider {

	DataFormatter formatter=new DataFormatter();
	public void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// fileInputStream Argument

		ArrayList<String> arry = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C://Users//jchowdha//Desktop//TestDoc.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++)

		{
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))

			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify TestCases coloum by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of cells
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("MemberID")) {
						coloumn = k;
					}

					k++;

				}
				// System.out.println(coloumn);

				while (rows.hasNext())

				{
					Row r = rows.next();
//	        	System.out.println(r.getCell(coloumn).getNumericCellValue());
					
					
					arry.add(String.valueOf(r.getCell(coloumn)));

				}
				System.out.println(arry);
//				call the method cirrusAlpha()

			}

		}

	}

}
