package ui;
import java.awt.Color;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import toDoList.ListElement;

public class ListPanel {
	
	public JPanel panel;
	private JScrollPane scrollPane;
	
	public ListPanel(List<? extends ListElement> list) {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(panel);
		for(ListElement t: list) {
			
			panel.add(t.getButton());
			
		}
		panel.setBorder(new LineBorder(Color.red,5,true)); //debug
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	
		
	
}
