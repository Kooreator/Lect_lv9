package manager;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MenuImage {
	
	private int x,y,w,h;
	private int num;
	
	private String fileName;
	private ImageIcon icon;
	
	public MenuImage(int x, int y,int w, int h, int num, String fN) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.num = num;
		this.fileName = fN;
		this.icon = new  ImageIcon(new ImageIcon(this.fileName).
				getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	

}
