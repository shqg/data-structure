package test;
import java.util.ArrayList;
import java.util.List;
//public class binaryTree {
//}
 
/**
	4.�ڶ�Ԫ�����ҳ���Ϊĳһֵ������·��
	��Ŀ������һ��������һ�ö�Ԫ����
	�����ĸ���㿪ʼ���·���һֱ��Ҷ��������������н���γ�һ��·����
	��ӡ����������������ȵ�����·����
	������������22 �����¶�Ԫ��
	10
	/ \
	5 12
	/\
	4 7
	���ӡ������·����10, 12 ��10, 5, 7��
	��Ԫ���ڵ�����ݽṹ����Ϊ��
	 
 */
 
/**
 * ������
 */
class BinaryTree {
	private BinaryTreeNode root;	// ��

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	/**
	 * �����ӽڵ�
	 * @param �ڵ�
	 */
	public synchronized void addNode(BinaryTreeNode node) {
		if (null == this.root) {
			this.root = node;
			return;
		}
		
		BinaryTreeNode tempNode = this.root;
		
		while (true) {
			if (node.getM_nValue() > tempNode.getM_nValue()) {	// ���ڸ��ڵ�
				if (null == tempNode.getM_pRight()) {
					tempNode.setM_pRight(node);
					return;
				} else {
					tempNode = tempNode.getM_pRight();
					continue;
				}
			} else if (node.getM_nValue() < tempNode.getM_nValue()) {	// С�ڸ��ڵ�
				if (null == tempNode.getM_pLeft()) {
					tempNode.setM_pLeft(node);
					return;
				} else {
					tempNode = tempNode.getM_pLeft();
					continue;
				}
			} else {	// ���ڸ��ڵ�
				return;
			}
		}
	}
	
	/**
	 * ���ָ��·���ʹ�С������·��
	 * @param ·���ĺ�
	 */
	public synchronized void printSumPath(int sumValue) {
		printSumPath(this.root, new ArrayList<Integer>(), 0, sumValue);
	}
	
	/**
	 * @param �ڵ�
	 * @param ·���洢����
	 * @param ��ʱ·���ĺ�
	 * @param ·���ĺ�
	 */
	private void printSumPath(BinaryTreeNode node, List<Integer> path, int tempSum, int sumValue) {
		if (null == node) {
			return;
		}
		
		tempSum += node.getM_nValue();
		path.add(node.getM_nValue());
		
		boolean isLeaf = (null == node.getM_pLeft() && null == node.getM_pRight());	// �Ƿ�ΪҶ��
		
		if (isLeaf && tempSum == sumValue) {	// ����
			System.out.print("sumPath(" + sumValue + "): ");
			for (int i : path) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		// �������ߣ������ߡ� :-)
		printSumPath(node.getM_pLeft(), path, tempSum, sumValue);
		printSumPath(node.getM_pRight(), path, tempSum, sumValue);
		
		// ��֤�ݹ���ɺ󷵻ظ��ڵ�ʱ·���Ǹ���㵽���ڵ��·����֮��������ڵ�������ӽڵ㣬û���򷵻ص�үү�ڵ�...
		path.remove(path.size() - 1);	// ɾ����ǰ�ڵ�
		// ��󲹳�һ�£����path����ָ����ǻ������͵Ļ�����仰��û���ˣ����ڵݹ���������û���ˣ����㷨Ҳ���ˣ��������������һ��tempSum+=XXX;�Խ��û���κ�Ӱ�죬����Ӱ��ݹ�returnʱ����������Ĳ���
	}
	
	/**
	 * ��ӡǰ�����
	 */
	public synchronized void print() {
		if (null == this.root) {
			System.out.print("HashCode: " + this.hashCode() +  "; ����;");
			return;
		}
		System.out.print("HashCode: " + this.hashCode() +  "; ��: ");
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
 * �ڵ�
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
