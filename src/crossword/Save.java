package crossword;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Save { //save to file
    private static final String file = "config.json";

    public static void saveCrossWords(ArrayList<Crossword> crosswords) {
        if (crosswords == null)
            return;
        try {
            Gson gson = new Gson();
            Type listOfTestObject = new TypeToken<ArrayList<Crossword>>() {
            }.getType();
            String s = gson.toJson(crosswords, listOfTestObject);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Crossword> getCrossWords() {
        creatFile();
        ArrayList<Crossword> crosswords;
        try {
            Reader reader = new FileReader(file);
            Gson gson = new Gson();
            TypeToken<ArrayList<Crossword>> typeToken = new TypeToken<ArrayList<Crossword>>() {
            };
            crosswords = gson.fromJson(reader, typeToken.getType());

        } catch (IOException e) {
            crosswords = new ArrayList<>();
        }
        if (crosswords == null)
            return new ArrayList<Crossword>();
        return crosswords;
    }

    private static boolean creatFile() {
        File f = new File(file);
        if (!f.exists()) {  //file not found create
            try {
                return f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}
