import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        Scanner inputFile;
        try {
            inputFile = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e)  {
            System.out.print("Filen finns inte, använd tangentbordet istället...");
            inputFile = new Scanner(System.in);

        }
        ArrayList<String> wordList = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            wordList.add(inputFile.nextLine());
        }
        for (int i = 0 ; i < wordList.size() ; i++) {
            System.out.println(wordList.get(i));

        }
           Math.random();
        Random R = new Random (10);
        int wordIndex   = R.nextInt(wordList.size());
        String correctWord = wordList.get(wordIndex);

    }
}

