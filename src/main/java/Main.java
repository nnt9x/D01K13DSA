public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(20);
        myLinkedList.addLast(30);
        myLinkedList.add(40,1);
        myLinkedList.add(50,0);
        myLinkedList.add(60,5);

        myLinkedList.display();
    }
}
