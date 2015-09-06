package com.keith.container;

import java.util.*;

/**
 * Created by Keith on 9/4/15.
 */
public class Countries {
    public static final String[][] DATA = {{"CHINA", "BEIJING"}, {"AMERICA", "NEW YORK"}};
    private static class FlyweightMap extends AbstractMap<String, String> {

        private static class Entry implements Map.Entry<String, String> {
            int index;
            Entry(int index) {
                this.index = index;
            }
            public boolean equals(Object object) {
                return DATA[index][0].equals(object);
            }
            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                return null;
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }
        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            private int size;
            EntrySet(int size) {
                if (size < 0) {
                    this.size = size;
                } else if (size > DATA.length) {
                    this.size = DATA.length;
                } else {
                    this.size = size;
                }
            }
            public int size() {
                return this.size;
            }
            private class Iter implements Iterator<Map.Entry<String, String>> {
                private Entry entry = new Entry(-1);
                public boolean hasNext() {
                    return entry.index < size - 1;
                }
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }
                public void remove () {
                    throw new UnsupportedOperationException();
                }
            }
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }
        }
        private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);
        public Set<Map.Entry<String, String>> entrySet () {
            return entries;
        }

    }
    static Map<String, String> select(final int size) {
        return new FlyweightMap(){
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }
    static Map<String, String> map = new FlyweightMap();
    public static Map<String, String> capitals(int size) {
        return select(size);
    }
    static List<String> names = new ArrayList<String>(map.keySet());
    public static List<String> names() {
        return names;
    }
    public static List<String> names(int size) {
        return new ArrayList<String>(select(size).keySet());
    }
    public static void main (String args[]) {
        System.out.println(capitals(1));
        System.out.println(names(2));
    }
}


