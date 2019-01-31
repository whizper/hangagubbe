import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangagubbe {
    public static void main(String[] args) {
        int points = 0;
        String guess;
        int guessesLeft = 4;
        String guessedLetters = "";

        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("filen finns inte använd tangentborde iställe");
            inputFile = new Scanner(System.in);
        }
        ArrayList<String> wordList = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            wordList.add(inputFile.nextLine());
        }
        Random R = new Random();
        String word = wordList.get(R.nextInt(wordList.size()));
        String star = "*";
        char[] myWord = new char[word.length()];
        for(int i = 0; i<word.length(); i++){

            myWord[i] += star.charAt(0);
        }
        for(int s = 0; s < 1; s++){
            System.out.print(myWord);
            System.out.println();
        }
        Scanner in = new Scanner(System.in);
        while (guessesLeft > 0) {
            char guessAsChar = in.nextLine().charAt(0);
            guess = Character.toString(guessAsChar);
            while (guessedLetters.contains("" + guessAsChar)) {
                System.out.println("Det har du redan gissat på!");
                guessAsChar = in.nextLine().charAt(0);
            }
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess.charAt(0)) {
                    myWord[i] = guess.charAt(0);
                    points ++;
                }
            }
            System.out.print(myWord);
            System.out.println();
            if(points == word.length()){
                System.out.println("Grattis XDD!");
                break;
            }

            boolean found = false;
            guessedLetters += guessAsChar;
            char[] wordAsChar = word.toCharArray();
            for(int u = 0; u < wordAsChar.length; u++){
                if (wordAsChar[u] == guessAsChar){
                    myWord[u] = guessAsChar;
                    found = true;
                }
            }
            if(!found){
                guessesLeft--;
                System.out.println(" Du ha " + guessesLeft + " kvar!");


            }
        }
    }

}