package textfiles;

import java.io.BufferedReader;
import java.io.FileReader;
public class ReadFile {
    public static void main(String[] args) {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            fr = new FileReader("P:/text.txt");
            br = new BufferedReader(fr);
            String sCurrentLine = "";
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}