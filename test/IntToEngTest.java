import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class IntToEngTest {

	@Test
	public void 入力が0の時zeroか() { // 0の例外処理
		assertThat(IntToEng.translateEng(0),is("zero"));
	}
	
	@Test
	public void 入力が一桁の時正しく返るか(){ // 1桁の場合の処理
		assertThat(IntToEng.translateEng(5),is("five"));
	}
	
	@Test
	public void 入力が10から19の時正しく返るか(){ // 10~19の例外処理
		assertThat(IntToEng.translateEng(17),is("seventeen"));
	}
	
	@Test
	public void 入力が20の時正しく返るか() // 1桁目が0の場合の処理
		{ assertThat(IntToEng.translateEng(20), is("twenty")); }
	
	@Test
	public void 入力が27の時正しく返るか() // 通常の2桁の場合の処理
		{ assertThat(IntToEng.translateEng(27), is("twenty seven")); }
	
	@Test
	public void 入力が100の時正しく返るか() // 1,2桁目が0の場合の処理
		{ assertThat(IntToEng.translateEng(100), is("one hundred")); }
	
	@Test
	public void 入力が111の時正しく返るか() // 3桁以上で2桁部分が10~19の場合の処理
		{ assertThat(IntToEng.translateEng(111), is("one hundred eleven")); }
	
	@Test
	public void 入力が101の時正しく返るか() // 数字の間に0が入った場合の処理
		{ assertThat(IntToEng.translateEng(101), is("one hundred one")); }
	
	@Test
	public void 入力が1000の時正しく返るか() // 1~3桁目が0の場合の処理
		{ assertThat(IntToEng.translateEng(1000), is("one thousand")); }
	
	@Test
	public void 入力が2000032の時正しく返るか() // 3区切りのうち間の区切りが全て0の場合の処理
		{ assertThat(IntToEng.translateEng(2000032), is("two million thirty two")); }
	
	@Test
	public void 入力が1000000000の時正しく返るか() // 最大単位がつくほどの数の場合の処理
		{ assertThat(IntToEng.translateEng(1000000000), is("one billion")); }
	
	
}
