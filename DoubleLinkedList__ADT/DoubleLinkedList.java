
package DoubleLinkedList__ADT;

public interface DoubleLinkedList<T> extends Iterable<T> {
	void clear();

	boolean isEmpty();

	int size();

	void add(T element);

	void addFirst(T element);

	void addLast(T element);

	T peekFirst();

	T peekLast();

	T removeFirst();

	T removeLast();

	T remove(Node<T> element);

	boolean remove(Object object);

	T removeAt(int index);

	int indexOf(Object object);

	boolean contains(Object object);
}
