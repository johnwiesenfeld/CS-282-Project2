import java.util.Vector;

public class AVL extends BST
{
	public AVL() { root = null; }

	public AVL(BST other)
	{
		//temporarily store nodes sorted in Vector via inOrder walk of BST
		Vector<Node> tempStorage = new Vector<Node>();
		StoreNodes(other, tempStorage);

		//build balanced tree from Vector, by recursively inserting mid-point of vector via pre-order
		BuildBalancedTree(0, tempStorage.size()-1, tempStorage);

		//Update heights in each Node of new AVL tree
		UpdateHeights(root);
	}

//helper methods for contstructing AVL from any BST
	private void StoreNodes(BST other, Vector<Node> tempStorage)
	{
		StoreNodes(other.root, tempStorage);
	}
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


//AVL deletion
	public void Delete(String Key, int FileNumber)
	{
		super.Delete(Key, FileNumber);
		//???? Do AVL Stuff? or are we doing lazy deletions?
		//...
	}

//BalanceFactor Calculation
	private int BalanceFactor(Node node)
	{
		return node.GetLeft().GetHeight() - node.GetRight().GetHeight();
	}

	private int Height(Node node)
	{
		if (node == null) {
			return 0;
		}

		int heightLeft = Height(node.GetLeft());
		int heightRight = Height(node.GetRight());

		return heightLeft > heightRight ? heightLeft + 1 : heightRight + 1;
	}

//Update all node heights in tree/subtree with starting at 'node'
	private void UpdateHeights(Node node)
	{
		if(node == null)
		{
			return;
		}
		node.SetHeight(Height(node));
		UpdateHeights(node.GetLeft());
		UpdateHeights(node.GetRight());
	}
}