
import gui.MailClientApplet;
import gui.MainApplet;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Main {
    
    public static void main (String[] args) {
        JFrame frame = new JFrame("Email Client");
        frame.setSize(850, 640);
        frame.setLocationRelativeTo(null);
        MainApplet mailApp = new MainApplet();
        mailApp.init();
        frame.getContentPane().add(mailApp);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
