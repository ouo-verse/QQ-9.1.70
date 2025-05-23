package s;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f433015a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final b f433016b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lock f433017a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        int f433018b;

        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<a> f433019a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f433019a) {
                poll = this.f433019a.poll();
            }
            if (poll == null) {
                return new a();
            }
            return poll;
        }

        void b(a aVar) {
            synchronized (this.f433019a) {
                if (this.f433019a.size() < 10) {
                    this.f433019a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f433015a.get(str);
            if (aVar == null) {
                aVar = this.f433016b.a();
                this.f433015a.put(str, aVar);
            }
            aVar.f433018b++;
        }
        aVar.f433017a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) h0.j.d(this.f433015a.get(str));
            int i3 = aVar.f433018b;
            if (i3 >= 1) {
                int i16 = i3 - 1;
                aVar.f433018b = i16;
                if (i16 == 0) {
                    a remove = this.f433015a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f433016b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f433018b);
            }
        }
        aVar.f433017a.unlock();
    }
}
