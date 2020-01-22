/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;
import matchmakingschedule.*;
import java.util.Random;

/**
 *
 * @author Joshua
 */
public class randomTime {
    int parkNum;
    teams[] teamInfo;
    String[] parkList;
    String[][][][] matches;
    String[][] Opp;
    int[][] oppTime;
    
    //getting information
    public void getInfo(String[] parkInfo,teams[] teams,String[][][][] matchInfo){
        parkNum=parkInfo.length;
        parkList=new String[parkNum];        
        for(int x=0;x<parkNum;x++){
            parkList[x]=parkInfo[x];
        }
        teamInfo=new teams[teams.length];
        for(int x=0;x<teamInfo.length;x++){
            teamInfo[x]=new teams();
            teamInfo[x]=teams[x];
        }
        matches=matchInfo;
        oppTime=new int[2][parkNum];
    }
    
    //gets the opponents for each park
    public void getOpps(int matchNum){
        int pairNum=(int)Math.ceil(teamInfo.length/2);
        Opp=new String[pairNum][2];
            for(int y=0;y<parkList.length;y++){
                for(int z=0;z<2;z++){
                    for(int a=0;a<2;a++){
                        if(z==0){
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
    
    //randonly assign them a time
    public void normRand(int matchNum){
        String[]tempTeam=new String[2];
        String[] changeTeam=new String[2];
        Random rand=new Random();
        for(int x=0;x<parkList.length;x++){
            int randTeam=rand.nextInt(2);
            int randTime=rand.nextInt(2);
            if(randTeam==0){
                changeTeam[0]=matches[matchNum][x][0][0];
                changeTeam[1]=matches[matchNum][x][0][1];
                tempTeam[0]=matches[matchNum][x][1][0];
                tempTeam[1]=matches[matchNum][x][1][1];
                
                if(randTime==0){
                    MatchMakingSchedule.matchInfo[matchNum][x][0][0]=changeTeam[0];
                    MatchMakingSchedule.matchInfo[matchNum][x][0][1]=changeTeam[1];        
                    MatchMakingSchedule.matchInfo[matchNum][x][1][0]=tempTeam[0];
                    MatchMakingSchedule.matchInfo[matchNum][x][1][1]=tempTeam[1]; 
                }
                else if(randTime==1){
                    MatchMakingSchedule.matchInfo[matchNum][x][0][0]=tempTeam[0];
                    MatchMakingSchedule.matchInfo[matchNum][x][0][1]=tempTeam[1];        
                    MatchMakingSchedule.matchInfo[matchNum][x][1][0]=changeTeam[0];
                    MatchMakingSchedule.matchInfo[matchNum][x][1][1]=changeTeam[1]; 
                }                
            }
            else if(randTeam==1){
                changeTeam[0]=matches[matchNum][x][1][0];
                changeTeam[1]=matches[matchNum][x][1][1];
                tempTeam[0]=matches[matchNum][x][0][0];
                tempTeam[1]=matches[matchNum][x][0][1];
                
                if(randTime==0){
                    MatchMakingSchedule.matchInfo[matchNum][x][0][0]=changeTeam[0];
                    MatchMakingSchedule.matchInfo[matchNum][x][0][1]=changeTeam[1];        
                    MatchMakingSchedule.matchInfo[matchNum][x][1][0]=tempTeam[0];
                    MatchMakingSchedule.matchInfo[matchNum][x][1][1]=tempTeam[1]; 
                }
                else if(randTime==1){
                    MatchMakingSchedule.matchInfo[matchNum][x][0][0]=tempTeam[0];
                    MatchMakingSchedule.matchInfo[matchNum][x][0][1]=tempTeam[1];        
                    MatchMakingSchedule.matchInfo[matchNum][x][1][0]=changeTeam[0];
                    MatchMakingSchedule.matchInfo[matchNum][x][1][1]=changeTeam[1]; 
                }            
            }
        }
        for(int x=0;x<parkList.length;x++){
            for(int y=0;y<2;y++){
                System.out.print(matches[matchNum][x][y][0]);
                System.out.print(",");
                System.out.println(matches[matchNum][x][y][1]);
            }
        }
    }
}
