import java.util.Vector;

public class AVL extends BST implements Tree
{
	//Default constructor
	public AVL() { this.root = null; }

	//Constructor for intaking BST
	public AVL(Tree tree)
	{
		Node Root = tree.GetRoot();
		ConvertToAVL(Root);
	}

	public Node GetRoot()
	{
		return this.root;
	}

//helper method for contstructing AVL from any BST
	private void ConvertToAVL(Node node)
	{
		if(node == null)
		{
			return;
		}
		ConvertToAVL(node.GetLeft());
		Insert(node.GetKey(), node.GetFiles());
		ConvertToAVL(node.GetRight());
	}

	private void BuildBalancedTree(int beginning, int end, Vector<Node> tempStorage)
	{
		if(beginning > end)
		{
			return;
		}

		int middle = (beginning + end)/2;
		Node temp = tempStorage.get(middle);
		
		super.Insert(temp.GetKey(), temp.GetFiles());
		BuildBalancedTree(0, middle - 1, tempStorage);
		BuildBalancedTree(middle + 1, end, tempStorage);
	}

//AVL insertion
	public void Insert(String Key, boolean[] InFile)
	{
		//normal BST insertion
		super.Insert(Key, InFile);

		//Do AVL Stuff
		Node temp = getNode(Key);
		Node parent = temp.GetParent();
		UpdateHeights(temp);

		while(parent != null)
		{
			if(BalanceFactor(parent) < -1 && Key.compareTo(temp.GetKey()) > 0) // Outside: right-right case
			{
				leftRotate(parent);
				UpdateHeights(parent);
				break;
			} else if(BalanceFactor(parent) > 1 && Key.compareTo(temp.GetKey()) < 0) // Outside: left-left case
			{
				rightRotate(parent);
				UpdateHeights(parent);
				break;
			} else if(BalanceFactor(parent) < -1 && Key.compareTo(temp.GetKey()) < 0) // Inside: right-left case
			{
				rightRotate(temp);
				leftRotate(parent);
				UpdateHeights(parent);
				break;
			} else if(BalanceFactor(parent) > 1 && Key.compareTo(temp.GetKey()) > 0)	// Inside: left-right case
			{
				leftRotate(temp);
				rightRotate(parent);
				UpdateHeights(parent);
				break;
			}
			temp = parent;
			parent = temp.GetParent();
		}
	}


//AVL deletion
	public boolean Delete(String Key, int FileNumber)
	{
		if(getNode(Key) == null) return false;
		Node temp = getNode(Key);
		Node parent = temp.GetParent();
		super.Delete(Key, FileNumber);
		if(!isEmpty()) {UpdateHeights(parent);}

		while(parent != null)
		{
			if(BalanceFactor(parent) < -1 && parent.GetRight().GetRight() != null) // Outside: right-right case
			{
				leftRotate(parent);
				UpdateHeights(parent);
				break;
			} else if(BalanceFactor(parent) > 1 && parent.GetLeft().GetLeft() != null) // Outside: left-left case
			{
				rightRotate(parent);
				UpdateHeights(parent);
				break;
			} else if(BalanceFactor(parent) < -1 && parent.GetRight().GetLeft() != null) // Inside: right-left case
			{
				rightRotate(temp);
				leftRotate(parent);
				UpdateHeights(parent);
				break;
			} else if(BalanceFactor(parent) > 1 && parent.GetLeft().GetRight()!= null)	// Inside: left-right case
			{
				leftRotate(temp);
				rightRotate(parent);
				UpdateHeights(parent);
				break;
			}
			temp = parent;
			parent = temp.GetParent();
		}
		return true;
	}

	public boolean[] Find(String Key)
	{
		return super.Find(Key);
	}

//BalanceFactor Calculation
	private int BalanceFactor(Node node)
	{
		if(node == null) return 0;

		return Height(node.GetLeft()) - Height(node.GetRight());
	}

//Calculate Height of a node recursively
	private int Height(Node node)
	{
		if (node == null) {
			return -1;
		}

		int heightLeft = Height(node.GetLeft());
		int heightRight = Height(node.GetRight());

		if(heightLeft > heightRight)
		{
			return heightLeft + 1;
		} else {
			return heightRight + 1;
		}
	}

//Update all node heights in path up to root starting at 'node' [O(logN)]
	private void UpdateHeights(Node node)
	{
		while(node != null)
		{
			node.SetHeight(Height(node));
			node = node.GetParent();
		}
	}
}