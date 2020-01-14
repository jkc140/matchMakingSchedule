/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

/**
 *
 * @author Joshua
 */
public class Rand {
    String[][] team;
    boolean pref;
    boolean[][]used;
    String[][]prefList;
    String[]options;
    
    public void getTeamInfo(String[][] teamInfo){
        /*team=new String[teamInfo.length][teamInfo[0].length];
        for(int x=0;x<teamInfo.length;x++){
            for(int y=0;y<teamInfo[x].length;y++){
                team[x][y]=teamInfo[x][y];
            }
        something to create a pull request
        }*/
        team=teamInfo;
    }
    public void getPref(){        
    }
    public void prefRand(){
    }
    public void normRand(){        
    }
}
