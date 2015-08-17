package ch.sourcepond.maven.utils.localized.messages;

import static java.util.Locale.getDefault;
import static java.util.Locale.setDefault;
import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class MessageImplTest {
	private static final String UNKNOWN_KEY = "unknownkey";
	private final DefaultMessagesFactory factory = new DefaultMessagesFactory();
	private final Messages impl = factory.newMessages("resources");
	private Locale currentLocale;

	/**
	 * 
	 */
	@Before
	public void setup() {
		currentLocale = getDefault();
		setDefault(Locale.ENGLISH);
	}

	/**
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void verifyDoNotAllowBlankBundleName() {
		factory.newMessages("  ");
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
		Locale.setDefault(currentLocale);
	}

	/**
	 * 
	 */
	@Test
	public void verifyTranslationsKeyNotFound() {
		assertEquals(UNKNOWN_KEY, impl.getMessage(UNKNOWN_KEY));
	}

	/**
	 * 
	 */
	@Test
	public void verifyTranslations() {
		assertEquals("This is a test message with some placeholders",
				impl.getMessage("testkey", "test", "some", "placeholders"));
	}
}
