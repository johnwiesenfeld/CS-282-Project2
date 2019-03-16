public class BST
{
	protected Node root;

	public BST() { root = null; }
	public BST(BST other) { };

	public void Insert(String Key, boolean[] InFile)
	{
		Node parent = getLeaf(Key), insertion = new Node(Key, InFile, parent);
		if (isEmpty())
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
		if (toDelete == null) { return; }

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
		Node node = getNode(Key);
		return node == null ? false : node.isInFile(FileNumber);
	}
	public boolean[] FindAll(String Key)
	{
		Node node = getNode(Key)
		return node == null ? null : node.GetFiles();
	}

	// return node with matching key, null on no match
	protected final Node getNode(String Key)
	{
		Node candidate = getLeaf(Key), key = new Node(Key);
		return candidate.compareTo(key) == 0 ? candidate : null;
	}

	// return node with matching key, or the parent if key not found
	protected final Node getLeaf(String Key)
	{
		Node key = new Node(Key);
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

	public final boolean isEmpty()
	{
		return root == null;
	}

	// protected rotation function(s)
}
