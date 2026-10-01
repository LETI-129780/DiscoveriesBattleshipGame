package iscteiul.ista.battleship;

/**
 * Representa uma barca (<i>barge</i>), o navio mais pequeno do jogo Battleship.
 * <p>
 * Uma barca ocupa apenas uma posição no tabuleiro, pelo que a sua orientação
 * não influencia as posições ocupadas.
 *
 * @author O Teu Nome
 * @see Ship
 */
public class Barge extends Ship {

    /** Número de posições ocupadas por uma barca. */
    private static final Integer SIZE = 1;

    /** Nome do navio, usado na sua identificação. */
    private static final String NAME = "Barca";

    /**
     * Constrói uma barca numa dada posição e orientação.
     * A posição indicada fica registada como a única posição ocupada pelo navio.
     *
     * @param bearing orientação da barca
     * @param pos     posição (canto superior esquerdo) onde a barca é colocada
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Devolve o tamanho da barca.
     *
     * @return o número de posições ocupadas, sempre 1
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
