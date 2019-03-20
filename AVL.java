public class AVL extends BST
{
	public AVL() { root = null; }

	public AVL(BST other)
	{
		root = other.root;
		FixAVL();
	}

	public void Insert(String Key, boolean[] InFile)
	{
		super.Insert(Key, InFile);
		FixAVL();
	}

	public void Delete(String Key, int FileNumber)
	{
		super.Delete(Key, FileNumber);
		FixAVL();
	}

	//fix tree to regain AVL status
	private void FixAVL()
	{
		CalclulateHeights();
		//write operation to rotate things appropriately
	}

	//Pre-order recursive walk to calculate node heights
	private void CalclulateHeights()
	{
		CalculateHeights(root);
	}
	private void CalculateHeights(Node currNode)
	{
		if(currNode == null)
		{
			return;
		}

		//Write height calculation peration here

		CalculateHeights(currNode.GetLeft());
		CalculateHeights(currNode.GetRight());
	}

}