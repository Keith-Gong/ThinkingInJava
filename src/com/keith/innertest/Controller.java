package com.keith.innertest;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keith on 8/24/15.
 */
public class Controller {
    public static void main (String args[]) {

    }
    private List<Event> list = new ArrayList<Event>();
    public void addEvent (Event event) {
        list.add(event);
    }
    public void run () {
        while (list.size() > 0) {
            for (Event event : new ArrayList<>(list)) {
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    list.remove(event);
                }
            }
        }
    }
}

abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event (long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready () {
        return System.nanoTime() >= eventTime;
    }
    public abstract void action ();
}
