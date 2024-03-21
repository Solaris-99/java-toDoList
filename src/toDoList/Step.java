package toDoList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.List;
import java.util.Map;


public class Step extends ListElement{
	
	
	public Step(String description, List<? extends ListElement> list) {
		super(description, list);
		setButtonListener();
	}

	
	private void setButtonListener() {
		ActionListener btnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.print("Task pressed");
				setStrikethroughFont();
				panel.repaint();
				//Just alternate fonts; [local]
			}
		};
		this.button.addActionListener(btnListener);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	private void setStrikethroughFont() {
		Font font = new Font("helvetica", Font.BOLD, 12); 
		if(!this.done) {
			Map attributes = font.getAttributes();
			attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
			Font newFont = new Font(attributes);
			this.button.setFont(newFont);
		}
		else {
			this.button.setFont(font);
		}
		this.done = !this.done;
		
	}
	
	
}
