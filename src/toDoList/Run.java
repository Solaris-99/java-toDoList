package toDoList;

import java.util.ArrayList;
import java.util.List;

import ui.Layout;

public class Run {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Task> tasks = new ArrayList<>();
		
//		tasks.add(new Task("t1"));
//		tasks.add(new Task("t2"));
//		tasks.add(new Task("t3"));
		
		Layout layout = new Layout(tasks);
	}
	

}
