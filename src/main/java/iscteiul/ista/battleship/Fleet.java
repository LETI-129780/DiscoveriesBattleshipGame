package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a frota de navios (Fleet) de um jogador no jogo Battleship.
 * Gere o conjunto de navios associados, permitindo adicionar novos navios,
 * verificar posições, detetar colisões com os limites do tabuleiro e outros navios,
 * bem como consultar o estado e imprimir informações sobre os navios.
 * 
 * @author iscteiul.ista.battleship
 * @version 1.0
 * @see IFleet
 * @see IShip
 */
public class Fleet implements IFleet {
    /**
     * Imprime no standard output a representação de uma lista de navios fornecida.
     *
     * @param ships a lista de navios a imprimir
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    private List<IShip> ships;

    /**
     * Constrói uma nova frota vazia, inicializando a lista de navios.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Retorna a lista de todos os navios que compõem a frota.
     * 
     * @return a lista de navios (IShip) da frota
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IFleet#addShip(battleship.IShip)
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IFleet#getShipsLike(java.lang.String)
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IFleet#getFloatingShips()
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IFleet#shipAt(battleship.IPosition)
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifica se um navio está inteiramente dentro dos limites do tabuleiro.
     * 
     * @invariante O tabuleiro tem dimensão definida por BOARD_SIZE.
     * @param s o navio a verificar
     * @return true se o navio estiver totalmente dentro do tabuleiro, false caso contrário
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Verifica se a adição de um navio representa risco de colisão (demasiado próximo)
     * em relação aos navios já existentes na frota.
     * 
     * @param s o navio a testar
     * @return true se houver risco de colisão/proximidade excessiva, false caso contrário
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }


    /**
     * Mostra o estado geral da frota, imprimindo todos os navios, os navios flutuantes
     * e os navios agrupados por categoria específica (Galeao, Fragata, Nau, Caravela, Barca).
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Imprime todos os navios da frota que pertencem a uma categoria específica.
     *
     * @param category a categoria de navios de interesse
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * Imprime todos os navios da frota que ainda se encontram a flutuar (não totalmente destruídos).
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Imprime todos os navios atualmente registados na frota.
     */
    void printAllShips() {
        printShips(ships);
    }

}
