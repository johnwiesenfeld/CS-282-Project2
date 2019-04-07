public class Splay extends BST implements Tree
{

	public Splay() { this.root = null; }

	public Splay(Tree tree) 
	{ 
		this.root = tree.GetRoot();	
	}

	public Node GetRoot()
	{
		return this.root;
	}
	
	public void Insert(String Key, boolean[] InFile)
	{
		//normal BST insertion
		super.Insert(Key, InFile);
		//Do splay stuff
		Splay(getLeaf(Key));
		
	}
	public boolean Delete(String Key, int FileNumber)
	{
		super.Delete(Key, FileNumber);
		
		Splay(getLeaf(Key));

		return true;
	}
	public boolean[] Find(String Key) // target = key
	{
		boolean[] inFile = super.Find(Key);
		Splay(getLeaf(Key));
		return inFile;
	}
	
	//public BST splay() { };
	
	private void Splay(Node key)
    {
        while (key.GetParent() != null)
        {
            Node Parent = key.GetParent();
            Node GrandParent = Parent.GetParent();
            if (GrandParent == null)
            {
                if (key == Parent.GetLeft())
                    rightRotate(key);//makeLeftChildParent(x, Parent);
                else
					leftRotate(key); //makeRightChildParent(x, Parent); 
            } 
            else
            {
                if (key == Parent.GetLeft())
                {
                    if (Parent == GrandParent.GetLeft())
                    {
                        rightRotate(Parent);
                        rightRotate(key);
                    }
                    else 
                    {
                        rightRotate(key);
                        leftRotate(key); 
                    }
                }
                else 
                {
                    if (Parent == GrandParent.GetLeft())
                    {
                        leftRotate(key); 
                        rightRotate(key);
                    } 
                    else 
                    {
                        leftRotate(Parent); 
                        leftRotate(key);
                    }
                }
            }
        }
        this.root = key;
    }
}