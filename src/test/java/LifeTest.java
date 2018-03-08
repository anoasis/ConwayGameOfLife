import com.demo.Life;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LifeTest {
    @Test
    public void testCountAliveNeighbors(){
        Life life = new Life(5,5);
        life.setAlive(1,2);
        life.setAlive(1,3);
        life.setAlive(1,4);
        assertEquals(0,life.countAliveNeighbors(0,0));
        assertEquals(1,life.countAliveNeighbors(1,1));
        assertEquals(1,life.countAliveNeighbors(1,2));
        assertEquals(2,life.countAliveNeighbors(1,3));
    }

    @Test
    public void testUnderPopulation(){
        Life life = new Life(5,5);
        life.setAlive(1,2);
        life.setAlive(1,3);
        life.setAlive(1,4);
        life.tick();
        assertEquals(false,life.isAlive(1,2));
        assertEquals(false,life.isAlive(1,4));
    }

    @Test
    public void testOverPopulation(){
        Life life = new Life(5,5);
        life.setAlive(1,2);
        life.setAlive(1,3);
        life.setAlive(1,4);
        life.setAlive(2,3);
        life.setAlive(0,3);
        life.tick();
        assertEquals(false,life.isAlive(1,3));
    }

    @Test
    public void testAliveCellInNextGeneration(){
        Life life = new Life(5,5);
        life.setAlive(1,2);
        life.setAlive(1,3);
        life.setAlive(1,4);
        life.tick();
        assertEquals(true,life.isAlive(1,3));
    }

    @Test
    public void testDeadCellInNextGeneration(){
        Life life = new Life(5,5);
        life.setAlive(1,2);
        life.setAlive(1,3);
        life.setAlive(1,4);
        life.tick();
        assertEquals(true,life.isAlive(2,3));
    }

    @Test
    public void testStillLive1(){
        Life life = new Life(5,5);
        life.setAlive(1,1);
        life.setAlive(1,2);
        life.setAlive(2,1);
        life.setAlive(2,2);
        life.tick();
        assertEquals(true,life.isAlive(1,1));
        assertEquals(true,life.isAlive(1,2));
        assertEquals(true,life.isAlive(2,1));
        assertEquals(true,life.isAlive(2,2));
        assertEquals(false,life.isAlive(3,2));
    }


    @Test
    public void testStillLive2(){
        Life life = new Life(5,5);
        life.setAlive(1,1);
        life.setAlive(0,2);
        life.setAlive(2,2);
        life.setAlive(1,3);
        life.tick();
        assertEquals(true,life.isAlive(1,1));
        assertEquals(true,life.isAlive(0,2));
        assertEquals(true,life.isAlive(2,2));
        assertEquals(true,life.isAlive(1,3));
        assertEquals(false,life.isAlive(3,2));
    }


}
