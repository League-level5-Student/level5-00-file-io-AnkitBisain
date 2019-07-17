package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame;
	JPanel panel;
	JButton addTask;
	JButton viewTasks;
	JButton removeTask;
	JButton saveList;
	JButton loadList;
	ArrayList<String> tasks;

	public static void main(String[] args) {
		ToDoList t = new ToDoList();
	}

	public ToDoList() {
		frame = new JFrame();
		panel = new JPanel();
		addTask = new JButton("add task");
		viewTasks = new JButton("view tasks");
		removeTask = new JButton("remove task");
		saveList = new JButton("save list");
		loadList = new JButton("load list");
		tasks = new ArrayList<String>();
		run();
	}

	void run() {
		panel.add(loadList);
		panel.add(saveList);
		panel.add(removeTask);
		panel.add(addTask);
		panel.add(viewTasks);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		loadList.addActionListener(this);
		saveList.addActionListener(this);
		removeTask.addActionListener(this);
		viewTasks.addActionListener(this);
		addTask.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == loadList) {
			try {
				tasks.clear();
				BufferedReader fr = new BufferedReader(new FileReader("src/_03_To_Do_List/ListOfThings.txt"));
				String line = fr.readLine();
				System.out.println(" i am here ");
				while (line != null) {
					tasks.add(line);
					line = fr.readLine();
				}
				fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == saveList) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/ListOfThings.txt");
				fw.flush();
				for(String s : tasks) {
					fw.write(s +"\n");
				}
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == removeTask) {
			String list = "\n";
			for (int i = 0; i < tasks.size(); i++) {
				list += i + ". " + tasks.get(i) + "\n ____ \n";
			}
			String indexStr = JOptionPane.showInputDialog(null, "Enter the index of the task you would like to remove" + list);
			int index = Integer.valueOf(indexStr);
			tasks.remove(index);
		}

		if (e.getSource() == addTask) {
			tasks.add(JOptionPane.showInputDialog(null, "What task would you like to add?"));
		}

		if (e.getSource() == viewTasks) {
			String list = "";
			for (int i = 0; i < tasks.size(); i++) {
				list += i + ". " + tasks.get(i) + "\n ____ \n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
	}

}
