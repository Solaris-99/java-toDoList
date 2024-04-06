package ui;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toDoList.ListElement;
import toDoList.TaskHandler;

public class ListElementPanel extends JPanel implements Serializable {
	
	private final Font DEF_FONT = new Font("helvetica", Font.BOLD, 12);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	private Font doneFont;
    private final JLabel finishDatePanel;
	private final ElementButton elementButton;

    public ListElementPanel(ListElement elem, List<? extends ListElement> list, TaskHandler handler) {
        JLabel creationDatePanel = new JLabel(DATE_FORMAT.format(elem.getCreationDate()));
		elementButton = new ElementButton(elem, handler);
        DeleteButton delButton = new DeleteButton(elem, list, handler);
		finishDatePanel = new JLabel();
		add(creationDatePanel);
		add(elementButton);
		add(finishDatePanel);
		add(delButton);
		setDoneFont();
		if(elem.isFinished()) {
			setFinished(elem.getFinishDate());
		}
		else {
			clearFinishState();
		}
		
	}
	
	public ElementButton getElementButton() {
		return elementButton;
	}
		
	public void clearFinishState() {
		System.out.println("Clearing panel finish state..");
		finishDatePanel.setText("P");
		elementButton.setFont(DEF_FONT);
	}
	
	public void setFinished(Date date) {
		System.out.println("Setting panel finish state..");

		String s = DATE_FORMAT.format(date);
		finishDatePanel.setText(s);
		elementButton.setFont(doneFont);
	}
	
	private void setDoneFont() {
		Map attributes = DEF_FONT.getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		doneFont = new Font(attributes);
	}
	
}
