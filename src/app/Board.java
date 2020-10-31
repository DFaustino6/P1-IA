package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Board implements Ilayout, Cloneable {
    int dim =3;
    List<Stack<Character>> stacks;
    String stackFormat="";
    String str ="";

    public Board(String str) {
        if(str.length() > (dim*2)-1) throw new IllegalStateException("Invalid arg in Board constructor");

        this.stacks = new ArrayList<Stack<Character>>(dim);
        this.str=str;

        for (int i = 0; i < dim; i++) 
            this.stacks.add(new Stack<Character>());
        
        int nStack=0;
        for (int i = 0; i < str.length(); i++)
            if(str.charAt(i)!=' ') stacks.get(nStack).push(str.charAt(i));
            else nStack++;
    }

    public Board(List<Stack<Character>> stacks){
        this.stacks=stacks;
    }
    
    private List<Stack<Character>> copyList(){
        List<Stack<Character>> temp = new ArrayList<Stack<Character>>(dim);
        for (int i = 0; i < dim; i++) 
            temp.add(new Stack<Character>());
        
        for (int i = 0; i < stacks.size(); i++) {
            for (Character c : stacks.get(i)) {
                temp.get(i).push(c);
            }
        }

        return temp;
    }

    @Override
    public List<Ilayout> children() {
        List<Ilayout> children = new ArrayList<>();
        char c=' ';   
        List<Stack<Character>> temp = new ArrayList<Stack<Character>>(dim);   
        for (int i = 0; i < stacks.size(); i++)        
            if(!stacks.get(i).empty()) {                   
                for (int j = 1; j < dim; j++) {
                    int newStack = (j+i)%dim;
                    temp = copyList(); 
                    c=temp.get(i).pop();                      
                    temp.get(newStack).push(c); 
                    Board b = new Board(temp);
                    if(!children.contains(b) && !equals(b)) children.add(b);                          
                }                 
            }  
        return children;
    }

    @Override
    public boolean isGoal(Ilayout I) {
        if(I instanceof Board) return equals(I);
        return false;
    }

    @Override
    public double getG() {
        return 1;
    }

    @Override
    public String toString() {
        if(stackFormat.equals("")){
            for (Stack<Character> stack : stacks) {
                if(!stack.empty()) stackFormat+=stack+"\r\n";
            }
        }      
        return stackFormat;
    }

    @Override
    public boolean equals(Object I) {
        if( I instanceof Board){
            Board b = (Board) I;
            return b.stacks.containsAll(stacks);
        }
        return false;
    }
    
}
