
public class SimpleLinkedList {
	private int length;	// Field to store the length of the list.
	private ListNode head;	// Field to hold the list items.

	// Already Implemented class for node
	protected class ListNode {
		private int item;		// Field to store an item
		private ListNode nextNode;	// Field to indicate next list node.
		
		ListNode() {}
		
		ListNode(int _item) {
			item = _item;
		}
		
		// Method to set an item
		public void setItem(int _item) {
			item = _item;
		}
		
		// Method to return the item
		public int getItem() {
			return item;
		}
		
		// Method to set next list node
		public void setNextNode(ListNode node) {
			nextNode = node;
		}
		
		// Method to return next list node
		public ListNode getNextNode() {
			return nextNode;
		}
	}

	// Already Implemented
	public SimpleLinkedList() {
		length = 0;
	}

	// Already Implemented
	public String toString() {
		String X = "";
		ListNode walker = head;
		while (walker != null) {
			String t = String.valueOf(walker.getItem());			
			X = X + " " + t;
			walker = walker.getNextNode();
		}
		return "[" + X + " ]";
	}

	// Already Implemented		
	public boolean isEmpty() {
		return (length == 0);
	}

	// Already Implemented
	public int size() {
		return length;
	}

	// Your work
	public int get(int index) {
		ListNode walker = head;
		int i;
		if(index<0 || index>length-1)
		{
			throw new IndexOutOfBoundsException("Array index: " + index);
		}
		else
		{
			for(i=0;i<index;i++){
				walker = walker.getNextNode();
			}
			return walker.getItem();
		}
	}

	// Your work	
	public void set(int index, int item) {
		int i;
		ListNode walker = head;
		if(index<0 || index>length-1)
			throw new IndexOutOfBoundsException("Array index: " + index);
		else
		{
			for(i=0;i<index;i++){
				walker = walker.getNextNode();
			}
			walker.item = item;
		}
	}

	// Your work	
	public void add(int item) {
		ListNode temp = new ListNode();
		temp.setItem(item);
		temp.setNextNode(null);
		ListNode walker = head;
		
		if(length == 0){
			head = temp;
			length++;
		}
		else{
		while(walker.nextNode != null){
			walker = walker.getNextNode();
		}

		walker.nextNode = temp;
		length++;
	}
		
	}
	
	// Your work	
	public void addAt(int index, int item) {
		int i;
		ListNode walker = head;
		ListNode temp = new ListNode(item);
		
		if(index > length){
			throw new IndexOutOfBoundsException("Array index: " + index);
		}
		else if(index == 0){
			temp.nextNode = head;
			head = temp;
			length++;
		}
		else{
			for(i=0;i<index-1;i++)
			{
				walker = walker.getNextNode();
			}
			
			temp.nextNode = walker.getNextNode();
			walker.nextNode = temp;
			length++;
		}
	}

	// Your work	
	public void remove(int item) {
		int find=0;
		ListNode walker = head;
		ListNode temp=new ListNode();
		
		while(walker != null){
			if(walker.nextNode.item == item){
				find =1;
				temp = walker.getNextNode();
				break;
			}
			else
				walker = walker.getNextNode();
		}
		
		if(find == 1)
		{
			walker.nextNode = temp.getNextNode();
			length--;
		}
		else
			throw new NullPointerException();
	}

	// Your work	
	public void removeAt(int index) {
		int i;
		ListNode walker = head;
		ListNode temp = new ListNode();
		
		if(index<0 || index>length-1)
			throw new IndexOutOfBoundsException("Array index: " + index);
		else if(index ==0){
			head = head.getNextNode();
			length--;
		}
		else{
			for(i=0;i<index-1;i++)
				walker = walker.getNextNode();
			
			temp = walker.getNextNode();
			walker.nextNode = temp.getNextNode();
			length--;
		}
	}	
}
