package ui;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import javax.swing.*;

import toDoList.ListElement;
import toDoList.TaskHandler;

public class ListElementPanel extends JPanel implements Serializable {
	private final Font DEF_FONT = new Font("helvetica", Font.BOLD, 12);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	private Font doneFont;
    private final JLabel finishDatePanel;
	private final ElementButton elementButton;
	private final String dateDisplayHtml = "<html><p style='font-weight:bold;font-size:10px;text-align:center'>%s</p><p style='font-size:8px'>%s</p></html>";


    public ListElementPanel(ListElement elem, List<? extends ListElement> list, TaskHandler handler) {
		int labelWidth = 65;
		int labelHeight = 30;
		String creationDate;
		String[] creationDateSplit;
		creationDateSplit=DATE_FORMAT.format(elem.getCreationDate()).split(" ");
		creationDate = String.format(dateDisplayHtml,creationDateSplit[0],creationDateSplit[1]);
		JLabel creationDatePanel = new JLabel(creationDate);
		elementButton = new ElementButton(elem, handler);
		DeleteButton delButton = new DeleteButton(elem, list, handler);
		finishDatePanel = new JLabel();
		creationDatePanel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		finishDatePanel.setPreferredSize(new Dimension(labelWidth,labelHeight));
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

		//this.setPreferredSize(new Dimension(this.getWidth(), elementButton.getHeight()));
	}

	public ElementButton getElementButton() {
		return elementButton;
	}
		
	public void clearFinishState() {
		System.out.println("Clearing panel finish state..");
		finishDatePanel.setText("<html><p style='margin-left:20px;text-align:center;font-weight:bold;font-style:italic'> P </p></html>");
		elementButton.setFont(DEF_FONT);
	}
	
	public void setFinished(Date date) {
		System.out.println("Setting panel finish state..");

		String[] split = DATE_FORMAT.format(date).split(" ");
		String s = String.format(dateDisplayHtml,split[0],split[1]);


		finishDatePanel.setText(s);
		elementButton.setFont(doneFont);
	}
	
	private void setDoneFont() {
		Map attributes = DEF_FONT.getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		doneFont = new Font(attributes);
	}
	
}
