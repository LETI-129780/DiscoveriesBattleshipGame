/**
 * Interface que define o contrato para a gestão de uma frota de navios no jogo Batalha Naval.
 * 
 * @author LETI-129780
 * @version 1.0
 */
package iscteiul.ista.battleship;

import java.util.List;

public interface IFleet {
    Integer BOARD_SIZE = 10;
    Integer FLEET_SIZE = 10;

    /**
     * Retorna a lista de todos os navios da frota.
     * @return lista de navios
     */
    List<IShip> getShips();

    /**
     * Adiciona um navio à frota.
     * @param s o navio a adicionar
     * @return true se foi adicionado com sucesso
     */
    boolean addShip(IShip s);

    /**
     * Retorna os navios de uma determinada categoria.
     * @param category o nome da categoria
     * @return lista de navios filtrados
     */
    List<IShip> getShipsLike(String category);

    /**
     * Retorna os navios que ainda se encontram a flutuar.
     * @return lista de navios ativos
     */
    List<IShip> getFloatingShips();

    /**
     * Retorna o navio numa determinada posição.
     * @param pos a posição a consultar
     * @return o navio nessa posição ou null
     */
    IShip shipAt(IPosition pos);

    /**
     * Imprime o estado atual da frota.
     */
    void printStatus();
}
