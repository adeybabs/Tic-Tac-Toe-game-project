package TicTacToe;

import java.util.*;

public class TicTacToe {
    static ArrayList<Integer>playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer>cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        //The Game board of the TicTacToe game is like a 2D array (3 rows and 3 columns

        char[] [] gameBoard = { {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},};



        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter integer 1-9 :");
            int position = scan.nextInt();

            System.out.println(position);

            placingPiece(gameBoard, position, "player");

            //Using Random class for generating pseudo random numbers
            Random random = new Random();
            int cpuPosition = random.nextInt(9) + 1;
            placingPiece(gameBoard, cpuPosition, "cpu");

            printGameBoard(gameBoard);
            checkWinner();

        }
    }

    //A print Game board method created outside the main method to make the code neater
    public static void printGameBoard(char [][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // A method for placing piece for the TicTacToe game
    public static void placingPiece(char[] [] gameBoard, int position, String user){

        char symbol = ' ';

        if (user.equals("player")){
            symbol = 'x';
        } else if (user.equals("cpu")){
            symbol = 'o';
        }
        // A switch case for the array positions(index)and placement of x
        switch (position) {
            case 1: gameBoard[0][0] = symbol;
                break;
            case 2: gameBoard[0][2] = symbol;
                break;
            case 3: gameBoard[0][4] = symbol;
                break;
            case 4: gameBoard[2][0] = symbol;
                break;
            case 5: gameBoard[2][2] = symbol;
                break;
            case 6: gameBoard[2][4] = symbol;
                break;
            case 7: gameBoard[4 ][0] = symbol;
                break;
            case 8: gameBoard[4][2] = symbol;
                break;
            case 9: gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    // A check winner method returning a String
    public static String checkWinner(){

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List diagonal1 = Arrays.asList(1,5,9);
        List diagonal2 = Arrays.asList(7,5,3);

   // Adding all of the checkwinner into a list and loop through
        List<List>winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(diagonal1);
        winning.add(diagonal2);

        //looping
        for (List l : winning){
            if (playerPositions.containsAll(l)){
                return "Congratulations champion!!!";
            } else if (cpuPositions.containsAll(l)){
                return "Sorry Computer wins!!!";
            }else if (playerPositions.size() + cpuPositions.size() == 9){
                return "Its a tie play again";
            }
        }
        return "";
    }
}
