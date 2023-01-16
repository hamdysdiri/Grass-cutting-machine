import com.grass.GrassMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllAcceptanceTest {
    private String firstLine ="5 5";
    private String secondLine ="1 2 N";
    private String ThirdLine ="GAGAGAGAA";
    private String FourthLine ="GAGAGAGAA";

    @Test
    public void GivenCommand_WhenVerifyIfMeetThePattern_ThenCommandChecked(){
        assertThat(new GrassMachine().verifyFirstLineYardCommand(firstLine)).isEqualTo(true);
        assertThat(new GrassMachine().verifyPosition(secondLine)).isEqualTo(true);
        assertThat(new GrassMachine().verifyInstructions(ThirdLine)).isEqualTo(true);
        assertThat(new GrassMachine().verifyPosition(secondLine)).isEqualTo(true);
        assertThat(new GrassMachine().verifyInstructions(FourthLine)).isEqualTo(true);
    }
}
