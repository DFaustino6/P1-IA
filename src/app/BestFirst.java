package app;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirst {

    protected Queue<State> abertos;
    private List<State> fechados;
    private State actual;
    private Ilayout objective;
    
    public static class State{
        private Ilayout layout;
        private State father;
        private double g;
        
        public State(Ilayout l,State n){
            layout=l;
            father=n;
            if(father!=null)
                g=father.g + l.getG();
            else g=0.0;
        }
        public boolean equals(State s){
            if(layout.equals(s.layout) && g==s.getG() && father.layout.equals(s.father.layout))
                return true;
            return false;
        }
        @Override
        public String toString(){ 
            return layout.toString();
        }

        public double getG(){return g;}
    }

    final private List<State> sucesssores(State n){
        List<State> sucs = new ArrayList<>();
        List <Ilayout> children = n.layout.children();
        for(Ilayout e : children){
            if(n.father == null || !e.equals(n.father.layout) ){
                State nn=new State(e,n);
                sucs.add(nn);
            } 
        }
        return sucs;
    }
    final public Iterator<State> solve(Ilayout s, Ilayout goal){
        Queue<State> abertos = new PriorityQueue<>(10,(s1,s2) -> (int) Math.signum(s1.getG()-s2.getG()));
        List<State> sucs;
        List<State> sequencia = new ArrayList<>();
        objective=goal;
        
        fechados = new ArrayList<>();
        abertos.add(new State(s,null));

        while(sequencia.isEmpty()){
            if(abertos.isEmpty())
               System.exit(1);
            actual=abertos.poll();
            if(objective.isGoal(actual.layout)){

                State actualTemp = actual;
                while(actualTemp.father!=null) {
                    sequencia.add(actualTemp);
                    actualTemp=actualTemp.father;
                }
                sequencia.add(actualTemp);
                sequencia = listReverse(sequencia);
            } else {
                sucs=sucesssores(actual);
                fechados.add(actual);
                Iterator<State> itr=sucs.iterator();
                while(itr.hasNext()){
                    State temp=itr.next();
                    if(!fechados.contains(temp))
                        abertos.add(temp);
                }
            }
        }
        
        return sequencia.iterator();
    }

    private List<State> listReverse(List<State> l) {
        int size = l.size();
        List<State> reversed = new ArrayList<State>();
        for(int i = size-1; i > -1; i--)
            reversed.add(l.get(i));
        return reversed;
    }
} 