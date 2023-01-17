package unit;

import com.grass.GrassMachine;
import com.grass.Yard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrassMachineTest {

    private String yardCommandSize ="2 2";
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
    }
}
