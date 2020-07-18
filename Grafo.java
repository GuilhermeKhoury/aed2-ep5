
package modelo.de.contágio;

import java.util.ArrayList;

public class Grafo {
   
    private int V;
    private ArrayList<Pessoa> vertices;
    private int A;
    
    public Grafo(ArrayList<Pessoa> pessoas){
        V = pessoas.size();
        vertices = pessoas;
        A = adj(vertices);
    }
    
    public int getA(){
        return this.A;
    }
    
    public int getV(){
        return this.V;
    }
    
    public ArrayList<Pessoa> getVertices(){
        return this.vertices;
    }
    
    
    public int adj(ArrayList<Pessoa> lista){
        
        this.V = lista.size();
        int qtd = 0;
        for (int i = 0; i < V-1; i++){
            for(int j = i+1; j < V; j++){
                ArrayList<String> origem_i = lista.get(i).getOrigem();
                ArrayList<String> origem_j = lista.get(j).getOrigem();
                for(int o = 0; o < origem_i.size()-1; o = o+2){
                    if(origem_i.get(o).equals(origem_j.get(o)) && origem_i.get(o+1).equals(origem_j.get(o+1))){
                        lista.get(i).getArestas().add(lista.get(j).getId());
                        lista.get(j).getArestas().add(lista.get(i).getId());
                        qtd++;
                    }
                    if(o+1 == origem_j.size()-1) break;
                }
            }
        }
        return qtd;
    }
}
