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
		else
		{
			insertion.compareTo(parent) > 0 ?
				parent.SetRight(insertion) : parent.SetLeft(insertion);
		}
	}

	public void Delete(String Key)
	{
		Node temp = getNode(Key);
		if (temp == null) { return; }
	}

	public boolean Find(Sting Key, int File)
	{

	}
	public boolean[] FindAll(String Key)
	{
		
	}
	// return node with matching key, or the parent if key not found
	protected final Node getNode(String Key)
	{
		Node key = new Node(key, boolean[5]);
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

	}

	// protected rotation function(s)
}
