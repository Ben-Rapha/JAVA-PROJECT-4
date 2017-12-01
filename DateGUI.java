/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

/**
 *
 * @author KINGSLEY OTTO
 */
import java.awt.GridLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author KINGSLEY OTTO
 */


public class DateGUI extends JFrame {
	
        
        // CREATE GUI STYLE
        public DateGUI(String title, int height, int width) {
	    setTitle(title);
	    setSize(height,width);
            setLocation  (600,200);
	    createMenu();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new GridLayout(1,2));
            setVisible(true);
   } //SSNGUI
       
  
      
	
     private void createMenu( ) {
      JMenuItem   item;
      JMenuBar    menuBar  = new JMenuBar();
      JMenu       fileMenu = new JMenu("File");
      FileMenuHandler fmh  = new FileMenuHandler(this);
      item = new JMenuItem("Open");    //Open...
      item.addActionListener( fmh );
      fileMenu.add( item );
      item = new JMenuItem("Quit");       //Quit...
      item.addActionListener( fmh );
      fileMenu.add( item );
      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      
    } //CREATE MENU

 }
