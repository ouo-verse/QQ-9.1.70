package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.exceptions.Exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubscriptionList implements Subscription {
    private List<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public SubscriptionList() {
    }

    private static void unsubscribeFromAll(Collection<Subscription> collection) {
        if (collection == null) {
            return;
        }
        Iterator<Subscription> it = collection.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().unsubscribe();
            } catch (Throwable th5) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th5);
            }
        }
        Exceptions.throwIfAny(arrayList);
    }

    public void add(Subscription subscription) {
        if (subscription.isUnsubscribed()) {
            return;
        }
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    List list = this.subscriptions;
                    if (list == null) {
                        list = new LinkedList();
                        this.subscriptions = list;
                    }
                    list.add(subscription);
                    return;
                }
            }
        }
        subscription.unsubscribe();
    }

    public void clear() {
        List<Subscription> list;
        if (!this.unsubscribed) {
            synchronized (this) {
                list = this.subscriptions;
                this.subscriptions = null;
            }
            unsubscribeFromAll(list);
        }
    }

    public boolean hasSubscriptions() {
        List<Subscription> list;
        boolean z16 = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && (list = this.subscriptions) != null && !list.isEmpty()) {
                z16 = true;
            }
        }
        return z16;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    public void remove(Subscription subscription) {
        if (!this.unsubscribed) {
            synchronized (this) {
                List<Subscription> list = this.subscriptions;
                if (!this.unsubscribed && list != null) {
                    boolean remove = list.remove(subscription);
                    if (remove) {
                        subscription.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (this.unsubscribed) {
                    return;
                }
                this.unsubscribed = true;
                List<Subscription> list = this.subscriptions;
                this.subscriptions = null;
                unsubscribeFromAll(list);
            }
        }
    }

    public SubscriptionList(Subscription... subscriptionArr) {
        this.subscriptions = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public SubscriptionList(Subscription subscription) {
        LinkedList linkedList = new LinkedList();
        this.subscriptions = linkedList;
        linkedList.add(subscription);
    }
}
