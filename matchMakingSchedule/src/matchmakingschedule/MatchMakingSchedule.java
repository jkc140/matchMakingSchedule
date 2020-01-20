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
        
        teams[] test=new teams[tCaseTeam.length];

        tCaseInitVal();
        for(int x=0;x<tCaseTeam.length;x++){
            test[x]=new teams();
            test[x].name=tCaseTeam[x][0];   
            test[x].initVal(tCaseTeam.length/*,x*/);
        }
        for(int x=0;x<tCaseTeam.length;x++){
            int count=0;
            test[x].prefInit(tCaseTeam[x].length);
            for(int y=1;y<tCaseTeam[x].length;y++){                
                //System.out.println(tCaseTeam[x][y]);
                if(tCaseTeam[x][y]!=null){
                    
                 /*   System.out.println("checking team name "+test[x].name);
                System.out.println("initializing the pref list");
                    
                    /*System.out.println("test pref list length"+test[x].pref.length);
                    System.out.println("count value 1 (before conversion): "+count);
                    System.out.println("current Pref in tCase array(before conversion): "+tCaseTeam[x][y]);
                    System.out.println("current value in team class pref list (before conversion)"+test[x].pref[count]);
                    System.out.println("checking the y value (before conversion): "+y);
                    System.out.println("checking the x value (before conversion): "+x);
                    System.out.println("assigning value");*/
                    test[x].pref[count]=tCaseTeam[x][y];
                    /*System.out.println("value assigned");
                    System.out.println("checking tCase array value (after conversion):"+tCaseTeam[x][y]);
                    System.out.println("checking the y value (after conversion): "+y);
                    System.out.println("checking the x value (afer conversion): "+x);
                    System.out.println("current count value (after conversion) "+(count));
                    System.out.println("current value in team class pref list (after conversion) "+test[x].pref[count]);
                   */count++;
                    /*System.out.println("chekcing count value after adding one to count "+(count));
                    System.out.println("checking value in pref list at 0 "+test[0].pref[0]);
                    System.out.println();*/
                }
                else{
                   // System.out.println("null break");
                    
                }
                
                    

                //}
                
            }
            
        }
        /*for(int y=0;y<tCaseTeam.length;y++){
            System.out.println("prefs for team "+test[y].name);
            for(int x=0;x<test[y].pref.length;x++){
            
            //if(test[2].pref[x]!=null&&test[2].pref[x].isEmpty()){
                    System.out.println(test[y].pref[x]);  
               // }
          
            }
        }*/
        
        
        randomLocation randLoc=new randomLocation();
        randomOpponents randOpp=new randomOpponents();
        randomTime randTime=new randomTime();
        randOpp.getTeams(test);
        randOpp.initVal(tCasePark.length);
        randOpp.getMatches(tCaseMatches);
        randOpp.normRand(0);
        for(int x=0;x<tCasePark.length;x++){
            for(int y=0;y<2;y++){
                for(int z=0;z<2;z++){
                    System.out.println(tCaseMatches[0][x][y][z]);
                }
            }
        }
        randLoc.getParks(tCasePark);
        randLoc.initVal(8, test);
        
        
        randLoc.getMatches(tCaseMatches);
        randLoc.getOpps(0);
        
        
        randLoc.getPref();
        /*randLoc.prefLeft();
        randLoc.prefSort();*/
        randLoc.prefRand2(0);
        //randLoc.prefSelect();
        randLoc.normRand(0);
        randLoc.storeInfo(0);
        randTime.getInfo(tCasePark, test, tCaseMatches);
        randTime.getOpps(0);
        randTime.normRand(0);
       /* System.out.println("results");
        for(int x=0;)*/
        //randLoc.test();
       /* randLoc.prefRand(0);
        randLoc.storeInfo(0);
        // TODO code application logic here
     /*   demo d=new demo();
        d.getInfo();
        d.lineSorting();
        /*d.randOpp();
        d.randLoc();
        d.randTime();*/
    }
    
    
    
}
