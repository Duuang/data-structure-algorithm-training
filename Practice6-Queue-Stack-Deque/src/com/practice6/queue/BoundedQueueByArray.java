package com.practice6.queue;

public class BoundedQueueByArray {
  private int[] array;
  private int head, tail;
  //private int size;   ����size����head��tail��ʾfull/empty����һ���ڵ���ʶ��full/empty
  //ptivate boolean isFull;   ���߲���size����boolҲ�ܱ�ʾ
  
  public BoundedQueueByArray(int capacity) {
    if(capacity > 0) {   
      head = 0;
      tail = 1;
      array = new int[capacity + 1];  //!!��capacity + 1��Ҫ�˷�һ��λ��
    }
  }
  public boolean offer(int value) {
    if (isFull()) {
      return false;
    }
    array[tail] = value;
    tail = tail == array.length - 1 ? 0:tail + 1;   //tail = (tail + 1) % array.length????
    return true;
  }
  
  public Integer poll() {
    if (isEmpty()) {
      return null;
    }
    head = (head + 1) % array.length;
    return array[head];
  }
  
  public Integer peek() {
    if (isEmpty()) {
      return null;
    }
    return array[(head + 1) % array.length];
  }
  
  public boolean isFull() {
    if (head == tail) {
      return true;
    }
    return false;
  }
  
  public boolean isEmpty() {
    if ((head + 1) % array.length == tail) {
      return true;
    }
    return false;
  }
  
  
  public static void main(String[] args) {
    BoundedQueueByArray test = new BoundedQueueByArray(3);
    
    System.out.println(test.isEmpty());
  }
}
