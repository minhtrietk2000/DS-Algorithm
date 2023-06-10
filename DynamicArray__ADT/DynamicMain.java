
package DynamicArray__ADT;

public class DynamicMain {
    public static void main(String[] args) {
        DynamicArr<String> arr = new DynamicArr<>();
        arr.add("Triet");
        arr.add("Nguyen");
        arr.add("Minh");
        System.out.println(arr.toString());
        System.out.println(arr.size());
    }
}
