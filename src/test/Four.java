package test;
import java.util.ArrayList;
import java.util.List;
//public class binaryTree {
//}
 
/**
	4.在二元树中找出和为某一值的所有路径
	题目：输入一个整数和一棵二元树。
	从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。
	打印出和与输入整数相等的所有路径。
	例如输入整数22 和如下二元树
	10
	/ \
	5 12
	/\
	4 7
	则打印出两条路径：10, 12 和10, 5, 7。
	二元树节点的数据结构定义为：
	 
 */
 
/**
 * 二叉树
 */
class BinaryTree {
	private BinaryTreeNode root;	// 根

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	/**
	 * 增加子节点
	 * @param 节点
	 */
	public synchronized void addNode(BinaryTreeNode node) {
		if (null == this.root) {
			this.root = node;
			return;
		}
		
		BinaryTreeNode tempNode = this.root;
		
		while (true) {
			if (node.getM_nValue() > tempNode.getM_nValue()) {	// 大于父节点
				if (null == tempNode.getM_pRight()) {
					tempNode.setM_pRight(node);
					return;
				} else {
					tempNode = tempNode.getM_pRight();
					continue;
				}
			} else if (node.getM_nValue() < tempNode.getM_nValue()) {	// 小于父节点
				if (null == tempNode.getM_pLeft()) {
					tempNode.setM_pLeft(node);
					return;
				} else {
					tempNode = tempNode.getM_pLeft();
					continue;
				}
			} else {	// 等于父节点
				return;
			}
		}
	}
	
	/**
	 * 输出指定路径和大小的所有路径
	 * @param 路径的和
	 */
	public synchronized void printSumPath(int sumValue) {
		printSumPath(this.root, new ArrayList<Integer>(), 0, sumValue);
	}
	
	/**
	 * @param 节点
	 * @param 路径存储集合
	 * @param 临时路径的和
	 * @param 路径的和
	 */
	private void printSumPath(BinaryTreeNode node, List<Integer> path, int tempSum, int sumValue) {
		if (null == node) {
			return;
		}
		
		tempSum += node.getM_nValue();
		path.add(node.getM_nValue());
		
		boolean isLeaf = (null == node.getM_pLeft() && null == node.getM_pRight());	// 是否为叶子
		
		if (isLeaf && tempSum == sumValue) {	// 满足
			System.out.print("sumPath(" + sumValue + "): ");
			for (int i : path) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		// 《向左走，向右走》 :-)
		printSumPath(node.getM_pLeft(), path, tempSum, sumValue);
		printSumPath(node.getM_pRight(), path, tempSum, sumValue);
		
		// 保证递归完成后返回父节点时路径是根结点到父节点的路径，之后遍历父节点的其他子节点，没有则返回到爷爷节点...
		path.remove(path.size() - 1);	// 删除当前节点
		// 最后补充一下，如果path不是指针而是基本类型的话，这句话就没用了（放在递归调用下面就没用了），算法也废了，比如在这里加入一句tempSum+=XXX;对结果没有任何影响，不会影响递归return时其他函数里的参数
	}
	
	/**
	 * 打印前序遍历
	 */
	public synchronized void print() {
		if (null == this.root) {
			System.out.print("HashCode: " + this.hashCode() +  "; 空树;");
			return;
		}
		System.out.print("HashCode: " + this.hashCode() +  "; 树: ");
		print(this.root);
		System.out.println();
	}
	
	private void print(BinaryTreeNode node) {
		if (null != node) {
			System.out.print(node.getM_nValue() + " ");
			print(node.getM_pLeft());
			print(node.getM_pRight());
		}
	}
}

/**
 * 节点
 */
class BinaryTreeNode {
	private int m_nValue; // value of node
	private BinaryTreeNode m_pLeft; // left child of node
	private BinaryTreeNode m_pRight; // right child of node
	
	BinaryTreeNode(int value) {
		this.m_nValue = value;
	}
	
	public int getM_nValue() {
		return m_nValue;
	}
	public void setM_nValue(int mNValue) {
		m_nValue = mNValue;
	}
	public BinaryTreeNode getM_pLeft() {
		return m_pLeft;
	}
	public void setM_pLeft(BinaryTreeNode mPLeft) {
		m_pLeft = mPLeft;
	}
	public BinaryTreeNode getM_pRight() {
		return m_pRight;
	}
	public void setM_pRight(BinaryTreeNode mPRight) {
		m_pRight = mPRight;
	}
}

public class Four {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(new BinaryTreeNode(10));
		tree.addNode(new BinaryTreeNode(5));
		tree.addNode(new BinaryTreeNode(12));
		tree.addNode(new BinaryTreeNode(4));
		tree.addNode(new BinaryTreeNode(7));
		tree.addNode(new BinaryTreeNode(9));
		tree.addNode(new BinaryTreeNode(3));
		tree.print();
		tree.printSumPath(22);
		tree.printSumPath(31);
	}
}
