public class Exercise26_9 {
  public static void main(String[] args) {
    Exercise26_9 exercise25_8 = new Exercise26_9();
  }

  Exercise26_9() {
    MyLinkedList list = new MyLinkedList();

    list.add("Red");
    list.add("Yellow");
    list.add("Green");
    list.add("Blue");
    list.add("Pink");

    java.util.Iterator iterator = list.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  class MyLinkedList extends MyAbstractList {
    private Node head, tail;

    /** Create a default list */
    public MyLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyLinkedList(Object[] objects) {
      super(objects);
    }

    /** Return the head element in the list */
    public Object getFirst() {
      if (size == 0) {
        return null;
      }
      else {
        return head.element;
      }
    }

    /** Return the last element in the list */
    public Object getLast() {
      if (size == 0) {
        return null;
      }
      else {
        return tail.element;
      }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(Object o) {
      Node newNode = new Node(o);
      newNode.next = head;
      head = newNode;
      size++;

      if (tail == null) {
        tail = head;
      }
    }

    /** Add an element to the end of the list */
    public void addLast(Object o) {
      if (tail == null) {
        head = tail = new Node(o);
      }
      else {
        tail.next = new Node(o);
        tail = tail.next;
      }

      size++;
    }

    /** Add a new element o at the specified index in this list
     * The index of the head element is 0 */
    public void add(int index, Object o) {
      if (index == 0) {
        addFirst(o);
      }
      else if (index >= size) {
        addLast(o);
      }
      else {
        Node current = head;
        for (int i = 1; i < index; i++) {
          current = current.next;
        }
        Node temp = current.next;
        current.next = new Node(o);
        (current.next).next = temp;
        size++;
      }
    }

    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public Object removeFirst() {
      if (size == 0) {
        return null;
      }
      else {
        Node temp = head;
        head = head.next;
        size--;
        if (head == null) {
          tail = null;
        }
        return temp.element;
      }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public Object removeLast() {
      if (size == 0) {
        return null;
      }
      else if (size == 1) {
        Node temp = head;
        head = tail = null;
        size = 0;
        return temp.element;
      }
      else {
        Node current = head;

        for (int i = 0; i < size - 2; i++) {
          current = current.next;
        }

        Node temp = tail;
        tail = current;
        tail.next = null;
        size--;
        return temp.element;
      }
    }

    /** Remove the element at the specified position in this list.
     *  Return the element that was removed from the list. */
    public Object remove(int index) {
      if (index < 0 || index >= size) {
        return null;
      }
      else if (index == 0) {
        return removeFirst();
      }
      else if (index == size - 1) {
        return removeLast();
      }
      else {
        Node previous = head;

        for (int i = 1; i < index; i++) {
          previous = previous.next;
        }

        Node current = previous.next;
        previous.next = current.next;
        size--;
        return current.element;
      }
    }

    /** Override toString() to return elements in the list */
    public String toString() {
      StringBuffer result = new StringBuffer("[");

      Node current = head;
      for (int i = 0; i < size; i++) {
        result.append(current.element);
        current = current.next;
        if (current != null) {
          result.append(", "); // Separate two elements with a comma
        }
        else {
          result.append("]"); // Insert the closing ] in the string
        }
      }

      return result.toString();
    }

    /** Clear the list */
    public void clear() {
      head = tail = null;
    }

    /** Return true if this list contains the element o */
    public boolean contains(Object o) {
      System.out.println("Implementation left as an exercise");
      return true;
    }

    /** Return the element from this list at the specified index */
    public Object get(int index) {
      // Implement it in this exercise
      if (index < 0 || index > size - 1) {
        return null;
      }

      Node current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }

      return current.element;
    }

    /** Return the index of the head matching element in this list.
     *  Return -1 if no match. */
    public int indexOf(Object o) {
      System.out.println("Implementation left as an exercise");
      return 0;
    }

    /** Return the index of the last matching element in this list
     *  Return -1 if no match. */
    public int lastIndexOf(Object o) {
      System.out.println("Implementation left as an exercise");
      return 0;
    }

    /** Replace the element at the specified position in this list
     *  with the specified element. */
    public Object set(int index, Object o) {
      System.out.println("Implementation left as an exercise");
      return null;
    }

    private class Node {
      Object element;
      Node next;

      public Node(Object element) {
        this.element = element;
      }
    }


    public java.util.Iterator iterator() {
      return new MyLinkedListIterator(this);
    }

    class MyLinkedListIterator implements java.util.Iterator {
      private MyLinkedList list = new MyLinkedList();
      private MyLinkedList originalList;
      private int current = 0;

      MyLinkedListIterator(MyLinkedList originalList) {
        this.originalList = originalList;
        for (int i = 0; i < originalList.size(); i++) {
          list.add(originalList.get(i));
        }
      }

      public boolean hasNext() {
        if (current < list.size()) {
          return true;
        }

        return false;
      }

      public Object next() {
        return list.get(current++);
      }

      public void remove() {
        list.remove(current);
        originalList.remove(current);
      }

    }
  }

  abstract class MyAbstractList implements MyList {
    protected int size = 0; // The size of the list

    /** Create a default list */
    protected MyAbstractList() {
    }

    /** Create a list from an array of objects */
    protected MyAbstractList(Object[] objects) {
      for (int i = 0; i < objects.length; i++) {
        add(objects[i]);
      }
    }

    /** Add a new element o at the end of this list */
    public void add(Object o) {
      add(size, o);
    }

    /** Return true if this list contains no elements */
    public boolean isEmpty() {
      return size == 0;
    }

    /** Return the number of elements in this list */
    public int size() {
      return size;
    }

    /** Remove the first occurrence of the element o from this list.
     *  Shift any subsequent elements to the left.
     *  Return true if the element is removed. */
    public boolean remove(Object o) {
      if (indexOf(o) >= 0) {
        remove(indexOf(o));
        return true;
      }
      else {
        return false;
      }
    }
  }

}

interface MyList<E> {
  /** Add a new element at the end of this list */
  public void add(E e);

  /** Add a new element at the specified index in this list */
  public void add(int index, E e);

  /** Clear the list */
  public void clear();

  /** Return true if this list contains the element */
  public boolean contains(E e);

  /** Return the element from this list at the specified index */
  public E get(int index);

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(E e);

  /** Return true if this list contains no elements */
  public boolean isEmpty();

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E e);

  /** Remove the first occurrence of the element o from this list.
   *  Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public boolean remove(E e);

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index);

  /** Replace the element at the specified position in this list
   *  with the specified element and returns the new set. */
  public Object set(int index, E e);

  /** Return the number of elements in this list */
  public int size();
}
