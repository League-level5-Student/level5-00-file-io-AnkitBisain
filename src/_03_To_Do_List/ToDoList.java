package _03_To_Do_List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton addTask = new JButton("add task");
		JButton viewTasks = new JButton("view tasks");
		JButton removeTask = new JButton("remove task");
		JButton saveList = new JButton("save list");
		JButton loadList = new JButton("load list");
		panel.add(loadList);
		panel.add(saveList);
		panel.add(removeTask);
		panel.add(addTask);
		panel.add(viewTasks);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
}
