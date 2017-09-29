/**
 * Created by Michael Sipes-Brandt on 9/29/17.
 */
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DisplayTester {

    public static void main(String[] args){

        JTextArea output = new JTextArea(20,30);
        DefaultCaret caret = (DefaultCaret)output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        Inputter inp = new Inputter("Homework 1", output);
        inp.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
    }



}
