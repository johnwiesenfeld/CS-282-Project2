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
		Splay(getNode(Key));
		
	}
	public boolean Delete(String Key, boolean[] InFile)
	{
		boolean successfulDelete = super.Delete(Key, InFile);
		
		Splay(getNode(Key));

		return successfulDelete;
	}
	public boolean[] Find(String Key) // target = key
	{
		boolean[] inFile = super.Find(Key);
		Splay(getNode(Key));
		return inFile;
	}
	
	//public BST splay() { };
	
	private void splay(Node key)
    {
        while (key.GetParent() != null)
        {
            Node Parent = key.GetParent();
            Node GrandParent = Parent.GetParent();
            if (GrandParent == null)
            {
                if (Parent.GetLeft() != null && key == Parent.GetLeft())
                    rightRotate(key);//makeLeftChildParent(key, Parent);
                else
					leftRotate(key); //makeRightChildParent(key, Parent); 
            }
            else
            {
                if (key == Parent.GetLeft())
                {
                    if (GrandParent != null && Parent == GrandParent.GetLeft())
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
                    if (GrandParent != null && Parent == GrandParent.GetLeft())
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
	
	public void makeLeftChildParent(Node c, Node p) //RightRotate
     {
         if ((c == null) || (p == null) || (p.GetLeft() != c) || (c.GetParent() != p))
             throw new RuntimeException("WRONG");
 
         if (p.GetParent() != null)
         {
             if (p == p.GetParent().GetLeft())
                 p.GetParent().SetLeft(c);
             else
                 p.GetParent().SetRight(c);
         }
         if (c.GetRight() != null)
             c.GetRight().SetParent(p);
         c.SetParent(p.GetParent());
         p.SetParent(c);
         p.SetLeft(c.GetRight());
         c.SetRight(p);
     }
 
     public void makeRightChildParent(Node c, Node p)//LeftRotate
     {
         if ((c == null) || (p == null) || (p.GetRight() != c) || (c.GetParent() != p))
             throw new RuntimeException("WRONG");
         if (p.GetParent() != null)
         {
             if (p == p.GetParent().GetLeft())
                 p.GetParent().SetLeft(c);
             else
                 p.GetParent().SetRight(c);
         }
         if (c.GetLeft() != null)
             c.GetLeft().SetParent(p);
         c.SetParent(p.GetParent());
         p.SetParent(c);
         p.SetRight(c.GetLeft());
         c.SetLeft(p);
     }
 
     private void Splay(Node key)
     {
        while (key.GetParent() != null)
        {
            Node Parent = key.GetParent();
            Node GrandParent = Parent.GetParent();
            if (GrandParent == null)
            {
                if (key == Parent.GetLeft())
                    makeLeftChildParent(key, Parent);
                else
					makeRightChildParent(key, Parent); 
            }
            else
            {
                if (key == Parent.GetLeft())
                {
                    if (Parent == GrandParent.GetLeft())
                    {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(key, Parent);
                    }
                    else
                    {
                        makeLeftChildParent(key, key.GetParent());
                        makeRightChildParent(key, key.GetParent());
                    }
                }
                else
                {
                    if (Parent == GrandParent.GetLeft())
                    {
                        makeRightChildParent(key, key.GetParent());
                        makeLeftChildParent(key, key.GetParent());
                    }
                    else
                    {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(key, Parent);
                    }
                }
				
				
            }
        }
        this.root = key;
    }
}