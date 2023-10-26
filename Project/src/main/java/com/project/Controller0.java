package com.project;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }

    @FXML
    private void runTask() {
        button1.setDisable(true);
        backgroundTask(0);      
        button1.setText("Aturar");
    }
       @FXML
    private void runTask2() {
         
        backgroundTask(1);
        button2.setText("Aturar");
    }
       @FXML
    private void runTask3() {
        backgroundTask(2);
        button3.setText("Aturar");

    }
    

    private void backgroundTask(int index) {
        // Executar la tasca
        executor.submit(() -> {
                
                    if (index == 0) {
                        
                        for (int i = 1; i <= 100; i++) {
                            percentatge0.setText(String.valueOf(i*(0.1)));
                            progres1.setProgress(i*(0.1));
            
                            // Simula un temps d'execució aleatori
                            int temps = (int) ( 1000);
                            try {
                                Thread.sleep(temps);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    if (index == 1) {
                        for (int i = 1; i <= 100; i++) {
                            
                            progres2.setProgress((i+((int)(Math.random()*(4-2+1)+2)))*(0.1));
                            percentatge1.setText(String.valueOf((i+((int)(Math.random()*(4-2+1)+2)))));
                            // Simula un temps d'execució aleatori
                            int temps = ((int)(Math.random()*(5-3+1)+3))*(1000);
                            try {
                                Thread.sleep(temps);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (index == 2) {
                        for (int i = 1; i <= 100; i++) {
                            percentatge2.setText(String.valueOf((i+((int)(Math.random()*(6-4+1)+4)))*(0.1)));

                            progres3.setProgress((i+((int)(Math.random()*(6-4+1)+4)))*(0.1));
            
                            // Simula un temps d'execució aleatori
                            int temps = ((int)(Math.random()*(8-3+1)+3))*(1000);
                            try {
                                Thread.sleep(temps);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                
            
        });
        
    }
    
    
    // Aquesta funció la cridaries quan vulguis tancar l'executor (per exemple, quan tanquis la teva aplicació)
    public void stopExecutor() {
        executor.shutdown();
    }
    private void startProcess() {

        // Create a background Task
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                // Set the total number of steps in our process
                int steps = 100;

                // Simulate a long running task
                for (int i = 0; i < steps; i++) {

                    Thread.sleep(10); // Pause briefly
                    // Update our progress and message properties
                    updateProgress(i, steps);
                }
                return null;
            }
        };
        task.setOnFailed(wse -> {
            wse.getSource().getException().printStackTrace();
            });
            progres1.progressProperty().bind(task.progressProperty());
            
            new Thread(task).start();
        }
    }