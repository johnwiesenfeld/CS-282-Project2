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

		bst = load("file1.txt", bst);
		bst = load("file2.txt", bst);
		bst = load("file3.txt", bst);
		bst = load("file4.txt", bst);
		this.tree = bst;
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
		int file = in.nextInt();
		in.nextLine();
		if(file < 0 || file > 4)
		{
			System.out.println("ERROR: file does not exist.");
			return;
		}
		System.out.println("Word? ");
		System.out.print('>');
		String word = in.nextLine();

		boolean[] inFile = new boolean[5];
		inFile[file] = true;

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
		int file = in.nextInt();
		in.nextLine();

		this.tree.Delete(word, file);
		
		System.out.println("Deletion done! ");
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
		for(int i = 0; i < 5; i++)
		{
			if(inFile[i] == true)
			{
				System.out.print(i + " ");
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
			//case "Splay":
			//	Splay splay = new Splay(this.tree);
			//	this.tree = splay;
			// 	break;
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

	public BST load(String FileName, BST Tree)
	{
		try
		{
			BST bst1 = Tree;
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
						bst1.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				//System.out.println(bst1.toString());
			}
			else if(FileName.equals("file2.txt"))
			{
				inFile[2]= true;
				while((line = br.readLine()) != null)
				{
					try {
						System.out.println(line);
						bst1.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				//System.out.println(bst1.toString());
			}
			else if(FileName.equals("file3.txt"))
			{
				inFile[3]= true;
				while((line = br.readLine()) != null)
				{
					try {
						System.out.println(line);
						bst1.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				//System.out.println(bst1.toString());
			}
			else if(FileName.equals("file4.txt"))
			{
				inFile[4]= true;
				while((line = br.readLine()) != null)
				{
					try {
						System.out.println(line);
						bst1.Insert(line, inFile); // fatal error HELP!!!
					} catch (IllegalArgumentException ex) {
						System.out.println(ex);
						System.out.println("ERROR: Exiting program, please edit input file.");
						System.exit(0);
					}
				}
				//System.out.println(bst1.toString());
			}
			else
				System.out.println("\nERROR: Please save data.txt and run app again");
			br.close();
			fr.close();
			return bst1;
		}
		catch (Exception exception1)
		{
			System.out.println("Error opening input file");
			System.exit(0);
			return null;
		}
	}
}
