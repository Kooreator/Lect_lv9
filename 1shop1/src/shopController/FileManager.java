package shopController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import shopModels.Cart;
import shopModels.Category;
import shopModels.User;

public class FileManager {
	private String usersFile = "users.txt";
	private String itemsFile = "items.txt";
	private String categoryFile = "category.txt";
	private String cartName = "cart.txt";
	private File file ;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	public void saveUsers() {
		this.file = new File(this.usersFile);
		String data = "";
		
		for(int i=0; i<UserManager.instance.getUsers().size(); i++) {
			data += UserManager.instance.getUsers().get(i).userInfo()+"/n";
		}
		
		try {
			this.fw = new FileWriter(file);
			
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void lodeUsers() {
		try {
			this.fr = new FileReader(this.usersFile);
			this.br = new BufferedReader(fr);
			String data = br.readLine();
			while(data != null) {
				String temp[] = data.split("/");
				UserManager.instance.getUsers().add(new User(temp[0],Integer.parseInt(temp[1])));
				data = br.readLine();
			}
			
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveCategory() {
		this.file = new File(this.categoryFile);
		String data = "";
		
		for(int i=0; i<CategoryManager.instance.getCategory().size(); i++) {
			data += CategoryManager.instance.getCategory().get(i).getName()+"/";
		}
		
		try {
			this.fw = new FileWriter(file);
			
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void lodeCategory() {
		try {
			this.fr = new FileReader(this.categoryFile);
			this.br = new BufferedReader(fr);
			
			String data = br.readLine();
			String[] temp = data.split("/");
			for(int i=0; i<temp.length; i++) {
				CategoryManager.instance.getCategory().add(new Category(temp[0]));
			}
			
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveCart() {
		this.file = new File(this.cartName);
		String data = "";
		
		for(int i=0; i<UserManager.instance.getUsers().size();i++) {
			if(0<UserManager.instance.getUsers().get(i).getCart().size()) {
				data+=(i+"/");
				for(int j=0; j<UserManager.instance.getUsers().get(i).getCart().size(); j++) {
					data += UserManager.instance.getUsers().get(i).getCart().get(j).getPrice()+"/";
					data += UserManager.instance.getUsers().get(i).getCart().get(j).getItemName()+"/";
				}
				data+="\n";
			}
		}
		
		try {
			this.fw = new FileWriter(file);
			
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void lodeCart() {
		try {
			this.fr = new FileReader(this.cartName);
			this.br = new BufferedReader(fr);
			
			String data = br.readLine();
			while(data != null) {
				String[] temp  = data.split("/");
				for(int i=1; i<temp.length; i+=2) {
					UserManager.instance.getUsers().get(Integer.parseInt(temp[0])).getCart().add(new Cart(Integer.parseInt(temp[i]),temp[i+1]));						
				}
				data = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveItems() {
		this.file = new File(this.itemsFile);
		String data = "";
		
		for(int i=0; i<CategoryManager.instance.getCategory().size(); i++) {
			if(0<CategoryManager.instance.getCategory().get(i).getItems().size()) {
				data+=(i+"/");
				for(int j=0; j<CategoryManager.instance.getCategory().get(i).getItems().size(); j++) {
					data+=CategoryManager.instance.getCategory().get(i).getItems().get(j).getName()+"/";
					data+=CategoryManager.instance.getCategory().get(i).getItems().get(j).getPrice()+"/";
					data+=CategoryManager.instance.getCategory().get(i).getItems().get(j).getCategory()+"/";
				}
				data+="\n";
			}
		}
		try {
			this.fw = new FileWriter(file);
			
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void lodeItems() {
		try {
			this.fr = new FileReader(this.itemsFile);
			this.br = new BufferedReader(fr);
			
			String data = br.readLine();
//			while(data ) {
//				
//			}
			
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
