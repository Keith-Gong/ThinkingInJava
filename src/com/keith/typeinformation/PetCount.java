package com.keith.typeinformation;

import java.util.*;

/**
 * Created by keith on 8/26/2015.
 */
class InstanceTest {
    //public static void main (String args[]) {


}

class Individual {
    public Individual ( String name) {
        System.out.format("%s", name);
    }
    public Individual () {

    }
}

class Person extends Individual {
    public Person (String name) {
        super(name);
    }
}

class Pet extends Individual {
    public Pet (String name) {
        super (name);
    }
    public Pet () {
        super();
    }
}

class Dog extends Pet {
    public Dog (String name) {
        super (name);
    }
    public Dog () {
        super ();
    }
}


class Mutt extends Dog {
    public Mutt (String name) {
        super(name);
    }
    public Mutt () {

    }
}

class Pug extends Dog {
    public Pug (String name) {
        super (name);
    }
    public Pug () {
        super ();
    }
}

class Cat extends Pet {
    public Cat (String name) {
        super (name);
    }
    public Cat () {

    }
}

class EgyptianMau extends Cat {
    public EgyptianMau (String name) {
        super (name);
    }
    public EgyptianMau () {

    }
}

class Manx extends Cat {
    public Manx (String name) {
        super (name);
    }
    public Manx () {

    }
}

class Cymric extends Cat {
    public Cymric (String name) {

    }
    public Cymric () {

    }
}

class Rodent extends Pet {
    public Rodent (String name) {
        super (name);
    }
    public Rodent () {

    }
}

class Rat extends Rodent {
    public Rat (String name) {
        super (name);
    }
    public Rat () {

    }
}

class Mouse extends Rodent {
    public Mouse (String name) {
        super (name);
    }
    public Mouse () {

    }
}

class Hamster extends Rodent {
    public Hamster (String name) {
        super (name) ;
    }
    public Hamster () {

    }
}

abstract class PetCreator  {
    private Random rand = new Random(47);
    public abstract List<Class<? extends Pet>> types ();
    public Pet randomPet () {
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }

    public Pet[] createArray (int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList (int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}

class LiteralPetCreator extends PetCreator {
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(
              Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class
            ));

    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class),
            allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}

class Pets {
    public static final PetCreator creator = new LiteralPetCreator();
    public static Pet[] createArray (int size) {
        return creator.createArray(size);
    }
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}

class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>();
    private static String[] typeNames = {
            "typeinformation.Mutt",
            "typeinformation.Pug",
            "typeinformation.EgyptianMau",
            "typeinformation.Manx",
            "typeinformation.Cymric",
            "typeinformation.Rat",
            "typeinformation.Mouse",
            "typeinformation.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader () {
        for (String name : typeNames) {
            try {
                types.add((Class<? extends Pet>)Class.forName(name));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException();
            }
        }
    }

    static {
        loader();
    }


    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}

/*public class PetCount {
    public static void main (String args[]) {
        countPets(new ForNameCreator());
    }
    static class PetCounter extends HashMap<String, Integer> {
        public void count (String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }
    public static void countPets (PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            //List each individual Pet
            System.out.println(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet)
                counter.count("Pet");
            if (pet instanceof Dog)
                counter.count("Dog");
            if (pet instanceof Mutt)
                counter.count("Mutt");
            if (pet instanceof Pug) ;
            counter.count("Pug");
            if (pet instanceof Cat)
                counter.count("Cat");
            if (pet instanceof Manx)
                counter.count("Manx");
            if (pet instanceof EgyptianMau)
                counter.count("EgyptianMau");
            if (pet instanceof Cymric)
                counter.count("Cymric");
            if (pet instanceof Rodent)
                counter.count("Rodent");
            if (pet instanceof Rat)
                counter.count("Rat");
            if (pet instanceof Mouse)
                counter.count("Mouse");
            if (pet instanceof Hamster)
                counter.count("Hamster");
        }

        System.out.println(counter);
    }
}*/

public class PetCount {
    public static void main (String args[]) {
        PetCount.countPets(Pets.creator);
    }
    static class PetCounter extends HashMap<String, Integer> {
        public void count (String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }
    public static void countPets (PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            //List each individual Pet
            System.out.println(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet)
                counter.count("Pet");
            if (pet instanceof Dog)
                counter.count("Dog");
            if (pet instanceof Mutt)
                counter.count("Mutt");
            if (pet instanceof Pug) ;
            counter.count("Pug");
            if (pet instanceof Cat)
                counter.count("Cat");
            if (pet instanceof Manx)
                counter.count("Manx");
            if (pet instanceof EgyptianMau)
                counter.count("EgyptianMau");
            if (pet instanceof Cymric)
                counter.count("Cymric");
            if (pet instanceof Rodent)
                counter.count("Rodent");
            if (pet instanceof Rat)
                counter.count("Rat");
            if (pet instanceof Mouse)
                counter.count("Mouse");
            if (pet instanceof Hamster)
                counter.count("Hamster");
        }

        System.out.println(counter);
    }
}
