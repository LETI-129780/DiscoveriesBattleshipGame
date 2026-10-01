package iscteiul.ista.battleship;

/**
 * Representa uma Fragata (Frigate) no jogo Battleship.
 * A Fragata é um tipo específico de navio com um tamanho fixo de 4 posições
 * e cuja orientação (bearing) determina a sua disposição no tabuleiro
 * (na vertical para Norte/Sul ou na horizontal para Este/Oeste).
 * 
 * @author iscteiul.ista.battleship
 * @version 1.0
 * @see Ship
 * @see Compass
 * @see IPosition
 */
public class Frigate extends Ship {
    private static final Integer SIZE = 4;
    private static final String NAME = "Fragata";

    /**
     * Constrói uma nova Fragata com uma dada orientação inicial e posição de referência.
     * 
     * @param bearing a orientação cardinal para onde a Fragata aponta (ex: NORTH, SOUTH, EAST, WEST)
     * @param pos     o ponto inicial/referência para o posicionamento da Fragata no tabuleiro
     * @throws IllegalArgumentException se o parâmetro {@code bearing} for inválido, não suportado ou nulo
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * Retorna o tamanho (número de posições ocupadas) da Fragata.
     * 
     * @return o tamanho do navio, que para a Fragata é sempre 4
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}
