
public class SimpleArrayList {
	private int length;	// Field to store the length of the list.
	private int maxSize;	// Field to store the maximum length of the list.
	private int[] list;	// Field to hold the list items.

	// Already Implemented		
	public SimpleArrayList() {
		length = 0;
		maxSize = 5;
		int[] _list = new int[5];
		list = _list;
	}

	// Already Implemented
	public boolean isEmpty() {
		return (length == 0);
	}

	// Already Implemented
	public int size() {
		return length;
	}

	// Already Implemented
	public int maxListSize() {
		return maxSize;
	}

	// Already Implemented	
	public String toString() {
		String X = "";
		for(int i=0; i<length; i++){
			String t = String.valueOf(list[i]);				
			X = X + " " + t;
		}
		return "[" + X + " ]";
	}

	// Your work	
	public int get(int index) {
		if (index <= maxSize - 1 && index>=0)
		{
			return list[index];
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("Array index: " + index);
		}
	}

	// Your work
	public void set(int index, int item) {
		if (index <= maxSize - 1 && index>=0)
		{
			list[index] = item;
		}
		else
			throw new ArrayIndexOutOfBoundsException("Array index: " + index);
	}

	// Your work
	public void add(int item) {
		if (length == maxSize)
		{
			grow();
			list[length] = item;
			length++;
		}
		else
		{
			list[length] = item;
			length++;
		}
	}

	// Your work
	public void addAt(int index, int item) {
		int[] temp = new int[maxSize];
		int i;
		if(index>length || index<0)
			throw new ArrayIndexOutOfBoundsException("Array index: " + index);
		else if (length == maxSize)
		{
			grow();
			for (i = index; i < maxSize; i++)
			{
				temp[i] = list[i];
			}

			for (i = index; i < length; i++)
			{
				list[i + 1] = temp[i];
			}

			list[index] = item;
			length++;
		}
		else
		{
			for (i = index; i < maxSize; i++)
			{
				temp[i] = list[i];
			}

			for (i = index; i < length; i++)
			{
				list[i + 1] = temp[i];
			}

			list[index] = item;
			length++;
		}
	}

	// Your work	
	public void remove(int item) {
		int i;
		int find = 0;
		for (i = 0; i < length; i++)
		{
			if (list[i] == item)
			{
				find = 1;
				break;
			}
		}

		//item이 list에 있으면 지우고 뒤의 item들을 앞으로 당김. item이 list에 없다면 에러 메시지.
		if (find == 0)
			throw new IllegalArgumentException();
		else
		{
			for (; i < length-1; i++)
				list[i] = list[i + 1];
			length--;
		}
	}

	// Your work
	public void removeAt(int index)
	{
		if (index <= maxSize - 1 && index>=0)
		{
			for (; index < length-1; index++)
				list[index] = list[index + 1];
			length--;
		}
		else
			throw new ArrayIndexOutOfBoundsException("Array index: " + index);
	}
	
	// Your work
	private void grow() {
		int[] _list = new int[maxSize+2];
		int i;
		for (i = 0; i < maxSize; i++)
		{
			_list[i] = list[i];
		}
		maxSize = maxSize + 2;
		list = _list;
	}

	// Your work
	private void shrink(){
		maxSize = maxSize - 1;
	}
}
