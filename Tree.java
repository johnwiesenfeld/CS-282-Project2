public interface Tree
{
	public Node GetRoot();
	public void Insert(String Key, boolean[] InFile);
	public boolean Delete(String Key, int FileNumber);
	public boolean Delete(String Key, boolean[] InFile);
	public boolean[] Find(String Key);
	public void print();
}