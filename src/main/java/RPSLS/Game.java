package RPSLS;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Scanner;

import static RPSLS.Tile.*;

public class Game extends Application {

    public static int TILE_SIZE = 150;
    public static int cVictoryCounter = 0;
    public static int pVictoryCounter = 0;
    public static String textToDisplay = "";
    public static Text notification = new Text("" + textToDisplay);
    public static GridPane gameboard = new GridPane();
    public static String pName = "";
    public static int victoriesLimit;
    public static Text cScore = new Text("" + cVictoryCounter);
    public static Text pScore = new Text("" + pVictoryCounter);


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

    public static void checkRockEffect (Tile pTile, Tile cTile) {
        if (pTile.getItem() == 1 && cTile.getItem() == 3 || cTile.getItem() == 4) {
            textToDisplay = pName + " wins!";
            pVictoryCounter++;
        } else if (pTile.getItem() == 1 && cTile.getItem() == 2 || cTile.getItem() == 5) {
            textToDisplay = "Computer wins!";
            cVictoryCounter++;
        } else {
            textToDisplay = "Draw!";
        }
    }

    public static void checkPaperEffect (Tile pTile, Tile cTile) {
        if (pTile.getItem() == 2 && cTile.getItem() == 5 || cTile.getItem() == 1) {
            textToDisplay = pName + " wins!";
            pVictoryCounter++;
        } else if (pTile.getItem() == 2 && cTile.getItem() == 3 || cTile.getItem() == 4) {
            textToDisplay = "Computer wins!";
            cVictoryCounter++;
        } else {
            textToDisplay = "Draw!";
        }
    }

    public static void checkScissorsEffect (Tile pTile, Tile cTile) {
        if (pTile.getItem() == 3 && cTile.getItem() == 2 || cTile.getItem() == 4) {
            textToDisplay = pName + " wins!";
            pVictoryCounter++;
        } else if (pTile.getItem() == 3 && cTile.getItem() == 1 || cTile.getItem() == 5) {
            textToDisplay = "Computer wins!";
            cVictoryCounter++;
        } else {
            textToDisplay = "Draw!";
        }
    }

    public static void checkLizardEffect (Tile pTile, Tile cTile) {
        if (pTile.getItem() == 4 && cTile.getItem() == 2 || cTile.getItem() == 5) {
            textToDisplay = pName + " wins!";
            pVictoryCounter++;
        } else if (pTile.getItem() == 4 && cTile.getItem() == 1 || cTile.getItem() == 3) {
            textToDisplay = "Computer wins!";
            cVictoryCounter++;
        } else {
            textToDisplay = "Draw!";
        }
    }

    public static void checkSpockEffect (Tile pTile, Tile cTile) {
        if (pTile.getItem() == 5 && cTile.getItem() == 1 || cTile.getItem() == 3) {
            textToDisplay = pName + " wins!";
            pVictoryCounter++;
        } else if (pTile.getItem() == 5 && cTile.getItem() == 2 || cTile.getItem() == 4) {
            textToDisplay = "Computer wins!";
            cVictoryCounter++;
        } else {
            textToDisplay = "Draw!";
        }
    }

    public static void updateScores() {
        cScore.setText("" + cVictoryCounter);
        pScore.setText("" + pVictoryCounter);
    }

    public static void updateNotifications() {
        notification.setText(textToDisplay);
    }

    public static void checkWinner() {
        if (pVictoryCounter == victoriesLimit || cVictoryCounter == victoriesLimit) {
            if (pVictoryCounter > cVictoryCounter) {
                textToDisplay = pName + " has won!!!";
                notification.setText(textToDisplay);
                gameboard.getChildren().remove(0);
                gameboard.getChildren().remove(1);
            } else {
                textToDisplay = "Computer has won!!!";
                notification.setText(textToDisplay);
                gameboard.getChildren().remove(0);
                gameboard.getChildren().remove(1);
            }
        }
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


        gameboard = newGame();

        Scene scene = new Scene(gameboard, TILE_SIZE * 3, TILE_SIZE * 6, Color.DARKSLATEGREY);

        primaryStage.setTitle("Rock Paper Scissors Lizard Spock");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Computer's tile
        Tile computerTile = new Tile(1, 0, 1, 1);
        gameboard.add(computerTile, (int) computerTile.getX(), (int) computerTile.getY());

        //Instructions tile
        Tile instructionTile = new Tile(1, 1, 1, 1);
        gameboard.add(instructionTile, (int) instructionTile.getX(), (int) instructionTile.getY());
        Image instructionsImage = new Image("images/instrukcja.png");
        ImagePattern instructionsPattern = new ImagePattern(instructionsImage);
        instructionTile.setFill(instructionsPattern);

        //Player's tile
        Tile playerTile = new Tile(1, 2, 1, 1);
        playerTile.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.DIGIT1) {
                    setRock(playerTile);
                    computerMove(computerTile);
                    checkRockEffect(playerTile, computerTile);
                    updateScores();
                    updateNotifications();
                    checkWinner();
                } if (e.getCode() == KeyCode.DIGIT2) {
                    setPaper(playerTile);
                    computerMove(computerTile);
                    checkPaperEffect(playerTile, computerTile);
                    updateScores();
                    updateNotifications();
                    checkWinner();
                } if (e.getCode() == KeyCode.DIGIT3) {
                    setScissors(playerTile);
                    computerMove(computerTile);
                    checkScissorsEffect(playerTile, computerTile);
                    updateScores();
                    updateNotifications();
                    checkWinner();
                } if (e.getCode() == KeyCode.DIGIT4) {
                    setLizard(playerTile);
                    computerMove(computerTile);
                    checkLizardEffect(playerTile, computerTile);
                    updateScores();
                    updateNotifications();
                    checkWinner();
                } if (e.getCode() == KeyCode.DIGIT5) {
                    setSpock(playerTile);
                    computerMove(computerTile);
                    checkSpockEffect(playerTile, computerTile);
                    updateScores();
                    updateNotifications();
                    checkWinner();
                }
            }
        });

        gameboard.add(playerTile, (int) playerTile.getX(), (int) playerTile.getY());
        playerTile.requestFocus();


        Text cSign = new Text("Computer:");
        cSign.setFont(Font.font("Broadway", FontWeight.BOLD, 22));
        GridPane.setHalignment(cSign, HPos.CENTER);
        GridPane.setValignment(cSign, VPos.CENTER);
        cSign.setFill(Color.BLACK);
        gameboard.add(cSign, 0, 0);

        cScore.setFont(Font.font("Broadway", FontWeight.BOLD, 34));
        GridPane.setHalignment(cScore, HPos.CENTER);
        GridPane.setValignment(cScore, VPos.CENTER);
        cScore.setFill(Color.BLACK);
        gameboard.add(cScore, 2, 0);

        Text pSign = new Text(pName + ":");
        pSign.setFont(Font.font("Broadway", FontWeight.BOLD, 22));
        GridPane.setHalignment(pSign, HPos.CENTER);
        GridPane.setValignment(pSign, VPos.CENTER);
        pSign.setFill(Color.WHITE);
        gameboard.add(pSign, 0, 2);

        pScore.setFont(Font.font("Broadway", FontWeight.BOLD, 34));
        GridPane.setHalignment(pScore, HPos.CENTER);
        GridPane.setValignment(pScore, VPos.CENTER);
        pScore.setFill(Color.WHITE);
        gameboard.add(pScore, 2, 2);

        Text instructions = new Text("Controls: \n1 - Rock \n2 - Paper \n3 - Scissors \n4 - Lizard \n5 - Spock \nx - exit \nn - restart");
        instructions.setFont(Font.font("Broadway", FontWeight.BOLD, 26));
        GridPane.setHalignment(instructions, HPos.CENTER);
        GridPane.setValignment(instructions, VPos.TOP);
        instructions.setFill(Color.WHITE);
        gameboard.add(instructions, 1, 4);

        notification.setFont(Font.font("Broadway", FontWeight.BOLD, 26));
        GridPane.setHalignment(pScore, HPos.CENTER);
        GridPane.setValignment(pScore, VPos.CENTER);
        notification.setFill(Color.WHITE);
        gameboard.add(notification, 1, 3);

    }


    public static void main(String[] args) {
        launch(args);
    }


}
