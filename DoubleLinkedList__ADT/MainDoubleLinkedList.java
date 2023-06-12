
package DoubleLinkedList__ADT;

public class MainDoubleLinkedList {
	public static void main(String[] args) {
		DefaultDoubleLinkedList<String> li = new DefaultDoubleLinkedList<>();
		li.add("Ahihi");
		li.add("Ahuhu");
		li.add("Do ngoc");
		System.out.println(li.toString());

		li.addFirst("first");
		li.addLast("last");
		System.out.println(li.toString());

		System.out.println(li.indexOf("Do ngoc"));
		System.out.println(li.contains("Ahuhu"));

		System.out.println(li.removeFirst());
		System.out.println(li.removeLast());
		System.out.println(li.toString());

		System.out.println(li.remove("Ahihi"));
		System.out.println(li.toString());

		System.out.println(li.removeAt(1));
		System.out.println(li.toString());
	}
}
