package toDoList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ui.AddElemForm;
import ui.Layout;


public class Run {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Task> tasks = new ArrayList<>();
		Layout tasksLayout = new Layout(400,600,tasks);
		AddElemForm layoutForm = tasksLayout.getForm();
		ActionListener AddTaskBtnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Task task = new Task(layoutForm.textField.getText());
				tasks.add(task);
				
				tasksLayout.addBtnListPanel(task.getButton());
				layoutForm.panel.revalidate();
				layoutForm.panel.repaint();
				System.out.println("Task added");
			}
		};
		tasksLayout.setFormBtnListener(AddTaskBtnListener);
		tasksLayout.update();
		
	}
	

}
