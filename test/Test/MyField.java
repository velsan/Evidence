package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author velsan
 */
public class MyField {

    JFrame frame = new JFrame();
    static JTextField field = new JTextField(15);

    public void inicialize() {
        frame.setVisible(true);
        frame.setTitle("Evidence");
        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 150);
        frame.setBackground(Color.decode("#CDCD00"));
       // field.addActionListener(new TextActionListener());
        frame.add(field);
    }
    
    public static JTextField getField() {
        return field;
    }
    
    class TextActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
}
