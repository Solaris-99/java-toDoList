package ui;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import toDoList.Step;
import toDoList.Task;


public class Layout {

	private JFrame frame;
	private AddElemForm form;
	
	public Layout(List<Task> tasks) {
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		JPanel tasksPanel = new JPanel();
		form = new AddElemForm(tasksPanel,tasks);
		frame.add(form, BorderLayout.NORTH);
		for(Task t: tasks) {
			tasksPanel.add(new ListElementPanel(t,tasks));
		}
		frame.setBounds(50,50, 400, 600);
		frame.setTitle("To-Do List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tasksPanel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
	public Layout(Task task) {
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		JPanel tasksPanel = new JPanel();
		form = new AddElemForm(tasksPanel,task);
		frame.add(form, BorderLayout.NORTH);
		List<Step> steps = task.getSteps();
 		for(Step t: steps) {
			tasksPanel.add(new ListElementPanel(t,steps));
		}
		frame.setBounds(50,50, 400, 600);
		frame.setTitle("To-Do List");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(tasksPanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	
	
	
	
//	private JFrame jframe;
//	private AddElemForm form;
//	private ListPanel listPanel;

	//add layout manager
	
//	public Layout(int w, int h, List<? extends ListElement> elemList, String title, int closeOperation) {
//		jframe = new JFrame();
//		Container pane = jframe.getContentPane();
//		
//		listPanel = new ListPanel(elemList);
//		
//		form = new AddElemForm(listPanel.panel);
//	
//		pane.setLayout(new BorderLayout());
//		
//		jframe.setBounds(25, 25, w, h);
//		jframe.setTitle(title);
//		jframe.setDefaultCloseOperation(closeOperation);
//		pane.add(form.panel,BorderLayout.NORTH);
//		pane.add(listPanel.panel,BorderLayout.CENTER);
//		jframe.setVisible(true);
//		
//	}
//	
//	public void setFormBtnListener(ActionListener btnListener) {
//		form.addButton.addActionListener(btnListener);
//	}
//	
//	public AddElemForm getForm() {
//		return form;
//	}
//	
//	
//	public JFrame getJFrame() {
//		return this.jframe;
//	}
//	
//	public void update() {
//		jframe.revalidate();
//		jframe.repaint();
//	}
//	
//	public void addToListPanel(JPanel panel) {
//		listPanel.panel.add(panel,0);
//	}
//	
}
