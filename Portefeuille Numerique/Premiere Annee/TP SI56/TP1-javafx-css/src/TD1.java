import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import ajout√©s pour le TextField, son Label et GridPane
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public class TD1 extends Application {
    
	String a="---- En attente ----";
	
	@Override
    public void start(Stage primaryStage) {
		TextField notification = new TextField ("");

		Label label = new Label(a);
		label.setId("label");


        Button btn = new Button();
        btn.setText("Minuscule");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
        		a=notification.getText();
        		a=a.toLowerCase();
        		label.setText(a);
            }
        });
        
        Button btn1 = new Button();
        btn1.setText("Majuscule");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
        		a=notification.getText();
        		a=a.toUpperCase();
        		label.setText(a);
            }
        });
        
        
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        //grid.setGridLinesVisible(true);//Voir les lignes et les colones
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setAlignment(Pos.CENTER);
            
        //lignes et colonnes
        HBox hbox = new HBox(8);
        hbox.getChildren().add(btn);
        hbox.setAlignment(Pos.CENTER);
        HBox hbox1 = new HBox(8); 
        hbox1.getChildren().add(btn1);
        hbox1.setAlignment(Pos.CENTER);
        
        VBox vbox = new VBox(8);
        vbox.getChildren().add(grid);
        vbox.getChildren().add(label);
        vbox.setAlignment(Pos.CENTER);
        
        grid.add(new Label("Texte ‡† modifier : "), 0, 0);
        grid.add(notification, 1, 0);
        grid.add(hbox,0,1);
        grid.add(hbox1,1,1);
        

        // Fin de la section
        
        // Creation de la scene   
        StackPane root = new StackPane();
        root.getChildren().add(vbox);
        //root.getChildren().add(label);
        ;
        
        Scene scene = new Scene(root, 500, 300, Color.SKYBLUE);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("TD1");
        primaryStage.setScene(scene);
        primaryStage.show();
        

        
    }

 

    public static void main(String[] args) {
        launch(args);
    }

}
     

