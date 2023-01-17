package unit;

import com.grass.GrassMachine;
import com.grass.Yard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrassMachineTest {
    private String positionLine ="1 2 N";
    private String instructionsCommand ="GAGAGAGAA";

    @Test
    public void shouldCommandHavePatternForPosition(){
        assertThat(new GrassMachine().verifyPosition(positionLine)).isEqualTo(true);
    }

    @Test
    public void shouldCommandHavePatternForInstructions(){
        assertThat(new GrassMachine().verifyInstructions(instructionsCommand)).isEqualTo(true);
    }

}
