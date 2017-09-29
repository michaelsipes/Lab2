/**
 * Created by Michael Sipes-Brandt on 9/29/17.
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Inputter extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private JTextArea output;
    private boolean inputting;
    private boolean doneInputting;
    private String message;
    private DisplayerWindow displayer;

    public Inputter(String name, JTextArea output) {
        super(name);
        this.output = output;
        add(new JScrollPane(output)); // add a Scroll bar to JFrame, scrolling associated with JTextArea object
        setSize(500, 500);            // when lines of messages exceeds the line capacity of JFrame, scroll bar scroll down.
        setVisible(true);
        output.addKeyListener(this);  // Adds the specified key listener to receive key events from this component.

        inputting = false;
        doneInputting = false;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(!inputting){
            inputting = true;
            doneInputting = false;
            message = "";
            if(displayer != null && displayer.isAlive()){
                displayer.interrupt();
                try {
                    displayer.join();
                } catch (InterruptedException e1) {
                    return;
                }
            }
        }
    }

    @Override
    //
    public void keyReleased(KeyEvent e) {

        if(inputting && !doneInputting){
            if(e.getKeyCode() != KeyEvent.VK_ENTER){
                message += e.getKeyChar();
                if(message.equalsIgnoreCase("exit")){
                    System.exit(0);
                }
            }else{
                doneInputting = true;
                inputting = false;
                if(doneInputting){
                    displayer = new DisplayerWindow("Displayer", message, output);
                    displayer.start();
                    doneInputting = false;
                }
            }
        }



    }

}

