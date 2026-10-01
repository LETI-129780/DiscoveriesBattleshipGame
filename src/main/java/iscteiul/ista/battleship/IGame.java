/**
 * Interface que define as regras, o estado global e as estatísticas de uma partida de Batalha Naval.
 * 
 * @author LETI-129780
 * @version 1.0
 */
package iscteiul.ista.battleship;

import java.util.List;

public interface IGame {
    /**
     * Efetua um disparo numa determinada posição do tabuleiro.
     * 
     * @param pos a posição onde vai ser efetuado o tiro
     * @return o navio atingido, ou null se for água
     */
    IShip fire(IPosition pos);

    /**
     * Retorna a lista de todas as posições onde já foram efetuados tiros.
     * 
     * @return lista com as posições dos tiros efetuados
     */
    List<IPosition> getShots();

    /**
     * Retorna o número total de tiros repetidos efetuados na partida.
     * 
     * @return quantidade de tiros repetidos
     */
    int getRepeatedShots();

    /**
     * Retorna o número total de tiros inválidos efetuados na partida.
     * 
     * @return quantidade de tiros inválidos
     */
    int getInvalidShots();

    /**
     * Retorna o número total de tiros certeiros (acertos) registados.
     * 
     * @return quantidade de acertos
     */
    int getHits();

    /**
     * Retorna o número de navios que já foram totalmente afundados.
     * 
     * @return quantidade de navios afundados
     */
    int getSunkShips();

    /**
     * Retorna o número de navios que ainda se encontram a flutuar na frota oponente.
     * 
     * @return quantidade de navios restantes
     */
    int getRemainingShips();

    /**
     * Imprime no terminal a lista de tiros válidos efetuados.
     */
    void printValidShots();

    /**
     * Imprime no terminal o estado atual da frota.
     */
    void printFleet();
}
