package MazeGenerator;

public class Edge {
    int start;
    int end;

    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Edge))
            return false;
        Edge e = (Edge) obj;
        return this.start == e.start && this.end == e.end;
    }
}
