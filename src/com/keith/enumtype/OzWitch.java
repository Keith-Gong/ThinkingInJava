package com.keith.enumtype;

/**
 * Created by Keith on 9/20/15.
 */
public enum OzWitch {
    WEST("Miss Gulch"),
    NORTH("Glinda"),
    EAST("Dorothy"),
    SOUTH("Missing");
    //CENTER(1);

    private String description;
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static void main (String args[]) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
