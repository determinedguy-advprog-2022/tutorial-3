package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslatorFacadeTest {

    TranslatorFacade translatorFacade = new TranslatorFacade();
    Lingua aeron = Aeron.getInstance();
    Lingua latin = Latin.getInstance();

    @Test
    public void testDecodeIsCorrectlyImplemented() {
        String aeronSpell = "y0BG)&0BGNH{$";
        String decoded = translatorFacade.decode(aeronSpell);
        assertEquals("I love myself", decoded);
    }

    @Test
    public void testEncodeIsCorrectlyImplemented() {
        String latinSpell = "I love myself";
        String encoded = translatorFacade.encode(latinSpell);
        assertEquals("y0BG)&0BGNH{$", encoded);
    }

    @Test
    public void processAeronCipherEncodeIsCorrectlyImplemented() {
        String text = "Je t'aime";
        String encoded = translatorFacade.processAeronCipher(text, "encode");
        assertEquals("Zc}b}FaDc", encoded);
    }

    @Test
    public void processAeronCipherDecodeIsCorrectlyImplemented() {
        String spell = "}c}FDs";
        String decoded = translatorFacade.processAeronCipher(spell, "decode");
        assertEquals("HeHamo", decoded);
    }

    @Test
    public void processAeronShifterPositiveShiftValueIsCorrectlyImplemented() {
        String text = "Ich liebe mich";
        int shift = 7;
        String shifted = translatorFacade.processAeronShifter(text, shift);
        assertEquals("be michIch lie", shifted);
    }

    @Test
    public void processAeronShifterNegativeShiftValueIsCorrectlyImplemented() {
        String text = "Aku sayang diriku";
        int shift = -7;
        String shifted = translatorFacade.processAeronShifter(text, shift);
        assertEquals("ang dirikuAku say", shifted);
    }
}
