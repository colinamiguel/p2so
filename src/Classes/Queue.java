/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author USER
 */
public class Queue {
    
    public int size;
    public QueueNode first;
    public QueueNode last;
    public int priority;
    
    public Queue(int priority){
        this.size = 0;
        this.first = null;
        this.last = null;
        this.priority = priority;
    };

    public int getSize() {
        return size;
    };

    public void setSize(int size) {
        this.size = size;
    };

    public QueueNode getFirst() {
        return first;
    };

    public void setFirst(QueueNode first) {
        this.first = first;
    };

    public QueueNode getLast() {
        return last;
    };

    public void setLast(QueueNode last) {
        this.last = last;
    };

    public int getPriority() {
        return priority;
    };

    public void setPriority(int priority) {
        this.priority = priority;
    };  
    
    public void enqueue(Car car){
        QueueNode node = new QueueNode(car);
        if(this.size == 0){
            this.first = this.last = node;
            this.size = this.size + 1;
        }else{
            QueueNode aux = this.last;
            aux.setNext(node);
            this.last = node;
            this.size = this.size + 1;
        };
    };
    
    public void dequeue(){
        if (this.size == 0){}else if(this.size == 1){
            this.first = this.last = null;
        }else if(this.size > 1){
            QueueNode aux = this.first.getNext();
            this.first = aux;
        };
    };
    
}
