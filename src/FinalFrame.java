import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FinalFrame {
    JFrame frame;
    JLabel label;
    FinalFrame()
    {
        frame  = new JFrame();
        label =  new JLabel("Hi im the output");
        label.setBounds(10,10,100,30);
        frame.add(label);
        frame.setLayout(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
