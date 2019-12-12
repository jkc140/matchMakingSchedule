/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingschedule;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author Joshua
 */
public class demo {
    public void getInfo(){
        File inputs=new File("teamInfo.txt");
        String[] lineStore;
        try{
            if(inputs.createNewFile()==true){
                System.out.println("Creating file");
            }
            else{
                System.out.println("File already there");
            }
            
            
            Scanner arrayLength=new Scanner(inputs);
            int numLine=0;
            while(arrayLength.hasNextLine()==true){
                numLine++;
                arrayLength.nextLine(); //this line needed to go to the next line
            }
            arrayLength.close();
            lineStore=new String[numLine];
            
            
            Scanner lineRead=new Scanner(inputs);
            int count=0;
            while(lineRead.hasNextLine()==true){
                lineStore[count]=lineRead.nextLine();
                count++;
            }
            for(int x=0;x<lineStore.length;x++){
                System.out.println(lineStore[x]);
            }            
            lineRead.close();
        }
        catch(Exception e){
            
        }
        finally{
            
        }
        
        
        
        
    }
}
