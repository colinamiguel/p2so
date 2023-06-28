/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Interfaz.Interface;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
//        Queue bugatti_reinforcent_queue, Queue lamborghini_reinforcement_queue, 
//        Queue priority1b, Queue priority2b, Queue priority3b,
//        Queue priority1l, Queue priority2l, Queue priority3l

        Interface dashboard = new Interface();
        dashboard.setVisible(true);
                
        Queue bugatti_reinforcent_queue = new Queue();
        Queue lamborghini_reinforcement_queue = new Queue();
        Queue priority1b = new Queue();
        Queue priority2b = new Queue();
        Queue priority3b = new Queue();
        Queue priority1l = new Queue();
        Queue priority2l = new Queue();
        Queue priority3l = new Queue();
        
        Administrator administrator = new Administrator(bugatti_reinforcent_queue, lamborghini_reinforcement_queue,
                                          priority1b, priority2b, priority3b, priority1l, priority2l, priority3l,
                                          dashboard);
        AI ai = new AI(administrator, dashboard);
        for(int i = 1; i <= 5; i++){
           administrator.create_car(i, "Lamborghini");
           administrator.create_car(i, "Bugatti");
        };
        
        while(true){
            
            if (administrator.bugatti_counter >=1 && administrator.lamborghini_counter >=1) {
                System.out.println("*****Comienza la carrera*****");
                //dashboard.message.setText("Comenzando la Carrera.");
                System.out.println("Calculando los resultados");
                dashboard.aistatus.setText("Calculando Resultados.");
                try {
                    Thread.sleep(10000);
                    dashboard.aistatus.setText("Esperando por el Administrador.");
                    dashboard.message.setText("Esperando la Próxima Carrera.");
                    ai.race();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                };
                
            }else{
                System.out.println("No hay carros disponibles para competir.");
                dashboard.aistatus.setText("Esperando por el Administrador.");
                dashboard.message.setText("No hay carros Disponibles para Competir.");
            };
        }
        
    };
    
};
