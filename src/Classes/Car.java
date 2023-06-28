/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;

/**
 *
 * @author USER
 */
public class Car {
    
    public int id;
    public int priority;
    public int total_quality;
    public int chasis_quality;
    public int bodywork_quality;
    public int engine_quality;
    public int wheels_quality;
    public int counter;
    public String make;
    
    public Car(int id, String make){
        this.id = id;
        this.priority = priority;
        this.total_quality = total_quality;
        this.chasis_quality = chasis_quality;
        this.bodywork_quality = bodywork_quality;
        this.engine_quality = engine_quality;
        this.wheels_quality = wheels_quality;
        this.counter = counter;
        this.make = make;
    };

    public String getMake() {
        return make;
    };

    public void setMake(String make) {
        this.make = make;
    };  

    public int getId() {
        return id;
    };

    public void setId(int id) {
        this.id = id;
    };

    public int getPriority() {
        return priority;
    };

    public void setPriority(int priority) {
        this.priority = priority;
    };

    public int getTotal_quality() {
        return total_quality;
    };

    public void setTotal_quality(int total_quality) {
        this.total_quality = total_quality;
    };

    public int getChasis_quality() {
        return chasis_quality;
    };

    public void setChasis_quality(int chasis_quality) {
        this.chasis_quality = chasis_quality;
    };

    public int getBodywork_quality() {
        return bodywork_quality;
    };

    public void setBodywork_quality(int bodywork_quality) {
        this.bodywork_quality = bodywork_quality;
    };

    public int getEngine_quality() {
        return engine_quality;
    };

    public void setEngine_quality(int engine_quality) {
        this.engine_quality = engine_quality;
    };

    public int getWheels_quality() {
        return wheels_quality;
    };

    public void setWheels_quality(int wheels_quality) {
        this.wheels_quality = wheels_quality;
    };

       public int getCounter() {
        return counter;
    };

    public void setCounter(int counter) {
        this.counter = counter;
    };
    
    public void define_quality(){
        Random random = new Random();
        if(random.nextFloat() < 0.4) {
            this.setBodywork_quality(0);
            System.out.println("Carroceria 0");
        }else{
            this.setBodywork_quality(1);
            System.out.println("carroceria 1");
        };
        
        if (random.nextFloat() < 0.3) {
            this.setChasis_quality(0);
        }else{
            this.setChasis_quality(1);
        };
        
        if (random.nextFloat() < 0.5) {
            this.setEngine_quality(0);
        }else{
            this.setEngine_quality(1);
        };
        
        if(random.nextFloat() < 0.6){
            this.setWheels_quality(0);
        }else{
            this.setWheels_quality(1);
        };
        
        this.total_quality = this.bodywork_quality + this.chasis_quality 
                             + this.engine_quality + this.wheels_quality;
        System.out.println("Calidad del carro: " + Integer.toString(this.total_quality));
        this.define_priority();
    };
    
    public void define_priority(){
        if (this.total_quality <= 1) {
            this.priority = 3;
        }else if(this.total_quality <=3){
            this.priority = 2;
        }else{
            this.priority = 1;
        };
        System.out.println("Prioridad del carro " + Integer.toString(this.priority) );
    };
    
};
