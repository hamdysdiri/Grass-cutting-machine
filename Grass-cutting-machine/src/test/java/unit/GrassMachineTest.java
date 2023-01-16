package unit;

import com.grass.GrassMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrassMachineTest {
    private String command ="5 5 1 2 N GAGAGAGAA";

    private String yardCommandSize ="5 5";
    private String positionLine ="1 2 N";
    private String instructionsCommand ="GAGAGAGAA";
    @Test
    public void shouldCommand(){
        new GrassMachine().command(command);
    }

    @Test
    public void shouldCommandHavePatternToSize(){
        assertThat(new GrassMachine().verifyFirstLineYardCommand(yardCommandSize)).isEqualTo(true);
    }

    @Test
    public void shouldCommandHavePatternForPosition(){
        assertThat(new GrassMachine().verifyPosition(positionLine)).isEqualTo(true);
    }

    @Test
    public void shouldCommandHavePatternForInstructions(){
        assertThat(new GrassMachine().verifyInstructions(instructionsCommand)).isEqualTo(true);
    }

}
