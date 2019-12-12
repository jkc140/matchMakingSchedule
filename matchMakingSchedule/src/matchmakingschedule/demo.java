/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingschedule;
import java.io.File;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
/**
 *
 * @author Joshua
 */
public class demo {
    public String[] lineStore;
    public int numTeam;
    public void getInfo(){
        File inputs=new File("teamInfo.txt");
        
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
            System.out.println(count);
                       
            lineRead.close();
        }
        catch(Exception e){
            
        }
        finally{
            
        }              
    }
    public void lineSorting(){
        String[] teamNum=new String[2];
        teamNum=lineStore[0].split("/");
        System.out.println("Team Num: "+teamNum[1]);
        numTeam=Integer.valueOf(teamNum[1]);
        int max=0;
        int count=0;
        /*String tempHolder= lineStore[4].replace("/", "0");
        System.out.println("new line store: " +tempHolder);
        System.out.print("true/false: ");
        System.out.println( tempHolder.indexOf("/")!=-1);*/
        int[] splitter=new int[numTeam];
        for(int x=3;x<3+numTeam;x++){
            String tempHolder=lineStore[x];
            while(tempHolder.indexOf("/")!=-1){
                tempHolder=tempHolder.replaceFirst("/", "0");
                count++;;
                System.out.println("Looping");
            }
            splitter[x-3]=count;
            System.out.println(count);
            if (count>max){
                max=count;
            }
            count=0;
        }
        System.out.println("text splittiung");
        for(int x=0;x<numTeam;x++){
            System.out.println(splitter[x]);
        }
        System.out.println("text splittiung");
        System.out.println(max);
        String[][] teamInfo=new String[numTeam][max+2];
        for(int x=0;x<numTeam;x++){
            teamInfo[x][max+1]=String.valueOf(splitter[x]);
        }
        for(int x=3;x<3+numTeam;x++){
            teamInfo[x-3]=lineStore[x].split("/");
            //System.out.println(lineStore[x]);
        }
        for(int x=0;x<numTeam;x++){
           // System.out.println("changing line");
            System.out.println(splitter[x]+1);
            for(int y=0;y<splitter[x]+1;y++){
               // System.out.println("Spot");
                System.out.println(teamInfo[x][y]);
            }
        }
    }
    public void randomize(){
        int[][] opponents=new int[numTeam/2][2];
        
        boolean[] hasTeam=new boolean[numTeam];
        boolean full=false;
        Random rand=new Random();
        boolean valid=false;
        int opp;
        int opp2;
        boolean allHas=false;
        int times=0;
        do{
            
            do{
                opp=rand.nextInt(numTeam);
                if(hasTeam[opp]==true){
                    valid=false;
                }
                else{
                    valid=true;
                    hasTeam[opp]=true;
                }
            }while(valid==false);
            opponents[times][0]=opp;
            do{
                opp2=rand.nextInt(numTeam);
                if(hasTeam[opp2]==true){
                    valid=false;
                }
                else{
                    valid=true;
                    hasTeam[opp2]=true;
                }
            }while(valid==false);
            opponents[times][1]=opp2; 
            times++;
            System.out.println("time: "+times);
            
            
            
            int count=0;
            System.out.println("Counting1"+count);
            for(int x=0;x<hasTeam.length;x++){
                 if(hasTeam[x]==true){
                     count++;
                     System.out.println("Counting2"+count);
                 }
                 else{
                     break;
                 }
            }
            System.out.println("Counting3"+count);
            //System.out.println("hasTeam"+hasTeam.length);
            if (count==hasTeam.length){
                System.out.println("Counting"+count);
                System.out.println("hasTeam"+hasTeam.length);
                allHas=true;
            }
            else{
                allHas=false;
            }
        }while(allHas==false);
        System.out.println(opponents[0][0]);
        System.out.println(opponents[0][1]);
        System.out.println(opponents[1][0]);
        System.out.println(opponents[1][1]);
    }
}
