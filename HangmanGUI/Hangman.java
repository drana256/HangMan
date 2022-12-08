import java.io.IOException;
import java.util.ArrayList;

public class Hangman
{
    public static void main(String[] args) 
    {
        ArrayList<String> toCheck = new ArrayList<String>();
        try 
        {
            FileLoader load = new FileLoader("Words.txt");      //Reads from a file and puts the contents to a arraylist
            toCheck = load.loadFile();
        } 
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
        Check ck = new Check(toCheck);
        GUI game = new GUI();
        
    }
}