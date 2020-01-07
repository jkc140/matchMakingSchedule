/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;
import java.util.Random;
/**
 *
 * @author Joshua
 */
public class randomLocation extends Rand{
    
    String[] parkList;
    String[][] tempSelect;
    String[][][][] matches;
    String [][][] assigned;
    boolean[] alreadyHas;
    public void getParks(String[]parks){
        parkList=new String[parks.length];
        parkList=parks;
    }
    
    public void randomLocation(){
        used=new boolean[parkList.length][2];
        prefList=new String[parkList.length][team.length];
        tempSelect=new String[parkList.length][2];
        matches=new String[team.length][parkList.length][2][2];
        alreadyHas=new boolean[team.length];
    }
    public void getMatches(String [][][][] matchInfo){
        matches=matchInfo;
    }
    public void getPref(){
        for(int x=0;x<parkList.length;x++){
            int count=0;            
            for(int y=0;y<team.length;y++){
                for(int z=0;z<team[y].length;z++){
                    if(team[y][z].equalsIgnoreCase(parkList[x])){
                        prefList[x][count]=team[y][0];
                    }
                }
            }
        }
    }
    public void prefRand(int matchNum){
        Random rand=new Random();
        int slotNum=0;
        boolean moveOn=false;
        String[][] tempPref=prefList;
        boolean[][] prefUsed = new boolean[parkList.length][2];
        boolean allPrefUsed=false;
        do{
        for(int z=0;z<2;z++){ //Setting the team pref
            for(int x=0;x<parkList.length;x++){
               // for(int y=0;y<prefList[x].length;y++){
                int anyMore=0; //anymore teams having pref for this available
                for(int w=0;w<prefList[x].length;w++){
                    for(int v=0;v<team.length;v++){                       
                        if(tempSelect[x][z].equalsIgnoreCase(team[v][0])){
                            slotNum=v;
                        }
                    }
                    if(alreadyHas[w]==true){
                        anyMore++;
                    }                    
                    else{
                        anyMore=0;
                    }                   
                }
                if(anyMore!=0){
                    moveOn=true; //is this needed have to test cause technically the break would skip over the do loop
                    break;                }
                else if(prefList[x].length==0){
                      moveOn=true;
                      break;
                }                
                do{
                   tempSelect[x][z]=prefList[x][rand.nextInt(prefList[x].length)]; //randomly selecting a team to get the priority
                   for(int y=0;y<team.length;y++){                       
                        if(tempSelect[x][z].equalsIgnoreCase(team[y][0])){
                            slotNum=y;
                        }
                   }
                   if(alreadyHas[slotNum]==false){
                       moveOn=true;
                       alreadyHas[slotNum]=true;
                   }
                   else{
                       moveOn=false;
                   }
                }while(moveOn=false);
                //}
                used[x][z]=true; //does this have to be moved into the if(alreadyhas==false) cause it may mess up the thing as it would be assigning a value to alreadyHas when it does not actually have to be it
                prefUsed[x][z]=true;
            }
        }
        int loc1=0;
        int loc2=0;
        int t1=0,t2=0;
        for(int z=0;z<2;z++){ //Setting the team pref
            for(int x=0;x<parkList.length;x++){
                for(int w=0;w<tempSelect.length;w++){
                    if(tempSelect[w][z]==matches[x][matchNum][z][0]){
                        loc1=w;
                        t1=z;
                    }
                    else if(tempSelect[w][z]==matches[x][matchNum][z][1]){
                        loc2=w;
                        t2=z;
                    }
                    
                    
                }
            }
        }
        
        if(loc1!=0&&loc2!=0){
           int num=rand.nextInt(2);
           if(num==0){
               assigned[loc1][t1][0]=tempSelect[loc1][t1];
               assigned[loc1][t1][1]=tempSelect[loc2][t2];
               used[loc2][t2]=false;
               prefUsed[loc2][t2]=false;
               
           }
           else{
               assigned[loc2][t2][0]=tempSelect[loc1][t1];
               assigned[loc2][t2][1]=tempSelect[loc2][t2];
               used[loc1][t1]=false;
               prefUsed[loc1][t1]=false;

                
           }
           
        }
        else if(loc1!=0&&loc2==0){
            assigned[loc1][t1][0]=tempSelect[loc1][t1];
            assigned[loc1][t1][1]=tempSelect[loc2][t2];
            for(int y=0;y<team.length;y++){
                    if(tempSelect[loc2][t2].equalsIgnoreCase(team[y][0])){
                        alreadyHas[y]=true;
                    }
                }
        }
        else if(loc1==0&&loc2!=0){
            assigned[loc2][t2][0]=tempSelect[loc1][t1];
            assigned[loc2][t2][1]=tempSelect[loc2][t2];
            for(int y=0;y<team.length;y++){
                    if(tempSelect[loc1][t1].equalsIgnoreCase(team[y][0])){
                        alreadyHas[y]=true;
                    }
                }
        }
        int prefCheck=0;
        for(int x=0;x<2;x++){
            for(int y=0;x<parkList.length;x++){
                if(prefUsed[y][x]==true){
                    prefCheck++;
                }
                else{
                    prefCheck=0;
                    break;
                }
            }
        }
        if(prefCheck!=0){//may have to change it to be prefCheck==parkList.length
            allPrefUsed=true;
        }
        else{
            allPrefUsed=false;
        }
            
        }while(allPrefUsed==false);    
        
        
    }

    public void normRand(int matchNum){
        //assigning teams that still need a team
        Random rand=new Random();
        int slotNum=0;
        boolean moveOn;
        //randomly assigning teams to parks that don't have a location
        for(int x=0;x<2;x++){
            for(int y=0;y<parkList.length;y++){
                if(used[y][x]==false){
                    do{
                   tempSelect[y][x]=prefList[x][rand.nextInt(prefList[y].length)]; //randomly selecting a team to get the priority
                   for(int z=0;z<team.length;z++){                       
                        if(tempSelect[y][x].equalsIgnoreCase(team[z][0])){
                            slotNum=y;
                        }                       
                   }
                   if(alreadyHas[slotNum]==false){
                       moveOn=true;
                       alreadyHas[slotNum]=true;
                   }
                   else{
                       moveOn=false;
                   }
                }while(moveOn=false);
                //}
                used[y][x]=true;
                String tempTeam="";
                for(int w=0;w<parkList.length;w++){
                    for(int v=0;v<2;v++){
                        if(tempSelect[y][x].equalsIgnoreCase(matches[matchNum][w][x][v])){
                            tempTeam=matches[matchNum][w][x][v];
                        }
                    }
                    
                }
                for(int f=0;f<team.length;f++){
                    if(tempTeam.equalsIgnoreCase(team[f][0])){
                        alreadyHas[f]=true;
                    }                     
                   
                }
                //HAVE TO MAKE IT SO THAT THE OPPONENT WILL ALSO HAVE ALREADY HAS SET AS TRUE
                }
                else{
                    continue;
                }
            }
        }        
    }
}
