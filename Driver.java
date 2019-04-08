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
		BST bst = new BST();
		tree = bst;
		load("file1.txt", tree);
		load("file2.txt", tree);
		load("file3.txt", tree);
		load("file4.txt", tree);

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

	public static void load(String FileName, Tree Tree)
	{
		try
		{
			boolean[] inFile = new boolean[4];
			FileReader fr = new FileReader(FileName);
			//BufferedReader br = new BufferedReader(fr);
			String line;
			System.out.print(FileName + "\t");
			if(FileName.equals("file1.txt"))
			{
				inFile[0]= true;
				Scanner sc0 = new Scanner(fr);
				while((sc0.hasNextLine()))
				{
					line = sc0.nextLine();
					try {
						System.out.println(line);
						Tree.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				sc0.close();
				//System.out.println(bst1.toString());
			}
			else if(FileName.equals("file2.txt"))
			{
				inFile[1]= true;
				Scanner sc1 = new Scanner(fr);
				while(sc1.hasNextLine())
				{
					line = sc1.nextLine();
					try {
						System.out.println(line);
						Tree.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				sc1.close();
				//System.out.println(bst1.toString());
			}
			else if(FileName.equals("file3.txt"))
			{
				inFile[2]= true;
				Scanner sc2 = new Scanner(fr);
				while(sc2.hasNextLine())
				{
					line = sc2.nextLine();
					try {
						System.out.println(line);
						Tree.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				sc2.close();
				//System.out.println(bst1.toString());
			}
			else if(FileName.equals("file4.txt"))
			{
				inFile[3]= true;
				Scanner sc3 = new Scanner(fr);
				while(sc3.hasNextLine())
				{
					line = sc3.nextLine();
					try {
						System.out.println(line);
						Tree.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				sc3.close();
				//System.out.println(bst1.toString());
			}
			else
				System.out.println("\nERROR: Please save data.txt and run app again");

			//br.close();
			fr.close();
		}
		catch (Exception exception1)
		{
			System.out.println("Error opening input file");
			System.exit(0);
		}
	}
}
