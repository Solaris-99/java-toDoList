package toDoList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskHandler implements Serializable {

	public static final String TASKS_FILE = "tasks.dat";
	private List<Task> tasks;

	public TaskHandler() {
		loadTasks();
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(0, task);
		saveTasks(tasks);
	}

	public void saveTasks(List<Task> tasks) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TASKS_FILE))) {
			outputStream.writeObject(tasks);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveTasks() {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TASKS_FILE))) {
			outputStream.writeObject(tasks);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadTasks() {
		tasks = new ArrayList<>();
		File file = new File(TASKS_FILE);
		if (file.exists()) {
			try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
				tasks = (ArrayList<Task>) inputStream.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
