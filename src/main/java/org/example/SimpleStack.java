package org.example;

import java.util.ArrayList;

public class SimpleStack implements Stack {

    private ArrayList<Item> stack;

    public SimpleStack() {
        this.stack  = new ArrayList<Item>();
    }

    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return this.stack.size();
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(Item item) {
        stack.add(item);
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        if (this.getSize() > 0) {
            return this.stack.get(this.getSize() - 1);
        } else {
            throw new EmptyStackException();
        }
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {
        if (this.getSize() > 0){
            Item item = this.peek();
            this.stack.remove(this.getSize()-1);
            return item;
        } else {
            throw new EmptyStackException();
        }

    }
}
