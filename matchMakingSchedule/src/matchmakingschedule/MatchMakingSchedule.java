/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingschedule;
import random.*;

/**
 *
 * @author Joshua
 */
public class MatchMakingSchedule {
    /*teamInfo Cases*/
    public static String[][] tCaseTeam=new String[8][4];
    public static String[]tCasePark=new String[2];
    public static String[][][][] tCaseMatches=new String[1][2][2][2];
    public static String[][] tCaseOpp=new String[4][2];
    public static String[][][][]matchInfo;
    public static void tCaseInitVal(){
        //team info
            tCaseTeam[0][0]="Hurbert";
        tCaseTeam[0][1]="park1";
                tCaseTeam[1][0]="Charlie";
        tCaseTeam[1][1]="park1";
        tCaseTeam[1][2]="park2";
                tCaseTeam[2][0]="Hector";
        tCaseTeam[2][1]="park2";
        tCaseTeam[2][2]="park1";
                tCaseTeam[3][0]="Arm3";
                tCaseTeam[4][0]="teamInfo7";
        tCaseTeam[4][2]="park1";
        tCaseTeam[4][3]="park2";
                tCaseTeam[5][0]="Albert";
        tCaseTeam[5][1]="park2";
        tCaseTeam[5][2]="park1";
            tCaseTeam[6][0]="Team4";
        tCaseTeam[6][3]="park2";
                tCaseTeam[7][0]="George";
        tCaseTeam[7][2]="park1";
        //parkInfo
        tCasePark[0]="park1";
        tCasePark[1]="park2";
        /*
        tCaseOpp[0][0]=tCaseTeam[3][0];
        tCaseOpp[0][1]=tCaseTeam[4][0];
        tCaseOpp[1][0]=tCaseTeam[6][0];
        tCaseOpp[1][1]=tCaseTeam[2][0];
        tCaseOpp[2][0]=tCaseTeam[0][0];
        tCaseOpp[2][1]=tCaseTeam[1][0];
        tCaseOpp[3][0]=tCaseTeam[5][0];
        tCaseOpp[4][1]=tCaseTeam[7][0];*/
        //tCaseMatches[0][0][0][0]="Hurbert";
        tCaseMatches[0][0][0][0]=tCaseTeam[3][0];
        tCaseMatches[0][0][0][1]=tCaseTeam[4][0];
        tCaseMatches[0][0][1][0]=tCaseTeam[6][0];
        tCaseMatches[0][0][1][1]=tCaseTeam[2][0];
        tCaseMatches[0][1][0][0]=tCaseTeam[0][0];
        tCaseMatches[0][1][0][1]=tCaseTeam[1][0];
        tCaseMatches[0][1][1][0]=tCaseTeam[5][0];
        tCaseMatches[0][1][1][1]=tCaseTeam[7][0];
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args) {
        
        fileReader fRead=new fileReader();
        
        fRead.getName(args);
        fRead.fileRead();        
        fRead.sort();
        teams[] teamInfo=new teams[fRead.numTeam];
        matchInfo=new String[Integer.valueOf(fRead.matchNum[1])][fRead.parkInfo.length][2][2];
        
        for(int x=0;x<teamInfo.length;x++){
            System.out.println("storing info in teams array");
            teamInfo[x]=new teams();
            teamInfo[x].name=fRead.teamInfo[x][0];
            System.out.println(teamInfo[x].name);
            teamInfo[x].initVal(teamInfo.length);
       }
        for(int x=0;x<teamInfo.length;x++){
            int count=0;
            teamInfo[x].prefInit(fRead.teamInfo[x].length);
            for(int y=1;y<fRead.teamInfo[x].length;y++){                
                if(fRead.teamInfo[x][y]!=null){

                    teamInfo[x].pref[count]=fRead.teamInfo[x][y];
                    count++;

                }
                else{
                    
                }

                
            }
            
        }

        
        for(int x=0;x<Integer.valueOf(fRead.matchNum[1]);x++){
            randomLocation randLoc=new randomLocation();
        randomOpponents randOpp=new randomOpponents();
        randomTime randTime=new randomTime();
        randOpp.getTeams(teamInfo);        
        randOpp.initVal(fRead.parkInfo.length);
        randOpp.getMatches(matchInfo);
        randOpp.normRand(x);    
        for(int y=0;y<teamInfo.length;y++){
            teamInfo[x].reset();
        }
        randLoc.getParks(fRead.parkInfo);
        randLoc.initVal(teamInfo.length, teamInfo);
        randLoc.getMatches(matchInfo);
        randLoc.getOpps(x);
        randLoc.getPref();
        randLoc.prefRand3();
        randLoc.normRand(x);
        randLoc.storeInfo(x);
        randTime.getInfo(fRead.parkInfo, teamInfo, matchInfo);
        randTime.getOpps(x);
        randTime.normRand(x);
        fileStore fStore=new fileStore();          
        fStore.storeInfo(fRead.parkInfo.length, matchInfo, fRead.parkInfo);
        }
        
     
    /*
    //she looking at planning
    //code itself
    //process
        //comments    
    */
        
    }    
}
