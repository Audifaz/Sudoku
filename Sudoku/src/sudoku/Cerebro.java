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
           File f = new File("C:\\Users\\LIVERPOOL I5\\Documents\\NetBeansProjects\\Sudoku\\src\\sudoku\\Matrizinicial.txt");

		Scanner s;
		try {	
                    //cargamos el archivo con la clase Scan
                    s  = new Scanner(f);
                    //Impirmimos el contenido
			
                                for (int i = 0; i < 9; i++){
                                        for (int j = 0; j < 9; j++){
                                            if (s.hasNextLine())
                                            {
                                                matrixI[i][j] =  s.nextInt(); 
                                             System.out.println("  "+matrixI[i][j]);  
                                            }

                                    }
                                }
				
			
			s.close();
                         for (int i = 0; i < 9; i++){
                                        for (int j = 0; j < 9; j++){
                                            System.out.println("  "+matrixI[i][j]);   
                                    }
                                }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
