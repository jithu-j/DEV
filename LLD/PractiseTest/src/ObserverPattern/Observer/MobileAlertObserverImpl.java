package ObserverPattern.Observer;

import ObserverPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    StockObservable observable;
    String userName;

    public MobileAlertObserverImpl(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "product is in stock hurry up!");
    }

    private void sendMsgOnMobile(String userName, String msg) {
        System.out.println("msg sent to: " + userName);
        //send the actual msg to end user
    }
}
