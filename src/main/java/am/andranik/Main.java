package am.andranik;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

//    static String s = "î³ñ³Íí³ÍáõÃÛáõÝÁ Ð³Û³ëï³ÝáõÙ:";
    static Map<Integer, Integer> theMap = ArmToUnicodeMap.getMap();

    public static void main(String[] args) throws IOException {
        File dir = new File("PATH_TO_DIR");

        for (File file : Objects.requireNonNull(dir.listFiles())){
            convertFile(file);
        }
    }


    public static void convertFile(File file) throws IOException{
        String path = file.getAbsolutePath();
        String name = file.getName().split("\\.")[0];

        String newPath = path.replace(name, name + "_utf");

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(newPath)));

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                writer.write(convertLine(line));
            }
        }

        writer.close();

        File oldFile = new File(path);
        File newFile = new File(newPath);

        oldFile.delete();
        newFile.renameTo(oldFile);
    }


    public static String convertLine(String line){
        StringBuilder b = new StringBuilder();

        for (char ch : line.toCharArray()){
            Integer i = theMap.get((int) ch);

            if(i != null){
                b.append((char) (int) i);
            } else {
                b.append(ch);
            }
        }
        return b.toString();
    }

}
