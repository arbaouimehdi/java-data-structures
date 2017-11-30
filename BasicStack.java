public class BasicStack<X> {

  private X [] data;

  // Track the stack location in the underlying array.
  // This variable will be incremented or decremented
  // base of the size of the stack, it behaves like an
  // internal pointer on our data structure.
  private int stackPointer;

  public BasicStack(){
    // Initalize a data structure
    // to a new object array of 1000
    // it means holding 1000 items in our stack
    data = (X[]) new Object[1000];

    // Initlialize the stack Pointer to 0
    stackPointer = 0;
  }

  // Push into stack
  // "newItem" is the item we want to put
  // on top of the stack.
  // Push method will take an incoming item
  // and add it to the underlying data structure array
  public void push(X newItem){

    // Takes a new item that's passed in
    // and assigning to the data structure
    // in one of its 1000 slots
    data[stackPointer++] = newItem;
  }

  // Pop from the stack
  // by decrementing the stack pointer
  // and returning the item
  public X pop(){

    // Before Decrementing
    // Check if the stack pointer is currently at zero
    // so if there is no more items on the stack, we
    // can't pop anything off.
    if(stackPointer == 0){
      throw new IllegalStateException("No more items on the stack");
    }

    // This will not actually delete the data from the slot
    // this simply return and decrement the stack pointer
    return data[--stackPointer];
  }

  // Check the existence of the current item in the stack
  // if so return a boolean
  public boolean contains(X item) {
    boolean found = false;

    // Loop through all items in our stack
    // and see if we have found the actual passed-in item
    for (int i = 0; i < stackPointer; i++) {

      // O(n)
      // Compare the data slot with the current item
      // passed-in, if the condition is valid set the boolean
      // found to true
      if (data[i].equals(item)) {
        found = true;
        break;
      }
    }

    return found;
  }

  // Check the existence of the current item in the stack
  // if so return the item
  public X access(X item) {

    // While we've items on the stack
    // grab each one by doing pop
    while (stackPointer > 0) {
      X tmpItem = pop();
      if(item.equals(tmpItem)) {
        return tmpItem;
      }
    }

    // Check if we didn't have an item in the stack
    throw new IllegalArgumentException("Could not find item on the stack: " + item);

  }

  // Return the current position of the stack pointer
  public int size() {
    return stackPointer;
  }


}
