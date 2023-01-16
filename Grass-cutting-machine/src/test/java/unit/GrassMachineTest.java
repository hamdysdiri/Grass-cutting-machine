package unit;

import com.grass.GrassMachin;
import org.junit.jupiter.api.Test;

public class GrassMachineTest {
    private String command ="X";

    @Test
    public void shouldCommand(){
        new GrassMachin().command(command);
    }

    @Test
    public void shouldCommandStartWIthTwoNumbersWithSpaceBetween(){
        new GrassMachin().test(command);
    }
}
