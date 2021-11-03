package basic;
//GUI
// swing, awt
// UI 엘리먼트를 담는 컨테이너
// 최상위 컨테이너 : JFrame
// 컨테이너 :JPanel
//컴포넌트 : JButton, JLabel,JTextField ,...

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class ManualPanel extends JPanel{
	public ManualPanel(int x ,int y, int weight , int height , Color c) {
		setBounds(x, y, weight, height);
		setBackground(c);
	}
}
class MyPanel extends JPanel{
	public MyPanel() {
		setBounds(0,0,250,400);
		setBackground(Color.blue);
				
	}
}
class MyPanel2 extends JPanel{
	public MyPanel2(){
		setBounds(250, 0, 250, 400);
		setBackground(Color.orange);
	}
}
class Contents extends JPanel implements ActionListener{
	
	//버튼 만들기
	//JBotton 클래스를 import > 객체 생성
	private JButton bt = new JButton();
	private boolean click;
	
	public Contents() {
		setLayout(null);
		setBounds(0, 0, 500, 400);
		
		//버튼 속성 설정
		//System.out.println(this.bt);
		bt.setBounds(100, 100, 100, 100); //크기 위치 
		bt.setText("push"); //글씨
		
		//on mac
		bt.setOpaque(true); // 투명도
		bt.setBorderPainted(false); // 테두리 삭제
		bt.setBackground(Color.gray); //버튼 컬러
		bt.addActionListener(this); //버튼에 리스너를 달아줌
		
		//패널에 버튼을 달아줌
		add(bt);
	}

	//ActionListener 인터페이스를 통한 메소드 오버라이딩
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getSource());
		System.out.println("아아");
		
		if(e.getSource() == this.bt ) {
			this.click = this.click ?  false : true;
			
			if(this.click)
			   this.bt.setBackground(Color.red);
			else 
				this.bt.setBackground(Color.gray);
		}
		
	}
}
//JFrame만들기
class MyFrame extends JFrame{
	public MyFrame() {
		//JFrame설정
		
		//0.
		//기본 레이 아웃 구성의 설정 -> 순서대로 나열식
		setLayout(null);
		
		//1.타이틀
		//super("title")
		//setTitle("title")
		setTitle("MyFrame Title");
		
		//2.크기
		//setBounds(x,y,width,height)
		setBounds(50,50, 500, 400);
		
		//3.종료조건
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// add 
		add(new MyPanel());
		add(new MyPanel2());
		add(new Contents());

		//4.보이기
		//setVisible(true)
		setVisible(true);
		
		//5.갱신
		revalidate();
		
	}
}
public class Ex {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}

}
