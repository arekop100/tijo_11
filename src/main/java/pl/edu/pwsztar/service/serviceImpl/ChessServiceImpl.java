package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.chess.RulesOfGame;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;
import pl.edu.pwsztar.domain.dto.PositionDto;
import pl.edu.pwsztar.domain.mapper.Converter;
import pl.edu.pwsztar.service.ChessService;

@Service
public class ChessServiceImpl implements ChessService {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame queen;
    private RulesOfGame rock;
    private RulesOfGame pawn;
    private RulesOfGame king;

    private Converter<PositionDto, FigureMoveDto> converter;

    @Autowired
    public ChessServiceImpl(@Qualifier("Bishop") RulesOfGame bishop,
                            @Qualifier("Knight") RulesOfGame knight,
                            @Qualifier("Queen") RulesOfGame queen,
                            @Qualifier("Rock") RulesOfGame rock,
                            @Qualifier("Pawn") RulesOfGame pawn,
                            @Qualifier("King") RulesOfGame king,
                            Converter<PositionDto, FigureMoveDto> converter) {
        this.bishop = bishop;
        this.knight = knight;
        this.queen = queen;
        this.rock = rock;
        this.pawn = pawn;
        this.king = king;
        this.converter = converter;
    }

    @Override
    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {
        PositionDto positionDto = converter.convert(figureMoveDto);
        return checkMove(figureMoveDto, positionDto);
    }

    private boolean checkMove(FigureMoveDto figureMoveDto, PositionDto positionDto){
        switch (figureMoveDto.getType()){
            case KING: return king.isCorrectMove(positionDto.getxStart(), positionDto.getyStart(), positionDto.getxEnd(), positionDto.getyEnd());
            case PAWN: return pawn.isCorrectMove(positionDto.getxStart(), positionDto.getyStart(), positionDto.getxEnd(), positionDto.getyEnd());
            case ROCK: return rock.isCorrectMove(positionDto.getxStart(), positionDto.getyStart(), positionDto.getxEnd(), positionDto.getyEnd());
            case QUEEN: return queen.isCorrectMove(positionDto.getxStart(), positionDto.getyStart(), positionDto.getxEnd(), positionDto.getyEnd());
            case BISHOP: return bishop.isCorrectMove(positionDto.getxStart(), positionDto.getyStart(), positionDto.getxEnd(), positionDto.getyEnd());
            case KNIGHT: return knight.isCorrectMove(positionDto.getxStart(), positionDto.getyStart(), positionDto.getxEnd(), positionDto.getyEnd());
            default: return false;
        }
    }
}
