package gui_myRace;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horse {
	private final int READY = 0;
	private final int RUN = 1 ;
	private final int GOAL = 2;
	
	private int num,x,y,w,h;
	
	private String fileName;
	private ImageIcon image;
	
	private int state;// ready 0 ,run 1, goal 2
	private int rank;
	private int record;
	
	public Horse(int num , int x , int y, int w,int h) {
		this.num = num;
		this.x = x; 
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("images_race/horse%d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		ImageIcon image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}

	public int getREADY() {
		return READY;
	}

	public int getRUN() {
		return RUN;
	}

	public int getGOAL() {
		return GOAL;
	}
	
	

}
