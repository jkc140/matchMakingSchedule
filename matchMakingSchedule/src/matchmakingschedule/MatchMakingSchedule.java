/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakingschedule;

/**
 *
 * @author Joshua
 */
public class MatchMakingSchedule {
    public static String[][][] matchInfo;
    //[a][b][c] a<-- match number, b is location c is time ??
    public static String[][] teamInfo;
    // [a][b] a<-- team name (length is number of teams, b<--preferences number of options
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fileReader fRead=new fileReader();
        //fRead.getName(); //NEED TO GET THE LINE FROM THE USER WHEN USING GUI/TXT FIELD
        fRead.fileRead();
        fRead.sort();
        teamInfo=fRead.teamInfo;
        // TODO code application logic here
    }
    
}
