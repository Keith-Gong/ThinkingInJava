package com.keith.innerclass;

/**
 * Created by keith on 8/24/2015.
 */
public class TestParcel {
    public static void main (String args[]) {
        Parcel parcel = new Parcel();
        Contents contents = parcel.getContents();
    }
}

interface Destination {
    String readLabel ();
}

interface Contents {
    int value ();
}

class Parcel {
    private class PContents implements Contents {

        @Override
        public int value() {
            return 0;
        }
    }

    private class PDestination implements Destination {

        @Override
        public String readLabel() {
            return null;
        }
    }

    public Destination getDestination () {
        return new PDestination();
    }

    public Destination destination (String s) {
        class PDestination1 implements Destination {

            @Override
            public String readLabel() {
                return null;
            }
        }
        return new PDestination1();
    }

    public Contents getContents () {
        return new PContents();
    }
}
