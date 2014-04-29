package poo.tema.trial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * User: Alexandru Burghelea
 * Date: 1/2/13
 * Time: 7:20 PM
 */
public class FrameWithAdapter {
    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Main");
        JButton opener = new JButton("Open new window");
        for (int i = 0 ; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            mainWindow.add(button);
        }
        mainWindow.add(opener);
        mainWindow.setLayout(new FlowLayout());
        mainWindow.pack();
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        mainWindow.setVisible(true);
        mainWindow.setVisible(true);
//
        final JFrame frame = new JFrame("Test");
        opener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing window");
                frame.setVisible(false);
            }
        });
    }
}
