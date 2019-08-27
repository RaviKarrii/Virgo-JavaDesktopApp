package com.allGUI;
import java.io.*;

public class FileManager {
    public void CreateFile(String FileName){
        System.out.println("Started Writing");
        try {
            File yourFile = new File(FileName);
            yourFile.createNewFile(); // if file already exists will do nothing
            FileOutputStream oFile = new FileOutputStream(yourFile, false);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void WriteFile(String FN,String Line){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(FN), "utf-8"))) {
            writer.write(Line);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public String ReadFile(String FN){
        try(BufferedReader br = new BufferedReader(new FileReader(FN))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return (everything);
        }
        catch (Exception e){

        }
        return "";
    }
}
