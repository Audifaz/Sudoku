/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
/**
 *
 * @author Emilio Águila Escalante - 163009
 *         Jorge Tenorio Guzmán - 162107
 *         Mauricio Tenorio Guzmán- 162106
 */
public class Cerebro {
   public int [][] matrixI;
   public String [][] matrixP;
   public int [][] matrixS;
  
   //public  Sudoku sud;
   
    public String contenido;
    public Cerebro() {
        
         matrixI= new int[9][9];
         matrixP= new String[9][9];
         matrixS= new int[9][9];
         // sud = new Sudoku();
         
    }
    public void startG(){
         File f = new File("Matrizinicial.txt");

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
                                             //System.out.println("  "+matrixI[i][j]);  
                                            }

                                    }
                                }
				
			
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
                }
    }
    public void matrizsolución(){
        File f = new File("Matrizsolucion.txt");

		Scanner s;
		try {	
                    //cargamos el archivo con la clase Scan
                    s  = new Scanner(f);
                    //Impirmimos el contenido
			
                                for (int i = 0; i < 9; i++){
                                        for (int j = 0; j < 9; j++){
                                            if (s.hasNextLine())
                                            {
                                                matrixS[i][j] =  s.nextInt();  
                                                System.out.println(matrixS[i][j]);
                                            }

                                    }
                                }
				
			
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
                }
    }
    
    public void loadG(){
        File f = new File("Matrizpartida.txt");

		Scanner s;
		try {	
                    //cargamos el archivo con la clase Scan
                    s  = new Scanner(f);
                    //Impirmimos el contenido
			
                                for (int i = 0; i < 9; i++){
                                        for (int j = 0; j < 9; j++){
                                            if (s.hasNextLine())
                                            {
                                                matrixP[i][j] =  s.nextLine();  
                                            }

                                    }
                                }
				
			
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
                }
    }
   public void saveG(){
        try {
            String ruta = "Matrizpartida.txt";
            
            File file = new File(ruta);

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < 9; i++){
                                        for (int j = 0; j < 9; j++){
                                         
                                              contenido = matrixP [i][j];
                                              bw.write(contenido);
                                                bw.newLine();
                                    }
                                }
            
            
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
