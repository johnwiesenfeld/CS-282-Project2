public class Splay extends BST
{
	//private Node treeRoot;
	public Splay() { root = null; }
	
	//public Splay(BST tree) { };
	
	public void Insert(String Key, boolean[] InFile)
	{
		//normal BST insertion
		super.Insert(Key, InFile);
		
		//Do splay stuff
		splay(Key);
		
	}
	public void Delete(String Key, int FileNumber)
	{
		super.Delete(Key, FileNumber);
		
		splay(Key);
	}
	public boolean Find(String Key, int FileNumber) // target = key
	{
		super.Find(Key, FileNumber);
		splay(Key);
		//return (Key == root.getData());	
		return (Key.compareTo(root.GetKey()) == 0);
	}
	
	//public BST splay() { };
	
	public Node splay(String key)
	{
		if (super.isEmpty())
			return null;

		root = splay(root,super.getPredecessor(key));
		return root;
	}
	private Node splay(Node Root, String key)
	{
		//Empty tree
		if (Root == null) return null;

		if (key.compareTo(Root.GetKey()) < 0) {
			// Key not in tree
			if (Root.GetLeft() == null) {
				return Root;
			}
			if (key.compareTo(Root.GetLeft().GetKey()) < 0) {
				Root.GetLeft().SetLeft(splay(Root.GetLeft().GetLeft(), key));
				Root = rightRotate(Root);
			}
			else if (key.compareTo(Root.GetLeft().GetKey()) > 0) {
				Root.GetLeft().SetRight(splay(Root.GetLeft().GetRight(), key));
				if (Root.GetLeft().GetRight() != null)
					Root.SetLeft(leftRotate(Root.GetLeft()));
			}

			if (Root.GetLeft() == null)
				return Root;
			else
				return rightRotate(Root);
		}

		else if (key.compareTo(Root.GetKey()) > 0){
			// Key not in tree
			if (Root.GetRight() == null)
				return Root;

			if (key.compareTo(Root.GetRight().GetKey()) < 0) {
				Root.GetRight().SetLeft(splay(Root.GetRight().GetLeft(), key));
				if (Root.GetRight().GetLeft() != null)
					Root.SetRight(rightRotate(Root.GetRight()));
			}
			else if (key.compareTo(Root.GetRight().GetKey()) > 0) {
				Root.GetRight().SetRight(splay(Root.GetRight().GetRight(), key));
				Root = leftRotate(Root);
			}

			if (Root.GetRight() == null)
				return Root;
			else
				return leftRotate(Root);
		}

		else return Root;
	}
}