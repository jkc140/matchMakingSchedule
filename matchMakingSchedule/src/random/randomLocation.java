/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;
import java.util.Random;
import matchmakingschedule.*;
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
    String[][] Opp;
    teams[]teamInfo;
    int [][] prefList;
    int prefBase=10;
    boolean prefMore[];
    int remove[];

    public void getParks(String[]parks){
        parkList=new String[parks.length];
        parkList=parks;
    }
    public void test(){
        for(int x=0;x<teamInfo.length;x++){   
            for(int y=0;y<team[x].length;y++){
   //             System.out.println(team[x][y]);
            }
            
        }
    }

    public void getMatches(String [][][][] matchInfo){
        //matches=matchInfo;
                matches=new String[matchInfo.length][matchInfo[0].length][matchInfo[0][0].length][matchInfo[0][0][0].length];

        for(int x=0;x<matchInfo.length;x++){
            for(int y=0;y<matchInfo[x].length;y++){
                for(int z=0;z<2;z++){
                    for(int a=0;a<2;a++){
     //                   System.out.println("matchInfo: "+matchInfo[x][y][z][a]);
                        matches[x][y][z][a]=matchInfo[x][y][z][a];
                    }   
                }   
            }
        }
     /*   System.out.println("matcheInfo0000"+matchInfo[0][0][0][0]);
        System.out.println("matches"+matches[0][0][0][0]);
    */}
    public void initVal(int teamNum,teams[] impTeamInfo){
        teamInfo=new teams[teamNum];
        assigned=new String[parkList.length][2][2];
        alreadyHas=new boolean[teamInfo.length];
        used=new boolean[parkList.length][2];        
        tempSelect=new String[parkList.length][2];
        prefList=new int[parkList.length][teamInfo.length];
        
        for(int x=0;x<teamInfo.length;x++){
            teamInfo[x]=new teams();
            teamInfo[x]=impTeamInfo[x];
        }
        for(int x=0;x<alreadyHas.length;x++){
            alreadyHas[x]=false;
        }
        
        /*for(int x=0;x<tempSelect.length;x++){
            for(int y=0;y<2;y++){
                tempSelect[x][y]="-5";
            }
        }*/
     prefMore=new boolean[prefList.length];
     for(int x=0;x<prefMore.length;x++){
        prefMore[x]=true;
     }
     remove=new int[teamInfo.length];
     
        
    }
    //Gets the preffered park for the teams
    public void getPref(){
        //System.out.println("Getpref");

        
        for(int x=0;x<prefList.length;x++){
            for(int y=0;y<prefList[x].length;y++){
                prefList[x][y]=(teamInfo.length+prefBase);
            }
        }
        //System.out.println(team[0][3]==null);
        
      //  System.out.println("putting in pref");
        for(int x=0;x<parkList.length;x++){
            int count=0;            
            for(int y=0;y<teamInfo.length;y++){
                
                for(int z=0;z<teamInfo[y].pref.length;z++){
                    if(teamInfo[y].pref[z]==null){

                    }
                    else if(teamInfo[y].pref[z].equalsIgnoreCase(parkList[x])){
            //            System.out.println("y: "+y);
                        prefList[x][count]=y;
                        count++;

                    }                    
                }
            }
        }
        for(int x=0;x<prefList.length;x++){
            //System.out.println(prefList.length);
           /* System.out.println("prefList");
            System.out.println(parkList[x]);
          */  for(int y=0;y<prefList[x].length;y++){

             //   System.out.println(prefList[x][y]);
            }
        }
    }
    public void getOpps(int matchNum){
    //    System.out.println("matches"+matches[0][0][0][0]);
        int pairNum=(int)Math.ceil(teamInfo.length/2);
        Opp=new String[pairNum][2];
       // for(int x=0;x<4;x++){
            for(int y=0;y<parkList.length;y++){
                for(int z=0;z<2;z++){
                    for(int a=0;a<2;a++){
    //                    System.out.println("storing opponents");
                        if(z==0){
                            System.out.println("y"+y);
                            System.out.println("z"+z);
                            System.out.println("a"+a);
                            System.out.println("matches select:"+matches[0][0][0][0]);
                            System.out.println("matches:"+matches[matchNum][y][z][a]);
                            Opp[y][a]=matches[matchNum][y][z][a];
    //                        System.out.println("opp:"+Opp[y][a]);
                        }
                        if (z==1){
    //                        System.out.println("matches:"+matches[matchNum][y][z][a]);
                            Opp[y+parkList.length][a]=matches[matchNum][y][z][a];
    //                        System.out.println("opp:"+Opp[y+parkList.length][a]);
                        }
                    }
                }
            }
            for(int x=0;x<parkList.length;x++){
    //            System.out.println("opp1: "+Opp[x][0]);
    //            System.out.println("opp2: "+Opp[x][1]);
            }
            
      //  }
    }
    
    public void prefRand3(){
        boolean valid=false;
        boolean valid2=false;
        int randVal;
        Random rand=new Random();            
        for(int x=0;x<2;x++){
            for(int y=0;y<parkList.length;y++){
                System.out.println("used: "+used[y][x]);
                if(used[y][x]==false){
                    System.out.println("used in");
     //               System.out.println("random for:  "+parkList[y]);
                    do{
                        System.out.println("prefList length: "+prefList[y].length);
                        System.out.println("remove: "+remove[y]);
                        randVal= rand.nextInt(prefList[y].length);
   //                     System.out.println("rand Team: "+teamInfo[randVal].name);
                        if(randVal==prefList[y].length+prefBase){
    //                        System.out.println("out of bounds");
                            valid =false;
                        }
                        else{
                            System.out.println(alreadyHas[randVal]);
                            if(alreadyHas[randVal]==true){
     //                           System.out.println("already has int prefRand");
                                valid=false;
                            }
                            else{
     //                           System.out.println("does not have");
                                valid2=true;
                                System.out.println("randVal: "+randVal);
                                System.out.println("alreadyHas: "+alreadyHas[randVal]);
                                alreadyHas[randVal]=true;
                                prefList[y][randVal]=prefList[y].length+prefBase;
                            }
                        }
                    }while(valid2==false);
                    tempSelect[y][x]=teamInfo[randVal].name;
                    used[y][x]=true;
                    for(int w=0;w<Opp.length;w++){
                        if(teamInfo[randVal].name.equalsIgnoreCase(Opp[w][0])||teamInfo[randVal].name.equalsIgnoreCase(Opp[w][0])){
                            alreadyHas[w]=true;
                        }
                    }

                    //do the random
                }
                else{
                    //continue on
                }
            }                   
        }            
    }
     
    public void prefLeft(){
       int anyMore=0;
        
        for(int x=0;x<prefList.length;x++){
            anyMore=0;
            for(int y=0;y<prefList[x].length;y++){
                if(prefList[x][y]==(teamInfo.length+prefBase)){
        /*            System.out.println("prefList: "+prefList[x][y]);
                    System.out.println("empty or used");
        */            anyMore++;
                }
                else{
                    if(alreadyHas[prefList[x][y]]==true){ 
      //                  System.out.println("already has in prefLeft");
                        prefList[x][y]=prefList[x].length+prefBase;
                        anyMore++;
                    }
                    else{
     //                   System.out.println("not used");
                        anyMore=0;
                    }
                }
                
            }
            
            if(anyMore==prefList[x].length){
      //          System.out.println("no more pref");
                prefMore[x]=false;
            }
            else{
       //         System.out.println("Still more");
                System.out.println("anyMore: "+anyMore);
                remove[x]=anyMore;
                System.out.println("remove: "+remove[x]);
                prefMore[x]=true;
            }
        }
        System.out.println("anyMore 2: "+anyMore);
    }
   
    public void prefSort(){
        int count=0;
        int temp=0;
        for(int x=0;x<prefList.length;x++){
            for(int y=0;y<prefList[x].length;y++){
                if(y==prefList[x].length-1){
                    
                }
                else{
                    for(int z=0;z<prefList[x].length;z++){
                        if (z==prefList[x].length){
                            temp=prefList[x][y];
                            prefList[x][y]=prefList[x][z];
                            prefList[x][z]=temp;
                        }
                        else if(prefList[x][y]>prefList[x][y]+z){
                            count++;
                        }
                        else if(prefList[x][y]<=prefList[x][y]+z){
                            temp=prefList[x][y];
                            prefList[x][y]=prefList[x][count];
                            prefList[x][count]=temp;
                        }
                    }
                }
            }
        }
    /*    for(int x=0;x<prefList.length;x++){
            for(int y=0;y<prefList[x].length;y++){
                System.out.println(prefList[x][y]);
            }
       }*/
                    
    }
    //selects a random park from prefernces
        public void prefSelect(){
        Random rand=new Random();
        /*int slotNum1=0;
        int slotNum2=0;
        int teamNum=0;
        int oppNum=0;
        int skip=-1;
        for(int x=0;x<tempSelect.length;x++){
            for(int y=0;y<tempSelect[x].length;y++){
                for(int z=0;z<teamInfo.length;z++){
                    if(tempSelect[x][y].equalsIgnoreCase(teamInfo[z].name)){
                        teamNum=z;
                    }
                }
                if(alreadyHas[teamNum]==true){
                    System.out.println("test");
                }
                for(int w=0;w<Opp.length;w++){
                    if(teamInfo[teamNum].name.equalsIgnoreCase(Opp[w][0])||teamInfo[teamNum].name.equalsIgnoreCase(Opp[w][1])){
                        oppNum=w;
                    }
                }
                if(alreadyHas[teamNum]==true&&alreadyHas[oppNum]==true&&used[y][x]==false){
                    System.out.println("Both have");
                    int randVal=rand.nextInt(2);
                    int oppTime=0;
                    int oppLoc=0;
                    int change;
                    for(int w=0;w<2;w++){
                            for(int v=0;v<tempSelect.length;v++){
                                if(tempSelect[v][w].equalsIgnoreCase(teamInfo[oppNum].name)){
                                    oppTime=w;
                                    oppLoc=v;
                                    
                                }
                            }
                        }
                    
                    if(randVal==0){
                        System.out.println("team1 selected");
                        change=teamNum;
                        used[y][x]=true;
                        tempSelect[oppLoc][oppTime]="empty";
                        //used[oppLoc][oppTime]=false;
                        
                    }
                    else{
                        System.out.println("team2 selected");
                        change=oppNum;
                        used[oppLoc][oppTime]=true;
                        tempSelect[y][x]="empty";
                        //used[y][x]=false;
                    }
                    
                }
                else if(alreadyHas[teamNum]==true&&alreadyHas[oppNum]==false){
                    System.out.println("team1 have");
                    alreadyHas[oppNum]=true;
                    used[y][x]=true;

                }
                else if(alreadyHas[teamNum]==false&&alreadyHas[oppNum]==true){ //Kind of pointless as it would be teamOne that is checking for it
                    System.out.println("team2 have");
                    alreadyHas[teamNum]=true;
                    used[y][x]=true;
                }
                else if(alreadyHas[teamNum]==false&&alreadyHas[oppNum]==false){ //sort of pointless cause it would definitely have one
                    System.out.println("none have");
                }
            }
        }
        for(int x=0;x<used.length;x++){
            for(int y=0;y<used[x].length;y++){
                System.out.println("used in prefSelect: "+used[x][y]);
            }
        }*/
        
        int slotNum1=0;
        int slotNum2=0;
        for(int x=0;x<Opp.length;x++){
            for(int y=0;y<teamInfo.length;y++){
                    if(Opp[x][0].equalsIgnoreCase(teamInfo[y].name)){
                        slotNum1=y;
                    }
                    else if(Opp[x][1].equalsIgnoreCase(teamInfo[y].name)){
                        slotNum2=y;
                    }
            }
            if((alreadyHas[slotNum1]==true)&&(alreadyHas[slotNum2]==true)){
       //         System.out.println("Both teams have pref");
                int randVal=rand.nextInt(2);
                int keep;
                int change;
                if(randVal==0){
                    keep=slotNum1;
                    change=slotNum2;
                }
                else{
                    keep=slotNum2;
                    change=slotNum1;
                }
                for(int z=0;z<2;z++){
                    for(int w=0;w<parkList.length;w++){
                        if(tempSelect[w][z].equalsIgnoreCase(teamInfo[change].name)){
                            System.out.println("changing");
                            tempSelect[w][z]="empty";
                            used[w][z]=false;
                        }
                    }
                }
            }
            else if((alreadyHas[slotNum1]==true)&&(alreadyHas[slotNum2]==false)){
                System.out.println("team 1 has pref");
                alreadyHas[slotNum2]=true;
            }
            else if((alreadyHas[slotNum1]==false)&&(alreadyHas[slotNum2]==true)){
                System.out.println("team 2 has pref");
                alreadyHas[slotNum1]=true;
            }
            else{
                System.out.println("None had pref");
            }
        }
    
    }
    
    public void prefRand2(int matchNum){
        boolean valid=false;
        boolean valid2=false;
        int randVal;
        Random rand=new Random();
        do{
            System.out.println("Loopiong");
            for(int x=0;x<2;x++){
                for(int y=0;y<parkList.length;y++){
                    System.out.println("used: "+used[y][x]);
                    if(used[y][x]==false){
                        System.out.println("used in");
         //               System.out.println("random for:  "+parkList[y]);
                        prefLeft();
                        prefSort();
                        System.out.println("prefMore: "+prefMore[y]);
                        if(prefMore[y]==true){
                            System.out.println("prefMore in");
                            do{
                                System.out.println("prefList length: "+prefList[y].length);
                                System.out.println("remove: "+remove[y]);
                                randVal= rand.nextInt(prefList[y].length-remove[y]);
           //                     System.out.println("rand Team: "+teamInfo[randVal].name);
                                if(randVal==prefList[y].length+prefBase){
            //                        System.out.println("out of bounds");
                                    valid =false;
                                }
                                else{
                                    System.out.println(alreadyHas[randVal]);
                                    if(alreadyHas[randVal]==true){
             //                           System.out.println("already has int prefRand");
                                        valid=false;
                                    }
                                    else{
             //                           System.out.println("does not have");
                                        valid2=true;
                                        System.out.println("randVal: "+randVal);
                                        System.out.println("alreadyHas: "+alreadyHas[randVal]);
                                        alreadyHas[randVal]=true;
                                        prefList[y][randVal]=prefList[y].length+prefBase;
                                    }
                                }
                            }while(valid2==false);
                            tempSelect[y][x]=teamInfo[randVal].name;
                            used[y][x]=true;
                            

                            //do the random
                        }
                        else{
                            //continue on
                        }
                    }                    
                }
                
            }
            for(int x=0;x<parkList.length;x++){
                for(int y=0;y<2;y++){
       //             System.out.println(tempSelect[x][y]);
                            System.out.println("used2: "+used[x][y]);

                }
            }
            
     //       System.out.println("assigining parks finished");
            int exitCount=0;
            prefSelect();
            for(int x=0;x<parkList.length;x++){
                for(int y=0;y<2;y++){
       //             System.out.println(tempSelect[x][y]);
                            System.out.println("used3: "+used[x][y]);

                }
            }
            for(int x=0;x<used.length;x++){
                for(int y=0;y<used[x].length;y++){
                    System.out.println("used: "+used[x][y]);
                    if(used[x][y]==true){
                        exitCount++;
                    }
                    else if(used[x][y]==false){
                        valid =false;
                        exitCount=0;
                        
                    }
                    System.out.println("exitCount2: "+exitCount);
                }
            }
            System.out.println("exitCount: "+exitCount);
            if(exitCount==used.length*2){
                System.out.println("exiting");
                valid=true;
            }
            else{
               System.out.println("not exiting");
                valid=false;
            }
            
        }while(valid==false);
       for(int x=0;x<alreadyHas.length;x++){
      //      System.out.println(alreadyHas[x]);
        }
    //    System.out.println("randomizing complete");
        
   //     System.out.println("selected parks");
        for(int x=0;x<2;x++){
            for(int y=0;y<parkList.length;y++){
                System.out.println("Park: "+parkList[x]+ ", time: "+y);
                System.out.println(tempSelect[y][x]);
            }
        }
    }

    

    
    
    
   public void prefRand(int matchNum){
        Random rand=new Random();
        int slotNum=0;
        boolean moveOn=false;
       // String[][] tempPref=prefList;
        boolean[][] prefUsed = new boolean[parkList.length][2];
        boolean allPrefUsed=false;
        for(int x=0;x<alreadyHas.length;x++){
            System.out.println(alreadyHas[x]);
        }
        do{
            System.out.println("looping");
            for(int z=0;z<2;z++){ //Setting the team pref
                for(int x=0;x<parkList.length;x++){
                   // for(int y=0;y<prefList[x].length;y++){

                    /*  THIS IS FOR THE ANYMORE STUFF   */

                    int anyMore=0; //anymore teams having pref for this available
                    for(int w=0;w<prefList[x].length;w++){
                        for(int v=0;v<teamInfo.length;v++){ 
                           /* System.out.println(tempSelect[x][z]);
                            System.out.println(team[v][0]);
                            System.out.println("x: "+x);
                            System.out.println("z: "+z);*/

                            if(tempSelect[x][z]!=null){
                        /*        System.out.println("temp: "+tempSelect[x][z]);
                                System.out.println("team: "+team[v][0]);
                                System.out.println("z: "+z);
                                System.out.println("x: "+x);
                                System.out.println("w: "+w);
                                System.out.println("v: "+v);
                                System.out.println("anyMore: "+anyMore);
                                System.out.println("Assigning slot Num"); //error here every so often it would just repeatively loop here
                         */       if(tempSelect[x][z].equalsIgnoreCase(teamInfo[v].name)){                                 
                                    System.out.println("equals");
                                    slotNum=v;
                                    System.out.println("slotNum: "+slotNum);
                                }                            
                            }
                            else{
                                System.out.println("null");
                                break;
                            }
                        }
                                                            System.out.println("slotNum: "+slotNum);

                        System.out.println("already has: "+alreadyHas[slotNum]);
                        System.out.println(teamInfo[slotNum].name);
                        if(alreadyHas[slotNum]==true){
                            System.out.println("Already has");
                            anyMore++;
                        }                    
                        else{
                            System.out.println("don't have");
                            anyMore=0;
                        }                   
                    }
                    System.out.println("Anymore: "+anyMore);
                    if(anyMore!=0){
                        moveOn=true; //is this needed have to test cause technically the break would skip over the do loop
                        break;                }
                    else if(prefList[x].length==0){
                          moveOn=true;
                          break;
                    }
                    else{
                        System.out.println("Anymore =0");
                    }
                    /*  THIS IS FOR THE ANYMORE STUFF   */


                    do{
                    //   System.out.println(rand.nextInt(prefList[x].length));
                        for(int y=0;y<prefList[x].length;y++){
                    //        System.out.println(prefList[x][y]);
                        }
                    //  System.out.println(prefList[x][rand.nextInt(prefList[x].length)]);
                       tempSelect[x][z]=teamInfo[prefList[x][rand.nextInt(prefList[x].length)]].name; //randomly selecting a team to get the priority
                       for(int y=0;y<teamInfo.length;y++){  
                    //       System.out.println(tempSelect[x][z]);
                            if(tempSelect[x][z].equalsIgnoreCase(teamInfo[y].name)){
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
                        if(tempSelect[w][z]==matches[matchNum][x][z][0]){
                            loc1=w;
                            t1=z;
                        }
                        else if(tempSelect[w][z]==matches[matchNum][x][z][1]){
                            loc2=w;
                            t2=z;
                        }


                    }
                }
            } //this thing is determining the two opponents and their slot num on tempSelect

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
                System.out.println("assigned 0: "+assigned[loc1][t1][0]);
                System.out.println("assigned 1: "+assigned[loc1][t1][1]);
                System.out.println("tempSelect 0: "+tempSelect[loc1][t1]);
                System.out.println("tempSelect 1: "+tempSelect[loc2][t2]);
                assigned[loc1][t1][0]=tempSelect[loc1][t1];
                assigned[loc1][t1][1]=tempSelect[loc2][t2];
                for(int y=0;y<teamInfo.length;y++){
                        if(tempSelect[loc2][t2].equalsIgnoreCase(teamInfo[y].name)){
                            alreadyHas[y]=true;
                        }
                    }
            }
            else if(loc1==0&&loc2!=0){
                assigned[loc2][t2][0]=tempSelect[loc1][t1];
                assigned[loc2][t2][1]=tempSelect[loc2][t2];
                for(int y=0;y<teamInfo.length;y++){
                        if(tempSelect[loc1][t1].equalsIgnoreCase(teamInfo[y].name)){
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
                   tempSelect[y][x]=teamInfo[prefList[x][rand.nextInt(prefList[y].length)]].name; //randomly selecting a team to get the priority
                   for(int z=0;z<teamInfo.length;z++){                       
                        if(tempSelect[y][x].equalsIgnoreCase(teamInfo[z].name)){
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
                for(int f=0;f<teamInfo.length;f++){
                    if(tempTeam.equalsIgnoreCase(teamInfo[f].name)){
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
    
    
    
    
    public void storeInfo(int matchNum){
       System.out.println("storing information");
        for(int x=0;x<2;x++){
            for(int y=0;y<parkList.length;y++){
                for(int z=0;z<Opp.length;z++){
                    for(int a=0;a<2;a++){
         /*               System.out.println("x"+x);
                        System.out.println("y"+y);
                        System.out.println("z"+z);
                        System.out.println("a"+a);
                        System.out.println("temp: "+tempSelect[y][x]);
                        System.out.println("opponent: "+Opp[z][a]);
        */               if(tempSelect[y][x].equalsIgnoreCase(Opp[z][a])){ //error here about a null pointer
                           
                           matches[matchNum][y][x][0]=Opp[z][0];
                           matches[matchNum][y][x][1]=Opp[z][1];
                           System.out.println("parks and opp");
                           System.out.println(matches[matchNum][y][x][0]=Opp[z][0]);
                           System.out.println(matches[matchNum][y][x][1]=Opp[z][1]);
                           MatchMakingSchedule.matchInfo[matchNum][y][x][0]=Opp[z][0];
                           MatchMakingSchedule.matchInfo[matchNum][y][x][1]=Opp[z][1];
                       } //only loops 3 times, when 4 teams should be assigned (at least only outputs 3 times)
                    }
                }
                
            }
        }
    /*    System.out.println(matches[matchNum][0][0][0]);
         System.out.println(matches[matchNum][0][0][1]);
    */    
    }
    
    
    
}
