package RPSLS;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game extends Application {

    public static int TILE_SIZE = 150;
    public static int cVictoryCounter = 0;
    public static int pVictoryCounter = 0;
    public static String textToDisplay = "Select the game mode";
    public static Text notification = new Text("" + textToDisplay);
    public static GridPane gameboard = new GridPane();
    public static String pName = "";
    public static int victoriesLimit;


    public static GridPane newGame() {
        GridPane root = new GridPane();
        root.setPrefSize(TILE_SIZE * 3, TILE_SIZE * 6);
        root.setStyle("-fx-background-color: linear-gradient(#4640c2, rgba(63,234,106,0.84))");

        for (int i = 0; i < 3; i++) {
            ColumnConstraints col = new ColumnConstraints(TILE_SIZE);
            root.getColumnConstraints().add(col);
        }
        for (int j = 0; j < 6; j++) {
            RowConstraints row = new RowConstraints(TILE_SIZE);
            root.getRowConstraints().add(row);
        }
        return root;
    }



    @Override
    public void start(Stage primaryStage) throws Exception {

        // Max letters = 10
        System.out.println("Please provide your name in the console and hit enter.");
        while (pName.length() < 1 || pName.length() > 10) {
            Scanner nameScanner = new Scanner(System.in);
            pName = nameScanner.nextLine();
            if (pName.length() < 1 || pName.length() > 10) {
                System.out.println("Selected name was too long, please try something under 11 characters.");
            }
        }

        System.out.println("Please provide the number of victories ranging from 1 to 100 required to finish the game and hit enter.");
        while (victoriesLimit < 1 || victoriesLimit > 100) {
            try {
                Scanner victoriesScanner = new Scanner(System.in);
                victoriesLimit = victoriesScanner.nextInt();
                if (victoriesLimit < 1 || victoriesLimit > 100) {
                    System.out.println("Incorrect number of rounds. Please select number of rounds between 1 and 100.");
                }

            } catch (RuntimeException ex) {
                System.out.println("Incorrect input type. Please provide WHOLE number ranging from 1 to 100.");
            }
        }

        // assure integer


        gameboard = newGame();

        Scene scene = new Scene(gameboard, TILE_SIZE * 3, TILE_SIZE * 6, Color.DARKSLATEGREY);

        primaryStage.setTitle("Rock Paper Scissors Lizard Spock");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Computer's tile
        Tile tile10 = new Tile(1,0,1,1);
        gameboard.add(tile10, (int) tile10.getX(), (int) tile10.getY());

        //Instructions tile
        Tile tile11 = new Tile(1,1,1,1);
        gameboard.add(tile11, (int) tile11.getX(), (int) tile11.getY());
        Image instructionsImage = new Image("images/instrukcja.png");
        ImagePattern instructionsPattern = new ImagePattern(instructionsImage);
        tile11.setFill(instructionsPattern);

        //Player's tile
        Tile tile12 = new Tile(1,2,1,1);
        gameboard.add(tile12, (int) tile12.getX(), (int) tile12.getY());

        Text cSign = new Text("Computer:");
        cSign.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 24));
        GridPane.setHalignment(cSign, HPos.CENTER);
        GridPane.setValignment(cSign, VPos.CENTER);
        cSign.setFill(Color.BLACK);
        gameboard.add(cSign, 0, 0);

        Text cScore = new Text("" + cVictoryCounter);
        cScore.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 34));
        GridPane.setHalignment(cScore, HPos.CENTER);
        GridPane.setValignment(cScore, VPos.CENTER);
        cScore.setFill(Color.BLACK);
        gameboard.add(cScore, 2, 0);

        Text pSign = new Text(pName + ":");
        pSign.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 24));
        GridPane.setHalignment(pSign, HPos.CENTER);
        GridPane.setValignment(pSign, VPos.CENTER);
        pSign.setFill(Color.WHITE);
        gameboard.add(pSign, 0, 2);

        Text pScore = new Text("" + pVictoryCounter);
        pScore.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 34));
        GridPane.setHalignment(pScore, HPos.CENTER);
        GridPane.setValignment(pScore, VPos.CENTER);
        pScore.setFill(Color.WHITE);
        gameboard.add(pScore, 2, 2);

        Text instructions = new Text("Controls: \n1 - Rock \n2 - Paper \n3 - Scissors \n4 - Lizard \n5 - Spock \nx - exit \nn - restart");
        instructions.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 28));
        GridPane.setHalignment(instructions, HPos.CENTER);
        GridPane.setValignment(instructions, VPos.CENTER);
        instructions.setFill(Color.WHITE);
        gameboard.add(instructions, 1, 4);
        

    }




    public static void main(String[] args) {
        launch(args);
    }

}
