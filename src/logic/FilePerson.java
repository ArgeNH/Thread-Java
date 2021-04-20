package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FilePerson extends FilePlain{

    public ArrayList<String> reader() throws IOException {
        ArrayList<String> output = new ArrayList<>();
        StringTokenizer tokens = new StringTokenizer(readFile(), "\n");
        while(tokens.hasMoreElements()){
            output.add(tokens.nextToken());
        }
        return output;
    }

    public void write(ArrayList<String> records) throws IOException{
        StringBuilder saveFile= new StringBuilder();
        for (String line : records) {
            saveFile.append(line+"\n");
        }
        writeFile(saveFile.toString());
    }


    public void pushJson(ArrayList<People> people) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String collection = gson.toJson(people);
        writeFile(collection);
    }

    public ArrayList<People> pullJson() throws IOException{
        String json = readFile();
        Gson gson = new Gson();
        Type type = new TypeToken <ArrayList<People>>(){}.getType();
        ArrayList<People> output = gson.fromJson(json, type);
        return output;
    }
}
