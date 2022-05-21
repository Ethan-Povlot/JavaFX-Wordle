import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Jordle.java is a  fun version of wordle in only javaFx for the Gui.
 * @author ethan Povlot
 * @version 1.1247979
 */
public class Jordle extends Application {
    private Random randomize = new Random();
    private boolean chkWords = false;
    private String word = Words.list.get(randomize.nextInt(Words.list.size()));
    /**
     * This is the backend of the program which determies which squares should be what color.
     * @param in User input.
     * @param word random word that is being guessed.
     * @param chkWords boolean for weather the word input must be real.
     * @return colors for the letters to be changed to.
     * @throws NullPointerException error used to move info if something was wrong with the input.
     * @throws OutOfMemoryError  error used to move info if something was wrong with the input.
     */
    public static Color[] backend(String in, String word, boolean chkWords)
        throws NullPointerException, OutOfMemoryError {
        if (in.length() != 5) {
            throw new NullPointerException();
        }
        if (chkWords) {
            if (!(Words.list.contains(in))) {
                throw new OutOfMemoryError();
            }
        }
        in = in.toLowerCase();
        String yellow = new String(word);
        Color[] out = new Color[in.length()];
        String[] ins = in.split("(?!^)");
        String[] words = word.split("(?!^)");

        for (int i = 0; i < in.length(); i++) {
            if (ins[i].equals("")) {
                out[i] = Color.TRANSPARENT;
            } else if (ins[i].equals(words[i])) {
                out[i] = Color.GREEN;
                yellow = yellow.replaceFirst(ins[i], "%");
            } else {
                out[i] = Color.GREY;
            }
        }
        for (int i = 0; i < in.length(); i++) {
            if (ins[i].equals("")) {
                out[i] = Color.TRANSPARENT;
            } else if (yellow.contains(ins[i]) && out[i] != Color.GREEN) {
                out[i] = Color.YELLOW;
                yellow = yellow.replaceFirst(ins[i], "%");
            }
        }
        return out;
    }
    /**
     *  Changes the color of boxes based on backend output.
     * @param colors array of colors as output from backend.
     * @param boxes boxes that are to be altered.
     */
    public static void changeColor(Color[] colors, Rectangle[]  boxes) {
        int i = 0;
        while (i < 5) {
            boxes[i].setFill(colors[i]);
            i++;
        }
    }
    /**
     * Checks if the user has won on this enter.
     * @param backend colors from the backend to check if the user won.
     * @return boolena for weather or not the user won.
     */
    public boolean winCheck(Color[] backend) {
        for (int i = 0; i < backend.length; i++) {
            if (backend[i] != Color.GREEN) {
                return false;
            }
        }
        return true;
    }
    /**
     * returs the right list of rectangles based on the input string.
     * @param str words that the user has written so far.
     * @param rect rectangle input, all avaliable rectangle.
     * @return rectangles that are to have their colors changed.
     */
    public static Rectangle[] retLst(String str, Rectangle[] rect) {
        if (str.length() == 5) {
            return new Rectangle[] {rect[0], rect[1], rect[2], rect[3], rect[4]};
        } else if (str.length() == 11) {
            return new Rectangle[] {rect[5], rect[6], rect[7], rect[8], rect[9]};
        } else if (str.length() == 17) {
            return new Rectangle[] {rect[10], rect[11], rect[12], rect[13], rect[14]};
        } else if (str.length() == 23) {
            return new Rectangle[] {rect[15], rect[16], rect[17], rect[18], rect[19]};
        } else if (str.length() == 29) {
            return new Rectangle[] {rect[20], rect[21], rect[22], rect[23], rect[24]};
        } else if (str.length() == 35) {
            return new Rectangle[] {rect[25], rect[26], rect[27], rect[28], rect[29]};
        }
        return rect;
    }
    /**
     * Basic function to remove last char of str if not null.
     * @param str string to have last char removed from/
     * @return str after the last char is removed.
     */
    public static String backSpace(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * Method to create all the rectangle for the program.
     * @return rectangle array with all the rectangles in it.
     */
    public static Rectangle[] makeRectangle() {
        Rectangle rect0 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect1 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect2 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect3 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect4 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect5 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect6 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect7 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect8 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect9 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect10 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect11 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect12 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect13 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect14 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect15 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect16 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect17 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect18 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect19 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect20 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect21 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect22 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect23 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect24 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect25 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect26 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect27 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect28 = new Rectangle(0, 0, 42.5, 80);
        Rectangle rect29 = new Rectangle(0, 0, 42.5, 80);
        Rectangle[] rects = new Rectangle[] {rect0, rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8,
            rect9, rect10, rect11, rect12, rect13, rect14, rect15, rect16, rect17, rect18, rect19, rect20,
            rect21, rect22, rect23, rect24, rect25, rect26, rect27, rect28, rect29};
        return rects;
    }
    /**
     * Makes the spacing for the boxes and puts them in the right order.
     * @param boxes all the HBoxes that are used to make the lines.
     * @param rect all the rectables that will be colored.
     * @return HBoxes with the right spacing and children.
     */
    public static HBox[] makeBox(HBox[] boxes, Rectangle[] rect) {
        boxes[0].setSpacing(0);
        boxes[0].getChildren().addAll(rect[0], rect[1], rect[2], rect[3], rect[4]);
        boxes[1].setSpacing(0);
        boxes[1].getChildren().addAll(rect[5], rect[6], rect[7], rect[8], rect[9]);
        boxes[2].setSpacing(0);
        boxes[2].getChildren().addAll(rect[10], rect[11], rect[12], rect[13], rect[14]);
        boxes[3].setSpacing(0);
        boxes[3].getChildren().addAll(rect[15], rect[16], rect[17], rect[18], rect[19]);
        boxes[4].setSpacing(0);
        boxes[4].getChildren().addAll(rect[20], rect[21], rect[22], rect[23], rect[24]);
        boxes[5].setSpacing(0);
        boxes[5].getChildren().addAll(rect[25], rect[26], rect[27], rect[28], rect[29]);
        return boxes;

    }
    /**
     * Main start method for Jordle.
     * @param primaryStage main stage of the game.
     */
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text(20, 20, "");
        Text text3 = new Text(20, 20, "Leaderboard:\n");
        Text jordle = new Text(120, 120, "JORDLE");
        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 50);
        jordle.setFont(font);
        text.setFont(Font.font(java.awt.Font.MONOSPACED, 74));
        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(text);
        vbox2.setAlignment(Pos.TOP_LEFT);
        Rectangle[] rects = makeRectangle();
        for (int i = 0; i < rects.length; i++) {
            rects[i].setStroke(Color.BLACK);
            rects[i].setFill(Color.TRANSPARENT);
            rects[i].setStrokeWidth(2.5);
        }
        HBox box1 = new HBox(5);
        HBox box2 = new HBox(5);
        HBox box3 = new HBox(5);
        HBox box4 = new HBox(5);
        HBox box5 = new HBox(5);
        HBox box6 = new HBox(5);
        HBox[] boxes = new HBox[] {box1, box2, box3, box4, box5, box6};
        boxes = makeBox(boxes, rects);
        Text text2 = new Text(20, 20, "Try guessing a word!");
        VBox boxMain = new VBox();
        boxMain.getChildren().addAll(boxes[0], boxes[1], boxes[2], boxes[3], boxes[4], boxes[5]);
        Button btn1 = new Button("Reset Game");
        Alert instructrions = new Alert(AlertType.NONE,
                              "Instructions for the game\nplease enter a 5 letter word, then press enter, then you will"
                                 + " see what colors are around the letters, if a letter is green then the letter is "
                                 + "in the right place\nIf a the color is yellow then the letter is in the word but in "
                                 + "the wrong place, grey means that the letter is not in the word.", ButtonType.OK);
        Button btn2 = new Button("Do You Need Instructions?");
        Button btn3 = new Button("Check for real words in Word List");
        btn1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                text.setText("");
                for (int i = 0; i < 30; i++) {
                    rects[i].setFill(Color.TRANSPARENT);
                }
                word = Words.list.get(new Random().nextInt(Words.list.size()));
                text2.setText("Try guessing a word!");
                text.requestFocus();
            }
        });
        btn2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                instructrions.show();
                text.requestFocus();
            }
        });
        btn3.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (chkWords) {
                    chkWords = false;
                    btn3.setText("Valid word check disabled");
                } else {
                    chkWords = true;
                    btn3.setText("Valid word check enabled");
                }
                text.requestFocus();
            }
        });
        Alert tooShort = new Alert(AlertType.NONE, "You must have all 5 letters full", ButtonType.OK);
        Alert winAlert = new Alert(AlertType.NONE, "You won Congrats", ButtonType.OK);
        Alert intro = new Alert(AlertType.NONE,
                              "Welcome to Jordle, please have fun by finding the mystery word!", ButtonType.OK);
        Alert gmeOvr = new Alert(AlertType.NONE,
                              "Unfortunantly you lost, please press reset to play again", ButtonType.OK);
        Alert notWord = new Alert(AlertType.NONE, "Based on your choices you must have a real word that is a posible"
                              + " solution based in the words in Words.java", ButtonType.OK);
        text.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
            case ENTER:
                try {
                    if (text.getText().replaceAll("[^a-zA-Z0-9_-]", "").length() % 5 == 0
                        && text.getText().substring(text.getText().length() - 1).
                        replaceAll("[^a-zA-Z0-9_-]", "").length() != 0) {
                        changeColor(backend(text.getText().substring(text.getText().length() - 5), word, chkWords),
                            retLst(text.getText(), rects));
                        if (winCheck(backend(text.getText().substring(text.getText().length() - 5), word, chkWords))) {
                            winAlert.showAndWait();
                            text2.setText("Congratulations! You've guessed the word!");
                            text3.setText(text3.getText()
                                + (text.getText().replaceAll("[^a-zA-Z0-9_-]", "").length() / 5 + " attempts\n"));
                            btn1.requestFocus();
                        } else if (text.getText().replaceAll("[^a-zA-Z0-9_-]", "").length() >= 29) {
                            text2.setText("Game over. The word was " + word + ".");
                            gmeOvr.show();
                        }
                        if (text.getText().replaceAll("[^a-zA-Z0-9_-]", "").length() < 30) {
                            text.setText(text.getText() + e.getText());
                        }
                    } else {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException f) {
                    tooShort.show();
                } catch (OutOfMemoryError g) {
                    notWord.show();
                }
                break;
            case BACK_SPACE:
                if (text.getText().length() % 6 != 0 || text.getText().length() == 0) {
                    text.setText(backSpace(text.getText()));
                }
                break;
            default:
                if (e.getText().matches("[a-zA-Z]+") && (text.getText().length() != 5 && text.getText().length() != 11
                    && text.getText().length() != 17 && text.getText().length() != 23 && text.getText().length() != 29
                    && text.getText().length() != 35 && text.getText().length() < 35)) {
                    text.setText(text.getText() + e.getText());
                }
            }
        });
        GridPane box = new GridPane();
        box.setPadding(new Insets(50, 50, 50, 50));
        box.add(btn1, 0, 7);
        box.add(btn2, 0, 5);
        box.add(btn3, 0, 6);
        box.add(text2, 0, 4);
        box.add(text3, 4, 4);
        box.add(boxMain, 0, 1);
        box.add(vbox2, 0, 1);
        box.add(jordle, 0, 0);
        Scene scene = new Scene(box);
        primaryStage.setTitle("Wordle Beta :)");
        primaryStage.setScene(scene);
        primaryStage.show();
        intro.show();
        text.requestFocus();
    }
}