/*Creator: Oliver Cho
 *Date: 9/9/2020
 *File Description: This file contains the gui class which contains all variables
 *and functions related to the Tic Tac Toe game and its gui
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//gui class
public class gui extends JPanel{
  //9 buttons representing the 9 tic tac toe squares
  JButton buttons[] = new JButton[9];
  //variable representing the current player's mark
  private String currentPlayerMark;

  //blank constructor
  public gui(){
    //set the current player's mark to X
    currentPlayerMark="X";
    //set the layout of the window to a 3 by 3 grid
    setLayout(new GridLayout(3,3));
    initializeButtons();
  }

  //function to initalize the buttons on the window
  public void initializeButtons(){
    //for each of the 9 buttons
    for(int i = 0; i <= 8; i++){
      buttons[i] = new JButton();
      //set the button's text to a dash as there is no entry yet
      buttons[i].setText("-");
      //set each button to listen for a click
      buttons[i].addActionListener(new buttonListener());
      //add the button to the tic tac toe squares
      add(buttons[i]);
    }
  }

  //function to reset all the buttons to dashes
  public void resetButtons(){
    for(int i = 0; i <= 8; i++){
      buttons[i].setText("-");
    }
  }

  //class to setup button listener for button clicks
  private class buttonListener implements ActionListener{

    //function to take action if a button is clicked
    public void actionPerformed(ActionEvent e) {
      //get the button that was clicked
      JButton buttonClicked = (JButton)e.getSource();
      //change the text of the button that was just clicked to the player's mark
      buttonClicked.setText(currentPlayerMark);
      //check if player has won
      if(checkForWin() == true)
        {
            JOptionPane.showConfirmDialog(null, "Game Over.");
            resetButtons();
        }

      //now that the player has selected his square alternate the player mark
      if (currentPlayerMark=="X"){
        currentPlayerMark="O";
      }
      else{
        currentPlayerMark="X";
      }

      //check if the board is full
      int sum=0;
      for(int i = 0; i <= 8; i++){
        if(buttons[i].getText()=="-"){
          sum++;
        }
      }
      //if the board is full end the game and reset the buttons
      if(sum==0){
        JOptionPane.showConfirmDialog(null, "Game Over.");
        resetButtons();
      }
    }

    //function to check if the player has won the game
    //if the player has won return true, otherwise return false
    public boolean checkForWin(){
      /**   Reference: the button array is arranged like this as the board
       *      0 | 1 | 2
       *      3 | 4 | 5
       *      6 | 7 | 8
       */
      //check the rows
      if(checkRowForWin()==true){
        return true;
      }
      //check the columns
      else if(checkColumnForWin()==true){
        return true;
      }
      //check the diagonals
      else if(checkDiagonalForWin()==true){
        return true;
      }
      else{
        return false;
      }
    }
    //function to check rows for 3 in a row
    //if there is a row with matching 3 in a row return true, otherwise return false
    public boolean checkRowForWin(){
      boolean result=false;
      //for each of the rows compare the values
      for(int i=0;i<=6;i=i+3){
        if((buttons[i].getText()==buttons[i+1].getText())&&(buttons[i+1].getText()==buttons[i+2].getText())&&(buttons[i].getText()!="-")){
          result=true;
        }
      }
      return result;
    }
    //function to check columns for 3 in a column
    //if there is a column with matching 3 in a column return true, otherwise return false
    public boolean checkColumnForWin(){
      boolean result=false;
      //for each of the columns compare the values
      for(int i=0;i<=2;i=i+1){
        if((buttons[i].getText()==buttons[i+3].getText())&&(buttons[i+3].getText()==buttons[i+6].getText())&&(buttons[i].getText()!="-")){
          result=true;
        }
      }
      return result;
    }
    //function to check diagonals for 3 matching
    //if all 3 values in a diagonal match return true, otherwise return false
    public boolean checkDiagonalForWin(){
      boolean result=false;
      //for top left to bottom right diagonal compare the values
      if((buttons[0].getText()==buttons[4].getText())&&(buttons[4].getText()==buttons[8].getText())&&(buttons[0].getText()!="-")){
        result=true;
      }
      //for top right to bottom left diagonal compare the values
      if((buttons[2].getText()==buttons[4].getText())&&(buttons[4].getText()==buttons[6].getText())&&(buttons[2].getText()!="-")){
        result=true;
      }
      return result;
    }
  }

}
