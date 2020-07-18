
package modelo.de.contágio;

import java.util.*;

public class Contagios {
    
    private int suscetiveis;
    private int infectados;
    private int removidos;
    private ArrayList<Integer> I;
    private ArrayList<Integer> R;
    private Pessoa p0;
    private int passos;
    
    public Contagios(Grafo g, Pessoa p){
        
        p0 = new Pessoa();
        suscetiveis = g.getV();
        infectados = 0;
        removidos = 0;
        I = new ArrayList<>();
        R = new ArrayList<>();
        passos = Contagiar(g, p0.getId());
        
    }
    
    public int getS(){
        return this.suscetiveis;
    }
    
    public ArrayList<Integer> getI(){
        return this.I;
    }
    
    public ArrayList<Integer> getR(){
        return this.R;
    }
    
    public int getPassos(){
        return this.passos;
    }
    
    public int Contagiar(Grafo g, int p) { 
        
        Pessoa v = g.getVertices().get(p);
        int passo = 0;
  
        // Create a queue for BFS 
        LinkedList<Pessoa> queue = new LinkedList<Pessoa>(); 
  
        // Mark the current node as visited and enqueue it
        
        v.setI();
        this.suscetiveis--;
        this.infectados++;
        queue.add(v);
        
        Random rdm = new Random();
  
        while (queue.size() != 0) { 
            
            int x = 50;
            int r = 20;
            v = queue.poll(); 
            
            if(x <= r){
                v.setR();
                this.removidos++;
            } 
            else{
                Iterator<Integer> i = v.getArestas().listIterator();
                while (i.hasNext()) { 
                    Pessoa w = g.getVertices().get(i.next()-1);
                    if (w.getEstado().equals("S")) {
                        int c = 80;
                        if(x <= c){
                            w.setI();
                            this.suscetiveis--;
                            this.infectados++;
                            queue.add(w);
                        }
                    } 
                }
            }
            passo++;
            this.I.add(infectados);
            this.R.add(removidos);
            System.out.println(passo+", "+I.get(I.size()-1)+", "+ R.get(R.size()-1));
        }
        System.out.println("terminou o contagio");
        return passo;
    } 
    
}
