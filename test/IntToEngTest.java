import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class IntToEngTest {

	@Test
	public void 入力が0の時zeroか() {
		assertThat(IntToEng.translateEng(0),is("zero"));
	}
	
	@Test
	public void 入力が一桁の時正しく返るか(){
		assertThat(IntToEng.translateEng(5),is("five"));
	}
	
	@Test
	public void 入力が10から19の時正しく返るか(){
		assertThat(IntToEng.translateEng(17),is("seventeen"));
	}
	
	
}
