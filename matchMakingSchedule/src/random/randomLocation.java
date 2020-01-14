/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;
import java.util.Random;
import java.math.*;
/**
 *
 * @author Joshua
 */
public class randomLocation extends Rand{
    /*Test Cases*/
    String[][] tCaseTeam=new String[8][4];
    String[]tCasePark=new String[2];
    String[][][][] tCaseMatches=new String[1][2][2][2];
    String[][] tCaseOpp=new String[4][2];
    public void initVal(){
        //team info
            tCaseTeam[0][0]="Hurbert";
        tCaseTeam[0][1]="park1";
                tCaseTeam[1][0]="Charlie";
        tCaseTeam[0][1]="park1";
        tCaseTeam[0][2]="park2";
                tCaseTeam[2][0]="Hector";
        tCaseTeam[0][1]="park2";
        tCaseTeam[0][2]="park1";
                tCaseTeam[3][0]="Arm3";
                tCaseTeam[4][0]="Test7";
        tCaseTeam[0][2]="park1";
        tCaseTeam[0][3]="park2";
                tCaseTeam[5][0]="Albert";
        tCaseTeam[0][1]="park2";
        tCaseTeam[0][2]="park1";
            tCaseTeam[6][0]="Team4";
        tCaseTeam[0][3]="park2";
                tCaseTeam[7][0]="George";
        tCaseTeam[0][2]="park1";
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
    
    /*          */
    
    
    
    String[] parkList;
    String[][] tempSelect;
    String[][][][] matches;
    String [][][] assigned;
    boolean[] alreadyHas;
    String[][] Opp;
    public void getParks(String[]parks){
        parkList=new String[parks.length];
        parkList=parks;
    }
    public void test(){
        for(int x=0;x<team.length;x++){   
            for(int y=0;y<team[x].length;y++){
                System.out.println(team[x][y]);
            }
            
        }
    }
    public void randomLocation(){
        used=new boolean[parkList.length][2];
        
        tempSelect=new String[parkList.length][2];
        //matches=new String[team.length][parkList.length][2][2];
        alreadyHas=new boolean[team.length];
    }
    public void getMatches(String [][][][] matchInfo){
        //matches=matchInfo;
                matches=new String[matchInfo.length][matchInfo[0].length][matchInfo[0][0].length][matchInfo[0][0][0].length];

        for(int x=0;x<matchInfo.length;x++){
            for(int y=0;y<matchInfo[x].length;y++){
                for(int z=0;z<2;z++){
                    for(int a=0;a<2;a++){
                        System.out.println("matchInfo: "+matchInfo[x][y][z][a]);
                        matches[x][y][z][a]=matchInfo[x][y][z][a];
                    }   
                }   
            }
        }
        System.out.println("matcheInfo0000"+matchInfo[0][0][0][0]);
        System.out.println("matches"+matches[0][0][0][0]);
    }
    public void getPref(){
        //System.out.println("Getpref");

        prefList=new String[parkList.length][team.length];
        for(int x=0;x<prefList.length;x++){
            for(int y=0;y<prefList[x].length;y++){
                prefList[x][y]="-1";
            }
        }
        //System.out.println(team[0][3]==null);
        
        
        for(int x=0;x<parkList.length;x++){
            int count=0;            
            for(int y=0;y<team.length;y++){
                
                for(int z=0;z<team[y].length;z++){
                    if(team[y][z]==null){
                        //System.out.println(team[y][z]==null);
                        //System.out.println("Skipping");
                    }
                    else if(team[y][z].equalsIgnoreCase(parkList[x])){
                     // System.out.println(team[y][0]);
                        prefList[x][count]=team[y][0];
                       // System.out.println(prefList[x][count]);
                        count++;
                       /* System.out.println(parkList[x]);
                        System.out.println("count: "+count);
                        System.out.println();  */
                    }                    
                }
            }
        }
        /*for(int x=0;x<prefList.length;x++){
            System.out.println(prefList.length);
            System.out.println("prefList");
            System.out.println(parkList[x]);
            for(int y=0;y<prefList[x].length;y++){

                System.out.println(prefList[x][y]);
            }
        }*/
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
                        /*System.out.println(tempSelect[x][z]);
                        System.out.println(team[v][0]);*/
                        if(tempSelect[x][z]!=null&&tempSelect[x][z].isEmpty()){
                            if(tempSelect[x][z].equalsIgnoreCase(team[v][0])){
                            slotNum=v;
                            }                            
                        }
                        else{
                            break;
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
                    System.out.println(rand.nextInt(prefList[x].length));
                    for(int y=0;y<prefList[x].length;y++){
                        System.out.println(prefList[x][y]);
                    }
                   System.out.println(prefList[x][rand.nextInt(prefList[x].length)]);
                   tempSelect[x][z]=prefList[x][rand.nextInt(prefList[x].length)]; //randomly selecting a team to get the priority
                   for(int y=0;y<team.length;y++){  
                       System.out.println(tempSelect[x][z]);
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
    
    
    public void getOpps(int matchNum){
        System.out.println("matches"+matches[0][0][0][0]);
        int pairNum=(int)Math.ceil(team.length/2);
        Opp=new String[pairNum][2];
       // for(int x=0;x<4;x++){
            for(int y=0;y<parkList.length;y++){
                for(int z=0;z<2;z++){
                    for(int a=0;a<2;a++){
                        System.out.println("storing opponents");
                        if(z==0){
                            System.out.println("y"+y);
                            System.out.println("z"+z);
                            System.out.println("a"+a);
                            System.out.println("matches select:"+matches[0][0][0][0]);
                            System.out.println("matches:"+matches[matchNum][y][z][a]);
                            Opp[y][a]=matches[matchNum][y][z][a];
                            System.out.println("opp:"+Opp[y][a]);
                        }
                        if (z==1){
                            System.out.println("matches:"+matches[matchNum][y][z][a]);
                            Opp[y+parkList.length][a]=matches[matchNum][y][z][a];
                            System.out.println("opp:"+Opp[y+parkList.length][a]);
                        }
                    }
                }
            }
            for(int x=0;x<parkList.length;x++){
                System.out.println("opp1: "+Opp[x][0]);
                System.out.println("opp2: "+Opp[x][1]);
            }
            
      //  }
    }
    
    public void storeInfo(int matchNum){
        System.out.println("storing information");
        for(int x=0;x<2;x++){
            for(int y=0;y<parkList.length;y++){
                for(int z=0;z<Opp.length;){
                    for(int a=0;a<2;a++){
                        System.out.println("temp: "+tempSelect[y][x]);
                        System.out.println("opponent: "+Opp[z][a]);
                       if(tempSelect[y][x].equalsIgnoreCase(Opp[z][a])){
                           
                           matches[matchNum][y][x][0]=Opp[z][0];
                           matches[matchNum][y][x][1]=Opp[z][1];
                           System.out.println("parks and opp");
                           System.out.println(matches[matchNum][y][x][0]=Opp[z][0]);
                           System.out.println(matches[matchNum][y][x][1]=Opp[z][1]);
                       }
                    }
                }
                
            }
        }
        
    }
    
    
    
}
//test hello this is working code so why is it not being pushed