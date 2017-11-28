package Controller;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import Class.ExcelConn;

public class SetData {
	private String alamat;
	private Frame.SetData main;
	private ExcelConn excel;
	private String[][] data;
	private String[] sheet;
	private int maxrow,maxcol;
	
	public void setAlamat(String alamat){
		this.alamat=alamat;
	}
	
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
	
	public String[] getSheet(String alamat){
		excel = new ExcelConn(alamat);
		sheet = excel.sheet;
		return sheet;
	}
	
	public String[][] getData(String alamat, String sheet){
		data=null;
		
		excel = new ExcelConn(alamat,sheet);
		this.data = excel.data;
		
		this.maxcol=excel.maxcol;
		this.maxrow=excel.maxrow;
		
		return data;
	}
	
	
	public DefaultTableModel table(){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		for(int i=0;i<maxrow+1;i++){
			for(int s=0;s<maxcol+1;s++){
				if(data[i][s]!=null)
					data[i][s]=data[i][s];
				else
					data[i][s]="";
			}
		}
		
		String[] head=new String[maxcol+1];
		for(int i=0;i<maxcol+1;i++){
			/*if(data[0][i]!=null)
				head[i]=data[0][i];
			else*/
				head[i]="";
		}
		dm.setDataVector(data, head);
		return dm;
	}
	
}
