
package modelo.de.contágio;

import java.util.ArrayList;  
import org.jfree.ui.RefineryUtilities;

public class ModeloDeContágio {

    
    public static void main(String[] args) {
        
        LerCSV obj = new LerCSV();
        ArrayList<Pessoa> vertices = obj.run();
        
        Grafo g = new Grafo(vertices);
        Pessoa P_0 = g.getVertices().get(0);
        
        Contagios c = new Contagios(g, P_0);
        int passos = c.getPassos();
        
        System.out.println("passos = "+passos);
        
        Gráfico grafico = new Gráfico("Contágio", passos, c.getI(), c.getR());
        grafico.pack();  
        RefineryUtilities.centerFrameOnScreen(grafico);  
        grafico.setVisible(true);
        
    }
    
}
