package com.keith.innerclass;

/**
 * Created by keith on 8/24/2015.
 */
public class ParcelAnonymity {
    public Contents contents () {
        return new Contents() {
            @Override
            public int value() {
                return 0;
            }
        };
    }

    public static void main (String args[]) {
        ParcelAnonymity parcelAnonymity = new ParcelAnonymity();
        Contents contents = parcelAnonymity.contents();
    }
}
