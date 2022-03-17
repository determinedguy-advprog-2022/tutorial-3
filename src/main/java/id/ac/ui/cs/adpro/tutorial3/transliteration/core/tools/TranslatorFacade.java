package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;

import java.util.ArrayList;
import java.util.List;

public class TranslatorFacade {

    public String encode(String text) {
        Parser parser = new Parser(Latin.getInstance());
        List<Spell> listOfText = parser.parseSentence(text);
        List<Spell> listOfResult = new ArrayList<>();
        for (Spell spell : listOfText) {
            Spell encoded = LinguaTranslator.translate(spell, Aeron.getInstance());
            String resultShifter = processAeronShifter(encoded.getText(), -3);
            String resultCipher = processAeronCipher(resultShifter, "encode");
            Spell newSpell = new Spell(resultCipher, Aeron.getInstance());
            listOfResult.add(newSpell);
        }
        Joiner joiner = new Joiner(Aeron.getInstance());
        return joiner.join(listOfResult);
    }

    public String decode(String code) {
        Parser parser = new Parser(Aeron.getInstance());
        List<Spell> listOfCode = parser.parseSentence(code);
        List<Spell> listOfResult = new ArrayList<>();
        for (Spell spell : listOfCode) {
            String resultCipher = processAeronCipher(spell.getText(), "decode");
            String resultShifter = processAeronShifter(resultCipher, 3);
            Spell newSpell = new Spell(resultShifter, Aeron.getInstance());
            Spell decoded = LinguaTranslator.translate(newSpell, Latin.getInstance());
            listOfResult.add(decoded);
        }
        Joiner joiner = new Joiner(Latin.getInstance());
        return joiner.join(listOfResult);
    }

    public String processAeronCipher(String text, String type) {

        Cipher c = new Cipher();
        Spell s = new Spell(text, Aeron.getInstance());
        if(type.equals("encode")) {
            return c.encode(s).getText();
        } else {
            return c.decode(s).getText();
        }
    }

    public String processAeronShifter(String text, int shift) {
        Shifter shifter = new Shifter();
        Spell s = new Spell(text, Aeron.getInstance());
        return shifter.shift(s, shift).getText();
    }

}
