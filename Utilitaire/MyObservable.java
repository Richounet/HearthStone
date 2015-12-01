package Utilitaire;

import java.util.Observable;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class MyObservable extends Observable
{
    public void Notify()
    {
        setChanged();
	notifyObservers(this);
    }
}
