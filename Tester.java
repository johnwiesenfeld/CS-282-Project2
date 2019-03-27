public class Tester
{
	public static void main(String[] args)
	{
		AVL avl = new AVL();

		String one = "Hello";
		boolean[] onefile = {false, true, false, false, false};
		String two = "My";
		boolean[] twofile = {false, false, true, false, false};
		String three = "name";
		boolean[] threefile = {true, false, false, false, false};
		String four = "is";
		boolean[] fourfile = {false, false, false, true, false};
		String five = "john";
		boolean[] fivefile = {false, false, false, false, true};

		String six = "what";
		String seven = "are";
		String eight = "you";
		String nine = "doing";
		String ten = "now";




		System.out.println(0);
		avl.Insert(one, onefile);

		System.out.println(1);
		avl.Insert(two, twofile);

		System.out.println(2);
		avl.Insert(three, threefile);

		System.out.println(3);
		avl.Insert(four, fourfile);

		System.out.println(4);
		avl.Insert(five, fivefile);

		System.out.println(5);
		avl.Insert(six, onefile);

		System.out.println(6);
		avl.Insert(seven, twofile);

		System.out.println(7);
		avl.Insert(eight, threefile);

		System.out.println(8);
		avl.Insert(nine, fourfile);

		System.out.println(9);
		avl.Insert(ten, fivefile);
		System.out.println();

		System.out.println(avl.getNode("Hello").GetHeight());

		avl.print();
	}
}