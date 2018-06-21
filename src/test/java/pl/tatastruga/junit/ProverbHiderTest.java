package pl.tatastruga.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pl.tatastruga.web.ProverbHider;

class ProverbHiderTest
{

	String proverbText;
	ProverbHider proverbHider = new ProverbHider();

	@Test
	void hidingProverbWithNoPunctuationMarks()
	{
		proverbText = "Gruszki na wierzbie";
		String actualdHiddenProverbText = proverbHider.hideProverbText(proverbText);

		assertEquals("_______ __ ________", actualdHiddenProverbText);
	}

	@Test
	void hidingProverbWithComma()
	{
		proverbText = "Co ma wisieć, nie utonie";
		String actualdHiddenProverbText = proverbHider.hideProverbText(proverbText);

		assertEquals("__ __ ______, ___ ______", actualdHiddenProverbText);
	}

	@Test
	void hidingProverbWithDash()
	{
		proverbText = "Co za dużo - to niezdrowo";
		String actualdHiddenProverbText = proverbHider.hideProverbText(proverbText);

		assertEquals("__ __ ____ - __ _________", actualdHiddenProverbText);
	}
	
	@Test
	void hidingProverbWithQuestionmark()
	{
		proverbText = "Polak, Węgier? Dwa bratanki";
		String actualdHiddenProverbText = proverbHider.hideProverbText(proverbText);

		assertEquals("_____, ______? ___ ________", actualdHiddenProverbText);
	}

}
