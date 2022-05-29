package MazeGenerator;

import java.util.Objects;

public class Path {
    public int start;
    public int end;

    int RIGHT, LEFT, BELOW, ABOVE;

    public Path(int start, int end){
        this.start = start;
        this.end = end;
        RIGHT = end + 1;
        LEFT = end - 1;
        ABOVE = end - Maze.WIDTH;
        BELOW = end + Maze.WIDTH;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return start == path.start && end == path.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Path{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
