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
public class QueueNode {
    
    public Car value;
    public QueueNode next;

    public QueueNode(Car car){
        this.value = car;
        this.next = null;
    };

    public Car getValue() {
        return value;
    };

    public void setValue(Car value) {
        this.value = value;
    };

    public QueueNode getNext() {
        return next;
    };

    public void setNext(QueueNode next) {
        this.next = next;
    };
    
    
    
}
