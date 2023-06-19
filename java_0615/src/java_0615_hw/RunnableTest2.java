package java0615A;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Runnable 인터페이스를 활용한 스레드 구현
class TimerRunnable2 extends JPanel implements Runnable {
   private JLabel timerLabel;
   public boolean isPause = false;

   // 생성자로 라벨 전달 받아 전달
   public TimerRunnable2(JLabel timerLabel) {
      this.timerLabel = timerLabel;

      this.timerLabel.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
//            isPause = !isPause;
            if (isPause) {
               resume();
            } else {
               pause();
            }
         }
      });
   }

   // run() 구현
   @Override
   public void run() {
      int n = 0;
      // 텍스트 라벨의 숫자가1초 간격으로 무한히 올라감
      while (true) {
         timerLabel.setText(String.valueOf(n));
         n++;
         try {
            Thread.sleep(100);
            synchronized (this) {
                    while (isPause) {
                        wait();
                    }
                }
//            if (isPause) {
////               Thread.interrupted();
//               return;
//            } else {
//               Thread.sleep(100);
//            }
         } catch (InterruptedException e) {
            return;
         }
      }
   } public synchronized void pause() {
        isPause = true;
    }

    public synchronized void resume() {
        isPause = false;
        notify();
    }
}
// 내일의 과제 isPaused 필드를 사용합니다 synchronized notify()
//resume() 메서드안에는 synchronized notify()를 사용합니다
//쓰레드답게 레이블 클릭시 addMouseListener()를이용합니다

public class Homework extends JFrame {
   public Homework() {
      setTitle("Runnable을 구현한 타이머 스레드 예제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(new FlowLayout());

      JLabel timerLabel = new JLabel();
      timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
      c.add(timerLabel);

      setSize(250, 150);
      setVisible(true);

      TimerRunnable2 runnable = new TimerRunnable2(timerLabel);
      // Runnable 인터페이스를 상속 받는 클래스를 스레드 객체로 만든 것
      Thread th = new Thread(runnable);
      th.start();

   }

   public static void main(String[] args) {
      new Homework();
   }
}

