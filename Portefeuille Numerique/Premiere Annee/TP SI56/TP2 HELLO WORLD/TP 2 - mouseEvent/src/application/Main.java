package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		 // définit la largeur et la hauteur de la fenêtre
        // en pixels, le (0, 0) se situe en haut à gauche de la fenêtre
          stage.setWidth(800);
        stage.setHeight(600);
        // met un titre dans la fenêtre
        stage.setTitle("Joli décor!");

        // la racine du sceneGraph est le root
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.SKYBLUE);
        // création du soleil
        Circle sun = new Circle(60, Color.web("yellow", 0.8));
        sun.setCenterX(600);
        sun.setCenterY(100);
        // création du sol
        Rectangle ground = new Rectangle(0, 400, 800, 200);
        ground.setFill(Color.GREEN);
        // création d'un élément plus complexe, le panneau
        Group sign = new Group();
        sign.setTranslateX(150);
        sign.setTranslateY(200);
        // Attention les coordonnées sont celles du panneau, pas de la scène
        Text text = new Text(10, 30, "Hello world!");
        text.setFont(new Font(80));
        text.setFill(Color.WHITE);
        // le repère utilisé est celui du panneau
        Rectangle panel = new Rectangle( 0, -50, 500, 110);
        panel.setFill(Color.DARKBLUE);
        
        // composer l'élément plus complexe
        sign.getChildren().add(panel);
        sign.getChildren().add(text);

        // ajout de tous les éléments de la scène
        root.getChildren().add(sun);
        root.getChildren().add(ground);
        root.getChildren().add(sign);

        
        
        //section liée à l'ajout d'action sur les objets


        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, handler0);
        sun.addEventHandler(MouseEvent.MOUSE_PRESSED, handler1);
        ground.addEventHandler(MouseEvent.MOUSE_PRESSED, handler2);
        sign.addEventHandler(MouseEvent.MOUSE_PRESSED, handler3);
        


        
        
        // ajout de la scène sur l'estrade
        stage.setScene(scene);
        // ouvrir le rideau
        stage.show();
		
	}
	
    public static void main(String[] args) {
    	launch(args);
    }
    EventHandler handler1 = new EventHandler<InputEvent>() {
        public void handle(InputEvent event) {
          System.out.println("SOLEIL");

          event.consume();
        }
      };
    EventHandler handler2 = new EventHandler<InputEvent>() {
          public void handle(InputEvent event) {
            System.out.println("SOL" );

            event.consume();
          }
      };
    EventHandler handler3 = new EventHandler<InputEvent>() {
          public void handle(InputEvent event) {
            System.out.println("PANEAU" );

            event.consume();
          }
        };
    EventHandler handler0 = new EventHandler<InputEvent>() {
            public void handle(InputEvent event) {

            		System.out.println("scene");

              
              event.consume();
            }
          };
      


}

