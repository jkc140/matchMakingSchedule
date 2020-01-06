/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingschedule;
import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

/**
 *
 * @author Joshua
 */
public class fileReader {
    String fName;
    String[] rawData;
    public void getName(String name){
        fName=name;
        fName=name+".txt"; // got to make it so it checks to see if .txt is on it
    }
    public void fileRead(){
        File dataFile=new File(fName);
        try{
            if(dataFile.createNewFile()==true){ 
                System.out.println("File is already there"); //delete me
            }
            else{                
                System.out.println("File is not there"); //delete me
            }
            
            Scanner arrayLength=new Scanner(fName);
            int numLine=0;
            while(arrayLength.hasNextLine()==true){
                numLine++;
                arrayLength.nextLine();
            }
            arrayLength.close();
            rawData=new String[numLine];
            
            Scanner storeData=new Scanner(fName);
            int count=0;
            while(storeData.hasNextLine()==true){
                rawData[count]=storeData.nextLine();
                count++;
            }
            storeData.close();

        }
        catch(IOException e){
            System.out.println("Invalid File");
        }
        finally{
        }
    }
    public void sort(){
    }
}
