public class Splay extends BST implements Tree
{

	public Splay() { root = null; }

	public Splay(Tree tree) { this.root = tree.GetRoot(); };

	public Node GetRoot()
	{
		return this.root;
	}
	
	public void Insert(String Key, boolean[] InFile)
	{
		//normal BST insertion
		super.Insert(Key, InFile);
		
		//Do splay stuff
		splay(Key);
		
	}
	public boolean Delete(String Key, int FileNumber)
	{
		super.Delete(Key, FileNumber);
		
		splay(Key);

		return true;
	}
	public boolean[] Find(String Key) // target = key
	{
		boolean[] inFile = super.Find(Key);
		splay(Key);
		//return (Key == root.getData());	
		return inFile;
	}
	
	//public BST splay() { };
	
	public void splay(String key)
	{
		if (isEmpty())
			//return null;

		
		splay(root,key);
		//return root;
	}
	private Node splay(Node Root, String key)
	{
		//Empty tree
		if (Root == null) return Root;

		if (key.compareTo(Root.GetKey()) < 0) 
		{
			// Key not in tree
			if (Root.GetLeft() == null) 
			{
				return Root;
			}
			if (key.compareTo(Root.GetLeft().GetKey()) < 0) 
			{
				Root.GetLeft().SetLeft(splay(Root.GetLeft().GetLeft(), key));
				rightRotate(Root);
			}
			else if (key.compareTo(Root.GetLeft().GetKey()) > 0) 
			{
				Root.GetLeft().SetRight(splay(Root.GetLeft().GetRight(), key));
				if (Root.GetLeft().GetRight() != null)
				{
					//Root.SetLeft(leftRotate(Root.GetLeft()));
					leftRotate(Root.GetLeft());
				}
			}

			if (Root.GetLeft() == null)
				return Root;
			else
			{
				rightRotate(Root);
				return Root;
			}
		}

		else if (key.compareTo(Root.GetKey()) > 0)
		{
			// Key not in tree
			if (Root.GetRight() == null)
				return Root;

			if (key.compareTo(Root.GetRight().GetKey()) < 0) 
			{
				Root.GetRight().SetLeft(splay(Root.GetRight().GetLeft(), key));
				if (Root.GetRight().GetLeft() != null)
				{
					//Root.SetRight(rightRotate(Root.GetRight()));
					rightRotate(Root.GetRight());
				}
			}
			else if (key.compareTo(Root.GetRight().GetKey()) > 0) {
				Root.GetRight().SetRight(splay(Root.GetRight().GetRight(), key));
				leftRotate(Root);
			}

			if (Root.GetRight() == null)
			{
				return Root;
			}
			else
			{
				leftRotate(Root);
				return Root;
			}
		}
		else return Root;
	}
}