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

    public static String[][][][]matchInfo;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args) {
        //gets the information from the file and stores it in the information
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

        //ranomizes the information and stores it in a file
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
    }    
}
