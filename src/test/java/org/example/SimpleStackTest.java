package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created stack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test pop")
    public void testPop() throws EmptyStackException {
        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When we add the new item
        stack.push(item);

        // then...
        assertEquals(item, stack.pop(), "The stack must return the item we popped");
        assertEquals(0, stack.getSize(), "The stack must contain 0 item after 'pop'");
    }



    @Test
    @DisplayName("Test peek an empty stack")
    public void testPeekEmptyStack() {
        //create an empty stack
        Stack stack = new SimpleStack();

        // When we peek at the top in an empty stack, should throws an EmptyStackException
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test peek")
    public void testPeek() throws EmptyStackException {
        //create an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When we add the new item
        stack.push(item);

        // then...
        assertEquals(item, stack.peek(), "The stack must return the item we popped");
    }
}
