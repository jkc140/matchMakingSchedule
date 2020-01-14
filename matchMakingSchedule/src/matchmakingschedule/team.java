/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingSchedule;

/**
 *
 * @author Joshua
 */
public class team {
    public String name;
    public String[] pref;
    public String matchTime;
    public String location;
    public String opponent;
    public String[][] match;
    public String opponentPlayed[][];
    
    
    public void getName(String[][] fileInfo,int teamNum){
        name=fileInfo[teamNum][0];
    }
    public void getPref(String[][] fileInfo,int teamNum){
        pref=new String[fileInfo[teamNum].length-1];
        for(int x=1;x<=teamNum;x++){
            pref[x-1]=fileInfo[teamNum][x];
        }
    }
    public void getOpponent(){
        
    }
    public void getTime(){
        
    }
    public void getLoc(){
        
    }
    public void matchInit(int TEMP){
        match=new String[TEMP][4];
    }
}