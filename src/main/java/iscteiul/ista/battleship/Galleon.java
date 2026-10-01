package iscteiul.ista.battleship;

/**
 * Representa um Galeão (Galleon) no jogo Battleship.
 * O Galeão é um navio de maior porte com um tamanho fixo de 5 posições
 * e uma disposição geométrica específica no tabuleiro consoante a orientação (bearing).
 * 
 * @author iscteiul.ista.battleship
 * @version 1.0
 * @see Ship
 * @see Compass
 * @see IPosition
 */
public class Galleon extends Ship {
    private static final Integer SIZE = 5;
    private static final String NAME = "Galeao";

    /**
     * Constrói um novo Galeão com uma dada orientação inicial e posição de referência.
     * 
     * @param bearing a orientação cardinal para onde o Galeão aponta (ex: NORTH, SOUTH, EAST, WEST)
     * @param pos     o ponto inicial/referência para o posicionamento do Galeão no tabuleiro
     * @throws NullPointerException se o parâmetro {@code bearing} for nulo
     * @throws IllegalArgumentException se o parâmetro {@code bearing} for inválido ou não suportado
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Retorna o tamanho (número de posições ocupadas) do Galeão.
     * 
     * @return o tamanho do navio, que para o Galeão é sempre 5
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche as posições ocupadas pelo Galeão quando orientado a Norte (NORTH).
     * 
     * @param pos o ponto de referência inicial
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche as posições ocupadas pelo Galeão quando orientado a Sul (SOUTH).
     * 
     * @param pos o ponto de referência inicial
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Preenche as posições ocupadas pelo Galeão quando orientado a Este (EAST).
     * 
     * @param pos o ponto de referência inicial
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche as posições ocupadas pelo Galeão quando orientado a Oeste (WEST).
     * 
     * @param pos o ponto de referência inicial
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
