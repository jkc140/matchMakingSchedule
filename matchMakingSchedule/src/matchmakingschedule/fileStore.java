/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingschedule;
import java.lang.*;
import java.io.*;
 

/**
 *
 * @author S331474817
 */
public class fileStore {
    //stores the info into a file
    public void storeInfo(int parkNum,String[][][][] matches,String[] parkList){
    StringBuilder builder = new StringBuilder();
    for(int x=0;x<matches.length;x++){
        for(int y=0;y<matches[x].length;y++){
            builder.append(parkList[y]+"");
            for(int z=0;z<matches[x][y].length;z++){
                builder.append("&");
                if(z==0){
                    builder.append("6:00pm");
                    for(int w=0;w<matches[x][y][z].length;w++){
                        builder.append("&");
                        builder.append(matches[x][y][z][w]);
                    }
                }
                else{
                    builder.append("7:00pm");
                    for(int w=0;w<matches[x][y][z].length;w++){
                        builder.append("&");
                        builder.append(matches[x][y][z][w]);
                    }
                }       
                
            }
            builder.append("/");
        }
        builder.append("\n");
    }
   
    
    try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("Schedule.txt"));
        writer.write(builder.toString());//save the string representation of the board
        System.out.println("Writing");
        writer.close(); 
    }
    catch(Exception e){
        System.out.println("error");
    }
    
    }
    
}
