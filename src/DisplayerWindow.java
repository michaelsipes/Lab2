/**
 * Created by Michael Sipes-Brandt on 9/29/17.
 */
import javax.swing.*;

/**
 * Created by user on 9/27/17.
 */
public class DisplayerWindow extends Thread{


    private JTextArea output;
    private String message;
    private String name;

    public DisplayerWindow(String name, String message, JTextArea output){
        this.name = name;
        this.output = output;
        this.message = message;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            this.output.append(message + "\n");
        }
    }
}
