package com.keith.enumtype;

/**
 * Created by Keith on 9/22/15.
 */
public enum EnumSingleton {

    SINGLETON {
        void setContext (Context context) {
            this.context = context;
        }
    };
    abstract void setContext(Context context);
    Context context;

    public static void main (String args[]) {
        Context context1 = new Context();
        EnumSingleton.SINGLETON.setContext(context1);
    }

}

class Context {

}


