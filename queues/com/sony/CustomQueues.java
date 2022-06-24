package queues.com.sony;

import stacks.com.sony.CustomStacks;

public class CustomQueues {
	private int[] data;
	private static final int DEFAULT_SIZE = 5;

	int end = 0;

	public CustomQueues() {
		this(DEFAULT_SIZE);
	}

	public CustomQueues(int size) {
		this.data = new int[size];
	}

	public boolean isFull() {
		return end == data.length;
	}

	public boolean isEmpty() {
		return end == 0;
	}

	public boolean insert(int item) {
		if (isFull())
			return false;

		data[end++] = item;
		return true;
	}

	public int remove() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty, no items to be removed");
		int removed = data[0];

		for (int i = 1; i< end; i++) {
			data[i-1] = data[i];
		}
		end --;
		return removed;
	}

	public int front() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return data[0];
	}

	public void display() {
		for (int i =0; i< end; i++)
			System.out.println(data[i]+" ");
	}
}