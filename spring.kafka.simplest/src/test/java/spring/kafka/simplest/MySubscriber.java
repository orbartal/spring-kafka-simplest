package spring.kafka.simplest;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MySubscriber<T> implements Subscriber<T> {
    private Subscription subscription;
    public List<T> consumedElements = new LinkedList<>();
 
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

	@Override
	public void onNext(T item) {
		System.out.println("Got : " + item);
		consumedElements.add(item);
		subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		System.err.println(t);
	}

	@Override
	public void onComplete() {
		System.out.println("Done");
	}
}