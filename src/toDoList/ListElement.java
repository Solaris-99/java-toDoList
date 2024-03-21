package toDoList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public abstract class ListElement {
	protected JButton button;
	protected JButton delButton;
	protected String name;
	protected Date date;
	public JPanel panel;
	public Date finishDate;
	public boolean done;
	
	public ListElement(String name, List<? extends ListElement> list)  {
		this.name = name;
		this.button = new JButton(name);
		this.done = false;
		this.delButton = new JButton("X");
		this.panel = new JPanel();
		panel.add(button);
		panel.add(delButton);
		this.date = new Date();
		ListElement element = this;
		
		ActionListener delBtnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int res = JOptionPane.showOptionDialog(new JFrame(), "¿Deseas borrar este elemento?","Borrar",
				         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				         new Object[] { "Sí", "No" }, JOptionPane.YES_OPTION);
				if(res == JOptionPane.YES_OPTION) {
				JPanel parentPanel = (JPanel) panel.getParent();
				list.remove(list.indexOf(element));
				parentPanel.remove(panel);
				parentPanel.revalidate();
				parentPanel.repaint();
				}
			
			}
		};
		delButton.addActionListener(delBtnListener);

		button.setPreferredSize(new Dimension(300,30));
		panel.setMaximumSize(new Dimension(400, 50));;
		panel.setBorder(new LineBorder(Color.red,5,true)); //debug
		
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public JButton getButton(){
		return this.button;
	}
	
	public Date getDate() {
		return this.date;
	}
	
}
