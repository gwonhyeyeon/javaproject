package java_0623_3;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SwingJDBC extends JFrame{
	
	private ResultSet rs=null;
	private Statement stmt = null;
	private PreparedStatement pst = null;
	
	private JButton[] btn = new JButton[4];
	private JLabel[] label = new JLabel[8];
	private JTextField[] tf = new JTextField[8];
	private JTable table;
	private JScrollPane jp= new JScrollPane();
	
	private JPanel labelTextP[] =new JPanel[4];
	// 레이블과 텍스트필드를 묶는 패널
	
	private String[][] data = new String[50][8];
	private String[] colName = {"empno     ","ename     ","job       ","mgr       ","hiredate  ","sal       ","comm      ","deptno    "};
	//띄어쓰기로 10칸으로 통일시켜준다 출력설계 맞추주기위해
	
	private String[] str={"","","","","","","",""};	
	
	//생성자
	public SwingJDBC() throws Exception{
		super("사원정보");
		
		//DB에 접속 
		Connection conn = DbConn.getConnection();//dbConn을 만들어줘야한다
		stmt = conn.createStatement();
		
		//레이블과 텍스트필드, 버튼 컴포넌트를 포함하는 패널
		JPanel inputPanel = new JPanel(); 		
		inputPanel.setLayout(new GridLayout(5,1));
		
		//레이블 작성 로직
		for(int i=0; i<8; i++){
			label[i]=new JLabel(colName[i]);
		}		
		//텍스트 필드 생성
		for(int i=0; i<8; i++){
			tf[i] = new JTextField(15);
		}		
		for(int i=0;i<4;i++){//4개의 패널을 생성
			labelTextP[i] = new JPanel();
		}		
		//labelTextP패널에 레이블과 텍스트 필드를 담는 로직
		int j = -1;
		for(int i=0;i<8;i++){
			if(i%2 ==0){
				j++;//첫번째 j=0 0 1 1 순으로 
			}
			labelTextP[j].add(label[i]);//레이블필드 추가
			labelTextP[j].add(tf[i]);//text field추가
		}		
		JPanel btnPanel = new JPanel(); //버튼을 담는 패널
		
		btn[0] = new JButton("선택");
		btn[1] = new JButton("입력");
		btn[2] = new JButton("수정");
		btn[3] = new JButton("삭제");
		
		//패널에 버튼을 담는 로직
		for(int i=0; i< 4; i++){
			btn[i].addActionListener(eh);//이벤트처리해주는리스너
			btnPanel.add(btn[i]);
		}
		
		inputPanel.add(labelTextP[0]);
		inputPanel.add(labelTextP[1]);
		inputPanel.add(labelTextP[2]);
		inputPanel.add(labelTextP[3]);
		inputPanel.add(btnPanel); //버튼 패널 삽입
		
		table = new JTable(data, colName);
		jp = new JScrollPane(table);
		
		jp.addMouseListener(new MouseAdapter(){});//마우스리스너등록 이벤트처리는생략
		
		Container cp = this.getContentPane();//컨테이너임포트
		cp.setLayout(new GridLayout(2,1));
		
		cp.add(jp); cp.add(inputPanel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100,100,500,500); //프레임의 크기 설정
		setVisible(true);
		showData();	
	}//생성자
	
	public void showData(){
		table.removeAll();
		try {
			for(int i=0;i<50; i++){
				for(int j=0; j<8; j++){//각컬럼은8개
					data[i][j]="";
				}
			}//for문
			rs=stmt.executeQuery("select * from emp");
			int i=0;
			while(rs.next()){
				data[i][0]=rs.getString(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
				data[i][4]=rs.getString(5);
				data[i][5]=rs.getString(6);
				data[i][6]=rs.getString(7);
				data[i++][7]=rs.getString(8);//i값 증가				
			}//while
			
			table.repaint();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//showData
	
	EventHandler eh = new EventHandler();
	
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getActionCommand().equals("선택")){
				//테이블의 선택한 로우값을 얻어온다.
				int row = table.getSelectedRow();
				
				for(int i=0; i<8; i++){
					tf[i].setText(data[row][i]);
				}				
			}else if(ae.getActionCommand().equals("입력")){
				try {
					for(int i =0; i<8; i++){
						if(tf[i].getText().equals("")){
							if(i==0 || i== 3|| i==5|| i==6 || i==7)//넘버타입인경우0 3 5 6 7
								str[i]="''";//넘버타입이해당된경우0 3 5 6 7일때 홑따옴표로 감싸주고 출력하세요
							else
								str[i]="";//그렇지안으면 기존그대로출력
						}else{
							str[i]=tf[i].getText();
						}//if문								
					}//for문
					
					stmt.executeQuery("insert into emp values("+str[0]+",'"
							+str[1]+"','"+str[2]+"',"+str[3]+",'"+str[4]+"',"
							+str[5]+","+str[6]+","+str[7]+")");//try catch문처리해준다
					stmt.execute("commit");							
				} catch (SQLException e) {
					System.out.println("입력 오류!!!");
			    }//try catch문
				
				//화면에 출력
				showData();
				
				//텍스트 필드에 있는 내용을 삭제
				for(int i = 0; i<8 ;i++){
					tf[i].setText("");
				}				
			}else if(ae.getActionCommand().equals("수정")){
				try {
					for(int i=0;i<8; i++){
						if(tf[i].getText().equals("")){
							if(i==0 || i==3|| i==5|| i==6|| i==7)
								str[i]="''";//입력과동일하게처리한다
							else
								str[i]="";							
						}else{
							str[i]=tf[i].getText();
						}//if
					}//for
				
				//오라클 Date형식에 맞게 문자열을 잘라낸다. 
					if(str[4].length() > 0){
						str[4] = str[4].substring(0,10);
					}//if
					
		stmt.executeUpdate("update emp set empno = "+str[0]
				+", ename='"+str[1]+"', job='"+str[2]
				+"', mgr="+str[3]+", hiredate='"+str[4]+"',sal="
				+str[5]+", comm="+str[6]+", deptno="
				+str[7]+" where empno = "+str[0]);
					stmt.executeQuery("commit");
			}catch (SQLException e) {				
				System.out.println("수정 오류!!!!");
			}//try catch
			//화면에 수정된 내용 출력
			showData();
			for(int i=0; i<8; i++){
				tf[i].setText("");//textfield 비우기 널값처리
			}//for
		}else if(ae.getActionCommand().equals("삭제")){
			try {
stmt.executeQuery("delete from emp where" + " empno = "+tf[0].getText());
				stmt.executeQuery("commit");
			} catch (SQLException e) {				
				System.out.println("삭제시 에러 발생!!!!");
			}
			//삭제된 내용을 테이블에 반영해서 화면 출력
			showData();
			for(int i = 0; i< 8; i++){
				tf[i].setText("");
			}			
		}//if문
	  }//actionPerformed()
	}//////EventHandler Class ///////////////////		
	public static void main(String[] args) throws Exception {
		new SwingJDBC();
	}
}
