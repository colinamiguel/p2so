package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */

import java.util.Random;

public class Administrator {
    
    public Queue bugatti_reinforcent_queue;
    public Queue lamborghini_reinforcement_queue;
    public Queue priority1b;
    public Queue priority2b;
    public Queue priority3b;
    public Queue priority1l;
    public Queue priority2l;
    public Queue priority3l;
    public int counter;
    public Car car1;
    public Car car2;
    
    public Administrator(Queue bugatti_reinforcent_queue, Queue lamborghini_reinforcement_queue, 
                         Queue priority1b, Queue priority2b, Queue priority3b,
                         Queue priority1l, Queue priority2l, Queue priority3l){
        
        this.bugatti_reinforcent_queue = bugatti_reinforcent_queue;
        this.lamborghini_reinforcement_queue = lamborghini_reinforcement_queue;
        this.priority1b = priority1b;
        this.priority2b = priority2b;
        this.priority3b = priority3b;
        this.counter = counter;
        this.car1 = car1;
        this.car2 = car2;
    };

    public Queue getBugatti_reinforcent_queue() {
        return bugatti_reinforcent_queue;
    }

    public void setBugatti_reinforcent_queue(Queue bugatti_reinforcent_queue) {
        this.bugatti_reinforcent_queue = bugatti_reinforcent_queue;
    }

    public Queue getLamborghini_reinforcement_queue() {
        return lamborghini_reinforcement_queue;
    }

    public void setLamborghini_reinforcement_queue(Queue lamborghini_reinforcement_queue) {
        this.lamborghini_reinforcement_queue = lamborghini_reinforcement_queue;
    }

    public Queue getPriority1b() {
        return priority1b;
    }

    public void setPriority1b(Queue priority1b) {
        this.priority1b = priority1b;
    }

    public Queue getPriority2b() {
        return priority2b;
    }

    public void setPriority2b(Queue priority2b) {
        this.priority2b = priority2b;
    }

    public Queue getPriority3b() {
        return priority3b;
    }

    public void setPriority3b(Queue priority3b) {
        this.priority3b = priority3b;
    }

    public Queue getPriority1l() {
        return priority1l;
    }

    public void setPriority1l(Queue priority1l) {
        this.priority1l = priority1l;
    }

    public Queue getPriority2l() {
        return priority2l;
    }

    public void setPriority2l(Queue priority2l) {
        this.priority2l = priority2l;
    }

    public Queue getPriority3l() {
        return priority3l;
    }

    public void setPriority3l(Queue priority3l) {
        this.priority3l = priority3l;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
       
    public void create_car(int id, String make){
        Car car = new Car(id, make);
        car.define_quality();
        switch(car.make){
            case "Bugatti":
                switch(car.priority){
                    case 1:
                        this.priority1b.enqueue(car);
                        break;
                    case 2:
                        this.priority2b.enqueue(car);
                        break;
                    case 3:
                        this.priority3b.enqueue(car);
                        break;
                };
                break;
            case "Lamborghini":
                switch(car.priority){
                    case 1:
                        this.priority1l.enqueue(car);
                        break;
                    case 2:
                        this.priority2l.enqueue(car);
                        break;
                    case 3:
                        this.priority3l.enqueue(car);
                        break;
                };
                break;     
        };
    };
    
    public void review_cycle(int counter, int id){
        if (counter%4 == 0) {
            Random random = new Random();
            if(random.nextFloat()<0.8){
                if(random.nextFloat() < 0.5){
                    create_car(id, "Lamborghini");
                }else{
                    create_car(id, "Bugatti");
                };
            };
            
        };
    };
    
    public void reinforce(Car car1, Car car2){
        switch(car1.make){
            case "Lamborghini":
                this.lamborghini_reinforcement_queue.enqueue(car1);
                break;
            case "Bugatti":
                this.bugatti_reinforcent_queue.enqueue(car1);
                break;
        };
        switch(car2.make){
            case "Lamborghini":
                this.lamborghini_reinforcement_queue.enqueue(car2);
                break;
            case "Bugatti":
                this.bugatti_reinforcent_queue.enqueue(car2);
                break;
        };
        
    };
    
    public void reinforcement_done(){
        Random random = new Random();
        if(random.nextFloat()<0.4){
            this.car1 = this.bugatti_reinforcent_queue.getFirst().value;
            this.car2 = this.lamborghini_reinforcement_queue.getFirst().value;
            this.bugatti_reinforcent_queue.dequeue();
            this.lamborghini_reinforcement_queue.dequeue();
            this.priority1b.enqueue(car1);
            this.priority1l.enqueue(car2);
        };
    };
    
};
