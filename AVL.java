import java.util.Vector;

public class AVL extends BST
{
	public AVL() { root = null; }

	public AVL(BST other)
	{
		Vector<Node> tempStorage = new Vector<Node>();

		//temporarily store nodes sorted in Vector via inOrder walk of BST
		StoreNodes(other, tempStorage);

		//build balanced tree from Vector, by recursively inserting mid-point of vector via pre-order
		BuildBalancedTree(0, tempStorage.size()-1, tempStorage);
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
		super.Insert(Key, InFile);
		//Do AVL Stuff
		Node temp = getNode(Key);
		//...
	}


//AVL deletion
	public void Delete(String Key, int FileNumber)
	{
		super.Delete(Key, FileNumber);
		//???? Do AVL Stuff?
		//...
	}

}