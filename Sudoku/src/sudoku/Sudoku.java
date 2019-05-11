/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import javax.swing.JMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author Emilio Águila Escalante - 163009
 *         Jorge Tenorio - 162107
 *         Mauricio Tenorio - 162106
 */
public class Sudoku extends JFrame implements ActionListener{
    
    public final int frameWidth = 600;
    public final int frameHeight = 640;
    public final int frameXOrigin = 425;
    public final int frameYOrigin = 100;
    public final int buttonW =60;
    public final int buttonH =59;    
    public JMenu menu;
    public int counter=0;
    public JButton[][] botones;
    public Cerebro brain;
    public int correctas;
    public String [][] matrixtemp;
    
    public static void main(String[] args) {
           Sudoku frame= new Sudoku();
           frame.setVisible(true);          
    }
    
    
    public Sudoku(){

        /*https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        Oracle (2017) "How to Set the Look and Feel". Accessed the 4 of May of 2019
        */
        try {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        Container contentPane=getContentPane();
        contentPane.setLayout( null );        
        setSize      (frameWidth, frameHeight);
        setResizable (false);
        setTitle     ("Sudoku");
        setLocation  (frameXOrigin, frameYOrigin);
        /* Background
        It was inspired from 
        Tech-gram Academy (2018) "50. How to set an image as background | JFrame | Java swing | Hindi". Retrieved from: https://www.youtube.com/watch?v=TQEEsR559QQ
        */
        JLabel background;
        ImageIcon img = new ImageIcon("sudokuGrid.png");
        background = new JLabel("",img, JLabel.CENTER);
        background.setBounds(0,0,600,600);
        add(background);
        /* Menus */ 
        JMenuItem item;
        JMenuBar jmenubar;
        menu = new JMenu("Options");
        //
        item = new JMenuItem("Start new game");
        item.addActionListener(this);
        menu.add(item);
        //
        menu.addSeparator();
        //
        item = new JMenuItem("Save current game");
        item.addActionListener(this);
        menu.add(item); 
        //
        menu.addSeparator();
        //
        item = new JMenuItem("Load saved game");
        item.addActionListener(this);
        menu.add(item); 
        //
        menu.addSeparator();
        //
        item = new JMenuItem("Check if you have alredy win");
        item.addActionListener(this);
        menu.add(item); 
        //
        menu.addSeparator();
        //
        item = new JMenuItem("Exit");
        item.addActionListener(this);
        menu.add(item); 
        //          
        jmenubar = new JMenuBar();
        setJMenuBar(jmenubar);
        jmenubar.add(menu); 
        /* End Menus */
        /*Buttons*/
        int i, j, a,b;
        botones = new JButton[9][9];
        a=25;
        b=24;
        //Inspirado en el código de https://prografacilsite.wordpress.com/2017/06/15/como-crear-una-matriz-grafica-de-botones-en-java-dinamicamente/
        //Devjtello (2017) "Como hacer una matriz gráfica de botones en java". Accesado el 2 de Mayo de 2019
        for (i = 0; i < 9; i++)
                {
                    for (j = 0; j < 9; j++)
                    {
                        JButton btnNuevo = new JButton();
                        btnNuevo.setText(Integer.toString(i+1) + Integer.toString(j+1));
                        btnNuevo.setBackground(new java.awt.Color(238, 238, 238));
                        
                        Font font = new Font("Arial", Font.BOLD, 19);
                        btnNuevo.setFont(font);                        
                        botones[i][j] = btnNuevo;
                        contentPane.add(botones[i][j]);
                        botones[i][j].setBounds(a,b,buttonW,buttonH);
                        botones[i][j].addActionListener(this);
                        
                        if(a % 3 ==0||a % 5 == 0){
                            a=a+1;
                        }
                        a=a+61;
                        System.out.println("["+a+"]"+"["+b+"]");
                    }
                    a=25;
                        if(b % 3==0){
                            b=b+1;
                        }                   
                    b=b+61;
                    j=1;
                }
        /*End Buttons*/
        setDefaultCloseOperation( EXIT_ON_CLOSE ); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
                JButton clickedButton = (JButton)e.getSource();
                String buttonText = clickedButton.getText();
                        if(buttonText.equals("")){
                                counter=1;
                                buttonText="1";
                                clickedButton.setText(Integer.toString(counter));
                                }
                                else
                                {        
                                        if(Integer.parseInt(buttonText)>8){
                                            clickedButton.setText("");
                                            buttonText="0";
                                        }
                                        else{
                                            counter=Integer.parseInt(buttonText)+1;
                                        }
                                        if( !buttonText.equals("0")){            
                                                clickedButton.setText(Integer.toString(counter));   
                                                clickedButton.setForeground(Color.black); 
                                        }
                                }
            }
            else
            {  
                JMenuItem clickedMenu = (JMenuItem)e.getSource();
                String menuText = clickedMenu.getText();  
                       switch(menuText){
                            case "Start new game": 
                                brain=new Cerebro();
                                brain.startG();
                                                for (int i = 0; i < 9; i++)
                                                {
                                                        for (int j = 0; j < 9; j++)
                                                        {
                                                           int v;
                                                           v=brain.matrixI[i][j];
                                                            if(v==0){
                                                            botones[i][j].setText(""); 
                                                            botones[i][j].setBackground(new java.awt.Color(255, 255, 255));                                                              
                                                            }
                                                            else{
                                                            botones[i][j].setEnabled(false); 
                                                            botones[i][j].setForeground(Color.black);
                                                            botones[i][j].setText(Integer.toString(brain.matrixI[i][j]));
                                                            }
                                                    }
                                                 }                                 
                            break;
                            case "Save current game":
                                for (int i = 0; i < 9; i++){
                                        for (int j = 0; j < 9; j++){
                                            String a;
                                            a = botones[i][j].getText();
                                            if(a.equals ("")){      
                                               brain.matrixP[i][j] = "0";
                                            }
                                            else{
                                                brain.matrixP[i][j]= botones[i][j].getText();
                                            }
                                    }
                                }
                                brain.saveG();
                            break;
                            case "Load saved game": 
                            brain.loadG();
                                for (int i = 0; i < 9; i++){
                                        for (int j = 0; j < 9; j++){
                                    int v;
                                                           v = Integer.parseInt(brain.matrixP[i][j]);
                                                            if(v == 0){
                                                            botones[i][j].setText(""); 
                                                            botones[i][j].setBackground(new java.awt.Color(255, 255, 255));                                                              
                                                            }
                                                            else{
                                                            botones[i][j].setForeground(Color.black);
                                                            botones[i][j].setText(brain.matrixP[i][j]);
                                                            }
                                        }
                                }
                            break;                                   
                            case "Check if you have alredy win": 
                                 correctas = 0;
                                brain.matrizsolución();
    
                               for(int i = 0; i < 9; i++){
                                    for(int j = 0; j < 9; j++){
                                        matrixtemp [i][j] = Integer.toString(brain.matrixS[i][j]);
                                        //System.out.println(matrixtemp[i][j]);
                                            if(matrixtemp [i][j].equals(brain.matrixP[i][j])){
                                                    
                                                    correctas ++;
                                                }
                                           else{
                                                    botones[i][j].setForeground(Color.red); 
                                                }
                                        } 
                                }
                               
                                 if(correctas == 81){
                                    JOptionPane.showMessageDialog(null,"Has ganado");
                                    
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Vuelvelo a intentar");
                                }
                            break;  
                            case "Exit": System.exit(0);
                            break;
                    }
            }   
    }//End actionPerformed


}
