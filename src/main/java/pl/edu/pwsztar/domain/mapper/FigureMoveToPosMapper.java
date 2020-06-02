package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;
import pl.edu.pwsztar.domain.dto.PositionDto;

@Component
public class FigureMoveToPosMapper implements Converter<PositionDto, FigureMoveDto>{


    @Override
    public PositionDto convert(FigureMoveDto figureMoveDto) {
        String[] startPos = figureMoveDto.getStart().split("_");
        String[] destinationPos = figureMoveDto.getDestination().split("_");

        int startX = startPos[0].charAt(0);
        int destX = destinationPos[0].charAt(0);
        int startY = Integer.parseInt(startPos[1]);
        int destY = Integer.parseInt(destinationPos[1]);

        return new PositionDto(startX, startY, destX, destY);
    }
}
