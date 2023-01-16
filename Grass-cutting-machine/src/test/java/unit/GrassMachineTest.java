package unit;

import com.grass.GrassMachin;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrassMachineTest {
    private String command ="X";

    @Test
    public void shouldCommand(){
        new GrassMachin().command(command);
    }

    @Test
    public void shouldCommandStartWIthTwoNumbersWithSpaceBetween(){
        assertThat(new GrassMachin().test(command)).isEqualTo(true);
    }
}
