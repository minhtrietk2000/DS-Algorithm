
package DoubleLinkedList__ADT;


import java.util.Iterator;

public class DefaultDoubleLinkedList<T> implements DoubleLinkedList<T> {
	private int size;
	private Node<T> head = null;
	private Node<T> tail = null;

	@Override
	public void clear() {
		Node<T> currentNode = head;
		while (currentNode != null) {
			Node<T> nextNode = currentNode.getNext();
			currentNode.setData(null);
			currentNode.setNext(null);
			currentNode.setPrev(null);
			currentNode = nextNode;
		}
		tail = head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(T element) {
		addLast(element);
	}

	@Override
	public void addFirst(T element) {
		if (isEmpty()) {
			Node<T> newNode = new Node<>(element, null, null);
			head = tail = newNode;
		} else {
			Node<T> newNode = new Node<>(element, null, head);
			head.setPrev(newNode);
			head = head.getPrev();
		}
		size++;
	}

	@Override
	public void addLast(T element) {
		if (isEmpty()) {
			Node<T> newNode = new Node<>(element, null, null);
			head = tail = newNode;
		} else {
			Node<T> newNode = new Node<T>(element, tail, null);
			tail.setNext(newNode);
			tail = tail.getNext();
		}
		size++;
	}

	@Override
	public T peekFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty Linked List!");
		return head.getData();
	}

	@Override
	public T peekLast() {
		if (isEmpty())
			throw new RuntimeException("Empty Linked List!");
		return tail.getData();
	}

	@Override
	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty Linked List!");
		T data = head.getData();
		size--;
		head = head.getNext();
		if (isEmpty())
			tail = null;
		else
			head.setPrev(null);
		return data;
	}

	@Override
	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("Empty Linked List!");
		T data = tail.getData();

		size--;
		tail = tail.getPrev();
		if (isEmpty())
			head = null;
		else
			tail.setNext(null);
		return data;
	}

	@Override
	public T remove(Node<T> element) {
		if (element.getNext() == null)
			return removeLast();
		if (element.getPrev() == null) {
			return removeFirst();
		}


		element.getPrev().setNext(element.getNext());
		element.getNext().setPrev(element.getPrev());

		T data = element.getData();
		size--;
		element.setData(null);
		element.setNext(null);
		element.setPrev(null);
		element = null;
		return data;
	}

	@Override
	public boolean remove(Object object) {
		Node<T> currentNode = head;
		if (object == null) {
			while (currentNode != null) {
				if (currentNode.getData() == null) {
					remove(currentNode);
					return true;
				}
				currentNode = currentNode.getNext();
			}
		} else {
			while (currentNode != null) {
				if (currentNode.getData() == object) {
					remove(currentNode);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public T removeAt(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException();
		Node<T> currentNode;
		int i;
		if (index < size / 2) {
			i = 0;
			currentNode = head;
			while (i != index) {
				currentNode = currentNode.getNext();
				i++;
			}
		} else {
			i = size - 1;
			currentNode = tail;
			while (i != index) {
				currentNode = currentNode.getPrev();
				i--;
			}
		}
		return remove(currentNode);
	}

	@Override
	public int indexOf(Object object) {
		int i = 0;
		Node<T> currentNode = head;
		if (object == null) {
			while (currentNode != null) {
				if (currentNode.getData() == null) {
					return i;
				}
				currentNode = currentNode.getNext();
				i++;
			}
		} else {
			while (currentNode != null) {
				if (currentNode.getData() == object) {
					return i;
				}
				currentNode = currentNode.getNext();
				i++;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(Object object) {
		return indexOf(object) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> currentNode = head;

			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public T next() {
				T data = currentNode.getData();
				currentNode = currentNode.getNext();
				return data;
			}
		};
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		else {
			StringBuilder sb = new StringBuilder(size);
			Node<T> currentNode = head;
			sb.append("[ ");
			while (currentNode != null) {
				sb.append(currentNode.getData());
				if (currentNode.getNext() != null)
					sb.append(",");
				currentNode = currentNode.getNext();
			}
			sb.append(" ]");
			return sb.toString();
		}
	}

}
