package stacks.com.sony;

public class DynamicStacks extends StacksImp {
	public DynamicStacks() {
		super();
	}

	public DynamicStacks(int size) {
		super(size);
	}

	@Override
	public boolean push(int item) throws StackException {
		if(this.is_full()) {
		//If stack is full, increase the array size * 2
			int[] temp = new int[data.length * 2];

		//Copy all previous items in new temp data
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
		}
		// Now after the increase in stack data size, items can be inserted
		return super.push(item);
	}
}