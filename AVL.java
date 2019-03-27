import java.util.Vector;

public class AVL extends BST
{
	//Default constructor
	public AVL() { root = null; }

	//Constructor for intaking BST
	public AVL(BST bst)
	{
		Node Root = bst.root;

		//temporarily store nodes sorted in Vector via inOrder walk of BST
		Vector<Node> tempStorage = new Vector<Node>();
		StoreNodes(Root, tempStorage);

		//build balanced tree from Vector, by recursively inserting mid-point of vector via pre-order
		BuildBalancedTree(0, tempStorage.size()-1, tempStorage);

		//Update heights in each Node of new AVL tree
		UpdateAllHeights(this.root);
	}

	//Constructor for intaking splay
	//***UNCOMMENT WHEN SPLAY IS WORKING***
/*	public AVL(Splay splay)
	{
		BST bst = (BST) splay;
		Node Root = bst.root;

		//temporarily store nodes sorted in Vector via inOrder walk of BST
		Vector<Node> tempStorage = new Vector<Node>();
		StoreNodes(Root, tempStorage);

		//build balanced tree from Vector, by recursively inserting mid-point of vector via pre-order
		BuildBalancedTree(0, tempStorage.size()-1, tempStorage);

		//Update heights in each Node of new AVL tree
		UpdateHeights(this.root);
	}
*/
//helper method for contstructing AVL from any BST
	private void StoreNodes(Node node, Vector<Node> tempStorage)
	{
		if(node == null)
		{
			return;
		}
		StoreNodes(node.GetLeft(), tempStorage);
		tempStorage.add(node);
		StoreNodes(node.GetRight(), tempStorage);
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
			temp = temp.GetParent();
			parent = temp.GetParent();
		}
	}


//AVL deletion
	public void Delete(String Key, int FileNumber)
	{
		Node temp = getNode(Key).GetParent();
		super.Delete(Key, FileNumber);
		if(!isEmpty()) {UpdateHeights(temp);}

		while(temp != null)
		{
			if(BalanceFactor(temp) < -1)
			{
				//...
				UpdateHeights(temp);
				break;
			} else if(BalanceFactor(temp) > 1)
			{
				//...
				UpdateHeights(temp);
				break;
			}
			temp = temp.GetParent();
		}
	}

//BalanceFactor Calculation
	private int BalanceFactor(Node node)
	{
		int leftHeight = 0;
		int rightHeight = 0;
		if(node.GetLeft()!= null)
		{
			leftHeight = node.GetLeft().GetHeight();
		}
		if(node.GetRight() != null)
		{
			rightHeight = node.GetRight().GetHeight();
		}

		return leftHeight - rightHeight;
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
//Update node heights in entire tree [O(N)]
	private void UpdateAllHeights(Node node)
	{
		if(node == null)
		{
			return;
		}
		node.SetHeight(Height(node));
		UpdateAllHeights(node.GetLeft());
		UpdateAllHeights(node.GetRight());
	}

	//strictly for testing, remove before submission:
	public void print()
	{
		print(root);
	}
	public void print(Node node)
	{
		if(node == null)
		{
			return;
		}
		print(node.GetLeft());

		System.out.println(node.GetKey() + "(" + node.GetHeight() + ") ");
		System.out.print("Left: ");
		if(node.GetLeft() != null)
		{
			System.out.print(node.GetLeft().GetKey() + " ");
		}
		System.out.print("Right: ");
		if(node.GetRight() != null)
		{
			System.out.print(node.GetRight().GetKey());
		}
		System.out.println();

		print(node.GetRight());
	}
}