package zu2;

import android.content.Context;
import java.util.HashMap;
import pw2.i;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<Integer, iu2.a> f453421a;

    public a() {
        HashMap<Integer, iu2.a> hashMap = new HashMap<>();
        this.f453421a = hashMap;
        hashMap.put(4, new iu2.a(116, "no ad due to operating closed."));
        this.f453421a.put(15, new iu2.a(125, "no ad due to vertical video."));
        iu2.a aVar = new iu2.a(119, "no ad due to hot video.");
        this.f453421a.put(8, aVar);
        this.f453421a.put(13, aVar);
        this.f453421a.put(14, aVar);
        iu2.a aVar2 = new iu2.a(122, "no ad due to WHYME VIDEO.");
        this.f453421a.put(10, aVar2);
        this.f453421a.put(11, aVar2);
        this.f453421a.put(12, new iu2.a(129, "no ad due to multi-camera video"));
    }

    public iu2.a a(Context context, ju2.a aVar) {
        if (aVar == null) {
            return null;
        }
        iu2.a i3 = i(aVar);
        if (i3 == null) {
            i3 = k(aVar);
        }
        if (i3 == null) {
            i3 = e(aVar);
        }
        if (i3 == null) {
            i3 = l(context, aVar);
        }
        if (i3 == null) {
            i3 = h(aVar);
        }
        if (i3 == null) {
            i3 = c(aVar);
        }
        if (i3 == null) {
            i3 = b();
        }
        if (i3 == null) {
            i3 = g(aVar);
        }
        if (i3 == null) {
            i3 = j(aVar);
        }
        if (i3 == null) {
            i3 = d(aVar);
        }
        if (i3 == null) {
            return f(aVar);
        }
        return i3;
    }

    protected iu2.a b() {
        return null;
    }

    protected iu2.a c(ju2.a aVar) {
        throw null;
    }

    protected iu2.a d(ju2.a aVar) {
        return null;
    }

    protected iu2.a e(ju2.a aVar) {
        return null;
    }

    protected iu2.a f(ju2.a aVar) {
        return null;
    }

    protected iu2.a g(ju2.a aVar) {
        if (aVar == null || !aVar.f410971m) {
            return null;
        }
        return new iu2.a(121, "no ad due to mini view.");
    }

    protected iu2.a h(ju2.a aVar) {
        return null;
    }

    protected iu2.a i(ju2.a aVar) {
        throw null;
    }

    protected iu2.a j(ju2.a aVar) {
        return null;
    }

    protected iu2.a k(ju2.a aVar) {
        throw null;
    }

    protected iu2.a l(Context context, ju2.a aVar) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public iu2.a m(int i3) {
        if (i3 != 3) {
            return this.f453421a.get(Integer.valueOf(i3));
        }
        return n();
    }

    iu2.a n() {
        int h16 = i.h(true);
        if (h16 != 1) {
            if (h16 != 2) {
                if (h16 != 3) {
                    return null;
                }
                return new iu2.a(133, "network status is unavailable, no ad due to closed");
            }
            return new iu2.a(131, "network status is cellular, no ad due to closed");
        }
        return new iu2.a(115, "no ad due to cache video.");
    }
}
