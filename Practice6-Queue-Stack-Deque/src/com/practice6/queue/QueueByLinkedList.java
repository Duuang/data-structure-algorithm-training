package com.practice6.queue;

public class QueueByLinkedList {
  
  class ListNode {
    int value;
    ListNode next;
    // ListNode prev;
    public ListNode(int value) {
      this.value = value;
    }
  }
  private ListNode head;
  private ListNode tail;
  
  // add at tail
  public void offer(int value) {
    if (head == null) {
      head = tail = new ListNode(value);
    } else {
      tail.next = new ListNode(value);
      tail = tail.next;
    }
  }
  
  //remove at head
  public Integer poll() {
    if (head == null) {
      return null;
    }
    ListNode prev = head;
    head = head.next;
    if (head == null) {
      tail = null;
    }
    prev.next = null;  //good practice
    return prev.value;
  }
  
  public Integer peek() {
    if (head == null)
      return null;
    return head.value;
  }
  
  public static void main(String[] args) {
    QueueByLinkedList test = new QueueByLinkedList();
    test.add(1);
    test.add(2);
    test.add(3);
    test.remove();
    test.remove();
    
  }
}
