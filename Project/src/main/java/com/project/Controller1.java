package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Controller1  implements initialize{
   

    @FXML
    private AnchorPane container;
   @FXML
    private Button button0, button1,button11;

    @FXML
    private ImageView imageView ;
   
     @FXML
    private ProgressBar progres1;
   @FXML
    private final List<LoadImage> loadImages = new ArrayList<>();

    @FXML
    public void initialize() {
        start();
        
    }

 @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View0");
    }

   
    private void start() {
        

        button1.setOnAction(event -> {
            loadImages.clear();
            progres1.setProgress(0);

            for (int i = 0; i < 24; i++) {
                loadImages.add(new LoadImage(System.getProperty("user.dir")+"\\src\\main\\resources\\assets\\image" + i + ".png"));
            }
            System.out.println(loadImages.size());
            loadImages.forEach(loadImage -> {
                loadImage.load().thenAccept(image -> {
                    imageView.setImage(image);
                    progres1.setProgress(progres1.getProgress() + 1.0 / 24);
                });
            });
        });

        button11.setOnAction(event -> {
            loadImages.forEach(loadImage -> loadImage.cancel(true));
        });
       
        
    }

   

    public class LoadImage {

    private final String path;

    public LoadImage(String path) {
        this.path = path;
    }

    public Object cancel(boolean b) {
        return null;
    }

    public CompletableFuture<Image> load() {
        return CompletableFuture.supplyAsync(() -> {
            int time = (int) (Math.random() * 45 + 5);
            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Image(getClass().getResourceAsStream(path).toString());
        });
    }
}
    
}