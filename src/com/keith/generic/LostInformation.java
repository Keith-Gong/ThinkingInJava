package com.keith.generic;

import java.util.*;

/**
 * Created by Keith on 8/29/15.
 */
public class LostInformation {
    public static void main (String args[]) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> particle = new Particle<>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
    }
}

class Frob {}

class Fnorkle {}

class Quark<S> {}

class Particle<K1, V2> {}
