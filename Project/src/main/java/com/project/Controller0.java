package com.project;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class Controller0 {

    @FXML
    private Button button0, button1,button2,button3;
    @FXML
    private AnchorPane container;
    @FXML
    private Label percentatge0, percentatge1,percentatge2;
     @FXML
    private ProgressBar progres1;
    @FXML
    private ProgressBar progres2;
    @FXML
    private ProgressBar progres3;


    private ExecutorService executor = Executors.newFixedThreadPool(3); // Creem una pool de dos fils
    private Future<?> task0, task1, task2;

    @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }

    @FXML
    private void runTask() {
    
        task0 = executor.submit(() -> {
            Platform.runLater(() -> {
                    button1.setText("Aturar");
                    
                });
    
            while (!task0.isCancelled()) {
    
                // Incrementem el percentatge de la barra de progrés
                for (int i = 1; i <= 100; i++) {
                    String valor = String.valueOf( i);
                    // Incrementem el percentatge de la barra de progrés
                    progres1.setProgress(i*(0.01));
                    // Actualitzem el valor de la caixa de text
                    Platform.runLater(() -> {
                        percentatge0.setText(valor + " %");
                    });
                    // Simula un temps d'execució aleatori
                    try {
                        Thread.sleep(1000);
                        if (task0.isCancelled()) {
                    // Si està cancel·lada, posem la barra de progrés al valor actual
                    progres1.setProgress(i*(0.01));
                    break;
                }
                    } catch (InterruptedException e) {
                        // Ignorem la excepció
                    }
                }    
               executor.shutdown();
            }      
        });
    
        button1.setOnAction(event -> {
            button1.setText("Iniciar");
            task0.cancel(true);  
            
        });
        
        
    }


     


     @FXML
    private void runTask2() {
    
        task1 = executor.submit(() -> {
            Platform.runLater(() -> {
                    button2.setText("Aturar");
                    
                });
            while (!task1.isCancelled()) {
    
                // Incrementem el percentatge de la barra de progrés
                for (int i = 1; i <= 100; i++) {
                   int valor = i + (int)(Math.random()*(4-2+1)+2);
                    // Incrementem el percentatge de la barra de progrés
                    progres2.setProgress(valor*(0.01));
                    // Actualitzem el valor de la caixa de text
                    Platform.runLater(() -> {
                        percentatge1.setText(valor + " %");
                    });
                    // Simula un temps d'execució aleatori
                    try {
                        Thread.sleep((int)(Math.random()*(5-3+1)+3) * 1000);
                        if (task1.isCancelled()) {
                    // Si està cancel·lada, posem la barra de progrés al valor actual
                    progres2.setProgress(valor*(0.01));
                    break;
                }
                    } catch (InterruptedException e) {
                        // Ignorem la excepció
                    }
                }    
               executor.shutdown();
            }      
        });
    
        button2.setOnAction(event -> {
            button2.setText("Iniciar");
            task1.cancel(true);
        });
    }
       @FXML
    private void runTask3() {
    
        task2 = executor.submit(() -> {
            Platform.runLater(() -> {
                    button3.setText("Aturar");
                    
                });
    
            while (!task2.isCancelled()) {
    
                // Incrementem el percentatge de la barra de progrés
                for (int i = 1; i <= 100; i++) {
                   int valor = i + (int)(Math.random()*(6-4+1)+4);
                    // Incrementem el percentatge de la barra de progrés
                    progres3.setProgress(valor*(0.01));
                    // Actualitzem el valor de la caixa de text
                    Platform.runLater(() -> {
                        percentatge2.setText(valor + " %");
                    });
                    // Simula un temps d'execució aleatori
                    try {
                       Thread.sleep((int)(Math.random()*(8-3+1)+3) * 1000);
                        if (task2.isCancelled()) {
                    // Si està cancel·lada, posem la barra de progrés al valor actual
                    progres3.setProgress(valor*(0.01));
                    break;
                }
                    } catch (InterruptedException e) {
                        // Ignorem la excepció
                    }
                }    
               executor.shutdown();
            }      
        });
    
        button3.setOnAction(event -> {
            button3.setText("Iniciar");
            task2.cancel(true);
        });
    }

}
