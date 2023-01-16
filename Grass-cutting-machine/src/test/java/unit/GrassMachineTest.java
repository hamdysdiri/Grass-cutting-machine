package unit;

import com.grass.GrassMachin;
import org.junit.jupiter.api.Test;

public class GrassMachineTest {
    @Test
    public void shouldCommand(){
        new GrassMachin().command();
    }
}
