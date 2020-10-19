package app;

import java.util.ArrayList;
import java.util.List;

public class Board implements Ilayout, Cloneable {
    private static final int dim=3;
    private int board[][];
    String s="";
    String boardFormat="";
    int empty;
    
    public Board(){
        board = new int[dim][dim];
    }
    
    public Board (String str) throws IllegalStateException{
        if(str.length() != dim*dim) throw new IllegalStateException("Invalid arg in Board constructor");
        
        board = new int[dim][dim];
        s = str;
        int si=0;
        for(int i=0;i<dim;i++)
            for(int j=0;j<dim;j++){
                if(str.charAt(si)=='0')
                    empty=si;
                board[i][j] = Character.getNumericValue(str.charAt(si++));
               
            }

    }
    @Override
    public String toString() {
        if(boardFormat.equals("")){
            String s = toStringLong();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(s.charAt(i) == '0')
                    boardFormat+=" ";
                else boardFormat+=c;
                if((i+1)%dim == 0)
                    boardFormat+="\r\n";
            }
        }
        return boardFormat;
    }

    @Override
    public String toStringLong(){
        return s;
    }

    @Override
    public List<Ilayout> children() {
        List<Ilayout> children = new ArrayList<>(); 
        int col = empty%dim;
        int row = (int)empty/dim;
        
        if(row>0) children.add(up(row,col)); 
        if(row<dim-1) children.add(down(row,col));
        if(col<dim-1) children.add(right(row,col)); 
        if(col>0) children.add(left(row,col));

        return children;
    }
    /**
     * Implemented for good measure
     * @return the hash code of the given board
     */
    @Override
    public int hashCode() {
        return toStringLong().hashCode();
    }
    /**
     * Since isGoal is already a comparison fuction, this one simply calls {@link #isGoal()}
     * @return comparison function so that contains works properly
     */
    @Override
    public boolean equals(Ilayout I){
        return isGoal(I);
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

    private Ilayout up( int row,int col){
        int newEmpty = col+(row-1)*dim;
        Board child = new Board(movement(newEmpty));   

        return child;
    }

    private Ilayout down(int row, int col){
        int newEmpty = col+(row+1)*dim;
        Board child = new Board(movement(newEmpty));  

        return child;
    }

    private Ilayout right(int row,int col){
        int newEmpty = (col+1)+row*dim;
        Board child = new Board(movement(newEmpty)); 
            
        return child;
    }

    private Ilayout left(int row,int col){
        int newEmpty = (col-1)+row*dim;
        Board child = new Board(movement(newEmpty)); 
            
        return child;
    }

    private String movement(int newEmpty){
        StringBuilder str = new StringBuilder(s);
        str.setCharAt(empty,s.charAt(newEmpty));
        str.setCharAt(newEmpty, '0');
        return str.toString();
    }
}
