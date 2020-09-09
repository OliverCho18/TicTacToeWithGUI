import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main{
  public static void main(String[] args){
    JFrame window = new JFrame("Tic-Tac-Toe");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().add(new gui());
    window.setBounds(300,200,300,300);
    window.setVisible(true);
  }
}
