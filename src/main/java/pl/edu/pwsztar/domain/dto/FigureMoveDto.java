package pl.edu.pwsztar.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.edu.pwsztar.domain.enums.FigureType;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@ToString
public class FigureMoveDto implements Serializable {
    private String start;
    private String destination;
    private FigureType type;

    public String getStart() {
        return start;
    }

    public String getDestination() {
        return destination;
    }

    public FigureType getType() {
        return type;
    }
}
