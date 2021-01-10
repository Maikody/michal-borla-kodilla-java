package com.kodilla.good.patterns.challenges.Flights;

import java.util.Objects;

public class Journey {
    private final Flight start;
    private final Flight end;

    public Journey(Flight start, Flight end) {
        this.start = start;
        this.end = end;
    }

    public Flight getStart() {
        return start;
    }

    public Flight getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journey journey = (Journey) o;
        return Objects.equals(start, journey.start) &&
                Objects.equals(end, journey.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
