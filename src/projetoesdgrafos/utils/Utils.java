package projetoesdgrafos.utils;

import projetoesdgrafos.grafo.Vertice;
import projetoesdgrafos.grafo.Grafo;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public interface Utils {
    
    public static Grafo criarGrafoTeste() {
        
        Grafo grafo = new Grafo();
        Map<Integer, Vertice> st = new TreeMap<>();
        
        st.put( 0, new Vertice( 0, 100, 100 ) );
        st.put( 1, new Vertice( 1, 150, 200 ) );
        st.put( 2, new Vertice( 2, 250, 200 ) );
        st.put( 3, new Vertice( 3, 200, 300 ) );
        st.put( 4, new Vertice( 4, 300, 300 ) );
        st.put( 5, new Vertice( 5, 100, 400 ) );
        st.put( 6, new Vertice( 6, 350, 200 ) );
        st.put( 7, new Vertice( 7, 450, 150 ) );
        st.put( 8, new Vertice( 8, 550, 150 ) );
        st.put( 9, new Vertice( 9, 450, 250 ) );
        st.put( 10, new Vertice( 10, 550, 250 ) );
        st.put( 11, new Vertice( 11, 450, 350 ) );
        st.put( 12, new Vertice( 12, 550, 350 ) );
        
        grafo.addAresta( st.get( 0 ), st.get( 5 ) );
        grafo.addAresta( st.get( 4 ), st.get( 3 ) );
        grafo.addAresta( st.get( 0 ), st.get( 1 ) );
        grafo.addAresta( st.get( 9 ), st.get( 12 ) );
        grafo.addAresta( st.get( 6 ), st.get( 4 ) );
        grafo.addAresta( st.get( 5 ), st.get( 4 ) );
        grafo.addAresta( st.get( 0 ), st.get( 2 ) );
        grafo.addAresta( st.get( 11 ), st.get( 12 ) );
        grafo.addAresta( st.get( 9 ), st.get( 10 ) );
        grafo.addAresta( st.get( 0 ), st.get( 6 ) );
        grafo.addAresta( st.get( 7 ), st.get( 8 ) );
        grafo.addAresta( st.get( 9 ), st.get( 11 ) );
        grafo.addAresta( st.get( 5 ), st.get( 3 ) );
        
        return grafo;
        
    }
    
}
