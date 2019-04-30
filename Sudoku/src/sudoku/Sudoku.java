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
    public final int buttonW =45;
    public final int buttonH =45;    
    JMenu menu;
    public final JButton seven;    
    
    
    public static void main(String[] args) {
           Sudoku frame= new Sudoku();
           frame.setVisible(true); 
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("sudokuGrid.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }           
    }
    
    
    public Sudoku(){

        
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
        //seven
        seven = new JButton("7");
        seven.setBounds(30,45,buttonW,buttonH);
        seven.setBackground(new java.awt.Color(245, 245, 228));
        seven.setOpaque(true);       
        contentPane.add(seven);
        /*End Buttons*/
        setDefaultCloseOperation( EXIT_ON_CLOSE ); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton){
        System.out.println("You got it");
        }
        
    }
}
