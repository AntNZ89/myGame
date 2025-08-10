import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyGame extends JFrame {
    // start attributes
    private static JButton jButton1 = new JButton();
    int gameField[][] = initialize();


    int x2 = 0;
    int y2 = 10;
    int posX = 0;
    int posY = 0;

    private static JButton bLEFT = new JButton();
    private static JButton bRIGHT = new JButton();
    private static JButton bDOWN = new JButton();
    private static JButton bUP = new JButton();
    private static JLabel lYOUHAVELOST = new JLabel();
    // end attributes

    public MyGame() {
        // Frame init
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 316;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("MyGame");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // start components

        jButton1.setBounds(88, 64, 104, 32);
        jButton1.setFont(new Font("Dialog", Font.BOLD, 11));
        jButton1.setText("Button");
        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1_ActionPerformed(evt);
            }
        });
        cp.add(jButton1);
        bLEFT.setBounds(8, 200, 80, 24);
        bLEFT.setFont(new Font("Dialog", Font.BOLD, 11));
        bLEFT.setText("LEFT");
        bLEFT.setMargin(new Insets(2, 2, 2, 2));
        bLEFT.addActionListener(new ActionListener() { ;
            public void actionPerformed(ActionEvent evt) {
                bLEFT_ActionPerformed(evt);
            }
        });
        cp.add(bLEFT);
        bRIGHT.setBounds(192, 200, 80, 24);
        bRIGHT.setFont(new Font("Dialog", Font.BOLD, 11));
        bRIGHT.setText("RIGHT");
        bRIGHT.setMargin(new Insets(2, 2, 2, 2));
        bRIGHT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bRIGHT_ActionPerformed(evt);
            }
        });
        cp.add(bRIGHT);
        bDOWN.setBounds(96, 200, 88, 24);
        bDOWN.setFont(new Font("Dialog", Font.BOLD, 11));
        bDOWN.setText("DOWN");
        bDOWN.setMargin(new Insets(2, 2, 2, 2));
        bDOWN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDOWN_ActionPerformed(evt);
            }
        });
        cp.add(bDOWN);
        bUP.setBounds(96, 168, 88, 24);
        bUP.setFont(new Font("Dialog", Font.BOLD, 11));
        bUP.setText("UP");
        bUP.setMargin(new Insets(2, 2, 2, 2));
        bUP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bUP_ActionPerformed(evt);
            }
        });
        cp.add(bUP);
        lYOUHAVELOST.setBounds(32, 72, 308, 88);
        lYOUHAVELOST.setText("YOU HAVE LOST!");
        lYOUHAVELOST.setFont(new Font("Dialog", Font.BOLD, 27));
        lYOUHAVELOST.setVisible(false);
        cp.add(lYOUHAVELOST);
        // end components

        setVisible(true);

    } // end of public MyGame

    // start methods

    public static void main(String[] args) {
        new MyGame();
    } // end of main

    public void jButton1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here
        gameField[posY][posX] = 1;
        gameField[y2][x2] = 9;
        printGameField(gameField);

    } // end of jButton1_ActionPerformed

    public void bLEFT_ActionPerformed(ActionEvent evt) {
        // TODO add your code here
        gameField[posY][posX] = 0;
        if (posX > 0){
            posX -= 1;
        }
        gameField[posY][posX] = 1;

        gameField[y2][x2] = 0;
        if (x2 > 0){
            x2--;
        }
        gameField[y2][x2] = 9;

        printGameField(gameField);

        if (y2 == posY && x2 == posX){
            System.out.println("You have lost!");
            setObjectsVisible();
        }

    } // end of bLEFT_ActionPerformed

    public void bRIGHT_ActionPerformed(ActionEvent evt) {
        // TODO add your code her
        gameField[posY][posX] = 0;
        if (posX < 9) {
            posX += 1;
        }
        gameField[posY][posX] = 1;

        gameField[y2][x2] = 0;
        if (x2 < 9){
            x2++;
        }
        gameField[y2][x2] = 9;

        printGameField(gameField);

        if (y2 == posY && x2 == posX){
            System.out.println("You have lost!");
            setObjectsVisible();
        }

    } // end of bRIGHT_ActionPerformed

    public void bDOWN_ActionPerformed(ActionEvent evt) {
        // TODO add your code here
        gameField[posY][posX] = 0;
        if (posY < 9){
            posY += 1;
        }
        gameField[posY][posX] = 1;

        gameField[y2][x2] = 0;
        if (y2 > 0){
            y2--;
        }
        gameField[y2][x2] = 9;


        printGameField(gameField);

        if (y2 == posY && x2 == posX){
            System.out.println("You have lost!");
            setObjectsVisible();
        }

    } // end of bDOWN_ActionPerformed

    public void bUP_ActionPerformed(ActionEvent evt) {
        // TODO add your code here
        gameField[posY][posX] = 0;
        if (posY > 0){
            posY -= 1;
        }
        gameField[posY][posX] = 1;

        gameField[y2][x2] = 0;
        if (y2 < 9){
            y2++;
        }
        gameField[y2][x2] = 9;

        printGameField(gameField);

        if (y2 == posY && x2 == posX){
            System.out.println("You have lost!");
            setObjectsVisible();
        }

    } // end of bUP_ActionPerformed


    public static int[][] initialize(){

        int myArray[][] = new int[11][11];

        for (int c = 0; c < 10 ; c++) {
            for (int r = 0; r < 10 ; r++) {

                myArray[c][r] = 0;

            } // end of for
        } // end of for


        return myArray;

    }

    public static void setObjectsVisible(){
        bUP.setVisible(false);
        bDOWN.setVisible(false);
        bLEFT.setVisible(false);
        bRIGHT.setVisible(false);
        jButton1.setVisible(false);
        lYOUHAVELOST.setVisible(true);

    }

    public static void printGameField(int[][] gameField){

        String string = "[\n";

        for (int c = 0 ; c < gameField.length ; c++){
            for (int r = 0 ; r < gameField.length ; r++){

                string += gameField[c][r];
                string += " ";

            }
            string += "\n";
        }

        string += "]";

        System.out.println(string);

    }
    // end methods
} // end of class MyGame