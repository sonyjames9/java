package stacks.com.sony;

public class StacksImp {
	protected int[] data;
	private static final int DEFAULT_SIZE = 5;

	int ptr = -1;

	public StacksImp() {
		this(DEFAULT_SIZE);
	}

	/*
	Above constructor is used to assign the default size of array 10
	If not then assign the size by yourselves
	* */

	//Constructor
	public StacksImp(int size) {
		this.data = new int[size];
	}

	//Constructor
	public StacksImp(int[] data) {
		this.data = data;
	}

	public boolean push(int item) throws StackException {
		if (is_full()) {
			System.out.println("Stack is full, no item can be pushed");
			throw new StackException("Cannot push into stack already full !!");
		}
		data[++ptr] = item;
		return true;
	}

	public int pop() throws StackException {
		if (is_empty()) {
			System.out.println("Stack is empty, no item to pop");
			throw new StackException("Cannot pop from an empty stack !!");
		}
		return data[ptr--];
	}

	public int peek() throws StackException {
		if (is_empty()) {
			System.out.println("Cannot peek from empty stack");
			throw new StackException("Cannot peek from an empty stack !!");
		}

		return data[ptr];
	}

	protected boolean is_full() {
		return ptr == data.length -1;
	}

	private boolean is_empty() {
		return ptr == -1;
	}
}
