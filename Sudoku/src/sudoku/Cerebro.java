/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import static java.lang.Math.random;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;

/**
 *
 * @authors Emilio Águila Escalante - 163009
 *         Jorge Tenorio - 
 *         Mauricio Tenorio -
 */


public class Cerebro {
    public int[][] matrixI, matrixP, matrixS;
    public String[][] matrizPP;
    public File archivo;
    public Scanner lector;
    
    public Cerebro(){
        matrixI=new int[9][9];
        matrixS=new int[9][9];
        matrixP=new int[9][9];     
	matrizPP= new String[9][9];
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
    
    public void saveG ()throws IOException{

        // https://www.programcreek.com/2011/03/java-write-to-a-file-code-example/
        
        File fnew=new File("C:\\Users\\jorge\\Documents\\NetBeansProjects\\sudoku\\src\\sudoku\\partida.txt");
        String source;
        FileOutputStream fos = new FileOutputStream(fnew);
 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        
                    
                    //c
         try{
       

        for (int i = 0; i < 9; i++){

            for (int j = 0; j < 9; j++){
                
                if ( matrizPP[i][j].equals("")){
                source = "0";
                } else{
                source = matrizPP[i][j];;
                
                } 

        bw.write(source);
        bw.newLine();
  
          
            }
            
        }
        
        bw.close();

         }catch (IOException e) {

			e.printStackTrace();

                }

    }    

    
    public void loadG(){
        
      
    }    
    
    public boolean checkWin(){
        boolean winner;
        winner=false;
        return winner;
    }    
    
    
    
}
