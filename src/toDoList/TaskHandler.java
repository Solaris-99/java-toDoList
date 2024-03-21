package toDoList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import ui.AddElemForm;
import ui.Layout;

public class TaskHandler  implements Serializable{
	
	List<Task> tasks;
	Layout layout;
	public static final String TASKS_FILE = "tasks.dat";
	
	//TODO:
	//constructor no parameters
	public TaskHandler(){
		loadTasks();
		layout = new Layout(400,600,tasks,"To-Do List", JFrame.EXIT_ON_CLOSE);
		AddElemForm layoutForm = layout.getForm();
		TaskHandler thisHandler = this;
		ActionListener AddTaskBtnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String text = layoutForm.textField.getText();
				if(!text.isBlank()) {
					Task task = new Task(text, tasks, thisHandler);
					tasks.add(task);
					layout.addToListPanel(task.panel);
					layoutForm.panel.revalidate();
					layoutForm.panel.repaint();
					System.out.println("Task added");
					layoutForm.textField.setText("");
					saveTasks();
				}
			}
		};
		layout.setFormBtnListener(AddTaskBtnListener);
		layout.update();
	}
	
	
	public void saveTasks() {
		//TODO
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TASKS_FILE))) {
            outputStream.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void loadTasks() {
		List<Task> tasks = new ArrayList<>();
		File file = new File(TASKS_FILE);
		if (file.exists()) {
			//TODO
			try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                tasks = (List<Task>) inputStream.readObject();
                System.out.println("Tasks loaded");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
		}
		this.tasks = tasks;
	}
	
	
	
	
}
