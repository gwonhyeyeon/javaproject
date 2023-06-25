package java_0623_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattingClient implements ActionListener, Runnable {
   //접속할 채팅 서버 ip
   private static final String SERVER_IP = "192.168.0.91";
   //혹은 "localhost"
   
   private Socket socket;
   private JFrame jframe;
   private JTextField jtf;
   private JTextArea jta;
   private JLabel jlb1,jlb2;
   private JPanel jp1, jp2;
   private String ip;
   private String chatName;
   private JButton jbtn;
   
   InputStream is;
   OutputStream os;
   BufferedReader br_in;
   BufferedWriter bw = null;
   PrintWriter pw = null;
   
   //생성자
   public ChattingClient() {
      //유저의 채팅 닉네임을 입력할 대화상자가 생성된다 ( 대화상자는 YES, NO버튼이 있는 상자이다)
      //JOptionPane.showInputDialog(대화상자의 부모 구성 요소, 표시할 메세지, 대화상자, 책 제목 , 대화상자 표시 유형)
      chatName = JOptionPane.showInputDialog(jframe, "대화명을 입력하세요", "대화명 입력 다이얼로그", JOptionPane.YES_NO_OPTION);
      
      //대화 상자의 내용 길이가 0이거나 내용이 비었으면 프로그램 종료
      if (chatName.length() == 0 || chatName == null)
         System.exit(0);
      
      //서버 ip 저장
      ip = SERVER_IP;
      
      //프레임 생성
      jframe = new JFrame("멀티 채팅 클라이언트 프로그램");
      
      //패널 1 생성 및 BorderLayout 설정
      jp1 = new JPanel();
      jp1.setLayout(new BorderLayout());
      
      //열 개수 (글자 수 ) 30 크기인 한 줄 텍스트 영역 생성 (채팅 입력창)
      jtf = new JTextField(30);
      
      //"종료" 써져 있는 버튼 생성 (채팅 종료 버튼)
      jbtn = new JButton("종료");
      
      //버튼은 패널1의 오른쪽, 텍스트 영역은 패널1의 중앙에 삽입
      jp1.add(jbtn, BorderLayout.EAST);
      jp1.add(jtf, BorderLayout.CENTER);
      
      //패널1 생성 및 BorderLayout설정
      jp2 = new JPanel();
      jp2.setLayout(new BorderLayout());
      
      //채팅 닉네임을 표시할 라벨 생성하여 배경색 노랑으로 설정
      jlb1 = new JLabel("대화명 : [[" + chatName + "]]");
      jlb1.setBackground(Color.YELLOW);
      
      //접속한 채팅 서버의 ip를 표시할 라벨 생성하여 배경색 초록으로 설정
      jlb2 = new JLabel("서버 IP 주소 : " + ip);
      jlb2.setBackground(Color.GREEN);
      
      //닉네임은 패널 2의 중앙에, 서버 ip는 패널 2의 오른쪽 삽입
      jp2.add(jlb1, BorderLayout.CENTER);
      jp2.add(jlb2, BorderLayout.EAST);
      
      //채팅 내용을 표시할 행 10 열50 크기의 텍스트 영역 생성하여 배경색 초록 설정
      jta = new JTextArea(" ", 10, 50);
      jta.setBackground(Color.GREEN);
      
      //채팅 내용 영역을 스크롤 팬에 담아 이전 내용울 볼 수 있게 하는데
      //가로 스크롤바는 없고 세로 스크롤 바는 항상 표시되게 설정
      JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      
      //패널 1은 프레임 아래에, 패널 2는 프레임 위에, 채팅 영역 스크롤은 프레임 중앙에
      jframe.add(jp1, BorderLayout.SOUTH);
      jframe.add(jp2, BorderLayout.NORTH);
      jframe.add(jsp, BorderLayout.CENTER);
      
      //채팅 입력창에 액션 이벤트 추가
      jtf.addActionListener(this);
      
      //종료 버튼에 액션 이벤트 추가
      jbtn.addActionListener(this);
      
      //프레임에 윈도우 이벤트 익명 클래스로 추가
      jframe.addWindowListener(new WindowAdapter() {
         //프레임을 닫았을 경우
         public void windowClosing(WindowEvent e) {
            try {
               //서버와 연결된 소켓에 종료메세지 전송 후
               pw.println(chatName + "#exit");
            }catch (Exception ee) {
               ee.printStackTrace();
            }
            //프로그램 종료
            System.exit(0);
         }
         //프레임 열었을 경우
         public void windowOpened(WindowEvent e) {
            //채팅 입력창에 강제 포커스 지정
            jtf.requestFocus();
         }
      });
      //채팅 내용 창 입력 불가 설정
      jta.setEditable(false);
      
      //프레임 크기를 내부 컴포넌트들 크기에 맞게 설정
      jframe.pack();
      
      //프레임 크기 변경 불가 설정
      jframe.setResizable(false);
      
      //프레임 보이기
      jframe.setVisible(true);
   }
   
   //액션 이벤트 메서드
   public void actionPerformed(ActionEvent e) {
      //이벤트 내용을 객체 변수에 저장
      Object obj = e.getSource();
      
      //채팅 입력창의 텍스트 내용을 문자열 변수에 저장
      String msg = jtf.getText();
      
      //발생한 이벤트가 채팅 입력창일 경우
      if (obj == jtf) {
         if (msg == null || msg.length() ==0) {
//JOptionPane.showMessageDialog(Component parentComponent, Object message, String title, int messageType)
//JOptionPane.showMessageDialog(대화상자의 부모 구성요소, 표시할 메세지, 대화상자 창 제목, 표시할 메세지 유형)
//대화상자의 부모 구성요소 : 상자가 표시되는 프레임을 결정, null 또는 parentComponent에 프레임이 없는 경우 기본 프레임 사용
            JOptionPane.showMessageDialog(jframe, "글을 쓰세요", "경고 ❗❗", JOptionPane.WARNING_MESSAGE);
         } else {
            try {
               //채팅 내용을 닉네임과 함께 서버에 전송
               pw.println(chatName + "#" + msg);
            }catch (Exception ee) {
               ee.printStackTrace();
            }
            //그리고 채팅 입력창을 비운다 (전송한 기존 채팅 내용을 삭제합니다)
            jtf.setText("");
         }
         //발생한 이벤트가 종료 버튼인 경우
      }else if (obj == jbtn) {
         try {
            //서버에 닉네임과 종료 메세지 전송 후 
            pw.println(chatName + "#exit");
         }catch (Exception ee) {
            ee.printStackTrace();
         }
         //프로그램 종료 
         System.exit(0);
      }
   }
   
   //서버 접속 메서드
   public void init() {
      try {
         //서버와 소켓 연결
         socket = new Socket(ip, 5001);
         
         //연결 소켓의 입출력 스트림 생성 및 세팅
         is = socket.getInputStream();
         os = socket.getOutputStream();
         br_in = new BufferedReader(new InputStreamReader(is));
         bw = new BufferedWriter(new OutputStreamWriter(os));
         pw = new PrintWriter(bw, true);
         
         //클라이언트 쓰레드 생성 및 시작
         Thread t = new Thread(this);
         t.start();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   //프로그램 시작
    public static void main(String[] args) {

       //프레임 창의 테두리 등에 기본적인 장식 비슷한 걸 보이게 한다.
       //생성된 JFrame에 현재 룩앤필에서 제공하는 창 장식 (예 : 테두리, 창을 닫기 위한 위젯, 제목
       JFrame.setDefaultLookAndFeelDecorated(true);
       
       //생성자로 GUI 생성 후 
       ChattingClient cc = new ChattingClient();
       
       //서버와 연결 및 채팅 시작
       cc.init();
   }
    //클라이언트 채팅 쓰레드 동작
    @Override
    public void run() {
       String message = null;
       String[] receiveMsg = null;
       boolean isStop = false;
       
       //쓰레드가 실행중이면 
       while(!isStop) {
          try {
             //서버에서 보낸 메세지를 문자열로 저장한다.
             message = (String) br_in.readLine();
             
             //메세지를 "#"을 구분자로 문자열 배열에 저장한다.
             receiveMsg = message.split("#");
          }catch (Exception e) {
             e.printStackTrace();
             isStop = true;
          }
          //receiveMsg[0] : 닉네임
          //receiveMsg[1] : 메세지
          System.out.println(receiveMsg[0] + " : " + receiveMsg[1] + "\n");
          
          //메세지가 "exit"일 때
          if (receiveMsg[1].equals("exit")) {
             //닉네임이 내 닉네임이면
             if(receiveMsg[0].equals(chatName)) {
                //프로그램 종료
                System.exit(0);
                
                //다른 유저 닉네임이면
             } else {
                //채팅 내용 영역에 해당 유저 종료 메세지 추가
                jta.append(receiveMsg[0] + " 님이 종료했습니다. \n");
                //커서를 채팅 내용 영역 제일 마지막 위치로 이동
                jta.setCaretPosition(jta.getDocument().getLength());
             }
             //그냥 일반 메세지 일 
          } else {
             //채팅 내용 영역에 해당 메세지 추가하고 커서를 마지막으로 이동
             jta.append(receiveMsg[0] + " : " + receiveMsg[1] + "\n");
             jta.setCaretPosition(jta.getDocument().getLength());
          }
       }
    }

}