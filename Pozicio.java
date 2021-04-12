import java.util.Objects;

public class Pozicio {
    public int x;
    public int y;

    public Pozicio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozicio pozicio = (Pozicio) o;
        return x == pozicio.x && y == pozicio.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
