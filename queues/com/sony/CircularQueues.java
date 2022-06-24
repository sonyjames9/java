package queues.com.sony;

public class CircularQueues {
	protected int[] data;
	private static final int DEFAULT_SIZE = 5;

	protected int front = 0;
	protected int end = 0;
	private int size = 0;

	public CircularQueues() {
		this(DEFAULT_SIZE);
	}

	public CircularQueues(int size) {
		this.data = new int[size];
	}

	public boolean isFull() {
		return size == data.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean insert(int item) {
		if (isFull())
			return false;

		data[end++] = item;
		size ++;
		end = end % data.length;

		return true;
	}

	public int remove() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty, no items to be removed");
		int removed = data[front++];
		front = front % data.length;
		size --;
		return removed;
	}

	public int front() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return data[front];
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Cicular queue is empty");
			return;
		}
		int i = front;
		do {
			System.out.print(data[i] + " -> ");
			i++;
			i %= data.length;
		} while (i != end);

	}
}
