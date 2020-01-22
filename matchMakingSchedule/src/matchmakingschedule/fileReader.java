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
    public void getName(String name){	
        fName=name;	
        fName=name+".txt"; // got to make it so it checks to see if .txt is on it	
    }	
    public void fileRead(){	
        System.out.println(fName);
        File dataFile=new File(fName);	
        try{	
            if(dataFile.createNewFile()==true){ 	
                System.out.println("Creating"); //delete me	
            }	
            else{                	
                System.out.println("File is already there"); //delete me	
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
    //            System.out.println(rawData[count]);
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
        for(int x=0;x<rawData.length;x++){
            System.out.println(rawData[x]);
        }	
        String[] teamNum=new String[2];	
        teamNum=rawData[0].split("/");	
    //    System.out.println("Team Num: "+teamNum[1]);	
        numTeam=Integer.valueOf(teamNum[1]);	
        int max=0;	
        int count=0;	
	
        int[] splitter=new int[numTeam];	
        for(int x=3;x<3+numTeam;x++){	
            String tempHolder=rawData[x];	
            while(tempHolder.indexOf("/")!=-1){	
                tempHolder=tempHolder.replaceFirst("/", "0");	
                count++;	
     //           System.out.println("Looping");	
            }	
            splitter[x-3]=count;	
   //         System.out.println(count);	
            if (count>max){	
                max=count;	
            }	
            count=0;	
        }	
    //    System.out.println("text splittiung");	
        for(int x=0;x<numTeam;x++){	
    //        System.out.println(splitter[x]);	
        }	
   //     System.out.println("text splittiung");	
   //     System.out.println(max);	
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
    //        System.out.println(splitter[x]+1);	
            for(int y=0;y<splitter[x]+1;y++){	
               // System.out.println("Spot");	
    //            System.out.println(teamInfo[x][y]);	
            }	
        }	
        int skipCount=3+numTeam+2;
        String tempHolder=rawData[skipCount];
            while(tempHolder.indexOf("/")!=-1){
                tempHolder=tempHolder.replaceFirst("/", "0");
                count++;;
            }
        parkInfo=new String[count];
    //    System.out.println("parks: ");
        //for(int x=skipCount;x<3+numTeam;x++){
            parkInfo=rawData[skipCount].split("/");
            //System.out.println(lineStore[x]);
            for(int x=0;x<parkInfo.length;x++){
   //             System.out.println(parkInfo[x]);

            }
            skipCount=skipCount+2;
    //        System.out.println(skipCount);
                        /*System.out.println(skipCount+1);
                        System.out.println(skipCount+2);
                        System.out.println(skipCount+3);   */        
            startDate=rawData[skipCount].split("/");
            endDate=rawData[skipCount+1].split("/");
            matchNum=rawData[skipCount+2].split("/");
           /* for(int x=0;x<startDate.length;x++){
                System.out.println("startDate");
                 System.out.println(startDate[x]);
            }*/
    //        System.out.println(startDate[1]);
   //         System.out.println(endDate[1]);
   //         System.out.println(matchNum[1]);
    }	
  
    int matchNum2=0;
    int parkNum=0;
    String[][] parkArray;
    String[] rawData2;
    public String[][][][] matchInfo;
    public String[][]parkDetail;
    public String[]parkList;    
    public void storeRead(){
        System.out.println("store read");
        File storeFile=new File("Schedule.txt");
        try{
            Scanner length=new Scanner(storeFile);
            while(length.hasNextLine()==true){	
                System.out.println("hello");
                matchNum2++;	
                length.nextLine();	
            }
            length.close();
            System.out.println("matchNum: "+matchNum2);
            rawData2=new String[matchNum2];
            System.out.println(rawData2);
            Scanner storing=new Scanner(storeFile);
            int count=0;	
            while(storing.hasNextLine()==true){	
                rawData2[count]=storing.nextLine();	
                System.out.println("line: "+rawData2[count]);
                count++;	
            }
            
            
            
            
        }
        catch(Exception e){
            
        }
    }
    public void storeSort(){
        System.out.println("store stort");
        String tempHolder;
        //for(int x=0;x<rawData2.length;x++){
            tempHolder=rawData2[0];
            while(tempHolder.indexOf("/")!=-1){
                System.out.println("parkNum1: "+parkNum);
                parkNum++;
                tempHolder=tempHolder.replaceFirst("/", "0");	
                
                System.out.println("parkNum2: "+parkNum);
            }
        //}
        System.out.println("parkNum: "+parkNum);
        matchInfo=new String[matchNum2][parkNum][2][2];
        parkArray=new String[matchNum2][parkNum];
        /*System.out.println("here 1");
        for(int x=0;x<matchNum2;x++){
            System.out.println("here 1.1");
            
            for(int y=0;y<parkNum;y++){
                System.out.println("here 2");
                parkArray[x]=rawData2[x].split("/");
                System.out.println("parkArray[y]: "+parkArray[0][0]);
                System.out.println("parkArray[y]: "+parkArray[1]);
            }
            
        }*/
        System.out.println("here 2");
        parkDetail=new String[parkNum][7];
        for(int x=0;x<matchNum2;x++){     
            System.out.println("parkNum 2: "+parkNum);
            for(int y=0;y<parkNum;y++){
               /* System.out.println("x: "+x);
                System.out.println("y: "+y);
               
                System.out.println("parkDetail: "+parkDetail.length);
                System.out.println("parkArray[x][y]: "+parkArray[x].length);
                System.out.println("parkNum: "+parkNum);*/
               
                parkArray[x]=rawData2[x].split("/");
                System.out.println("parkArray[y]: "+parkArray[x][y]);
                parkDetail[y]=parkArray[x][y].split("&");
                //System.out.println(parkDetail[y].length);
                for(int a=0;a<parkDetail[y].length;a++){
                    

                    
                        System.out.println(a);
                        System.out.println(parkDetail[y][a]);

                }
                    matchInfo[x][y][0][0]=parkDetail[y][2];
                    matchInfo[x][y][0][1]=parkDetail[y][3];
                    matchInfo[x][y][1][0]=parkDetail[y][5];
                    matchInfo[x][y][1][1]=parkDetail[y][6];
                
                
                
                
            }
            System.out.println("next match");
        }
       
        System.out.println("here 3");
        parkList=new String[parkNum];
        for(int x=0;x<parkNum;x++){
            System.out.println(parkDetail[0]);
            parkList[x]=parkDetail[x][0];
            
        }
        System.out.println("end");

    }
    
}