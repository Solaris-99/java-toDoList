package ui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import toDoList.ListElement;


public class Layout {
	private JFrame jframe;
	private AddElemForm form;
	private ListPanel listPanel;

	//add layout manager
	
	public Layout(int w, int h, List<? extends ListElement> elemList, String title, int closeOperation) {
		jframe = new JFrame();
		Container pane = jframe.getContentPane();
		
		listPanel = new ListPanel(elemList);
		
		form = new AddElemForm(listPanel.panel);
	
		pane.setLayout(new BorderLayout());
		
		jframe.setBounds(25, 25, w, h);
		jframe.setTitle(title);
		jframe.setDefaultCloseOperation(closeOperation);
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
	
	public void addToListPanel(JPanel panel) {
		listPanel.panel.add(panel,0);
	}
	
}
