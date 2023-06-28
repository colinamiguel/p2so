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
    
    public Queue(){
        this.size = 0;
        this.first = null;
        this.last = null;
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
    
    public void enqueue(Car car){
        QueueNode node = new QueueNode(car);
        if(this.size == 0){
            System.out.println("tamano cero");
            this.first = this.last = node;
            this.size = this.size + 1;
            System.out.println("se ha encolado el carro de id " + node.value.id + " de marca: " + node.value.make);
        }else{
            QueueNode aux = this.last;
            aux.setNext(node);
            this.last = node;
            this.size = this.size + 1;
            System.out.println("se ha encolado el carro de id " + node.value.id + " de marca: " + node.value.make);
        };
    };
    
    public void dequeue(){
        if (this.size == 0){}else if(this.size == 1){
            System.out.println("se ha desencolado el carro de id " + this.first.value.id + " de marca: " + this.first.value.make);
            this.first = this.last = null;
            this.size = this.size - 1;
        }else if(this.size > 1){
            System.out.println("se ha desencolado el carro de id " + this.first.value.id + " de marca: " + this.first.value.make);
            QueueNode aux = this.first.getNext();
            this.first = aux;
            this.size = this.size - 1;
        };
    };
    
}
