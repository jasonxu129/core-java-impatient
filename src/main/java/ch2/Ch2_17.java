package ch2;

public class Ch2_17 {
    public static class Queue {
        private Node head;
        private Node tail;

        public static class Node {
            private String desc;
            private Node next;

            public Node(String desc) {
                this.desc = desc;
                this.next = null;
            }

            public String getDesc() { return desc; }

            public Node getNext() { return next; }

            public void setNext(Node next) {
                this.next = next;
            }
        }

        public class Iterator {
            private Node current;
            private Iterator() {
                current = head;
            }
            // Or even shorter:
            // private Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            public String next() {
                if (current != null) {
                    String res = current.getDesc();
                    current = current.next;
                    return res;
                } else {
                    return null;
                }
            }
        }

        public Iterator iterator() {
            return new Iterator();
        }

        public void add(String des) {
            Node node = new Node(des);
            if (tail == null) {
                head = tail = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
        }

        public String remove() {
            if (head == null) {
                return null;
            }
            Node node = head;
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            return node.getDesc();
        }

        public void print() {
            Node n = head;
            while (n != null) {
                System.out.println(n.getDesc());
                n = n.getNext();
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add("n1");
        q.add("n2");
        q.remove();
        q.add("n3");
        q.add("n0");

        q.print();

        System.out.println("iterator print:");
        Queue.Iterator iter = q.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
