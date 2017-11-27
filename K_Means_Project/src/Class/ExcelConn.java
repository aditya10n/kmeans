package Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelConn {
	
	public String[] sheet;
	public String[] data;
	
	
	
	public ExcelConn(String alamat){
		FileInputStream inputStream;
		FileInputStream excelFile;
		Workbook workbook = null;
		try {
			excelFile = new FileInputStream(new File(alamat));
            workbook = new XSSFWorkbook(excelFile);
            
            sheet = new String[workbook.getNumberOfSheets()];
            for(int i=0; i<workbook.getNumberOfSheets(); i++){
            	sheet[i]=workbook.getSheetName(i);
            }
            
            JOptionPane.showMessageDialog(null, "File ditemukan");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Tidak dapat membuka file ERR01");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Tidak dapat membuka file ERR02");
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Tidak dapat membuka file ERR02");
			e.printStackTrace();
		}
         
	}
	
	public ExcelConn(String alamat, String sheet, String from, String to){
		
        
		try {
			FileInputStream excelFile = new FileInputStream(new File(alamat));
	        Workbook workbook = new XSSFWorkbook(excelFile);
	        Sheet datatypeSheet = workbook.getSheet(sheet);
			
	        Iterator<Row> rowIterator = datatypeSheet.iterator();
	        while(rowIterator.hasNext())
            {
	        	
            }
			
	        
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
