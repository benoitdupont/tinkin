package be.ben.tinkin.provider;

import be.ben.tinkin.Fact;

import java.util.List;

/**
 * @author Benoit Dupont
 */
public interface FactProvider {

    List<Fact> getFacts();
}
