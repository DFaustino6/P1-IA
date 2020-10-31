package app;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        BestFirst s = new BestFirst();
        //System.out.println(new Board("AB C").children());
        Iterator<BestFirst.State> it = s.solve(new Board(sc.nextLine()),new Board(sc.nextLine()));

        if(it==null) System.out.println("no solution was found");
        else{
            while(it.hasNext()){
                BestFirst.State i = it.next();
                System.out.println(i);
                if(!it.hasNext()) System.out.println((int)i.getG());
            }
        }
        sc.close();
    }

} 