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

	public void Delete(String Key, int FileNumber)
	{
		Node toDelete = getNode(Key);
		if (toDelete == null || Key.compareTo(toDelete.GetKey) != 0) { return; }

		// case 1, no children
		if (toDelete.GetRight() == null && toDelete.GetLeft() == null)
		{
			
		}
		// case 3, two children
		else if ()
		{

		}
		// case 2, one child

		// need to fix root somewhere
		
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
	protected final Node getPredecessor(Node node)
	{
			node = node.GetLeft();
			while (node.GetRight() != null)
			{
					node = node.GetRight();
			}
			return node;
	}

	public final String toString()
	{
		return "";
	}

	// protected rotation function(s)
}
