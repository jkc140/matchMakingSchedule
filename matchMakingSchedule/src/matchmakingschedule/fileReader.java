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
    String[][] teamInfo;	
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
        int numTeam;	
        String[] teamNum=new String[2];	
        teamNum=rawData[0].split("/");	
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
            String tempHolder=rawData[x];	
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
        teamInfo=new String[numTeam][max+2];	
        for(int x=0;x<numTeam;x++){	
            teamInfo[x][max+1]=String.valueOf(splitter[x]);	
        }	
        for(int x=3;x<3+numTeam;x++){	
            teamInfo[x-3]=rawData[x].split("/");	
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
        String[] parkInfo;
        String[] startDate=new String[2];
        String[] endDate=new String[2];
        String[] matchNum=new String[2];
        int skipCount=3+numTeam+2; //gives parks
        String tempHolder=rawData[skipCount];
            while(tempHolder.indexOf("/")!=-1){
                tempHolder=tempHolder.replaceFirst("/", "0");
                count++;;
            }
        parkInfo=new String[count];
        System.out.println("parks: ");
        //for(int x=skipCount;x<3+numTeam;x++){
            parkInfo=rawData[skipCount].split("/");
            //System.out.println(lineStore[x]);
            for(int x=0;x<parkInfo.length;x++){
                System.out.println(parkInfo[x]);

            }
            skipCount=skipCount+2;
            System.out.println(skipCount);
                        System.out.println(skipCount+1);
                        System.out.println(skipCount+2);
                        System.out.println(skipCount+3);           
            startDate=rawData[skipCount].split("/");
            endDate=rawData[skipCount+1].split("/");
            matchNum=rawData[skipCount+2].split("/");
           /* for(int x=0;x<startDate.length;x++){
                System.out.println("startDate");
                 System.out.println(startDate[x]);
            }*/
            System.out.println(startDate[1]);
            System.out.println(endDate[1]);
            System.out.println(matchNum[1]);

        //}
        
    }	
}