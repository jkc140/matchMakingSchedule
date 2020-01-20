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
    teams[]teams;    
    int numTeam=8;
        boolean[] hasTeam;
        boolean valid=false;
        int opp;
        int opp2;
    
    public void getTeams(teams[] teamInfo){
        teamNum=teamInfo.length;
        teams =new teams[teamInfo.length];
        for(int x=0;x<teamInfo.length;x++){
            teams[x]=new teams();
            teams[x]=teamInfo[x];            
        }
        teams=teamInfo;
        alreadyPlayed=new boolean[teamNum][teamNum-1];
        for(int x=0;x<teamInfo.length;x++){
            alreadyPlayed[x]=teamInfo[x].prevOpp;
        }
        
    }
    public void getMatches(String[][][][] matchInfo){
        matches=matchInfo;
    }
    public void initVal(int pNum){
        hasTeam=new boolean[teamNum];
        parkNum=pNum;
    }
    public void normRand(int matchNum){
        Random rand=new Random();
        //System.out.println("hello");
        for(int x=0;x<2;x++){
           // System.out.println("setting teams for time "+x);
           // System.out.println("parkNum" +parkNum);
            for(int y=0;y<parkNum;y++){
           //     System.out.println("Helo");
           //     System.out.println("setting teams for park "+y);
                do{
            //        System.out.println("selecting first team");
                    opp=rand.nextInt(teamNum);
            //        System.out.println("opp: "+opp);
                    if(hasTeam[opp]==true){
                        valid=false;
            //             System.out.println("team already chosed");
                    }                     
                    else{
                        valid=true;
                        hasTeam[opp]=true;
            //            System.out.println("team chosen "+opp);
                    }                    
                }while(valid==false);
            //    System.out.println("assinging 1 team to match making");
                MatchMakingSchedule.tCaseMatches[matchNum][x][y][0]=teams[opp].name;
                do{
            //        System.out.println("selecting second team");
                    opp2=rand.nextInt(teamNum);
            //        System.out.println("opp2: "+opp2);
                    if(hasTeam[opp2]==true){
                        valid=false;
            //            System.out.println("team already chosed");
                    }                    
                    else{
                        valid=true;
                        hasTeam[opp2]=true;
            //            System.out.println("team chosen "+opp2);
                    }            
            //        System.out.println("assinging teams to already played");
                    for(int z=0;z<teamNum-1;z++){
             //           System.out.println(alreadyPlayed[opp2][z]);
                        if(alreadyPlayed[opp2][z]==true){
                            valid=false;
                        }
                        else if(valid==true){
                            valid=true;
                            //alreadyPlayed[opp][z]=true;
            /*                System.out.println();
                            System.out.println("opp2: "+opp2);
                            System.out.println("opp: "+opp);
            */                if(opp2<=opp){
            //                    System.out.println("opp2<opp");
                                teams[opp].prevOpp[opp2]=true;
                            }
                            else if(opp2>opp){
            //                    System.out.println("opp2>opp");
                                teams[opp].prevOpp[opp2-1]=true;
                            }
                            
                            if(opp<=opp2){
            //                    System.out.println("opp<opp2");
                                teams[opp2].prevOpp[opp]=true;
                            }
                            else if(opp>opp2){
            //                    System.out.println("opp>opp2");
                                teams[opp2].prevOpp[opp-1]=true;
                            }
                            break;
                            
                        }
                    }
                }while(valid==false);
                    
            //    System.out.println("assinging 2 team to matches");
                MatchMakingSchedule.tCaseMatches[matchNum][x][y][1]=teams[opp2].name;                
            }
        }
    }

}
