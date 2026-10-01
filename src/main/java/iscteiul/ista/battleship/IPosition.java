/**
 * Interface que define o contrato para uma posição (coordenada) no tabuleiro da Batalha Naval.
 * Permite gerir as linhas, colunas, estados de ocupação e disparos.
 * 
 * @author LETI-129780
 * @version 1.0
 */
package iscteiul.ista.battleship;

public interface IPosition {
    /**
     * Retorna o índice da linha da posição.
     * 
     * @return o número da linha
     */
    int getRow();

    /**
     * Retorna o índice da coluna da posição.
     * 
     * @return o número da coluna
     */
    int getColumn();

    /**
     * Compara esta posição com outro objeto para verificar a igualdade.
     * 
     * @param other o objeto a comparar
     * @return true se forem posições iguais, false caso contrário
     */
    boolean equals(Object other);

    /**
     * Verifica se esta posição é adjacente a outra posição fornecida.
     * 
     * @padrão IPosition other a outra posição a verificar
     * @return true se forem adjacentes, false caso contrário
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marca a posição como ocupada por um navio.
     */
    void occupy();

    /**
     * Regista que foi efetuado um disparo sobre esta posição.
     */
    void shoot();

    /**
     * Verifica se a posição se encontra ocupada por um navio.
     * 
     * @return true se estiver ocupada, false caso contrário
     */
    boolean isOccupied();

    /**
     * Verifica se a posição já foi atingida por um disparo.
     * 
     * @return true se já recebeu um tiro, false caso contrário
     */
    boolean isHit();
}
