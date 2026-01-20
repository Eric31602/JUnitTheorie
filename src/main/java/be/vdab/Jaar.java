package be.vdab;

import java.util.Objects;

public class Jaar {
    private final int jaar;
    public Jaar(int jaar) {
        this.jaar = jaar;
    }
    public boolean isSchrikkeljaar() {
        return jaar % 4 == 0 && jaar % 100 != 0 || jaar % 400 == 0;
    }
    @Override
    public String toString() {
        return String.valueOf(jaar);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jaar jaar1)) return false;
        return jaar == jaar1.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jaar);
    }
}