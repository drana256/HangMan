import java.io.IOException;
import java.util.ArrayList;

public class Hangman
{
    public static void main(String[] args) 
    {
        ArrayList<String> toCheck = new ArrayList<String>();
        try 
        {
            FileLoader load = new FileLoader("Words.txt");
            toCheck = load.loadFile();
        } 
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }

        Check ck = new Check(toCheck);
        ck.checking();



        System.out.println("Game Over !!!");
    }
}