package controller;

import java.util.*;
import java.util.stream.IntStream;

import model.Tactician;
import model.items.*;
import model.map.Field;
import model.units.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Agustin Matthey
 * @since v2.1
 */
class GameControllerTest extends AbstractControllerTest {



    @BeforeEach
    void setUp() {
        // Se define la semilla como un número aleatorio para generar variedad en los tests
        controller = new GameController(4, 7);
        randomSeed = controller.getSeed();   //Recupero la semilla utilizada al crear el controlador
        testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
    }





    @Test
    void getTacticians() {
        List<Tactician> tacticians = controller.getTacticians();
        assertEquals(4, tacticians.size());
        for (int i = 0; i < tacticians.size(); i++) {
            assertEquals("Player " + i, tacticians.get(i).getName());
        }
    }

    @Test
    void getGameMap() {
        Field gameMap = controller.getGameMap();
        assertEquals(7, gameMap.getSize());
        assertTrue(controller.getGameMap().isConnected());
        Random testRandom = new Random(randomSeed);
        // Para testear funcionalidades que dependen de valores aleatorios se hacen 2 cosas:
        //  - Comprobar las invariantes de las estructuras que se crean (en este caso que el mapa tenga
        //    las dimensiones definidas y que sea conexo.
        //  - Setear una semilla para el generador de números aleatorios. Hacer esto hace que la
        //    secuencia de números generada sea siempre la misma, así pueden predecir los
        //    resultados que van a obtener.
        //    Hay 2 formas de hacer esto en Java, le pueden pasar el seed al constructor de Random, o
        //    usar el método setSeed de Random.
        //  ESTO ÚLTIMO NO ESTÁ IMPLEMENTADO EN EL MAPA, ASÍ QUE DEBEN AGREGARLO (!)
    }

    @Test
    void getTurnOwner() {
        ArrayList<Tactician> auxArr = new ArrayList<>();
        auxArr.addAll(controller.getTacticians());
        Collections.shuffle(auxArr,new Random(controller.getSeed()));
        Tactician predictedTurnOwner = auxArr.get(0);
        assertEquals(predictedTurnOwner,controller.getTurnOwner());
    }

    @Test
    void getRoundNumber() {
        controller.initGame(10);
        for (int i = 1; i < 10; i++) {
            assertEquals(i, controller.getRoundNumber());
            for (int j = 0; j < 4; j++) {
                controller.endTurn();
            }
        }
    }

    @Test
    void getMaxRounds() {
        Random randomTurnSequence = new Random();
        IntStream.range(0, 50).map(i -> randomTurnSequence.nextInt() & Integer.MAX_VALUE).forEach(nextInt -> {
            controller.initGame(nextInt);
            assertEquals(nextInt, controller.getMaxRounds());
        });
        controller.initEndlessGame();
        assertEquals(-1, controller.getMaxRounds());
    }

    @Test
    void endTurn() {
        Tactician firstPlayer = controller.getTurnOwner();
        // Se comprueba utilizando el arreglo que almacena el orden de los turnos y un nuevo arreglo que utiliza la misma semilla
        Tactician secondPlayer = controller.getCurrentRoundOrder().get(1);
        ArrayList<Tactician> auxArr = new ArrayList<>();
        auxArr.addAll(controller.getTacticians());
        Collections.shuffle(auxArr,new Random(controller.getSeed()));
        assertNotEquals(secondPlayer.getName(), firstPlayer.getName());

        controller.endTurn();
        assertNotEquals(firstPlayer.getName(), controller.getTurnOwner().getName());
        assertEquals(secondPlayer.getName(), controller.getTurnOwner().getName());
        assertEquals(secondPlayer,auxArr.get(1));
    }

    @Test
    void removeTactician() {
        assertEquals(4, controller.getCurrentRoundOrder().size());
        controller.getCurrentRoundOrder()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

        controller.removeTactician("Player 0");
        assertEquals(3, controller.getCurrentRoundOrder().size());
        controller.getCurrentRoundOrder().forEach(tactician -> assertNotEquals("Player 0", tactician));
        controller.getCurrentRoundOrder()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

        controller.removeTactician("Player 5");
        assertEquals(3, controller.getCurrentRoundOrder().size());
        controller.getTacticians()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
    }



    @Test
    void getWinners() {
        controller.initGame(2);
        IntStream.range(0, 8).forEach(i -> controller.endTurn());
        assertEquals(4, controller.getWinners().size());
        controller.getWinners()
                .forEach(player -> Assertions.assertTrue(testTacticians.contains(player)));


        controller.initGame(2);
        IntStream.range(0, 4).forEach(i -> controller.endTurn());
        assertTrue(controller.getWinners().isEmpty());
        controller.removeTactician("Player 0");
        controller.removeTactician("Player 2");
        IntStream.range(0, 2).forEach(i -> controller.endTurn());
        List<String> winners = controller.getWinners();
        assertEquals(2, winners.size());
        assertTrue(List.of("Player 1", "Player 3").containsAll(winners));

        controller.initEndlessGame();
        for (int i = 0; i < 3; i++) {
            //assertNull(controller.getWinners());
            controller.removeTactician("Player " + i);
        }
        assertTrue(List.of("Player 3").containsAll(controller.getWinners()));
    }

    // Desde aquí en adelante, los tests deben definirlos completamente ustedes
    @Test
    void selectUnitIn() {
        setUp2();
        assertNull(controller.getSelectedUnit());
        controller.selectUnitIn(0,0);
        assertEquals(controller.getTurnOwner().getSelectedUnit(),testUnit1);
    }



    @Test
    void getSelectedUnit() {
        setUp2();
        assertNull(controller.getSelectedUnit());
        controller.selectUnitIn(0,0);
        assertEquals(controller.getTurnOwner().getSelectedUnit(),controller.getSelectedUnit());

    }



    @Test
    void getItems() {
        setUp2();
        controller.selectUnitIn(0,0);
        assertTrue(testPlayer1.getItems().containsAll(Arrays.asList(testItem1,testItem2)));
        assertTrue(controller.getItems().containsAll(Arrays.asList(testItem1,testItem2)));

    }

    @Test
    void equipItem() {
        setUp2();
        controller.selectUnitIn(0,0);
        assertNull(controller.getSelectedUnit().getEquippedItem());
        controller.equipItem(0);
        assertEquals(controller.getSelectedUnit().getEquippedItem(),testItem1);

    }

    @Test
    void useItemOn() {
        setUp3();
        setUp2();
        assertEquals(100, controller.getGameMap().getCell(2,2).getUnit().getCurrentHitPoints());
        controller.selectUnitIn(0,0);
        controller.equipItem(0);
        testUnit3.setEquippedItem(testItem3); //equip sorcerer
        controller.useItemOn(1,0);
        assertEquals(70, controller.getSelectedUnit().getCurrentHitPoints());
        assertEquals(85, controller.getGameMap().getCell(1,0).getUnit().getCurrentHitPoints());



    }

    @Test
    void selectItem() {
        setUp2();
        controller.selectUnitIn(0,0);
        assertNull(controller.getTurnOwner().getSelectedItem());
        controller.selectItem(0);
        assertEquals(testItem1,controller.getTurnOwner().getSelectedItem());

    }

    @Test
    void giveItemTo() {
        setUp3();
        setUp2();
        assertFalse(testUnit3.getItems().contains(testItem2));
        controller.selectUnitIn(0,0);
        controller.selectItem(1);
        assertEquals(1,testUnit3.getItems().size());
        assertEquals(testItem2,controller.getTurnOwner().getSelectedItem());
        testUnit1.giveItemTo(testUnit3,testItem2);
        assertTrue(testUnit3.getItems().contains(testItem2));
    }


}