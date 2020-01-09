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
        //getting other info
        String[] parkInfo;
        String[] startDate=new String[2];
        String[] endDate=new String[2];
        String[] matchNum=new String[2];
        int skipCount=3+numTeam+2; //gives parks
        String tempHolder=lineStore[skipCount];
            while(tempHolder.indexOf("/")!=-1){
                tempHolder=tempHolder.replaceFirst("/", "0");
                count++;;
            }
        parkInfo=new String[count];
        System.out.println("parks: ");
        //for(int x=skipCount;x<3+numTeam;x++){
            parkInfo=lineStore[skipCount].split("/");
            //System.out.println(lineStore[x]);
            for(int x=0;x<parkInfo.length;x++){
                System.out.println(parkInfo[x]);

            }
            skipCount=skipCount+2;
            System.out.println(skipCount);
                        System.out.println(skipCount+1);
                        System.out.println(skipCount+2);
                        System.out.println(skipCount+3);           
            startDate=lineStore[skipCount].split("/");
            endDate=lineStore[skipCount+1].split("/");
            matchNum=lineStore[skipCount+2].split("/");
           /* for(int x=0;x<startDate.length;x++){
                System.out.println("startDate");
                 System.out.println(startDate[x]);
            }*/
            System.out.println(startDate[1]);
            System.out.println(endDate[1]);
            System.out.println(matchNum[1]);
       
        //}
        
        
        
    }
    public void randOpp(){
        int[][] opponents=new int[numTeam/2][2];        
        boolean[] hasTeam=new boolean[numTeam];
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
            for(int x=0;x<hasTeam.length;x++){
                 if(hasTeam[x]==true){
                     count++;
                 }
                 else{
                     break;
                 }
            }
            if (count==hasTeam.length){
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
    public void randLoc(){
        boolean[][] LocSelect=new boolean[5][2];
        boolean allHas=false;
        boolean valid=false;
        int TEMPMATCHPERTIME=1;
        int[][] location=new int[TEMPMATCHPERTIME][2];
        Random rand=new Random();
        int loc;
        int cycle;        
        int numLoc=5;
        for(int time=0;time<2;time++){
            cycle=0;
           System.out.println("cycle1"+cycle);
            do{
            
                do{
                    loc=rand.nextInt(numLoc);
                    if(LocSelect[loc][time]==true){
                        valid=false;
                    }
                    else{
                        valid=true;
                        LocSelect[loc][time]=true;
                    }
                }while(valid==false);
                System.out.println("cycle2"+cycle);
                System.out.println("time"+time);
                location[cycle][time]=loc;
                cycle++;
                int count=0;
                System.out.println("Counting1 "+ count);
                for(int x=0;x<numLoc;x++){
                     if(LocSelect[x][time]==true){
                         count++;
                         System.out.println("Counting2 "+ count);
                     }
                     /*else{
                         break;
                     } <-- causes errors cause does not loop through them all, which is what it should not do, but since only 4 teams and 1 match at each time it has to check all of them
                        ^ it this is to make sure all parks are selected, but since there is only 1 match per time that means only 1 location out of the 5 is being used and this part does not work with it
                     */
                }
                System.out.println("Counting3 "+ count);
                if (count==TEMPMATCHPERTIME/*LocSelect.length*/){
                    System.out.println("hasTeam"+LocSelect.length);
                    System.out.println("Counting1 "+ count);
                    allHas=true;
                }
                else{
                    allHas=false;
                }
            }while(allHas==false);
            System.out.println("Second time");
        }
        System.out.println(location[0][0]);
        System.out.println(location[0][1]);
    }
    public void randTime(){
        int numLoc=5;
        int numTime=2;
        boolean[][]locHasTime=new boolean[numLoc][2];
        int[][] matchTime=new int[numLoc][2];
        boolean allHas=false;
        boolean valid=false;
        int cycle=0;
        int time;
        Random rand=new Random();
        int TEMPMATCHNUM=1;
        for(int loop=0;loop<2;loop++){
            cycle=0;
           System.out.println("cycle1"+cycle);
            do{
            
                do{
                    time=rand.nextInt(2);
                    if(locHasTime[time][loop]==true){
                        valid=false;
                    }
                    else{
                        valid=true;
                        locHasTime[time][loop]=true;
                    }
                }while(valid==false);
                System.out.println("cycle2"+cycle);
                System.out.println("time"+loop);
                matchTime[cycle][loop]=time;
                cycle++;
                int count=0;
                System.out.println("Counting1 "+ count);
                for(int x=0;x<numLoc;x++){
                     if(locHasTime[x][loop]==true){
                         count++;
                         System.out.println("Counting2 "+ count);
                     }
                     /*else{
                         break;
                     } <-- causes errors cause does not loop through them all, which is what it should not do, but since only 4 teams and 1 match at each time it has to check all of them
                        ^ it this is to make sure all parks are selected, but since there is only 1 match per time that means only 1 location out of the 5 is being used and this part does not work with it
                     */
                }
                System.out.println("Counting3 "+ count);
                if (count==TEMPMATCHNUM/*LocSelect.length*/){
                    System.out.println("hasTeam"+matchTime.length);
                    System.out.println("Counting1 "+ count);
                    allHas=true;
                }
                else{
                    allHas=false;
                }
            }while(allHas==false);
            System.out.println("Second time");
        }
        System.out.println("1st Time: "+matchTime[0][0]);
        System.out.println("2nd Time: "+matchTime[0][1]);
    }
    
}
