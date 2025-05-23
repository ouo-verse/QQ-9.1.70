package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompositeSubscription implements Subscription {
    private Set<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public CompositeSubscription() {
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
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet(4);
                    }
                    this.subscriptions.add(subscription);
                    return;
                }
            }
        }
        subscription.unsubscribe();
    }

    public void addAll(Subscription... subscriptionArr) {
        int i3 = 0;
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet(subscriptionArr.length);
                    }
                    int length = subscriptionArr.length;
                    while (i3 < length) {
                        Subscription subscription = subscriptionArr[i3];
                        if (!subscription.isUnsubscribed()) {
                            this.subscriptions.add(subscription);
                        }
                        i3++;
                    }
                    return;
                }
            }
        }
        int length2 = subscriptionArr.length;
        while (i3 < length2) {
            subscriptionArr[i3].unsubscribe();
            i3++;
        }
    }

    public void clear() {
        Set<Subscription> set;
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed && (set = this.subscriptions) != null) {
                    this.subscriptions = null;
                    unsubscribeFromAll(set);
                }
            }
        }
    }

    public boolean hasSubscriptions() {
        Set<Subscription> set;
        boolean z16 = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && (set = this.subscriptions) != null && !set.isEmpty()) {
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
        Set<Subscription> set;
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed && (set = this.subscriptions) != null) {
                    boolean remove = set.remove(subscription);
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
                Set<Subscription> set = this.subscriptions;
                this.subscriptions = null;
                unsubscribeFromAll(set);
            }
        }
    }

    public CompositeSubscription(Subscription... subscriptionArr) {
        this.subscriptions = new HashSet(Arrays.asList(subscriptionArr));
    }
}
