package unit;

import com.grass.GrassMachin;
import org.junit.jupiter.api.Test;

public class GrassMachineTest {
    @Test
    public void shouldCommand(){
        String command ="X";
        new GrassMachin().command(command);
    }
}
