package test;

/**
 * @author luochengcheng
 * ����һ��������
 */
class Node {
	//����
	private int record;
	//ָ����һ������
	private Node nextNode;

	public Node(int record) {
		super();
		this.record = record;
	}
	public int getRecord() {
		return record;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}

/**
 * @author luochengcheng
 *	���ַ�ʽʵ�ֵ�����ķ�ת(�ݹ顢��ͨ)
 *	����ǿ�ҽ����Ա�����ֽ�ͱʸ��Ŵ��뻭ͼ(�������)
 */
public class ReverseSingleList {
	/** 
	 * �ݹ飬�ڷ�ת��ǰ�ڵ�֮ǰ�ȷ�ת�����ڵ� 
	 */
	public static Node reverse(Node head) {
		if (null == head || null == head.getNextNode()) {
			return head;
		}
		Node reversedHead = reverse(head.getNextNode());
		head.getNextNode().setNextNode(head);
		head.setNextNode(null);
		return reversedHead;
	}

	/** 
	 * ����������ǰ�ڵ����һ���ڵ㻺�����ĵ�ǰ�ڵ�ָ�� 
	 *  
	 */
	public static Node reverse2(Node head) {
		if (null == head) {
			return head;
		}
		Node pre = head;
		Node cur = head.getNextNode();
		Node next;
		while (null != cur) {
			next = cur.getNextNode();
			cur.setNextNode(pre);
			pre = cur;
			cur = next;
		}
		//��ԭ�����ͷ�ڵ����һ���ڵ���Ϊnull���ٽ���ת���ͷ�ڵ㸳��head   
		head.setNextNode(null);
		head = pre;
		
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(0);
		Node tmp = null;
		Node cur = null;
		// ����һ������Ϊ10����������ͷ�ڵ����head   
		for (int i = 1; i < 10; i++) {
			tmp = new Node(i);
			if (1 == i) {
				head.setNextNode(tmp);
			} else {
				cur.setNextNode(tmp);
			}
			cur = tmp;
		}
		//��ӡ��תǰ������
		Node h = head;
		while (null != h) {
			System.out.print(h.getRecord() + " ");
			h = h.getNextNode();
		}
		//���÷�ת����
		head = reverse2(head);
		System.out.println("\n**************************");
		//��ӡ��ת��Ľ��
		while (null != head) {
			System.out.print(head.getRecord() + " ");
			head = head.getNextNode();
		}
	}
}