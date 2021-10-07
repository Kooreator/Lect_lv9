package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Account;
import models.User;

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
		String data = bm.getUserManager().getUsers().size()+"\n";
		
		for(int i=0; i<bm.getUserManager().getUsers().size(); i++) {
			data += this.bm.getUserManager().getUsers().get(i).getInfo()+"\n";
			for(int j=0; j<this.bm.getUserManager().getUsers().get(i).getAccount().size(); j++) {
				data += this.bm.getUserManager().getUsers().get(i).getAccount().get(j).getInfo()+"\n";
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
	public void lode() {
		ArrayList<User> user = this.bm.getUserManager().getUsers();
		try {
			this.fr = new FileReader(this.fileName);
			this.br = new BufferedReader(this.fr);
			String data = br.readLine();
			for(int i=0; i<Integer.parseInt(data); i++) {
				String str = br.readLine();
				String temp[] = str.split("/");
				user.add(new User(Integer.parseInt(temp[0]),temp[1],temp[2],temp[3],Integer.parseInt(temp[4])));
				for(int j=0; j<Integer.parseInt(temp[4]); j++) {
					str = br.readLine();
					String temp2[] = str.split("/");
					user.get(i).getAccount().add(new Account(Integer.parseInt(temp2[0]),Integer.parseInt(temp2[1])));
				}
			}
			
			this.fr.close();
			this.br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
