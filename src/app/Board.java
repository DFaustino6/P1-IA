package app;

import java.util.ArrayList;
import java.util.List;

public class Board implements Ilayout, Cloneable {
    private static final int dim=3;
    private int board[][];
    String s="";
    int empty;
    
    public Board(){
        board = new int[dim][dim];
    }
    
    public Board (String str) throws IllegalStateException{
        if(str.length() != dim*dim) throw new IllegalStateException("Invalid arg in Board constructor");
        
        board = new int[dim][dim];

        int si=0;
        for(int i=0;i<dim;i++)
            for(int j=0;j<dim;j++){
                if(str.charAt(si)==0)
                    empty=si;
                board[i][j] = Character.getNumericValue(str.charAt(si++));
            }

    }

    public String toString(){
        for(int i=0;i<dim;i++)
            for(int j=0;j<dim;j++)
                s += String.valueOf(board[i][j]);
        return s;
    }

    @Override
    public List<Ilayout> children() {
        List<Ilayout> children = new ArrayList<>(); 

        return null;
    }

    @Override
    public boolean isGoal(Ilayout I) {
        if(toString().equals(I.toString())) return true;
        else return false;
    }

    @Override
    public double getG() {
        return 1;
    }

}
