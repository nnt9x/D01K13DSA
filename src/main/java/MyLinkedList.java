public class MyLinkedList {
    // Vị trí đầu tiên Linked list
    private Node head;

    // Co 1 thuoc tinh luu tru kich thuoc
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Thêm các phần tử => in ra các phần tử
    public void addFirst(int x) {
        Node tmp = new Node(x);
        // Buoc 1: lay ra head hien tai
        Node currentHead = head;
        // Bươc 2: gan head -> node tmp
        head = tmp;
        // Buoc 3: Trỏ head -> node trước do (bươc 1)
        tmp.setNext(currentHead);
        size++;
    }

    public void addLast(int x) {
        Node tmp = new Node(x);
        Node last;
        Node i = head;
        while (true) {
            if (i.getNext() == null) {
                last = i;
                break;
            }
            i = i.getNext();
        }
        last.setNext(tmp);
        // Bước 1: tìm ra phần tử cuối -> duyệt đến
        // khi node có next = null
        // Bước 2: trỏ node next cuối -> node mới vừa thêm
        // Node mới bjo sẽ là phần tử cuối
        size++;
    }

    public void add(int x, int position) {
        if (position == 0) {
            addFirst(x);
        } else if (position == size) {
            addLast(x);
        } else if (position > size) {
            throw new RuntimeException("Không thể thêm vào vị trí này!");
        } else {
            // Vị trí từ > 0 và < size ??
            Node previous = null; // i - 1
            Node current; // i (chính là vị trí cần thay thế) -> lát node sẽ chuyển thành
            // node vị trí i +1

            for (int j = 0; j < position; j++) {
                if (previous == null) {
                    previous = head;
                } else {
                    previous = previous.getNext();
                }
            }
            current = previous.getNext();

            Node tmp = new Node(x);
            previous.setNext(tmp);
            tmp.setNext(current);

            size++;
        }
    }

    public void removeFirst() {
        // Kiểm tra có rỗng hay ko?
        if (isEmpty()) {
            throw new RuntimeException("Danh sách rỗng!");
        }
        // Bước 1: Lấy ra head hiện tại
        Node currentHead = head;
        Node nextHead = currentHead.getNext();
        currentHead.setNext(null);

        // Buoc 2: Gan lai head
        head = nextHead;
        size--;
    }

    public void removeLast() {
        // Y tuong: tim ra node gần cuối
        // Gán node gần cuối có next = null => trở thành node cuối
        Node tmp = head;
        while (true) {
            if (tmp.getNext().getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        tmp.setNext(null);
        size--;
    }

    public void remove(int position) {
        if (position == 0) {
            removeFirst();
        } else if (position == size - 1) {
            removeLast();
        } else {
            Node previousNode = null, currentNode = null, nextNode = null; // i-1, i, i + 1
            for (int i = 0; i <= position - 1; i++) {
                if (previousNode == null) {
                    previousNode = head;
                } else {
                    previousNode = previousNode.getNext();
                }
            }
            currentNode = previousNode.getNext();
            nextNode = currentNode.getNext();

            previousNode.setNext(nextNode);
            currentNode.setNext(null);
            size--;
        }
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    public void display() {
        Node n = head;
        while (true) {
            System.out.print(n);
            System.out.print("-->");
            n = n.getNext();
            if (n == null) break;
        }
        System.out.println();
    }

}
