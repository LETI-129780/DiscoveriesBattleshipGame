package iscteiul.ista.battleship;

/**
 * Representa uma Caravela no jogo Battleship.
 * A Caravela é um tipo específico de navio com um tamanho fixo de 2 posições
 * e cuja orientação (bearing) determina a sua disposição no tabuleiro
 * (na vertical para Norte/Sul ou na horizontal para Este/Oeste).
 * 
 * @author iscteiul.ista.battleship
 * @version 1.0
 * @see Ship
 * @see Compass
 * @see IPosition
 */
public class Caravel extends Ship {
    private static final Integer SIZE = 2;
    private static final String NAME = "Caravela";

    /**
     * Constrói uma nova Caravela com uma dada orientação inicial e posição de referência.
     * 
     * @param bearing a orientação cardinal para onde a Caravela aponta (ex: NORTH, SOUTH, EAST, WEST)
     * @param pos     o ponto inicial/referência para o posicionamento da Caravela no tabuleiro
     * @throws NullPointerException se o parâmetro {@code bearing} for nulo
     * @throws IllegalArgumentException se o parâmetro {@code bearing} for inválido ou não suportado
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

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
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Retorna o tamanho (número de posições ocupadas) da Caravela.
     * 
     * @return o tamanho do navio, que para a Caravela é sempre 2
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
