/*
COMP282 Section 16304 Project 2
Group members:
Nicholas Warfield
Javier Aguayo
John Wiesenfeld
*/

import java.io.*;
import java.util.Scanner;

public class Driver{

	public static void main(String[] args)
	{
		Driver driver = new Driver();
		driver.run();
	}

	private Tree tree;

	public void run()
	{
		//Create new BST and assign it to Tree interface
		BST bst = new BST();
		tree = bst;

		//load data from files
		load("file1.txt");
		load("file2.txt");
		load("file3.txt");
		load("file4.txt");

		Scanner in = new Scanner(System.in);
		boolean exit = false;
		while (!exit)
		{
			switch(commandline(in))
			{
				case "quit":		exit = true;		break;
				case "insert":		insert(in);			break; // add =insert
				case "delete":		delete(in);			break; // drop =delete
				case "find":		find(in);			break;
				case "select":		select(in);			break;
				case "print":		print();			break;
				default:	    	help();		    	break;
			}
		}

		in.close();
	}

	public void insert(Scanner in)
	{
		System.out.println("Which file? ");
		System.out.print('>');
		String files = in.nextLine();
		String[] filesArr = files.split(",");

		//create boolean array to pass to tree assigning this datum to a particular file
		boolean[] inFile = new boolean[4];
		for(int i = 0; i < filesArr.length; i++)
		{
			int temp = Integer.parseInt(filesArr[i]);
			if(temp < 1 || temp > 4)
			{
				System.out.println("ERROR: file does not exist.");
				return;
			}
			if(temp == 1)
				inFile[0] = true;
			else if(temp == 2)
				inFile[1] = true;
			else if(temp == 3)
				inFile[2] = true;
			else //if(temp == 4)
				inFile[3] = true;
			
		}
		System.out.println("Word? ");
		System.out.print('>');
		String word = in.nextLine();
		this.tree.Insert(word, inFile);
		
		System.out.println("Insertion done! ");
	}
	
	public void delete(Scanner in)
	{
		System.out.println("Word? ");
		System.out.print('>');
		String word = in.nextLine();
		System.out.println("Which file? ");
		System.out.print('>');
		String files = in.nextLine();
		String[] filesArr = files.split(",");

		//create a boolean array to pass to tree of which file to delete from
		boolean[] inFile = new boolean[4];
		for(int i = 0; i < filesArr.length; i++)
		{
			int temp = Integer.parseInt(filesArr[i]);
			if(temp < 1 || temp > 4)
			{
				System.out.println("ERROR: file does not exist.");
				return;
			}
			if(temp == 1)
				inFile[0] = true;
			else if(temp == 2)
				inFile[1] = true;
			else if(temp == 3)
				inFile[2] = true;
			else //if(temp == 4)
				inFile[3] = true;
		}
		//Delete returns boolean
		if(this.tree.Delete(word, inFile))
		{
			System.out.println("Deletion done! ");
		} else {
			System.out.println("The word cannot be found!");
		}
	}
	
	public void find(Scanner in)
	{
		System.out.println("Word? ");
		System.out.print('>');
		String word = in.nextLine();

		boolean[] inFile = this.tree.Find(word);
		if(inFile == null)
		{
			System.out.println("The word cannot be found!");
			return;
		}
		for(int i = 0; i < 4; i++)
		{
			if(inFile[i] == true)
			{
				System.out.print((i+1) + " ");
			}
		}
		System.out.println();
	}

	//select will create a new tree by passing current tree.
	//BST and subclasses are written to accept BST into constructor
	public void select(Scanner in)
	{
		System.out.println("Type of tree? ");
		System.out.print('>');
		String word = in.nextLine();
		switch(word)
		{
			case "BST":
				BST bst = new BST(this.tree);
				this.tree = bst;
				break;
			case "AVL":
				AVL avl = new AVL(this.tree);
				this.tree = avl;
				break;
			case "Splay":
				Splay splay = new Splay(this.tree);
				this.tree = splay;
			 	break;
			default:
				System.out.println("ERROR: Invalid Tree type. Valid entries include \"BST, AVL, and Splay.\"");
				break;
		}
	}
	
	public void print()
	{
		this.tree.print();
	}
	
	//menu to call all operations from command line
	public String commandline(Scanner in)
	{
		System.out.println("\nPlease enter a command: insert, delete, " +
			"find, select, print, and quit.");
		System.out.print('>');
		String line = in.nextLine();
		return line;
	}
	
	public void help()
	{
		System.out.println("\nYour options are:" +
			"\nselect (select type of tree)" +
			"\nfind " +
			"\ninsert " +
			"\ndelete " +
			"\nprint " +
			"\nquit (ends the program)\n");
	}

	//load data from file
	public void load(String FileName)
	{
		try
		{
			boolean[] inFile = new boolean[4];
			FileReader fr = new FileReader(FileName);
			//BufferedReader br = new BufferedReader(fr);
			String line;
			switch(FileName)
			{
				case "file1.txt":
					inFile[0] = true;
					break;
				case "file2.txt":
					inFile[1] = true;
					break;
				case "file3.txt":
					inFile[2] = true;
					break;
				case "file4.txt":
					inFile[3] = true;
					break;
				default:
					System.out.println("\nERROR: Please save data.txt and run app again");
					return;
			}

			Scanner sc0 = new Scanner(fr);
			while((sc0.hasNextLine()))
			{
				line = sc0.nextLine();
				try {
					this.tree.Insert(line, inFile);
				} catch (IllegalArgumentException ex) {
					System.out.println(ex);
					System.out.println("ERROR: Exiting program, please edit input file.");
					System.exit(0);
				}
			}
			sc0.close();
			fr.close();
		} catch (Exception exception1) {
			System.out.println("Error opening input file");
			System.exit(0);
		}
	}
}
