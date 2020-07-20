package com.practice6.stack;

//use ListNode to implement stack (push, pop, peek)
public class StackByLinkedList {
  
  class ListNode {
    int value;
    ListNode next;
    // ListNode prev;
    public ListNode(int value) {
      this.value = value;
    }
  }
  private ListNode head;
  
  public Integer pop() {
    if (head == null) {
      return null;
    }
    ListNode popped = head;
    head = head.next;
    popped.next = null;   //good practice
    return popped.value;
  }
  
  public void push(int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = head;
    head = newNode;
  }
  
  public Integer peek() {
    if (head == null) {
      return null;
    }
    return head.value;
  }
  
  public static void main(String[] args) {
    StackByLinkedList test = new StackByLinkedList();
    test.push(1);
    test.push(2);
    test.push(3);
    test.pop();
    test.pop();
  }
  
}

