public class BST
{
	protected Node root;

	public BST() { root = null; }
	public BST(BST other) { };

	public void Insert(String Key, boolean[] InFile)
	{
		Node insertion = root;
		while (insertion != null)
		{
			int cmp = key.compareTo(insertion.GetKey());
			if (cmp == 0)
		}


		if (root == null) { root = new Node(Key, InFile); }
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
		
	}

	public final String toString()
	{

	}

	// protected rotation function(s)
}
