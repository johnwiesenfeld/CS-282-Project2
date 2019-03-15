public class Node implements Comparable<Node>
{
	private String key;
	private boolean[] inFile;
	private Node left, right, parent;
	private int height;
	private static final int fileCount = 5;

	public Node(String Key)
	{
		key = Key;
		inFile = new boolean[fileCount];
		left = null;
		right = null;
		parent = null;
		height = 0;
	}
	public Node(String Key, boolean[] InFile)
	{
		key = key;
		inFile = InFile;
		left = null;
		right = null;
		parent = null;
		height = 0;
	}
	public Node(String Key, boolean[] InFile, Node Parent)
	{
		key = key;
		inFile = InFile;
		left = null;
		right = null;
		parent = Parent;
		height = 0;
	}
	public Node(String Key, boolean[] InFile, Node Parent, Node Left, Node Right)
	{
		key = key;
		inFile = InFile;
		left = Left;
		right = Right;
		parent = Parent;
		height = 0;
	}
	public Node(String Key, boolean[] InFile, Node Parent, Node Left, Node Right, int Height)
	{
		key = key;
		inFile = InFile;
		left = Left;
		right = Right;
		parent = Parent;
		height = Height;
	}

	public int compareTo(Node other)
	{
		return key.compareTo(other.key);
	}

	public String toString()
	{
		String s = "Key: " + key;
		s += "\nUser: " + (inFile[0] ? "Here" : "Not Here");
		for (int i = 1; i < fileCount; i++)
		{
			s += "\nFile " + i + ": ";
			s += (inFile[i] ? "Here" : "Not Here");
		}
		return s + '\n';
	}

	public boolean isInFile(int fileNumber)
	{
		if (fileNumber < 0 || fileNumber > fileCount) { return false; }
		return inFile[fileNumber];
	}
	public boolean[] GetFiles() { return inFile; }
	public void SetFiles(int fileNumber, boolean isPresent)
	{
		if (fileNumber < 0 || fileNumber > fileCount) { return; }
		inFile[fileNumber] = isPresent;
	}
	public void setFiles(boolean[] InFiles)
	{
		if (InFiles.length != fileCount) { return; }
		inFile = InFiles;
	}
	public String GetKey() { return key; }

	public void SetHeight(int Height) { height = Height; }
	public int GetHeight() { return height; }

	public void SetLeft(Node Left) { left = Left; }
	public void SetRight(Node Right) { right = Right; }
	public void SetParent(Node Parent) { parent = Parent; }

	public Node GetLeft() { return left; }
	public Node GetRight() { return right; }
	public Node GetParent() { return parent; }
	public Node GetGrandParent() { return parent == null ? null : parent.parent; }
	public Node GetSibling()
	{
		return parent == null ? null :
			parent.left == this ? parent.right : parent.left;
	}
	public Node GetUncle()
	{
		return parent == null ? null : parent.GetSibling();
	}
}
