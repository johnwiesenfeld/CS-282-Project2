public class JohnTester
{
	public static void main(String[] args)
	{
		BST bst = new BST();

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
		bst.Insert(one, onefile);

		System.out.println(1);
		bst.Insert(two, twofile);

		System.out.println(2);
		bst.Insert(three, threefile);

		System.out.println(3);
		bst.Insert(four, fourfile);

		System.out.println(4);
		bst.Insert(five, fivefile);

		System.out.println(5);
		bst.Insert(six, onefile);

		System.out.println(6);
		bst.Insert(seven, twofile);

		System.out.println(7);
		bst.Insert(eight, threefile);

		System.out.println(8);
		bst.Insert(nine, fourfile);

		System.out.println(9);
		bst.Insert(ten, fivefile);
		System.out.println();

		AVL avl = new AVL(bst);
		avl.print();
	}
}