/*
COMP282 Section 16304 Project 2
Group members:
Nicholas Warfield
Javier Aguayo
John Wiesenfeld
*/

public interface Tree
{
	public Node GetRoot();
	public void Insert(String Key, boolean[] InFile);
	public boolean Delete(String Key, boolean[] InFile);
	public boolean[] Find(String Key);
	public void print();
}