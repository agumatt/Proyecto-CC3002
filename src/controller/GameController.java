package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import controller.eventHandlers.AttackedUnitDefeatedHandler;
import controller.eventHandlers.PlayerDefeatedHandler;
import controller.eventHandlers.SelectedUnitDefeatedHandler;
import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;


/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {

    private final ArrayList<Tactician> tacticians = new ArrayList<>();
    private final ArrayList<Tactician> currentRoundOrder = new ArrayList<>();
    private int roundNumber = 0;
    private int maxRounds;
    private Tactician turnOwner;
    private ArrayList<String> winners = new ArrayList<>();
    private int next = 1;
    private SelectedUnitDefeatedHandler sUDH = new SelectedUnitDefeatedHandler(this);
    private PlayerDefeatedHandler pDH = new PlayerDefeatedHandler(this);
    private  AttackedUnitDefeatedHandler aUDH = new AttackedUnitDefeatedHandler(this);
    private long seed = new Random().nextLong();
    private Field map = new Field(seed);

    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayers
     *     the number of players for this game
     * @param mapSize
     *     the dimensions of the map, for simplicity, all maps are squares
     */
    public GameController(int numberOfPlayers, int mapSize) {
           for(int i=0;i<numberOfPlayers;i++){
               tacticians.add(new Tactician("Player "+ i));
               currentRoundOrder.add(tacticians.get(i));
           }
           for(int i=0;i<mapSize;i++){
               for(int j=0;j<mapSize;j++){
                   map.addCells(false,new Location(i,j));
               }
           }
           Collections.shuffle(currentRoundOrder,new Random(seed));
           turnOwner=currentRoundOrder.get(0);

           for(Tactician t : tacticians){
               t.addObserver(aUDH);
               t.addObserver(pDH);
               t.addObserver(sUDH);
           }


    }


    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayers
     *     the number of players for this game
     * @param mapSize
     *     the dimensions of the map, for simplicity, all maps are squares
     * @param connect
     *      indicates if the cells of the map are all connected
     */
    public GameController(int numberOfPlayers, int mapSize, boolean connect) {
        for(int i=0;i<numberOfPlayers;i++){
            tacticians.add(new Tactician("Player "+ i));
            currentRoundOrder.add(tacticians.get(i));
        }
        for(int i=0;i<mapSize;i++){
            for(int j=0;j<mapSize;j++){
                map.addCells(connect,new Location(i,j));
            }
        }
        Collections.shuffle(currentRoundOrder,new Random(seed));
        turnOwner=currentRoundOrder.get(0);

        for(Tactician t : tacticians){
            t.addObserver(aUDH);
            t.addObserver(pDH);
            t.addObserver(sUDH);
        }


    }

    public List<Tactician> getCurrentRoundOrder(){
        return List.copyOf(currentRoundOrder);
    }

    public long getSeed() {
        return seed;
    }

    /**
     * @return the list of all the tacticians participating in the game.
     */
    public List<Tactician> getTacticians() {
        return List.copyOf(tacticians);
    }

    private void setNewOrder(){   //randomize
        if(roundNumber==0){
            Collections.shuffle(currentRoundOrder,new Random(seed));
            turnOwner = currentRoundOrder.get(0);
            return;
        }
        Tactician auxSave = currentRoundOrder.get(currentRoundOrder.size()-1);
        Collections.shuffle(currentRoundOrder,new Random(seed));
        while(currentRoundOrder.get(0).getName().equals(auxSave.getName())) {
             Collections.shuffle(currentRoundOrder,new Random(seed));
        }
        turnOwner=currentRoundOrder.get(0);
    }

    /**
     * @return the map of the current game
     */
    public Field getGameMap() {
        return map;
    }

    /**
     * @return the tactician that's currently playing
     */
    public Tactician getTurnOwner() {
        return turnOwner;
    }

    /**
     * @return the number of rounds since the start of the game.
     */
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * @return the maximum number of rounds a match can last
     */
    public int getMaxRounds() {
        return maxRounds;
    }

    public void cleanPlayers(ArrayList<Tactician> players){
        for(Tactician t : players){
            t.setSelectedUnit(null);
            t.setSelectedItem(null);
            for(IUnit u : t.getUnits()){
                t.removeUnit(u);
            }
        }
    }

    /**
     * Finishes the current player's turn.
     */
    public void endTurn() {
        if(currentRoundOrder.size()==1){
            winners.add(currentRoundOrder.get(0).getName());
            currentRoundOrder.clear();
            cleanPlayers(tacticians);
            currentRoundOrder.addAll(tacticians);
            Collections.shuffle(currentRoundOrder,new Random(seed));
            turnOwner = currentRoundOrder.get(0);  //se prepara un juego nuevo
            roundNumber = 0;
            return;
        }
        int currentIndex = currentRoundOrder.indexOf(turnOwner);
        if(next==0){
            return;
        }
        if(currentIndex <(currentRoundOrder.size()-1)) {
            turnOwner = currentRoundOrder.get(currentIndex + 1);
        }else if(roundNumber<maxRounds || maxRounds==-1){
            roundNumber++;
            setNewOrder();
        }else{
            int maxUnits=0;
            Tactician aWinner=turnOwner;
            for(Tactician t: currentRoundOrder){
                if(t.getUnits().size()>maxUnits){
                    maxUnits=t.getUnits().size();
                    aWinner=t;
                }
            }
            winners.add(aWinner.getName());
            for(Tactician t : currentRoundOrder){
                if(!t.getName().equals(aWinner.getName()) && t.getUnits().size()==maxUnits){
                    winners.add(t.getName());
                }
            }
            cleanPlayers(tacticians);
            currentRoundOrder.clear();
            currentRoundOrder.addAll(tacticians);
            Collections.shuffle(currentRoundOrder,new Random(seed));
            turnOwner = currentRoundOrder.get(0);  //se prepara un juego nuevo
            roundNumber = 0;

        }
    }

    /**
     * Removes a tactician and all of it's units from the game.
     *
     * @param tactician
     *     the player to be removed
     */
    public void removeTactician(String tactician) {
         boolean found = false;
        Tactician tacticianToRemove = null;
         for(Tactician t : currentRoundOrder){
             if(t.getName().equals(tactician)){
                 found = true;
                 tacticianToRemove = t;
             }
         }
         if(!found){
             return;
         }
         for(IUnit u : tacticianToRemove.getUnits()){
             u.getLocation().setUnit(null);
         }
         int cSize = currentRoundOrder.size();
         int iAuxSave = currentRoundOrder.indexOf(tacticianToRemove);
         currentRoundOrder.remove(tacticianToRemove);   //remove player
        if(turnOwner!=null && turnOwner.getName().equals(tactician)){  //remove current player
            if(iAuxSave<cSize-1){
                next=0;
                turnOwner = currentRoundOrder.get(iAuxSave);   //hicimos aqui el paso al siguiente jugador
            }else{
                turnOwner = currentRoundOrder.get(currentRoundOrder.size()-1);
            }
            endTurn();
            next = 1;
        }
    }


    public void removeUnit(IUnit unit){
         unit.getLocation().setUnit(null);
         unit.getTactician().removeUnit(unit);
    }

    /**
     * Starts the game.
     * @param maxTurns
     *  the maximum number of turns the game can last
     */
    public void initGame(final int maxTurns) {
        winners = new ArrayList<>();
        roundNumber = 1;
        this.maxRounds = maxTurns;

    }


    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        winners = new ArrayList<>();
        roundNumber = 1;
        this.maxRounds = -1;
    }

    /**
     * @return the winner of this game, if the match ends in a draw returns a list of all the winners
     */
    public List<String> getWinners() {
        return List.copyOf(winners);
    }

    /**
     * @return the current player's selected unit
     */
    public IUnit getSelectedUnit() {
        return turnOwner.getSelectedUnit();
    }

    /**
     * Selects a unit in the game map
     *
     * @param x
     *     horizontal position of the unit
     * @param y
     *     vertical position of the unit
     */
    public void selectUnitIn(int x, int y) {
         turnOwner.setSelectedUnit(map.getCell(x,y).getUnit());
    }

    /**
     * @return the inventory of the currently selected unit.
     */
    public List<IEquipableItem> getItems() {
        return turnOwner.getItems();
    }

    /**
     * Equips an item from the inventory to the currently selected unit.
     *
     * @param index
     *     the location of the item in the inventory.
     */
    public void equipItem(int index) {
        turnOwner.equipItem(turnOwner.getItems().get(index));
    }

    /**
     * Uses the equipped item on a target
     *
     * @param x
     *     horizontal position of the target
     * @param y
     *     vertical position of the target
     */
    public void useItemOn(int x, int y) {
         turnOwner.useEquippedItem(map.getCell(x,y).getUnit());
    }

    /**
     * Selects an item from the selected unit's inventory.
     *
     * @param index
     *     the location of the item in the inventory.
     */
    public void selectItem(int index) {
        turnOwner.setSelectedItem(turnOwner.getItems().get(index));
    }
    /**
     * Gives the selected item to a target unit.
     *
     * @param x
     *     horizontal position of the target
     * @param y
     *     vertical position of the target
     */
    public void giveItemTo(int x, int y) {
         turnOwner.giveItemTo(map.getCell(x,y).getUnit(),turnOwner.getSelectedItem());
    }
}
