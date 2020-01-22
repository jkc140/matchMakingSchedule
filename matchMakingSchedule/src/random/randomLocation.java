/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;
import java.util.Random;
import matchmakingschedule.*;
/**
 *
 * @author Joshua
 */
public class randomLocation extends Rand{    
    String[] parkList;
    String[][] tempSelect;
    String[][][][] matches;
    String [][][] assigned;
    boolean[] alreadyHas;
    String[][] Opp;
    teams[]teamInfo;
    int [][] prefList;
    int prefBase=10;
    boolean prefMore[];
    int remove[];

    
    //get park information
    public void getParks(String[]parks){
        parkList=new String[parks.length];
        parkList=parks;
    }

    //get match Information
    public void getMatches(String [][][][] matchInfo){
        matches=new String[matchInfo.length][matchInfo[0].length][matchInfo[0][0].length][matchInfo[0][0][0].length];
        for(int x=0;x<matchInfo.length;x++){
            for(int y=0;y<matchInfo[x].length;y++){
                for(int z=0;z<2;z++){
                    for(int a=0;a<2;a++){
                        matches[x][y][z][a]=matchInfo[x][y][z][a];
                    }   
                }   
            }
        }

    }
    
    //initiate values
    public void initVal(int teamNum,teams[] impTeamInfo){
        teamInfo=new teams[teamNum];
        assigned=new String[parkList.length][2][2];
        alreadyHas=new boolean[teamInfo.length];
        used=new boolean[parkList.length][2];        
        tempSelect=new String[parkList.length][2];
        prefList=new int[parkList.length][teamInfo.length];        
        for(int x=0;x<teamInfo.length;x++){
            teamInfo[x]=new teams();
            teamInfo[x]=impTeamInfo[x];
        }
        for(int x=0;x<alreadyHas.length;x++){
            alreadyHas[x]=false;
        }
        prefMore=new boolean[prefList.length];
        for(int x=0;x<prefMore.length;x++){
           prefMore[x]=true;
        }
        remove=new int[teamInfo.length];    
    }
    //Gets the preffered park for the teams
    public void getPref(){
        for(int x=0;x<prefList.length;x++){
            for(int y=0;y<prefList[x].length;y++){
                prefList[x][y]=(teamInfo.length+prefBase);
            }
        }
        for(int x=0;x<parkList.length;x++){
            int count=0;            
            for(int y=0;y<teamInfo.length;y++){
                
                for(int z=0;z<teamInfo[y].pref.length;z++){
                    if(teamInfo[y].pref[z]==null){
                    }
                    else if(teamInfo[y].pref[z].equalsIgnoreCase(parkList[x])){
                        prefList[x][count]=y;
                        count++;
                    }                    
                }
            }
        }

    }
    //gets the opponents for each match
    public void getOpps(int matchNum){
        int pairNum=(int)Math.ceil(teamInfo.length/2);
        Opp=new String[pairNum][2];
            for(int y=0;y<parkList.length;y++){
                for(int z=0;z<2;z++){
                    for(int a=0;a<2;a++){
                        if(z==0){
                            System.out.println("y"+y);
                            System.out.println("z"+z);
                            System.out.println("a"+a);
                            System.out.println("matches select:"+matches[0][0][0][0]);
                            System.out.println("matches:"+matches[matchNum][y][z][a]);
                            Opp[y][a]=matches[matchNum][y][z][a];
                        }
                        if (z==1){
                            Opp[y+parkList.length][a]=matches[matchNum][y][z][a];
                        }
                    }
                }
            }
            for(int x=0;x<parkList.length;x++){
            }
    }
    
    //randomizes the location with preferances
    public void prefRand3(){
        boolean valid=false;
        boolean valid2=false;
        int randVal;
        Random rand=new Random();            
        for(int x=0;x<2;x++){
            for(int y=0;y<parkList.length;y++){
                if(used[y][x]==false){
                    do{
                        randVal= rand.nextInt(prefList[y].length);
                        if(randVal==prefList[y].length+prefBase){
                            valid =false;
                        }
                        else{
                            if(alreadyHas[randVal]==true){
                                valid=false;
                            }
                            else{
                                valid2=true;

                                alreadyHas[randVal]=true;
                                prefList[y][randVal]=prefList[y].length+prefBase;
                            }
                        }
                    }while(valid2==false);
                    tempSelect[y][x]=teamInfo[randVal].name;
                    used[y][x]=true;
                    for(int w=0;w<Opp.length;w++){
                        if(teamInfo[randVal].name.equalsIgnoreCase(Opp[w][0])||teamInfo[randVal].name.equalsIgnoreCase(Opp[w][0])){
                            alreadyHas[w]=true;
                        }
                    }

                }
                else{
                }
            }                   
        }            
    }
     
   //randomizes the location without preferances
    public void normRand(int matchNum){
        Random rand=new Random();
        int slotNum=0;
        boolean moveOn;
        for(int x=0;x<2;x++){
            for(int y=0;y<parkList.length;y++){
                if(used[y][x]==false){
                    do{
                       tempSelect[y][x]=teamInfo[prefList[x][rand.nextInt(prefList[y].length)]].name; //randomly selecting a team to get the priority
                       for(int z=0;z<teamInfo.length;z++){                       
                            if(tempSelect[y][x].equalsIgnoreCase(teamInfo[z].name)){
                                slotNum=y;
                            }                       
                       }
                       if(alreadyHas[slotNum]==false){
                           moveOn=true;
                           alreadyHas[slotNum]=true;
                       }
                       else{
                           moveOn=false;
                       }
                    }while(moveOn=false);                    
                    used[y][x]=true;
                    String tempTeam="";
                    for(int w=0;w<parkList.length;w++){
                        for(int v=0;v<2;v++){
                            if(tempSelect[y][x].equalsIgnoreCase(matches[matchNum][w][x][v])){
                                tempTeam=matches[matchNum][w][x][v];
                            }
                        }
                    }
                    for(int f=0;f<teamInfo.length;f++){
                        if(tempTeam.equalsIgnoreCase(teamInfo[f].name)){
                            alreadyHas[f]=true;
                        }                   
                    }
                }
                else{
                    continue;
                }
            }
        }        
    }
    
    
    
    //stores the information into matchInfo
    public void storeInfo(int matchNum){
        for(int x=0;x<2;x++){
            for(int y=0;y<parkList.length;y++){
                for(int z=0;z<Opp.length;z++){
                    for(int a=0;a<2;a++){
                        if(tempSelect[y][x].equalsIgnoreCase(Opp[z][a])){                                                
                           MatchMakingSchedule.matchInfo[matchNum][y][x][0]=Opp[z][0];
                           MatchMakingSchedule.matchInfo[matchNum][y][x][1]=Opp[z][1];
                       } 
                    }
                }                
            }
        }    
    }
    
    
    
}
