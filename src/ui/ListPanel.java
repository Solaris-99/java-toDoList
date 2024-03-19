package ui;
import javax.swing.*;
import java.util.List;
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
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	
		
	
}
