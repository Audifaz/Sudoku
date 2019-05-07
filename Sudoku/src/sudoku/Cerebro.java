/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

import java.io.File;
import static java.lang.Math.random;
import java.util.Scanner;

/**
 *
 * @authors Emilio Águila Escalante - 163009
 *         Jorge Tenorio - 
 *         Mauricio Tenorio -
 */


public class Cerebro {
    public int[][] matrixI, matrixP, matrixS;
    public File archivo;
    public Scanner lector;
    
    public Cerebro(){
        matrixI=new int[9][9];
        matrixS=new int[9][9];
        matrixP=new int[9][9];        
    }
    
    public void startG(){
           for (int i = 0; i < 9; i++)
                {
                    for (int j = 0; j < 9; j++)
                    {
                            matrixI[i][j]=(int)((Math.random())*10);       
                    }

                }
      
    }
    
    public void saveG(){
        
      
    }    
    
    public void loadG(){
        
      
    }    
    
    public boolean checkWin(){
        boolean winner;
        winner=false;
        return winner;
    }    
    
    
    
}
