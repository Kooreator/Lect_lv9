package myGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileData {
	public static FileData instance = new FileData();
	String guildFile = "guild.txt";
	String shopFile = "shop.txt";
	String invenFile = "inven.txt";
	File file ;
	FileWriter fw ;
	FileReader fr;
	BufferedReader br;
	
	public void guildSave() {
		this.file = new File(this.guildFile);
		String data = "";
		for(int i=0; i<Guild.g.getGuild().size(); i++) {
			data += Guild.g.getGuild().get(i).info()+"\n";
			data += Guild.g.getGuild().get(i).weaponInfo()+"\n";
			data += Guild.g.getGuild().get(i).armorInfo()+"\n";
			data += Guild.g.getGuild().get(i).ringInfo()+"\n";
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
	public void guildLode() {
		this.file = new File(this.guildFile);
		if(file.exists()) {
			try {
				this.fr = new FileReader(file);
				this.br = new BufferedReader(fr);
				int index = -1;
				int cnt = 1;
				String data = br.readLine();
				while(data != null) {
					if(cnt % 4 == 1) {
						String temp[] = data.split("/");
						Guild.g.getGuild().add(new Unit(temp[0],Integer.parseInt(temp[1]),
								Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),
								Integer.parseInt(temp[5]),Boolean.parseBoolean(temp[6])));
						index ++;
					}else if(cnt % 4 == 2&&!data.equals("null")) {
						String temp[] = data.split("/");
						Guild.g.getGuild().get(index).setWeapon
						(new Item(temp[0],temp[1],Integer.parseInt(temp[2]),Integer.parseInt(temp[3])));
					}else if(cnt % 4 == 3&&!data.equals("null")) {
						String temp[] = data.split("/");
						Guild.g.getGuild().get(index).setArmor
						(new Item(temp[0],temp[1],Integer.parseInt(temp[2]),Integer.parseInt(temp[3])));
					}else if(cnt % 4 == 0&&!data.equals("null")) {
						String temp[] = data.split("/");
						Guild.g.getGuild().get(index).setRing
						(new Item(temp[0],temp[1],Integer.parseInt(temp[2]),Integer.parseInt(temp[3])));
					}
					cnt ++;
					data = br.readLine();
				}
				fr.close();
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shopSave() {
		this.file = new File(this.shopFile);
		String data = "";
		for(int i=0;i<Shop.instance.getWeaponList().size(); i++) {
			data += Shop.instance.getWeaponList().get(i).Info()+"/";
		}
		data += "\n";
		for(int i=0; i<Shop.instance.getArmorList().size(); i++) {
			data += Shop.instance.getArmorList().get(i).Info()+"/";
		}
		data += "\n";
		for(int i=0; i<Shop.instance.getRingList().size(); i++) {
			data += Shop.instance.getRingList().get(i).Info()+"/";
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
	public void shopLode() {
		this.file = new File(this.shopFile);
		if(file.exists()) {
			try {
				this.fr = new FileReader(file);
				this.br = new BufferedReader(fr);
				String data = br.readLine();
				String[] temp = data.split("/");
				for(int i=0; i<temp.length; i+=4) {
					Shop.instance.getWeaponList().add(new Item(temp[i],temp[i+1],
							Integer.parseInt(temp[i+2]),Integer.parseInt(temp[i+3])));
				}
				data = br.readLine();
				temp = data.split("/");
				for(int i=0; i<temp.length; i+=4) {
					Shop.instance.getArmorList().add(new Item(temp[i],temp[i+1],
							Integer.parseInt(temp[i+2]),Integer.parseInt(temp[i+3])));
				}
				data = br.readLine();
				temp = data.split("/");
				for(int i=0; i<temp.length; i+=4) {
					Shop.instance.getRingList().add(new Item(temp[i],temp[i+1],
							Integer.parseInt(temp[i+2]),Integer.parseInt(temp[i+3])));
				}
				fr.close();
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void invenSave() {
		this.file = new File(this.invenFile);
		String data = "";
		for(int i=0; i<Inventory.instance.getItems().size(); i++) {
			data += Inventory.instance.getItems().get(i).Info()+"/";
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
	public void invenLode() {
		this.file = new File(this.invenFile);
		if(file.exists()) {
			try {
				this.fr = new FileReader(file);
				this.br = new BufferedReader(fr);
				String data = br.readLine();
				if(data!= null) {
					String[] temp = data.split("/");
					for(int i=0; i<temp.length; i+=4) {
						Inventory.instance.getItems().add(new Item(temp[i],temp[i+1],
								Integer.parseInt(temp[i+2]),Integer.parseInt(temp[i+3])));
					}					
				}
				fr.close();
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void save() {
		guildSave();
		shopSave();
		invenSave();
	}
	public void lode() {
		guildLode();
		shopLode();
		invenLode();
	}
}
