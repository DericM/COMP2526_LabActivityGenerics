package ca.bcit.comp2526.labs.generics;

/**
 * Box.
 *
 * @author BCIT
 * @version 2016
 */
public class Box {

    private Object t;

    /**
     * @param t
     */
    public void set(Object t) {
        this.t = t;
    }

    /**
     * @return t
     */
    public Object get() {
        return t;
    }

}
