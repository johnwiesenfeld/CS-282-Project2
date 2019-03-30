public interface Tree
{
	public Node GetRoot();
	public void Insert(String Key, boolean[] InFile);
	public void Delete(String Key, int FileNumber);
	public boolean[] Find(String Key);
	public void print();
}