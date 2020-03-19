package RPSLS;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

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

    public void setRock(Tile tile) {
        this.item = 1;
        Image rockImage = new Image("images/rock.jpg");
        ImagePattern rockPattern = new ImagePattern(rockImage);
        tile.setFill(rockPattern);
    }

    public void setPaper(Tile tile) {
        this.item = 2;
        Image paperImage = new Image("images/paper.jpg");
        ImagePattern paperPattern = new ImagePattern(paperImage);
        tile.setFill(paperPattern);
    }

    public void setScissors(Tile tile) {
        this.item = 3;
        Image scissorsImage = new Image("images/scissors.jpg");
        ImagePattern scissorsPattern = new ImagePattern(scissorsImage);
        tile.setFill(scissorsPattern);
    }

    public void setLizard(Tile tile) {
        this.item = 4;
        Image lizardImage = new Image("images/lizard.jpg");
        ImagePattern lizardPattern = new ImagePattern(lizardImage);
        tile.setFill(lizardPattern);
    }

    public void setSpock(Tile tile) {
        this.item = 5;
        Image spockImage = new Image("images/spock.jpg");
        ImagePattern spockPattern = new ImagePattern(spockImage);
        tile.setFill(spockPattern);
    }



}
