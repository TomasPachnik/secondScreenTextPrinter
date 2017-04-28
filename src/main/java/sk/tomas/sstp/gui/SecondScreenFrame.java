package sk.tomas.sstp.gui;

import sk.tomas.servant.annotation.Autowired;
import sk.tomas.sstp.configuration.PropertyBundle;
import sk.tomas.sstp.main.App;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tomas Pachnik on 25-Apr-17.
 */
public class SecondScreenFrame extends JFrame implements Runnable {

    @Autowired
    private App app;
    @Autowired
    private PropertyBundle propertyBundle;

    private JTextArea jTextArea;
    private Point p;

    public void setP(Point p) {
        this.p = p;
    }

    private void showFrame() {
        JPanel panel = new JPanel();

        //remove entire titlebar
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        // Can not be resized
        setResizable(false);
        //set maximized
        setExtendedState(Frame.MAXIMIZED_BOTH);

        panel.setBackground(Color.BLACK);
        setContentPane(panel);

        jTextArea = new JTextArea();

        //center JTextArea
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, propertyBundle.getFontsize());
        jTextArea.setFont(font);

        if (!propertyBundle.invertColors()) {
            jTextArea.setBackground(Color.BLACK);
            jTextArea.setForeground(Color.WHITE);
        } else {
            jTextArea.setBackground(Color.WHITE);
            jTextArea.setForeground(Color.BLACK);

        }

        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);

        jTextArea.setColumns(propertyBundle.getColumns());
        jTextArea.setRows(propertyBundle.getRows());

        jTextArea.setText(app.getText());

        panel.add(jTextArea, gbc);

        setLocation(p);
        pack();
        setVisible(true);
    }

    public JTextArea getJTextArea() {
        return jTextArea;
    }

    @Override
    public void run() {
        showFrame();
    }
}
