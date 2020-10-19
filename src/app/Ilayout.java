/**
 * ILayout
 */
package app;
public interface Ilayout {
    /**
     * @return the children of the reciever
     */
    List<Ilayout> children();
    /**
     * @return true if the receiver equals the argument 'I'; return false otherwise
     */
    boolean isGoal(Ilayout I);
    /**
    @return the cost for moving from the input config to the receiver.
    */
    double getG();
}
}
