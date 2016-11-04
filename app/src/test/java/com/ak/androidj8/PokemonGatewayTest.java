package com.ak.androidj8;

import org.junit.Test;

import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertEquals;

public class PokemonGatewayTest {

    @Test
    public void testObservableSyncCall() throws Exception {

        String expected = "Ivysaur";

        Observable testObject = Observable.just("Ivysaur", "Charizard", "Butterfree", "Arbok");

        String actual = (String) testObject.toBlocking().first();

        assertEquals(expected, actual);

    }

    @Test
    public void testSubscribeWithNoError() throws Exception {

        Pokemon pokemon = new Pokemon();
        pokemon.name = "Ivysaur";

        Observable<Pokemon> pokemonObservable = Observable.just(pokemon);

        TestSubscriber<Pokemon> testSubscriber = new TestSubscriber<>();

        pokemonObservable
                .subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

    }

}
