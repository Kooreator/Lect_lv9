package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private String fileName = "Bank.txt";
	private File file = new File(fileName);
	private FileWriter fw;  
	private FileReader fr;
	private BufferedReader br;
	
	public static FileManager instance = new FileManager();
	
	public static BankManager bm = new BankManager();
	
	public FileManager() {}
	
	public void save() {
		String data = "";
		
		for(int i=0; i<bm.getUserManager().getUsers().size(); i++) {
			
			for(int j=0; j<this.bm.getUserManager().getUsers().get(i).getAccount().size(); j++) {
				
			}
		}
		try {
			this.fw = new FileWriter(this.fileName);
			
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
