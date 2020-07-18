
package modelo.de.contágio;

import java.util.ArrayList;

public class Pessoa {
    
    private int id;
    private String num;
    private ArrayList<String> origem;
    private ArrayList<String> destino;
    private ArrayList<Integer> arestas;
    private String estado;
    
    public Pessoa(){
    
        id = 0;
        origem = new ArrayList<>();
        destino = new ArrayList<>();
        arestas = new ArrayList<>();
        estado = "S";
    
    }       
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNum(String num){
        this.num = num;
    }
    
    public String getNum(){
        return this.num;
    }
    
    public void addOrigem(String x, String y){
        this.origem.add(x);
        this.origem.add(y);
    }
    
    public ArrayList<String> getOrigem(){
        return this.origem;
    }
    
    public void addDestino(String x, String y){
        this.destino.add(x);
        this.destino.add(y);
    }
    
    public ArrayList<String> getDestino(){
        return this.destino;
    }
    
    public void addAresta(int p){
        this.arestas.add(p);
    }
    
    public ArrayList<Integer> getArestas(){
        return this.arestas;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public void setI(){
        this.estado = "I";
    }
    
    public void setR(){
        this.estado = "R";
    }
}


