package pl.edu.pwsztar.domain.dto;

public class PositionDto {
    private final int xStart;
    private final int xEnd;
    private final int yStart;
    private final int yEnd;

    public PositionDto(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;
    }

    public int getxStart() {
        return xStart;
    }

    public int getxEnd() {
        return xEnd;
    }

    public int getyStart() {
        return yStart;
    }

    public int getyEnd() {
        return yEnd;
    }
}
