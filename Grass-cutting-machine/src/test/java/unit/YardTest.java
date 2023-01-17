package unit;

import com.grass.GrassMachine;
import com.grass.Yard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class YardTest {
    private String yardCommandSize ="1 1";

    @Test
    public void shouldCommandHavePatternToSize(){
        Assertions.assertThat(new Yard(yardCommandSize).getYard().length).isEqualTo(Integer.parseInt(String.valueOf(yardCommandSize.charAt(0))));
        Assertions.assertThat(new Yard(yardCommandSize).verifyFirstLineYardCommand(yardCommandSize)).isEqualTo(true);
    }

}
