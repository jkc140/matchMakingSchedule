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
public class randomOpponents {
    String[][][][] matches;
    boolean[][] alreadyPlayed;
    int parkNum;
    int teamNum;
    String[][] teams;    
    int numTeam=8;
        boolean[] hasTeam;
        boolean valid=false;
        int opp;
        int opp2;
    
    public void getTeams(teams[] teamInfo){
        teamNum=teamInfo.length;
        teams=teamInfo;
        alreadyPlayed=new boolean[teamNum][teamNum-1];
        for(int x=0;x<teamInfo.length;x++){
            alreadyPlayed[x]=teamInfo[x].prevOpp;
        }
        
    }
    public void getMatches(String[][][][] matchInfo){
        matches=matchInfo;
    }
    public void initVal(){
        hasTeam=new boolean[numTeam];
    }
    public void normRand(int matchNum){
        Random rand=new Random();
        for(int x=0;x<2;x++){
            for(int y=0;y<parkNum;y++){
                do{
                    opp=rand.nextInt(teamNum);
                    if(hasTeam[opp]==true){
                        valid=false;
                    }                    
                    else{
                        valid=true;
                        hasTeam[opp]=true;
                    }                    
                }while(valid==false);
                matches[matchNum][x][y][0]=teams[opp][0];
                do{
                    opp2=rand.nextInt(teamNum);
                    if(hasTeam[opp2]==true){
                        valid=false;
                    }                    
                    else{
                        valid=true;
                        hasTeam[opp2]=true;
                    }            
                    for(int z=0;z<teamNum-1;z++){
                        if(alreadyPlayed[opp2][z]==true){
                            valid=false;
                        }
                        else{
                            valid=true;
                            alreadyPlayed[opp][z]=true;
                            alreadyPlayed[opp2][opp-1]=true;
                            break;
                        }
                    }
                }while(valid==false);
                matches[matchNum][x][y][1]=teams[opp2][0];
                
            }
        }
    }
    public void storeInfo(){
        
    }
}
