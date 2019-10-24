public class BST<T>
{
	Node root;

	public BST() {
	}

	public boolean find(Comparable item) {
		return find(root, item);
	}

	public boolean find(Node t, Comparable item) {
		if (t == null) {
			return false;
		}
		if (t.data == item) {
			return true;
		}
		if (item.compareTo(t.data) < 0) {
			return find(t.left, item);
		}
		else {
			return find(t.right, item);
		}
	}

	public void insert(Comparable item) {
		root = insert(root, item);
	}

	public Node insert(Node t, Comparable item) {
		if (t == null) {
			root = new Node(item);
			return root;
		}
		else if ((t.data).compareTo(item) < 0) {
			t.right = insert(t.right, item);
			return t;
		}
		else {
			t.left = insert(t.left, item);
			return t;
		}
	}

	public void print() {
		print(root);
	}

	public void print(Node t) {
		if (t != null) {
			print(t.left);
			System.out.println(t.data);
			print(t.right);
		}
	}

	public void delete(Comparable item) {
		root = delete(root, item);
	}

	public Node delete(Node t, Comparable item) {
		if (t == null) {
			return null;
		}
		if ((t.data).compareTo(item) == 0) {
			if (t.left == null) {
				return t.right;
			}
			if (t.right == null) {
				return t.left;
			}
			if (t.right.left == null) {
				t.data = t.right.data;
				t.right = t.right.right;
				return t;
			}
			else {
				t.data = rightSmallest(t.right);
			}
		}
		else if ((t.data).compareTo(item) > 0) {
			t.left = delete(t.left, item);
			return t;
		}
		else {
			t.right = delete(t.right, item);
		}
		return t;
	}

	public Comparable rightSmallest(Node t) {
		if (t.left.left == null) {
			Comparable smallest = t.left.data;
			t.left = t.left.right;
			return smallest;
		}
		else {
			return rightSmallest(t.left);
		}
	}
}