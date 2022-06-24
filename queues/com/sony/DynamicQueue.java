package queues.com.sony;

public class DynamicQueue extends CircularQueues {
	public DynamicQueue() {
		super();
	}

	public DynamicQueue(int size) {
		super(size);
	}

	@Override
	public boolean insert(int item) {
		if (this.isFull()) {
			//If stack is full, increase the array size * 2
			int[] temp = new int[data.length * 2];

			//Copy all previous items in new temp data
			for (int i = 0; i < data.length; i++) {
				temp[i] = data[(front + i) % data.length];
			}
			front = 0;
			end = data.length;
			data = temp;
		}
		// Now after the increase in stack data size, items can be inserted
		return super.insert(item);
	}
}
