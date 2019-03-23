import java.io.*;
import java.util.Scanner;

public class Driver{
	
	private String typeOfTree;
	
	public static void main(String[] args)
	{
		BST tree = new BST();
		tree = load("file1.txt", tree);
		//tree = load("file2.txt", tree);
		//tree = load("file3.txt", tree);
		//tree = load("file4.txt", tree);
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		while (!exit)
		{
			switch(commandline(tree, in))
			{
				case "quit":		exit = true;		break;
				case "insert":		insert(tree, in);	break; // add =insert
				case "delete":		delete(tree, in);	break; // drop =delete
				case "find":		find(tree, in);		break;
				case "select":		select(tree, in);	break;
				case "print":		print(tree);		break;
				default:	    	help();		    	break;
			}
		}
		
		in.close();
	}

	public static void insert(BST Tree, Scanner in)
	{
		System.out.println("Which file? ");
		System.out.print('>');
		int file = in.nextInt();
		System.out.println("Word? ");
		System.out.print('>');
		String word = in.nextLine();
		
		System.out.println("Insertion done! ");
	}
	
	public static void delete(BST Tree, Scanner in)
	{
		System.out.println("Word? ");
		System.out.print('>');
		String word = in.nextLine();
		System.out.println("Which file? ");
		System.out.print('>');
		int file = in.nextInt();
		
		System.out.println("Deletion done! ");
	}
	
	public static void find(BST Tree, Scanner in)
	{
		System.out.println("Word? ");
		System.out.print('>');
		String word = in.nextLine();
		
	}
	
	public static void select(BST Tree, Scanner in)
	{
		System.out.println("Type of tree? ");
		System.out.print('>');
		String word = in.nextLine();
		//typeOfTree.SetTree(word);
	}
	
	public static void print(BST Tree)
	{
		System.out.println(Tree.toString());
	}
	
	public void SetTree(String Tree) { typeOfTree = Tree; }
	
	//menu to call all operations from command line
	public static String commandline(BST tree, Scanner in)
	{
		System.out.println("\nPlease enter a command: insert, delete, " +
			"find, select, print, and quit.");
		System.out.print('>');
		String line = in.nextLine();
		return line;
	}
	
	public static void help()
	{
		System.out.println("\nYour options are:" +
			"\nselect (select type of tree)" +
			"\nfind " +
			"\ninsert " +
			"\ndelete " +
			"\nprint " +
			"\nquit (ends the program)\n");
	}

	public static BST load(String FileName, BST Tree)
	{
		try
		{
			BST tree = Tree;
			boolean[] inFile = new boolean[5];
			FileReader fr = new FileReader(FileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			if(FileName.equals("file1.txt"))
			{
				inFile[1]= true;
				while((line = br.readLine()) != null)
				{
					try {
						System.out.println(line);
						tree.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				//System.out.println(tree.toString());
			}
			else if(FileName.equals("file2.txt"))
			{
				inFile[2]= true;
				while((line = br.readLine()) != null)
				{
					try {
						System.out.println(line);
						//tree.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				//System.out.println(tree.toString());
			}
			else if(FileName.equals("file3.txt"))
			{
				inFile[3]= true;
				while((line = br.readLine()) != null)
				{
					try {
						System.out.println(line);
						//tree.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				//System.out.println(tree.toString());
			}
			else if(FileName.equals("file4.txt"))
			{
				inFile[4]= true;
				while((line = br.readLine()) != null)
				{
					try {
						System.out.println(line);
						//tree.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				//System.out.println(tree.toString());
			}
			else
				System.out.println("\nERROR: Please save data.txt and run app again");
			br.close();
			fr.close();
			return tree;
		}
		catch (Exception exception1)
		{
			System.out.println("Error opening input file");
			System.exit(0);
			return null;
		}
	}
}
