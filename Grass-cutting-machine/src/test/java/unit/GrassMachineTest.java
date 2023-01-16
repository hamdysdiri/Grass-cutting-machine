package unit;

import com.grass.GrassMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrassMachineTest {
    private String command ="3 3 qsdqsdqsqsd";

    @Test
    public void shouldCommand(){
        new GrassMachine().command(command);
    }

    @Test
    public void shouldCommandStartWIIthTwoDigitsSeparatedByWhiteSpace(){
        assertThat(new GrassMachine().test(command)).isEqualTo(true);
    }
}
