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

public class AI {
    
    public Car car1;
    public Car car2;
    public Administrator administrator;
    public Interface dashboard;
    
    public AI(Administrator administrator, Interface dashboard){
        this.car1 = car1;
        this.car2 = car2;
        this.administrator = administrator;
        this.dashboard = dashboard;
    };
    
    public void race(){
        
        Random random = new Random();
        float rand = random.nextFloat();
        
        if(rand <0.33){
            System.out.println("No se llevo a cabo la carrera.");
            dashboard.message.setText("No se llevó a cabo la carrera.");
        }else if(rand <0.6){
            System.out.println("Empate");
            dashboard.message.setText("Empate.");
        }else{
            car1 = this.administrator.select_car1();
            car2 = this.administrator.select_car2();
            
            car1.counter = car1.counter + 1;
            car2.counter = car2.counter + 1;
            
            if (car1.total_quality > car2.total_quality) {
                System.out.println("el carro 1 ha ganado");
                dashboard.message.setText("El carro 1 ha ganado.");
            }else{
                System.out.println("el carro 2 ha ganado");
                dashboard.message.setText("El carro 2 ha ganado.");
            }
        };
        
        
        
        
    }
    
}
