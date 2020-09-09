import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class gui extends JPanel{
  JButton buttons[] = new JButton[9];
  private String currentPlayerMark;

  public gui(){
    currentPlayerMark="X";
    setLayout(new GridLayout(3,3));
    initializeButtons();
  }

  public void initializeButtons(){
    for(int i = 0; i <= 8; i++){
      buttons[i] = new JButton();
      buttons[i].setLabel(Integer.toString(i));
      buttons[i].setText("-");
      buttons[i].addActionListener(new buttonListener());
      add(buttons[i]);
    }
  }

  public void resetButtons(){
    for(int i = 0; i <= 8; i++){
      buttons[i].setText("-");
    }
  }

  private class buttonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
        buttonClicked.setText(currentPlayerMark);

        if (currentPlayerMark=="X"){
          currentPlayerMark="O";
        }
        else{
          currentPlayerMark="X";
        }

        if(checkForWin() == true)
            {
                JOptionPane.showConfirmDialog(null, "Game Over.");
                resetButtons();
            }

        int sum=0;
        for(int i = 0; i <= 8; i++){
          if(buttons[i].getText()=="-"){
            sum++;
          }
        }
        if(sum==0){
          JOptionPane.showConfirmDialog(null, "Game Over.");
          resetButtons();
        }
    }
    public boolean checkForWin(){
      /**   Reference: the button array is arranged like this as the board
       *      0 | 1 | 2
       *      3 | 4 | 5
       *      6 | 7 | 8
       */
      if(checkRowForWin()==true){
        return true;
      }
      else if(checkColumnForWin()==true){
        return true;
      }
      else if(checkDiagonalForWin()==true){
        return true;
      }
      else{
        return false;
      }
    }
    public boolean checkRowForWin(){
      boolean result=false;
      for(int i=0;i<=6;i=i+3){
        if((buttons[i].getText()==buttons[i+1].getText())&&(buttons[i+1].getText()==buttons[i+2].getText())&&(buttons[i].getText()!="-")){
          result=true;
        }
      }
      return result;
    }
    public boolean checkColumnForWin(){
      boolean result=false;
      for(int i=0;i<=2;i=i+1){
        if((buttons[i].getText()==buttons[i+3].getText())&&(buttons[i+3].getText()==buttons[i+6].getText())&&(buttons[i].getText()!="-")){
          result=true;
        }
      }
      return result;
    }
    public boolean checkDiagonalForWin(){
      boolean result=false;
      if((buttons[0].getText()==buttons[4].getText())&&(buttons[4].getText()==buttons[8].getText())&&(buttons[0].getText()!="-")){
        result=true;
      }
      if((buttons[2].getText()==buttons[4].getText())&&(buttons[4].getText()==buttons[6].getText())&&(buttons[2].getText()!="-")){
        result=true;
      }
      return result;
    }
  }

}
