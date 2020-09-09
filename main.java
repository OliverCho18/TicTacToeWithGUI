/*Creator: Oliver Cho
 *Date: 9/9/2020
 *File Description: This file contains the main class which runs the Tic Tac Toe
 *game and its gui
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main{
  public static void main(String[] args){
    //createa new JFram called Tic Tac Toe
    JFrame window = new JFrame("Tic-Tac-Toe");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //set the contents of the window to an instance of gui
    window.getContentPane().add(new gui());
    window.setBounds(300,200,300,300);
    window.setVisible(true);
  }
}
