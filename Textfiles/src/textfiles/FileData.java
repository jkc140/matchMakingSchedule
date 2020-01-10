
package textfiles;

import java.io.PrintWriter;
public class FileData {
    public static void main(String[] args) {
    PrintWriter writer;
    try {
 writer = new PrintWriter("P:/text.txt");
       writer.println("Line 111111");
       writer.println("line 22222");
       writer.println("line 33333");
       writer.println("line 44444");
       writer.close();
       System.out.println("finished");
     } catch (Exception e) {
       e.printStackTrace();
     }
    }
}