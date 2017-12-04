/*
 * This program will allow you to create a fish object or multiple by using the 
    constructor that is provided in the fish class. Then if the fish object is
    put into a thread object it will have access to the start method, since the
    fish class implements Runnable. if you have mutliple fish running by using 
    the start method for each then it will make the fish move at the times you
    implemented into the constructo
 */
package project.pkg5.thread.compsci.pkg3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javafx.scene.layout.HBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Project5ThreadCompSci3{

    public static void main(String[] args){
        JFrame j = new JFrame();
        j.setSize(10000, 1000);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(new GridLayout(3,0));
        j.getContentPane().setBackground(Color.CYAN);
        
        Fish f1 = new Fish(500,10, "Red", 50, j);
        Fish f2 = new Fish(1000,10, "Blue", 100, j);
        Fish f3 = new Fish(10, 10, "Yellow", 150, j);
        j.add(f1);
        j.add(f2);
        j.add(f3);
        
        Thread t = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread (f3);
 
        j.setVisible(true);
        
        t.start();
        t2.start();
        t3.start();
        
    }
    
}
