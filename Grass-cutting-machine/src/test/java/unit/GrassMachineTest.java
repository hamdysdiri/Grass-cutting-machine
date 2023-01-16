package unit;

import com.grass.GrassMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrassMachineTest {
    private String command ="5 5 1 2 N GAGAGAGAA";

    @Test
    public void shouldCommand(){
        new GrassMachine().command(command);
    }

    @Test
    public void shouldCommandHaveAPattern(){
        assertThat(new GrassMachine().test(command)).isEqualTo(true);
    }

}
