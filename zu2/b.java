package zu2;

import android.content.Context;
import com.tencent.qqlive.ona.protocol.jce.AdPageInfo;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends a {

    /* renamed from: b, reason: collision with root package name */
    Set<Integer> f453422b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    Set<Integer> f453423c = new HashSet();

    public b() {
        this.f453422b.add(2);
        this.f453422b.add(1);
        this.f453422b.add(3);
        this.f453422b.add(4);
        this.f453423c.add(4);
        this.f453423c.add(6);
        this.f453423c.add(8);
        this.f453423c.add(10);
        this.f453423c.add(11);
        this.f453423c.add(12);
        this.f453423c.add(15);
        this.f453423c.add(16);
    }

    private boolean o(int i3, int i16) {
        if (this.f453422b.contains(Integer.valueOf(i3)) && this.f453423c.contains(Integer.valueOf(i16))) {
            return true;
        }
        return false;
    }

    @Override // zu2.a
    public iu2.a a(Context context, ju2.a aVar) {
        return super.a(context, aVar);
    }

    @Override // zu2.a
    protected iu2.a c(ju2.a aVar) {
        return null;
    }

    @Override // zu2.a
    protected iu2.a i(ju2.a aVar) {
        AdPageInfo adPageInfo;
        if (aVar != null && (adPageInfo = aVar.f410965g) != null) {
            int i3 = adPageInfo.adPlayMode;
            if (o(aVar.f410960b, i3)) {
                iu2.a m3 = m(i3);
                if (m3 != null) {
                    m3.e(i3);
                }
                return m3;
            }
            return null;
        }
        return null;
    }

    @Override // zu2.a
    protected iu2.a k(ju2.a aVar) {
        AdPageInfo adPageInfo;
        if (aVar != null && (adPageInfo = aVar.f410965g) != null && adPageInfo.style == 2) {
            return new iu2.a(119, "no ad due to hot video.", 19);
        }
        return null;
    }
}
