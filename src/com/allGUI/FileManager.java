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
}
