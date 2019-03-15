public class BST
{
	protected Node root;

	public BST() { root = null; }
	public BST(BST other) { };

	public void Insert(String Key, boolean[] InFile)
	{
		Node parent = getNode(Key), insertion = new Node(Key, InFile, parent);
		if (root == null)
		{
			root = insertion;
		}
		else if (insertion.compareTo(parent) > 0)
		{
			parent.SetRight(insertion);
		}
		else if (insertion.compareTo(parent) < 0)
		{
			parent.SetLeft(insertion);
		}
	}

	public void Delete(String Key)
	{
		Node temp = getNode(Key);
		if (temp == null) { return; }
	}

	public boolean Find(String Key, int FileNumber)
	{
		return getNode(Key).isInFile(FileNumber);
	}
	public boolean[] FindAll(String Key)
	{
		return getNode(Key).GetFiles();
	}
	// return node with matching key, or the parent if key not found
	protected final Node getNode(String Key)
	{
		Node key = new Node(Key, new boolean[5]);
		Node temp = root, tempParent = null;
		while (temp != null)
		{
				tempParent = temp;
				int cmp = key.compareTo(temp);
				if (cmp == 0) { return temp; }
				else if (cmp > 0) { temp = temp.GetRight(); }
				else { temp = temp.GetLeft(); }
		}
		return tempParent;
	}

	public final String toString()
	{
		return "";
	}

	// protected rotation function(s)
}
