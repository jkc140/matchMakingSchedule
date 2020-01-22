/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingschedule;

/**
 *
 * @author S331474817
 */
public class teams {
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joshua
 */
    public String name;
    public String[] pref;
    public String matchTime;
    public String location;
    public String opponent;
    public String[][] match;
    public String opponentPlayed[][];
    public boolean prevOpp[];
    public int teamSlotNum;

    
    public void getName(String[][] fileInfo,int teamNum){
        name=fileInfo[teamNum][0];
    }
    public void getPref(String[][] fileInfo,int teamNum){
        pref=new String[fileInfo[teamNum].length-1];
        for(int x=1;x<=teamNum;x++){
            pref[x-1]=fileInfo[teamNum][x];
        }
    }

    public void matchInit(int TEMP){
        match=new String[TEMP][4];
    }
    public void getPrevPlayed(int slotNum){
        //prevOpp[];
    }
    public void prefInit(int max){
        pref=new String[max];
    }
    public void initVal(int teamNum/*,int slotNum*/){
        prevOpp=new boolean[teamNum-1];
        for(int x=0;x<prevOpp.length;x++){
            prevOpp[x]=false;
        }
        //teamSlotNum=slotNum;
    }
    
    public void reset(){
        int count=0;
        for(int x=0;x<prevOpp.length;x++){
            if(prevOpp[x]==true){
                count++;
            }
            else{
                count=0;
            }
        }
        if(count==prevOpp.length){
            for(int x=0;x<prevOpp.length;x++){
                prevOpp[x]=false;
            }
        }
    }
}