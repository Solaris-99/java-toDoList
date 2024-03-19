package ui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import toDoList.ListElement;


public class Layout {
	private JFrame jframe;
	private AddElemForm form;
	private ListPanel listPanel;

	//add layout manager
	
	public Layout(int w, int h, List<? extends ListElement> elemList) {
		jframe = new JFrame();
		Container pane = jframe.getContentPane();
		
		listPanel = new ListPanel(elemList);
		
		form = new AddElemForm(listPanel.panel);
	
		pane.setLayout(new BorderLayout());
		
		jframe.setBounds(10, 10, w, h);
		jframe.setTitle("To-Do List");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.add(form.panel,BorderLayout.NORTH);
		pane.add(listPanel.panel,BorderLayout.CENTER);
		jframe.setVisible(true);
		
	}
	
	public void setFormBtnListener(ActionListener btnListener) {
		form.addButton.addActionListener(btnListener);
	}
	
	public AddElemForm getForm() {
		return form;
	}
	
	
	public JFrame getJFrame() {
		return this.jframe;
	}
	
	public void update() {
		jframe.revalidate();
		jframe.repaint();
	}
	
	public void addBtnListPanel(JButton btn) {
		listPanel.panel.add(btn);
	}
	
}
