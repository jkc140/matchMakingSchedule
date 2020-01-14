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
    /*Test Cases*/
    public static String[][] tCaseTeam=new String[8][4];
    public static String[]tCasePark=new String[2];
    public static String[][][][] tCaseMatches=new String[1][2][2][2];
    public static String[][] tCaseOpp=new String[4][2];
    public static void initVal(){
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
                tCaseTeam[4][0]="Test7";
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
    public static void main(String[] args) {
        initVal();
        /*for(int x=0;x<tCaseTeam.length;x++){
            for(int y=0;y<tCaseTeam[x].length;y++){
                //System.out.println(tCaseTeam[x][y]);
                if(tCaseTeam[x][y]==null){
                    System.out.println(tCaseTeam[x][y]==null);
                    tCaseTeam[x][y]="-1";
                }
                
            }
        }*/
        /*for(int x=0;x<tCaseTeam.length;x++){
            for(int y=0;y<tCaseTeam[x].length;y++){
                //System.out.println(tCaseTeam[x][y]);
                
                    System.out.println(tCaseTeam[x][y]);
                 
                
            }
        }*/
        //System.out.println(tCaseTeam[0][0]);
        
        randomLocation randLoc=new randomLocation();
        randLoc.getParks(tCasePark);
        randLoc.getTeamInfo(tCaseTeam);
        randLoc.getMatches(tCaseMatches);
        randLoc.randomLocation();
        randLoc.getOpps(0);
        randLoc.getPref();
        //randLoc.test();
        randLoc.prefRand(0);
        randLoc.normRand(0);
        //randLoc.storeInfo(0);
        // TODO code application logic here
     /*   demo d=new demo();
        d.getInfo();
        d.lineSorting();
        /*d.randOpp();
        d.randLoc();
        d.randTime();*/
    }
    
    
    
}
