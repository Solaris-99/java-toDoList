package ui;


import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    public Header(){
        JLabel cDate, taskName, fDate;
        cDate = new JLabel("<html><strong>Creación</strong></html>");
        this.setPreferredSize(new Dimension(375,35));
        taskName = new JLabel("<html><strong>Tarea</strong></html>");
        taskName.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        fDate = new JLabel("<html><strong>Finalización    Del.</strong></html>");
        this.setLayout(new BorderLayout());
        add(cDate,BorderLayout.WEST);
        add(taskName,BorderLayout.CENTER);
        add(fDate,BorderLayout.EAST);
    }
}
