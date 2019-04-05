public class BST implements Tree
{
	protected Node root;

	public BST() { root = null; }
	public BST(Tree tree) { this.root = tree.GetRoot(); }

	public Node GetRoot()
	{
		return this.root;
	}

	public void Insert(String Key, boolean[] InFile)
	{
		Node parent = getLeaf(Key), insertion = new Node(Key, InFile, parent);
		if (isEmpty())
		{
			root = insertion;
		}
        else if (insertion.compareTo(parent) == 0)
        {
            parent.SetFiles(InFile);
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

		// two children case
		if (toDelete.GetRight() != null && toDelete.GetLeft() != null)
		{
			Node pred = getPredecessor(toDelete);
			Node temp = new Node(pred.GetKey(), pred.GetFiles());
			
			pred.SetKey(toDelete.GetKey());
			pred.SetFiles(toDelete.GetFiles());
			
			toDelete.SetKey(temp.GetKey());
			toDelete.SetFiles(temp.GetFiles());

			toDelete = pred;
		}

		// grab possible subTree
		Node subTree = toDelete.GetLeft();
		if (subTree == null) { subTree = toDelete.GetRight(); }

		// deletion
		if (toDelete == root)
		{
			root = subTree;
			if (root != null) { root.SetParent(null); }
		}
		else
		{
			Node parent = toDelete.GetParent();
			if (parent.GetLeft() != null && parent.GetLeft().compareTo(toDelete) == 0)
			{
				parent.SetLeft(subTree);
			}
			else
			{
				parent.SetRight(subTree);
			}

			if (subTree != null)
			{
				subTree.SetParent(parent);
			}
		}

		toDelete.SetParent(null);
		toDelete.SetRight(null);
		toDelete.SetLeft(null);
	}

	/* //I think the only Find() we need only has String parameter
	public boolean Find(String Key, int FileNumber)
	{
		Node node = getNode(Key);
		return node == null ? false : node.isInFile(FileNumber);
	}
	*/
	public boolean[] Find(String Key)
	{
		Node node = getNode(Key);
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

	public void print()
	{
		print(root, 0, 10);
	}

	public void print(Node node, int space, int count)
	{
		if (node == null) return;

		space += count;

		print(node.GetRight(), space, count);
		System.out.print("\n");
		for (int i = count; i < space; i++)
			System.out.print(" ");
		System.out.print(node.GetKey() + "\n");

		print(node.GetLeft(), space, count);
	}

	public final boolean isEmpty()
	{
		return root == null;
	}

	// protected rotation function(s)
	protected final void leftRotate(Node node)
	{
		Node x = node.GetRight();
		Node y = x.GetLeft();

		x.SetLeft(node);
		node.SetRight(y);
		if(y != null)
		{
			y.SetParent(node);
		}

		if (node.GetParent() == null) {
			root = x;
		} else {
			if(node.GetParent().GetLeft() == node)
			{
				node.GetParent().SetLeft(x);
			} else {
				node.GetParent().SetRight(x);
			}
		}

		x.SetParent(node.GetParent());
		node.SetParent(x);
	}

	protected final void rightRotate(Node node)
	{
		Node x = node.GetLeft();
		Node y = x.GetRight();

		x.SetRight(node);
		node.SetLeft(y);
		if(y != null)
		{
			y.SetParent(node);
		}

		if (node.GetParent() == null) {
			root = x;
		} else {
			if(node.GetParent().GetLeft() == node)
			{
				node.GetParent().SetLeft(x);
			} else {
				node.GetParent().SetRight(x);
			}
		}
		x.SetParent(node.GetParent());
		node.SetParent(x);
	}
}
