/**
 * Implementação da interface IPosition que representa uma coordenada (linha e coluna) 
 * no tabuleiro da Batalha Naval, controlando o seu estado de ocupação e disparos.
 * 
 * @author LETI-129780
 * @version 1.0
 */
package iscteiul.ista.battleship;

import java.util.Objects;

public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Constrói uma nova posição com a linha e coluna especificadas,
     * inicializando a posição como desocupada e sem tiros registados.
     * 
     * @param row o índice da linha
     * @param column o índice da coluna
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Retorna o índice da linha da posição.
     * 
     * @return o número da linha
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Retorna o índice da coluna da posição.
     * 
     * @return o número da coluna
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Calcula o código hash para esta posição com base na coluna, estado de tiro, ocupação e linha.
     * 
     * @return o valor do hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compara esta posição com outro objeto para verificar a igualdade de coordenadas.
     * 
     * @param otherPosition o objeto a comparar
     * @return true se as posições tiverem a mesma linha e coluna, false caso contrário
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Verifica se esta posição é adjacente (na horizontal, vertical ou diagonal) a outra posição.
     * 
     * @param other a outra posição a verificar
     * @return true se forem adjacentes, false caso contrário
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marca esta posição como ocupada por um navio.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Regista que foi efetuado um disparo sobre esta posição.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Verifica se a posição se encontra ocupada por um navio.
     * 
     * @return true se estiver ocupada, false caso contrário
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Verifica se a posição já foi atingida por um disparo.
     * 
     * @return true se já foi atingida, false caso contrário
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Retorna uma representação em texto da posição com as respetivas coordenadas de linha e coluna.
     * 
     * @return string formatada com a linha e coluna
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}
