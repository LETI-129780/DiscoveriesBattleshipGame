/**
 * Interface que define o contrato para um navio no jogo Batalha Naval.
 * Permite gerir categorias, tamanhos, posições, orientações e estados de dano.
 * 
 * @author LETI-129780
 * @version 1.0
 */
package iscteiul.ista.battleship;

import java.util.List;

public interface IShip {
    /**
     * Retorna a categoria ou tipo do navio (ex: Galeão, Fragata).
     * 
     * @return a categoria do navio
     */
    String getCategory();

    /**
     * Retorna o tamanho do navio em número de posições/quadrados.
     * 
     * @return o tamanho do navio
     */
    Integer getSize();

    /**
     * Retorna a lista de todas as posições ocupadas pelo navio no tabuleiro.
     * 
     * @return lista de posições do navio
     */
    List<IPosition> getPositions();

    /**
     * Retorna a posição principal ou inicial do navio.
     * 
     * @return a posição principal
     */
    IPosition getPosition();

    /**
     * Retorna a orientação/direção (bússola) do navio no tabuleiro.
     * 
     * @return a orientação compasso do navio
     */
    Compass getBearing();

    /**
     * Verifica se o navio ainda se encontra a flutuar (não totalmente afundado).
     * 
     * @return true se ainda tiver partes a flutuar, false caso contrário
     */
    boolean stillFloating();

    /**
     * Retorna a coordenada da linha mais acima ocupada pelo navio.
     * 
     * @return índice da linha superior
     */
    int getTopMostPos();

    /**
     * Retorna a coordenada da linha mais abaixo ocupada pelo navio.
     * 
     * @return índice da linha inferior
     */
    int getBottomMostPos();

    /**
     * Retorna a coordenada da coluna mais à esquerda ocupada pelo navio.
     * 
     * @return índice da coluna mais à esquerda
     */
    int getLeftMostPos();

    /**
     * Retorna a coordenada da coluna mais à direita ocupada pelo navio.
     * 
     * @return índice da coluna mais à direita
     */
    int getRightMostPos();

    /**
     * Verifica se o navio ocupa uma determinada posição do tabuleiro.
     * 
     * @param pos a posição a verificar
     * @return true se o navio ocupar essa posição, false caso contrário
     */
    boolean occupies(IPosition pos);

    /**
     * Verifica se este navio está demasiado próximo de outro navio (regrando o espaçamento).
     * 
     * @param other o outro navio a verificar
     * @return true se estiver demasiado próximo, false caso contrário
     */
    boolean tooCloseTo(IShip other);

    /**
     * Verifica se este navio está demasiado próximo de uma determinada posição.
     * 
     * @param pos a posição a verificar
     * @return true se estiver demasiado próximo, false caso contrário
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Regista um disparo numa posição específica deste navio.
     * 
     * @param pos a posição atingida pelo tiro
     */
    void shoot(IPosition pos);
}
