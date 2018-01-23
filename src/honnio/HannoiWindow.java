package honnio;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class HannoiWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	Tower tower = null;
	int amountOfDisc = 3;
	char[] towerName = {'A','B','C'};
	JMenuBar bar;
	JMenu menuGrade;
	JMenuItem oneGradeItem,twoGradeItem,threeGradeItem;
	JButton renew = null;
	JButton autoButton = null;
	JPanel center = new JPanel();
	
	public HannoiWindow() {
		tower = new Tower(towerName);
		tower.setAmountOfDisc(amountOfDisc);
		tower.setMaxDiscWidth(120);
		tower.setMinDiscWidth(50);
		tower.setDiscHeight(16);
		tower.putDiscOnTower();
		
		add(tower,BorderLayout.CENTER);
		bar =new JMenuBar();
		menuGrade=new JMenu("ѡ�񼶱�");
		oneGradeItem=new JMenuItem("����");
		twoGradeItem=new JMenuItem("�м�");
		threeGradeItem=new JMenuItem("�߼�");
		
		menuGrade.add(oneGradeItem);
		menuGrade.add(twoGradeItem);
		menuGrade.add(threeGradeItem);
		
		bar.add(menuGrade);
		setJMenuBar(bar);
		oneGradeItem.addActionListener(this);
		twoGradeItem.addActionListener(this);
		threeGradeItem.addActionListener(this);
		
		renew=new JButton("���¿�ʼ");
		renew.addActionListener(this);
		
		autoButton=new JButton("�Զ���ʾ");
		autoButton.addActionListener(this);
		
		JPanel north=new JPanel();
		north.add(renew);
		north.add(autoButton);
		
		String mess="��ȫ�����Ӵ�"+towerName[0]+"�����˵�"+towerName[1]+"����"+towerName[2]+"��";
		
		JLabel hintMess = new JLabel(mess,JLabel.CENTER);
		north.add(hintMess);
		
		add(north,BorderLayout.NORTH);
		setResizable(false);
		setVisible(true);
		setBounds(60,60,460,410);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==oneGradeItem) {
			amountOfDisc=3;
			tower.setAmountOfDisc(amountOfDisc);
			tower.putDiscOnTower();
		}else if(e.getSource()==twoGradeItem) {
			amountOfDisc=4;
			tower.setAmountOfDisc(amountOfDisc);
			tower.putDiscOnTower();
		}else if(e.getSource()==threeGradeItem) {
			amountOfDisc=5;
			tower.setAmountOfDisc(amountOfDisc);
			tower.putDiscOnTower();
		}else if(e.getSource()==renew) {
			tower.setAmountOfDisc(amountOfDisc);
			tower.putDiscOnTower();
		}else if(e.getSource()==autoButton) {
			tower.setAmountOfDisc(amountOfDisc);
			tower.putDiscOnTower();
			int x=this.getBounds().x+this.getBounds().width;
			int y=this.getBounds().y;
			tower.getAutoMoveDisc().setLocation(x,y);
			tower.getAutoMoveDisc().setSize(280, this.getBounds().height);
			tower.getAutoMoveDisc().setVisible(true);
		}
		validate();
	}

	public static void main(String[] args) {
		new HannoiWindow();
	}
}
