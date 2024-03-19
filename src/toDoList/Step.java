package toDoList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Step extends ListElement{
	
	public Step(String description) {
		super(description);
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
