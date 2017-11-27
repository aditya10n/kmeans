package Controller;

import javax.swing.JFileChooser;

import Class.ExcelConn;

public class SetData {
	private String alamat;
	private Frame.SetData main;
	private ExcelConn excel;
	
	public String openFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY );
		fileChooser.setAcceptAllFileFilterUsed(false);
		
	    int open = fileChooser.showOpenDialog(null);
	    if (open == JFileChooser.APPROVE_OPTION) {
	       alamat=fileChooser.getSelectedFile().toString();
	    }
	    return alamat;
	}
	
	public String[] getSheet(){
		String[] sheet=null;
		
		excel = new ExcelConn(alamat);
		sheet = excel.sheet;
		return sheet;
	}
	
	public String[] getData(String sheet, String from, String to){
		String[] data=null;
		
		excel = new ExcelConn(alamat,sheet,from,to);
		data = excel.data;
		return data;
	}
	
	public void setAlamat(String alamat){
		this.alamat=alamat;
	}
}
