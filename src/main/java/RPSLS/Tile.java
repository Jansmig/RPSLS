package RPSLS;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import static RPSLS.Game.TILE_SIZE;

public class Tile extends Rectangle {
/*
    1 = Rock
    2 = Paper
    3 = Scissors
    4 = Lizard
    5 = Spock
*/

    private int item;


    public Tile(int x, int y, int width, int height) {
        super(x, y, width, height);
        setStroke(Color.BLACK);
        setHeight(TILE_SIZE);
        setWidth(TILE_SIZE);
        setFill(Color.DARKSLATEGRAY);
    }

    public void tileReset(Tile tile) {
        setFill(Color.DARKSLATEGRAY);
    }

    public static void setRock(Tile tile) {
        Image rockImage = new Image("images/rock.jpg");
        ImagePattern rockPattern = new ImagePattern(rockImage);
        tile.setFill(rockPattern);
        tile.item = 1;
    }

    public static void setPaper(Tile tile) {
        tile.item = 2;
        Image paperImage = new Image("images/paper.jpg");
        ImagePattern paperPattern = new ImagePattern(paperImage);
        tile.setFill(paperPattern);
    }

    public static void setScissors(Tile tile) {
        tile.item = 3;
        Image scissorsImage = new Image("images/scissors.jpg");
        ImagePattern scissorsPattern = new ImagePattern(scissorsImage);
        tile.setFill(scissorsPattern);
    }

    public static void setLizard(Tile tile) {
        tile.item = 4;
        Image lizardImage = new Image("images/lizard.jpg");
        ImagePattern lizardPattern = new ImagePattern(lizardImage);
        tile.setFill(lizardPattern);
    }

    public static void setSpock(Tile tile) {
        tile.item = 5;
        Image spockImage = new Image("images/spock.jpg");
        ImagePattern spockPattern = new ImagePattern(spockImage);
        tile.setFill(spockPattern);
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public static void computerMove(Tile tile) {
        int randomInt = 0;
        Random randomizer = new Random();
        randomInt = randomizer.nextInt(5) + 1;
        if (randomInt == 1) {
            setRock(tile);
        } if (randomInt == 2) {
            setPaper(tile);
        } if (randomInt == 3) {
            setScissors(tile);
        } if (randomInt == 4) {
            setLizard(tile);
        } if (randomInt == 5) {
            setSpock(tile);
        }
    }





}
