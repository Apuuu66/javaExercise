public class Exercise11_7International {
  public static void main(String[] args) {
    QueueOfIntegers queue = new QueueOfIntegers();
    
    for (int i = 0; i < 10; i++)
      queue.enqueue(i);
    
    while (!queue.empty())
      System.out.print(queue.dequeu() + " ");  
  }
}

class MyQueue {
  private Object[] elements;
  private int size;
  public static final int DEFAULT_CAPACITY = 16;

  /** Construct a queue with the default capacity 16 */
  public MyQueue() {
    this(DEFAULT_CAPACITY);
  }

  /** Construct a queue with the specified maximum capacity */
  public MyQueue(int capacity) {
    elements = new Object[capacity];
  }

  /** Push a new integer to the end of the queue */
  public Object enqueue(int value) {
    if (size >= elements.length) {
      Object[] temp = new Object[elements.length * 2];
      System.arraycopy(elements, 0, temp, 0, elements.length);
      elements = temp;
    }

    return elements[size++] = value;
  }

  /** Return and remove the first element from the queue */
  public Object dequeu() {
    Object temp = elements[0];
    
    // Shift all elements to the left
    for (int i = 1; i < size; i++)
      elements[i - 1] = elements[i];
    
    size--; // Reduce the queue size
    
    return temp;
  }

  /** Exercise3_21 whether the queue is empty */
  public boolean empty() {
    return size == 0;
  }

  /** Return the number of elements in the queue */
  public int getSize() {
    return size;
  }
}