package org.example;
import java.util.Iterator;
import java.util.List;

public class DoublyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator(head);
    }

    private class MyIterator implements Iterator<T> {
        Node<T> current;

        MyIterator (Node<T> current){
            this.current = current;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }


    private static class Node<V> {
        public V data; //данные
        public Node<V> next; //ссылка на следующий узел
        public Node<V> previous; //ссылка на предыдущий узел

        public Node(V data) {
            this.data = data;
        }
    }

    public void addInBeginning(T data) {
        if (data != null) {
            Node<T> newNode = new Node<>(data);
            if (head != null) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            } else {
                head = tail = newNode;
            }
        }
    }

    public T extValueFromTheBeginningWithoutDeleting() {  //извлечение значения из начала списка без его удаления из списка;
        return head.data;
    }

    public T extValueFromTheBeginningWithDeleting() {  //извлечение значения из начала списка с удалением его из списка;
        T x = head.data;
        remove(head.data);
        return x;
    }

    public T extValueFromTheEndWithoutDeleting() {  //извлечение значения из конца списка без удаления из списка;
        return tail.data;
    }

    public T extValueFromTheEndWithDeleting() { //извлечение значения из конца списка с удалением;
        T y = tail.data;
        remove(tail.data);
        return y;
    }

    public void addInEnd(T data) {
        if (data != null) {
            Node<T> newNode = new Node<T>(data);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
        }
    }

    public boolean searchValue(T data) {   //определение, содержит ли список заданное значение, или нет;
        if (data != null) {
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    return true;
                } else if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void remove(T data) {    //удаление заданного значения из списка;
        if (head == null || data == null) return;
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        Node<T> nextNode = head.next;
        if (searchValue(data)) {
            while (currentNode != null) {
                if (currentNode.data.equals(data)) {
                    if (currentNode == head) {
                        head = nextNode;
                        if (head != null) head.previous = null;
                    } else if (currentNode == tail) {
                        tail = currentNode.previous;
                        tail.next = null;
                    } else if (previousNode != null) {

                        previousNode.next = currentNode.next;
                        nextNode.previous = currentNode.previous;
                    }
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
                if (currentNode != null) nextNode = currentNode.next;
            }
        }
    }

    public boolean empty() {   //определение, является ли список пустым, или нет;
        return head == null;
    }

    public void printAllDirectOrder() {
        forEach(System.out::println);
        System.out.println();
    }


    public DoublyLinkedList<T> allReverseOrder() {
        if (head != null) {
            DoublyLinkedList<T> newList = new DoublyLinkedList<>();
            Node<T> currentNode = tail;
            while (currentNode != null) {
                newList.addInEnd(currentNode.data);
                currentNode = currentNode.previous;
            }
            return newList;
        } else return new DoublyLinkedList<>();
    }

    @SafeVarargs
    public final void addAllArrayValuesToTheBeginning(T... x) {
        for (int i = x.length - 1; i >= 0; i--) {
            addInBeginning(x[i]);
        }
    }

    public void addAllCollectionValuesToTheBeginning(List<T> x) {
        for (int i = x.size() - 1; i >= 0; i--) {
            addInBeginning(x.get(i));
        }
    }

    @SafeVarargs
    public final void addAllArrayValuesToTheEnd(T... x) {
        for (T o : x) {
            addInEnd(o);
        }
    }

    public void addAllCollectionValuesToTheEnd(List<T> x) {
        for (T i : x) {
            addInEnd(i);
        }
    }

    public void absorbingTheListToTheTop(DoublyLinkedList<T> x) {
        if (x.head == null) return;
        Node<T> currentNodeX = x.tail;
        while (currentNodeX != null) {
            addInBeginning(currentNodeX.data);
            x.remove(currentNodeX.data);
            currentNodeX = currentNodeX.previous;
        }
    }

    public void absorbingTheListToTheEnd(DoublyLinkedList<T> x) {
        if (x.head == null) return;
        Node<T> currentNodeX = x.head;
        while (currentNodeX != null) {
            addInEnd(currentNodeX.data);
            x.remove(currentNodeX.data);
            currentNodeX = currentNodeX.next;
        }
    }

    public DoublyLinkedList<T> listHeadToValue(T data) {
        if (data != null) {
            DoublyLinkedList<T> newList = new DoublyLinkedList<>();
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    newList.addInEnd(currentNode.data);
                    break;
                } else if (currentNode.next != null) {
                    newList.addInEnd(currentNode.data);
                    currentNode = currentNode.next;
                } else {
                    newList.addInEnd(currentNode.data);
                    break;
                }
            }
            return newList;
        }
        return new DoublyLinkedList<>();
    }

    public DoublyLinkedList<T> listTailToValue(T data) {
        if (data != null) {
            DoublyLinkedList<T> newList = new DoublyLinkedList<>();
            Node<T> currentNode = tail;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    newList.addInEnd(currentNode.data);
                    break;
                } else if (currentNode.previous != null) {
                    newList.addInEnd(currentNode.data);
                    currentNode = currentNode.previous;
                } else {
                    newList.addInEnd(currentNode.data);
                    break;
                }
            }
            return newList;
        }
        return new DoublyLinkedList<>();
    }

    public DoublyLinkedList<T> listValueToTail(T data) {
        if (data != null) {
            DoublyLinkedList<T> newList = new DoublyLinkedList<>();
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    newList.addInEnd(currentNode.data);
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                        newList.addInEnd(currentNode.data);
                    }
                    break;
                } else if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    break;
                }
            }
            return newList;
        }
        return new DoublyLinkedList<>();
    }

    public DoublyLinkedList<T> listValueToHead(T data) {
        if (data != null) {
            DoublyLinkedList<T> newList = new DoublyLinkedList<>();
            Node<T> currentNode = tail;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    newList.addInEnd(currentNode.data);
                    while (currentNode.previous != null) {
                        currentNode = currentNode.previous;
                        newList.addInEnd(currentNode.data);
                    }
                    break;
                } else if (currentNode.previous != null) {
                    currentNode = currentNode.previous;
                } else {
                    break;
                }
            }
            return newList;
        }
        return new DoublyLinkedList<>();
    }
}