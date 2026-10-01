package iscteiul.ista.battleship;

/**
 * Representa uma Nau (Carrack) no jogo Battleship.
 * A Nau é um tipo específico de navio com um tamanho fixo de 3 posições
 * e cuja orientação (bearing) determina a sua disposição no tabuleiro
 * (na vertical para Norte/Sul ou na horizontal para Este/Oeste).
 * 
 * @author LETI-129785
 * @version 1.0
 * @see Ship
 * @see Compass
 * @see IPosition
 */
public class Carrack extends Ship {
    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Constrói uma nova Nau com uma dada orientação inicial e posição de referência.
     * 
     * @param bearing a orientação cardinal para onde a Nau aponta (ex: NORTH, SOUTH, EAST, WEST)
     * @param pos     o ponto inicial/referência para o posicionamento da Nau no tabuleiro
     * @throws IllegalArgumentException se o parâmetro {@code bearing} for inválido, não suportado ou nulo
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Retorna o tamanho (número de posições ocupadas) da Nau.
     * 
     * @return o tamanho do navio, que para a Nau é sempre 3
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}
