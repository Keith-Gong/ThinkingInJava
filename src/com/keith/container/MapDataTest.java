package com.keith.container;

import com.keith.generic.IterableFibonacci;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by Keith on 9/3/15.
 */
public class MapDataTest {
    public static void main (String args[]) {
        System.out.println(MapData.map(new Letters(), 11));
        System.out.println(MapData.map(new Letters(), "Pop"));
    }
}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
        };
    }
}
class MapData<K,V> extends LinkedHashMap<K,V> {
    public MapData(Generator<Pair<K,V>> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K,V> pair = generator.next();
            put(pair.KEY, pair.VALUE);
        }
    }

    public MapData(Generator<K> generatorK, Generator<V> generatorV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(generatorK.next(), generatorV.next());
        }
    }

    public MapData(Generator<K> generatorK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(generatorK.next(), value);
        }
    }

    public MapData(Iterable<K> iterableK, Generator<V> generatorV) {
        for (K key : iterableK) {
            put(key, generatorV.next());
        }
    }

    public MapData(Iterable<K> iterableK, V value) {
        for (K key : iterableK) {
            put(key, value);
        }
    }

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> generator, int quantity) {
        return new MapData<K, V>(generator, quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> generatorK, Generator<V> generatorV, int quantity) {
        return new MapData<K, V>(generatorK, generatorV, quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> generatorK, V value, int quantity){
        return new MapData<K, V>(generatorK, value, quantity);
    }

    public static <K,V> MapData<K,V> map(Iterable<K> iterableK, Generator<V> generatorV) {
        return new MapData<K, V>(iterableK, generatorV);
    }

    public static <K,V> MapData<K,V> map(Iterable<K> iterableK, V value){
        return new MapData<K, V>(iterableK, value);
    }
}

class Pair<K,V> {
    public final K KEY;
    public final V VALUE;
    public Pair(K KEY, V VALUE) {
        this.KEY = KEY;
        this.VALUE = VALUE;
    }
}
