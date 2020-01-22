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
    String[] parkInfo;
        String[] startDate=new String[2];
        String[] endDate=new String[2];
        String[] matchNum=new String[2];
    //get file name
    public void getName(String name){	
        fName=name;	
        fName=name+".txt"; // got to make it so it checks to see if .txt is on it	
    }	
    //get the information out of file
    public void fileRead(){	
        System.out.println(fName);
        File dataFile=new File(fName);	
        try{	
            if(dataFile.createNewFile()==true){ 	
            }	
            else{                	
            }	

            Scanner arrayLength=new Scanner(dataFile);	
            int numLine=0;	
            while(arrayLength.hasNextLine()==true){	
                numLine++;	
                arrayLength.nextLine();	
            }	
            arrayLength.close();	
            rawData=new String[numLine];	

            Scanner storeData=new Scanner(dataFile);	
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
    //store the information into different arrays that we can use
    public void sort(){	
        System.out.println(rawData.length);
        for(int x=0;x<rawData.length;x++){
            System.out.println(rawData[x]);
        }	
        String[] teamNum=new String[2];	
        teamNum=rawData[0].split("/");	
        numTeam=Integer.valueOf(teamNum[1]);	
        int max=0;	
        int count=0;	
	
        int[] splitter=new int[numTeam];	
        for(int x=3;x<3+numTeam;x++){	
            String tempHolder=rawData[x];	
            while(tempHolder.indexOf("/")!=-1){	
                tempHolder=tempHolder.replaceFirst("/", "0");	
                count++;	
            }	
            splitter[x-3]=count;	
            if (count>max){	
                max=count;	
            }	
            count=0;	
        }	
	
        teamInfo=new String[numTeam][max+2];	
        for(int x=0;x<numTeam;x++){	
            teamInfo[x][max+1]=String.valueOf(splitter[x]);	
        }	
        for(int x=3;x<3+numTeam;x++){	
            teamInfo[x-3]=rawData[x].split("/");	
        }	
	
        int skipCount=3+numTeam+2;
        String tempHolder=rawData[skipCount];
            while(tempHolder.indexOf("/")!=-1){
                tempHolder=tempHolder.replaceFirst("/", "0");
                count++;;
            }
        parkInfo=new String[count];
            parkInfo=rawData[skipCount].split("/");
            skipCount=skipCount+2;     
            startDate=rawData[skipCount].split("/");
            endDate=rawData[skipCount+1].split("/");
            matchNum=rawData[skipCount+2].split("/");

    }	
  
    int matchNum2=0;
    int parkNum=0;
    String[][] parkArray;
    String[] rawData2;
    public String[][][][] matchInfo;
    public String[][]parkDetail;
    public String[]parkList;    
    //read the file we store our data in
    public void storeRead(){
        System.out.println("store read");
        File storeFile=new File("Schedule.txt");
        try{
            Scanner length=new Scanner(storeFile);
            while(length.hasNextLine()==true){	
                matchNum2++;	
                length.nextLine();	
            }
            length.close();
            rawData2=new String[matchNum2];
            System.out.println(rawData2);
            Scanner storing=new Scanner(storeFile);
            int count=0;	
            while(storing.hasNextLine()==true){	
                rawData2[count]=storing.nextLine();	
                count++;	
            }
        }
        catch(Exception e){
        }
    }
    //make the data usable
    public void storeSort(){
        String tempHolder;
            tempHolder=rawData2[0];
            while(tempHolder.indexOf("/")!=-1){
                parkNum++;
                tempHolder=tempHolder.replaceFirst("/", "0");        
            }        
        matchInfo=new String[matchNum2][parkNum][2][2];
        parkArray=new String[matchNum2][parkNum];
        parkDetail=new String[parkNum][7];
        for(int x=0;x<matchNum2;x++){     
            for(int y=0;y<parkNum;y++){               
                parkArray[x]=rawData2[x].split("/");
                parkDetail[y]=parkArray[x][y].split("&");
                matchInfo[x][y][0][0]=parkDetail[y][2];
                matchInfo[x][y][0][1]=parkDetail[y][3];
                matchInfo[x][y][1][0]=parkDetail[y][5];
                matchInfo[x][y][1][1]=parkDetail[y][6];
            }
        }
       
        parkList=new String[parkNum];
        for(int x=0;x<parkNum;x++){
            parkList[x]=parkDetail[x][0];            
        }
    }    
}