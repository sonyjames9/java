package stacks.com.sony;

import queues.com.sony.CircularQueues;
import queues.com.sony.CustomQueues;
import queues.com.sony.DynamicQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		CustomStacks stacks_object = new DynamicStacks();
		stacks_object.push(1);
		stacks_object.push(2);
		stacks_object.push(3);
		stacks_object.push(4);
		int peek_item = stacks_object.peek();
		System.out.println("Peeked Item : "+peek_item);
		System.out.println("Popped Item : "+stacks_object.pop());
		System.out.println("Peeked Item : "+stacks_object.peek());
		stacks_object.push(4);
		stacks_object.push(5);
		stacks_object.push(6);
		System.out.println("Peeked Item : "+stacks_object.peek());

		CustomQueues queue = new CustomQueues(5);
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.display();
		System.out.println(queue.front());
		queue.insert(6);
		queue.insert(7);

		CircularQueues cqueue = new DynamicQueue(5);
		cqueue.insert(10);
		cqueue.insert(20);
		cqueue.insert(30);
		cqueue.insert(40);
		cqueue.insert(50);
		cqueue.display();
		System.out.println("\n"+cqueue.front());
		System.out.println("\n"+cqueue.remove());
		cqueue.insert(65);
		cqueue.insert(7);
		cqueue.display();

	}
}
