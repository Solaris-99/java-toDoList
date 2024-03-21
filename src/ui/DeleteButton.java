package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import toDoList.ListElement;

public class DeleteButton extends JButton implements ActionListener{
	ListElement elem;
	List<? extends ListElement> list;
	
	public DeleteButton(ListElement elem, List<? extends ListElement> list) {
		super("X");
		this.elem = elem;
		this.list = list;
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		JPanel parentPanel = (JPanel) this.getParent();
		JPanel grandPPanel = (JPanel) parentPanel.getParent();
		list.remove(elem);
		grandPPanel.remove(parentPanel);
		grandPPanel.revalidate();
		grandPPanel.repaint();
		System.out.println("deleted");
		System.out.println(list.toString());
	}
	
}
