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
    public Map<Integer, Vertice> vertices;
    
    public Grafo() {
        st = new TreeMap<>();
        vertices = new TreeMap<>();
    }
    
    public Vertice addVertice( double x, double y ) {
        Vertice v = new Vertice( vertices.size(), x, y );
        vertices.put( v.id, v );
        return v;
    }
    
    public void addAresta( int origem, int destino ) {
        Vertice vo = vertices.get( origem );
        Vertice vd = vertices.get( destino );
        if ( !st.containsKey( vo ) ) {
            st.put( vo, new ArrayList<>() );
        }
        if ( !st.containsKey( vd ) ) {
            st.put( vd, new ArrayList<>() );
        }
        st.get( vo ).add( 0, new Aresta( vo, vd ) );
        st.get( vd ).add( 0, new Aresta( vd, vo ) );
    }
    
    public List<Aresta> adjacentes( int origem ) {
        return st.getOrDefault( vertices.get( origem ), new ArrayList<>() );
    }

    public int getQuantidadeVertices() {
        return vertices.size();
    }
    
    public void draw( EngineFrame e ) {
        
        for ( Map.Entry<Vertice, List<Aresta>> entry : st.entrySet() ) {
            for ( Aresta a : entry.getValue() ) {
                a.draw( e );
            }
        }
        
        for ( Map.Entry<Integer, Vertice> entry : vertices.entrySet() ) {
            entry.getValue().draw( e );
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
