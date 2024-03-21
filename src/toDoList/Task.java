package toDoList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import ui.AddElemForm;
import ui.Layout;

public class Task extends ListElement implements Serializable{ 
	private List<Step> steps;
	private TaskHandler handler;
	
	public Task (String name, List<? extends ListElement> list, TaskHandler handler) {
		super(name, list);
		this.handler = handler;
		setButtonListener();
		this.steps = new ArrayList<>();
	}
	
	

	public List<Step> getSteps(){
		return this.steps;
	}
	
	public void add(Step step) {
		steps.add(step);
		handler.saveTasks();
	}
	
	private void setButtonListener() {
		ActionListener btnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.print("Task pressed");
				//open a new window, show tasks
				//create a new Layout.
				createLayout();
				
			}
		};
		this.button.addActionListener(btnListener);
	}
	
	private void createLayout() {
		Layout stepsLayout = new Layout(400,600,steps, name, JFrame.DISPOSE_ON_CLOSE);
		AddElemForm form = stepsLayout.getForm();
		//button for adding steps
		ActionListener AddStepBtnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Step step = new Step(form.textField.getText(), steps);
				add(step);
				stepsLayout.addToListPanel(step.panel);
				form.panel.revalidate();
				form.panel.repaint();
				
			}
		};
		stepsLayout.setFormBtnListener(AddStepBtnListener);
	}
	

}
