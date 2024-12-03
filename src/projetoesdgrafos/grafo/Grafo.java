package projetoesdgrafos.grafo;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Um grafo implementado usando uma tabela de símbolos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Grafo {
    
    public Map<Vertice, List<Aresta>> st;
    
    public Grafo() {
        st = new TreeMap<>();
    }
    
    public void addAresta( Vertice origem, Vertice destino ) {
        if ( !st.containsKey( origem ) ) {
            st.put( origem, new ArrayList<>() );
        }
        if ( !st.containsKey( destino ) ) {
            st.put( destino, new ArrayList<>() );
        }
        st.get( origem ).addFirst( new Aresta( origem, destino ) );
        st.get( destino ).addFirst( new Aresta( destino, origem ) );
    }
    
    public void adjacentes( Vertice origem ) {
        st.getOrDefault( origem, new ArrayList<>() );
    }

    public void draw( EngineFrame e ) {
        
        for ( Map.Entry<Vertice, List<Aresta>> entry : st.entrySet() ) {
            for ( Aresta a : entry.getValue() ) {
                a.draw( e );
            }
        }
        
        for ( Vertice v : st.keySet() ) {
            v.draw( e );
        }
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        for ( Map.Entry<Vertice, List<Aresta>> entry : st.entrySet() ) {
            sb.append( entry.getKey() ).append( " -> " );
            boolean primeiro = true;
            for ( Aresta a : entry.getValue() ) {
                if ( primeiro ) {
                    primeiro = false;
                } else {
                    sb.append( ", " );
                }
                sb.append( a.destino.id );
            }
            sb.append( "\n" );
        }
        
        return sb.toString().trim();
        
    }
    
}
