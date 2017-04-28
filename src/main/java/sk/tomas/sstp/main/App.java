package sk.tomas.sstp.main;

import sk.tomas.servant.annotation.Autowired;
import sk.tomas.sstp.gui.ControlPanel;
import sk.tomas.sstp.gui.SecondScreenFrame;

/**
 * Created by Tomas Pachnik on 26-Apr-17.
 */
public class App {

    @Autowired
    private ControlPanel controlPanel;
    @Autowired
    private SecondScreenFrame secondScreenFrame;

    private String text;

    public App() {
        this.text = "";
    }

    void initialize() {

        Thread thread1 = new Thread(controlPanel);
        Thread thread2 = new Thread(secondScreenFrame);

        thread1.start();
        thread2.start();

    }

    public String getText() {
        return text;
    }

    public void updateText(String text) {
        this.text = text;
        secondScreenFrame.getJTextArea().setText(text);
    }
}
