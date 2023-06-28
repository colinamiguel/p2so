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

import Classes.Interfaz.Interface;
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
    public Car selected1;
    public Car selected2;
    public int lamborghini_counter;
    public int bugatti_counter;
    public Interface dashboard;
    
    public Administrator(Queue bugatti_reinforcent_queue, Queue lamborghini_reinforcement_queue, 
                         Queue priority1b, Queue priority2b, Queue priority3b,Queue priority1l, 
                         Queue priority2l, Queue priority3l, Interface dashboard){
        
        this.bugatti_reinforcent_queue = bugatti_reinforcent_queue;
        this.lamborghini_reinforcement_queue = lamborghini_reinforcement_queue;
        this.priority1b = priority1b;
        this.priority2b = priority2b;
        this.priority3b = priority3b;
        this.counter = counter;
        this.car1 = car1;
        this.car2 = car2;
        this.selected1 = selected1;
        this.selected2 = selected2;
        this.priority1l = priority1l;
        this.priority2l = priority2l;
        this.priority3l = priority3l;
        this.lamborghini_counter = lamborghini_counter;
        this.bugatti_counter = bugatti_counter;
        this.dashboard = dashboard;
        
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
        this.dashboard.adminstatus.setText("Creando Carros.");
        Car car = new Car(id, make);
        car.define_quality();
        switch(car.make){
            case "Bugatti":
                switch(car.priority){
                    case 1:
                        this.priority1b.enqueue(car);
                        this.bugatti_counter ++;
                        this.dashboard.b1queue.setText(Integer.toString(this.priority1b.size));
                        break;
                    case 2:
                        this.priority2b.enqueue(car);
                        this.bugatti_counter ++;
                        this.dashboard.b2queue.setText(Integer.toString(this.priority2b.size));
                        break;
                    case 3:
                        this.priority3b.enqueue(car);
                        this.bugatti_counter ++;
                        this.dashboard.b3queue.setText(Integer.toString(this.priority3b.size));
                        break;
                };
                break;
            case "Lamborghini":
                switch(car.priority){
                    case 1:
                        this.priority1l.enqueue(car);
                        this.lamborghini_counter ++;
                        this.dashboard.l1queue.setText(Integer.toString(this.priority1l.size));
                        break;
                    case 2:
                        this.priority2l.enqueue(car);
                        this.lamborghini_counter ++;
                        this.dashboard.l2queue.setText(Integer.toString(this.priority2l.size));
                        break;
                    case 3:
                        this.priority3l.enqueue(car);
                        this.lamborghini_counter ++;
                        this.dashboard.l3queue.setText(Integer.toString(this.priority3l.size));
                        break;
                };
                break;     
        };
        this.dashboard.adminstatus.setText("En Espera.");
    };
    
    public void review_cycle(int counter, int id){
        if (counter%4 == 0) {
            Random random = new Random();
            if(random.nextFloat()<0.8){
                if(random.nextFloat() < 0.5){
                    create_car(id, "Lamborghini");
                    this.lamborghini_counter ++;
                    System.out.println("Se ha creado un carro Lamborghini");
                }else{
                    create_car(id, "Bugatti");
                    this.bugatti_counter ++;
                    System.out.println("Se ha creado un carro Bugatti");
                };
            };
            
        };
    };
    
    public void reinforce(Car car1, Car car2){
        this.dashboard.adminstatus.setText("Reforzando Carros.");
        switch(car1.make){
            case "Lamborghini":
                this.lamborghini_reinforcement_queue.enqueue(car1);
                this.dashboard.lrqueue.setText(Integer.toString(this.lamborghini_reinforcement_queue.size));
                break;
            case "Bugatti":
                this.bugatti_reinforcent_queue.enqueue(car1);
                this.dashboard.brqueue.setText(Integer.toString(this.bugatti_reinforcent_queue.size));
                break;
        };
        switch(car2.make){
            case "Lamborghini":
                this.lamborghini_reinforcement_queue.enqueue(car2);
                this.dashboard.lrqueue.setText(Integer.toString(this.lamborghini_reinforcement_queue.size));
                break;
            case "Bugatti":
                this.bugatti_reinforcent_queue.enqueue(car2);
                this.dashboard.brqueue.setText(Integer.toString(this.bugatti_reinforcent_queue.size));
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
            this.dashboard.lrqueue.setText(Integer.toString(this.lamborghini_reinforcement_queue.size));
            this.dashboard.brqueue.setText(Integer.toString(this.bugatti_reinforcent_queue.size));
            this.priority1b.enqueue(car1);
            this.dashboard.b1queue.setText(Integer.toString(this.priority1b.size));
            this.priority1l.enqueue(car2);
            this.dashboard.l1queue.setText(Integer.toString(this.priority1l.size));
            this.lamborghini_counter ++;
            this.bugatti_counter ++;
        }else{
            this.car1 = this.bugatti_reinforcent_queue.getFirst().value;
            this.bugatti_reinforcent_queue.dequeue();
            
            switch(car1.make){
                case "Lamborghini":
                    switch(car1.priority){
                        case 1:
                            this.priority1l.enqueue(car1);
                            break;
                        case 2:
                            this.priority2l.enqueue(car1);
                            break;
                        case 3:
                            this.priority3l.enqueue(car1);
                            break;
                    };
                    break;
                case "Bugatti":
                    switch(car1.priority){
                        case 1:
                            this.priority1b.enqueue(car1);
                            break;
                        case 2:
                            this.priority2b.enqueue(car1);
                            break;
                        case 3:
                            this.priority3b.enqueue(car1);
                            break;
                    };
                    break;
            };
            
            switch(car2.make){
                case "Lamborghini":
                    switch(car2.priority){
                        case 1:
                            this.priority1l.enqueue(car2);
                            break;
                        case 2:
                            this.priority2l.enqueue(car2);
                            break;
                        case 3:
                            this.priority3l.enqueue(car2);
                            break;
                    };
                    break;
                case "Bugatti":
                    switch(car2.priority){
                        case 1:
                            this.priority1b.enqueue(car2);
                            break;
                        case 2:
                            this.priority2b.enqueue(car2);
                            break;
                        case 3:
                            this.priority3b.enqueue(car2);
                            break;
                    };
                    break;
            };           
        };
    };
    
    public Car select_car1(){
        dashboard.adminstatus.setText("Seleccionado el carro de Bugatti");
        if (this.priority1b.size != 0) {
            this.selected1 = this.priority1b.first.value;
            this.priority1b.dequeue();
            this.dashboard.b1queue.setText(Integer.toString(this.priority1b.size));
            this.bugatti_counter --;
        }else if(this.priority2b.size != 0){
            this.selected1 = this.priority2b.first.value;
            this.priority2b.dequeue();
            this.dashboard.b2queue.setText(Integer.toString(this.priority2b.size));
            this.bugatti_counter --;
        }else if(this.priority3b.size != 0){
            this.selected1 = this.priority3b.first.value;
            this.priority3b.dequeue();
            this.dashboard.b3queue.setText(Integer.toString(this.priority3b.size));
            this.bugatti_counter --;
        }else{
            System.out.println("No hay carros disponibles");
        };
        return this.selected1;
    };
        
    public Car select_car2(){
        dashboard.adminstatus.setText("Seleccionado el carro de Lamborghini");
        if (this.priority1l.size != 0) {
            this.selected2 = this.priority1l.first.value;
            this.priority1l.dequeue();
            this.dashboard.l1queue.setText(Integer.toString(this.priority1l.size));
            this.lamborghini_counter --;
        }else if(this.priority2l.size != 0){
            this.selected2 = this.priority2l.first.value;
            this.priority2l.dequeue();
            this.dashboard.l2queue.setText(Integer.toString(this.priority2l.size));
            this.lamborghini_counter --;
        }else if(this.priority3l.size != 0){
            this.selected2 = this.priority3l.first.value;
            this.priority3l.dequeue();
            this.dashboard.l3queue.setText(Integer.toString(this.priority3l.size));
            this.lamborghini_counter --;
        }else{
            System.out.println("No hay carros disponibles");
        };
        return this.selected2;
    };

};
