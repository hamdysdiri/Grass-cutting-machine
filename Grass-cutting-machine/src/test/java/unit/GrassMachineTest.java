package unit;

import com.grass.GrassMachine;
import com.grass.Yard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassMachineTest {

    private String yardCommandSize ="5 5";
    private String positionLine ="1 1 N";
    private String instructionsCommand ="GAGAGAGAA";

    private Yard yard = new Yard(yardCommandSize);
    private GrassMachine grassMachine = new GrassMachine(yard);

    @Test
    public void shouldCommandHavePatternForPosition(){
        assertThat(new GrassMachine(new Yard(yardCommandSize)).verifyPosition(positionLine)).isEqualTo(true);
    }

    @Test
    public void shouldCommandHavePatternForInstructions(){
        assertThat(new GrassMachine(new Yard(yardCommandSize)).verifyInstructions(instructionsCommand)).isEqualTo(true);
    }

    @Test
    public void shouldGrassMachineBeOnPosition() throws Exception {
        grassMachine.putOnPosition(positionLine);
        GrassMachine expected = new GrassMachine(new Yard("2 2"));
        expected.putOnPosition("1 1 N");
        assertThat(grassMachine.hashCode()).isEqualTo(expected.hashCode());
        Exception thrown = assertThrows(
                Exception.class,
                () -> expected.putOnPosition("3 3 N"),
                "Expected doThing() to throw"
        );
        assertTrue(thrown.getMessage().contentEquals("error, machine grass will be off the yard"));

    }


    @Test()
    public void shouldGrassMachineBeMove() throws Exception {
        grassMachine.putOnPosition(positionLine);
        grassMachine.move("GGGG");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=N");

        grassMachine.putOnPosition(positionLine);
        grassMachine.move("G");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=W");

        grassMachine.putOnPosition(positionLine);
        grassMachine.move("GG");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=S");

        grassMachine.putOnPosition(positionLine);
        grassMachine.move("GGG");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=E");


        grassMachine.putOnPosition(positionLine);
        grassMachine.move("GGGGGGG");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=E");

        grassMachine.putOnPosition(positionLine);
        grassMachine.move("DDDD");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=N");

        grassMachine.putOnPosition(positionLine);
        grassMachine.move("D");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=E");

        grassMachine.putOnPosition(positionLine);
        grassMachine.move("DD");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=S");

        grassMachine.putOnPosition(positionLine);
        grassMachine.move("DDD");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=W");

        // If the position after movement is outside the yard, the machine will not move step
        Yard yard = new Yard("1 1");
        GrassMachine grassMachine1 = new GrassMachine(yard);
        grassMachine1.putOnPosition(positionLine);
        grassMachine1.move("A");
        assertThat(grassMachine1.getPosition()).isEqualTo("x=1, y=1, O=N");


        // If the position after movement is outside the yard, the machine will not move step
        grassMachine1.putOnPosition(positionLine);
        grassMachine1.move("AAAA");
        assertThat(grassMachine1.getPosition()).isEqualTo("x=1, y=1, O=N");

        grassMachine.putOnPosition("1 1 W");
        grassMachine.move("A");
        assertThat(grassMachine.getPosition()).isEqualTo("x=0, y=1, O=W");

        grassMachine.putOnPosition("1 1 S");
        grassMachine.move("A");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=0, O=S");

        grassMachine.putOnPosition("1 1 E");
        grassMachine.move("A");
        assertThat(grassMachine.getPosition()).isEqualTo("x=2, y=1, O=E");

        grassMachine.putOnPosition("1 1 N");
        grassMachine.move("A");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=2, O=N");

        grassMachine.putOnPosition("1 2 N");
        grassMachine.move("GA");
        assertThat(grassMachine.getPosition()).isEqualTo("x=0, y=2, O=W");

        grassMachine.putOnPosition("1 2 N");
        grassMachine.move("GAGA");
        assertThat(grassMachine.getPosition()).isEqualTo("x=0, y=1, O=S");

        grassMachine.putOnPosition("1 2 N");
        grassMachine.move("GAGAGA");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=1, O=E");

        grassMachine.putOnPosition("1 2 N");
        grassMachine.move("GAGAGAGAA");
        assertThat(grassMachine.getPosition()).isEqualTo("x=1, y=3, O=N");

        grassMachine.putOnPosition("3 3 E");
        grassMachine.move("AADAADADDA");
        assertThat(grassMachine.getPosition()).isEqualTo("x=5, y=1, O=E");

    }
}
