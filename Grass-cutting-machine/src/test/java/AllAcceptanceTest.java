import com.grass.GrassMachine;
import com.grass.ReadInput;
import com.grass.Yard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllAcceptanceTest {
    private String firstLine ="5 5";
    private String secondLine ="1 2 N";
    private String thirdLine ="GAGAGAGAA";

    @Test
    public void GivenCommand_WhenVerifyIfMeetThePattern_ThenCommandChecked(){
        assertThat(new ReadInput(new GrassMachine(new Yard(firstLine))).verifyOrderOfInput(firstLine, secondLine, thirdLine)).isEqualTo(true);
    }

}
