package MazeGenerator;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
