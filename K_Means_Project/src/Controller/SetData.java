package Controller;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import Class.ExcelConn;

public class SetData {
	private String alamat;
	private Frame.SetData main;
	private ExcelConn excel;
	private Object[][] data;
	
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
	
	public Object[][] getData(String sheet, String from, String to){
		data=null;
		
		excel = new ExcelConn(alamat,sheet);
		data = excel.data;
		return data;
	}
	
	public void setAlamat(String alamat){
		this.alamat=alamat;
	}
	
	public DefaultTableModel table(){
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		dm.setDataVector(data, null);
		return dm;
	}
}
