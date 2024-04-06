package toDoList;

import java.io.*;
import java.util.*;
import java.util.Comparator;

public class TaskHandler implements Serializable {

	public static final String TASKS_FILE = "tasks.dat";
	private List<Task> tasks;

	public TaskHandler() {
		loadTasks();
//		loadData();
//		if(tasks == null){
//			tasks = new ArrayList<Task>();
//		}
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(0, task);
		saveData();
		saveTasks();
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
	
	//text-based
	public void saveData() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"));
			for (Task t : tasks) {
				writer.write(t+ "\n");
			}
			writer.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private void loadData() {
		tasks = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"));
			String line;
			while((line = reader.readLine()) != null ) {
				if(line.isEmpty()){
					break;
				}
				String creationDate, finishDate, name, steps, step;
				int crDateBrckt1, crDateBrckt2, finDateBrckt1, finDateBrckt2, bgnSteps;
				String[] stepsArr;

				//indexes
				crDateBrckt1 = line.indexOf("[");
				crDateBrckt2 = line.indexOf("]");
				finDateBrckt1 = line.indexOf("[", crDateBrckt2);
				finDateBrckt2 = line.indexOf("]", crDateBrckt2+1);
				bgnSteps = line.lastIndexOf("}>:");

				//substrings
				creationDate = line.substring(crDateBrckt1+1,crDateBrckt2);
				finishDate = line.substring(finDateBrckt1+1,finDateBrckt2);
				name = line.substring(finDateBrckt2+1, bgnSteps);
				steps = line.substring(bgnSteps+3);

				//create task
				Task task = new Task(name, creationDate,finishDate);

				System.out.println("task: " + name);
				if(steps.length() > 1){

					stepsArr = steps.split(",");
					System.out.println(Arrays.toString(stepsArr));
					for(String s : stepsArr){
						if(!s.equals(";")){

						System.out.println("Step substring s: "+ s);
						crDateBrckt1 = s.indexOf("[");
						crDateBrckt2 = s.indexOf("]");
						finDateBrckt1 = s.indexOf("[", crDateBrckt2);
						finDateBrckt2 = s.indexOf("]", crDateBrckt2+1);

						//substrings for step
						creationDate = s.substring(crDateBrckt1+1,crDateBrckt2);
						finishDate = s.substring(finDateBrckt1+1,finDateBrckt2);
						name = s.substring(finDateBrckt2+1,s.length()-1);
						Step stepObj = new Step(name,creationDate,finishDate, task);
						task.addStep(stepObj);
						System.out.println("step: "+name);
						}

						//create step, add to task
					}

				}
				this.addTask(task);
				tasks.sort(Comparator.comparing(ListElement::getCreationDate).reversed());
			}
			reader.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}


}
