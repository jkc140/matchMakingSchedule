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
    int numTeam;
    String parkInfo;
    String startDate;
    String endDate;
    String matchNum;
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
        	
        String[] teamNum=new String[2];	
        teamNum=rawData[0].split("/");	
        System.out.println("Team Num: "+teamNum[1]);	
        numTeam=Integer.valueOf(teamNum[1]);	
        int max=0;	
        int count=0;	
	
        int[] splitter=new int[numTeam];	
        for(int x=3;x<3+numTeam;x++){	
            String tempHolder=rawData[x];	
            while(tempHolder.indexOf("/")!=-1){	
                tempHolder=tempHolder.replaceFirst("/", "0");	
                count++;	
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
    }	
    public void storeInfo(){
        
    }
    
    int matchNum2=0;
    int parkNum=0;
    String[][] parkArray;
    String[] rawData2;
    String[][][][] matchInfo;
    String[][] parkDetail;
    String[] parkList;
    public void storeRead(){
        
        File storeFile=new File("Schedule.txt");
        try{
            Scanner length=new Scanner("Schedule.txt");
            while(length.hasNextLine()==true){	
                matchNum2++;	
                length.nextLine();	
            }
            length.close();
            
            rawData2=new String[matchNum2];
            Scanner storing=new Scanner("Schedule.txt");
            int count=0;	
            while(storing.hasNextLine()==true){	
                rawData2[count]=storing.nextLine();	
                count++;	
            }
            
            
            
            
        }
        catch(Exception e){
            
        }
    }
    public void storeSort(){
        String[] tempHolder=new String[rawData2.length];
        for(int x=0;x<rawData2.length;x++){
            tempHolder[x]=rawData2[x];
            while(tempHolder[x].indexOf("/")!=-1){
                tempHolder[x]=tempHolder[x].replaceFirst("/", "0");	
                parkNum++;
            }
        }
        matchInfo=new String[matchNum2][parkNum][2][2];
        parkArray=new String[matchNum2][parkNum];
        for(int x=0;x<matchNum2;x++){
            for(int y=0;x<parkNum;y++){
                parkArray[x]=rawData[x].split("/");
            }
        }
        parkDetail=new String[parkNum][7];
        for(int x=0;x<matchNum2;x++){
            for(int y=0;x<parkNum;y++){
                parkDetail[y]=parkArray[x][y].split("|");
            }
        }
        for(int x=0;x<matchNum2;x++){
            for(int y=0;y<parkNum;y++){
                matchInfo[x][y][0][0]=parkDetail[y][2];
                matchInfo[x][y][0][0]=parkDetail[y][3];
                matchInfo[x][y][1][1]=parkDetail[y][5];
                matchInfo[x][y][1][1]=parkDetail[y][6];
                
            }
        }
        parkList=new String[parkNum];
        for(int x=0;x<parkNum;x++){
            parkList[x]=parkDetail[x][0];
        }

    }
    public void storeStore(){
        
    }
}