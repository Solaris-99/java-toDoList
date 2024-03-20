package toDoList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


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
				//Just alternate fonts; [local]
			}
		};
		this.button.addActionListener(btnListener);
	}
	
	
}
