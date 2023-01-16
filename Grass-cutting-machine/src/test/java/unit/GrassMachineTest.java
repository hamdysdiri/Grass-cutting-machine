package unit;

import com.grass.GrassMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrassMachineTest {
    private String command ="3 3 1 2 N qsdqsdqsqsd";

    @Test
    public void shouldCommand(){
        new GrassMachine().command(command);
    }

    @Test
    public void shouldCommandStartWithFourDigitsSeparatedByWhiteSpaceAndOneDirection(){
        assertThat(new GrassMachine().test(command)).isEqualTo(true);
    }

}
