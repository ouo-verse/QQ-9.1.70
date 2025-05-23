package sx2;

import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.tvideo.danmaku.manager.l;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StBarrage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tz3.i;
import tz3.k;
import vz3.h;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends com.tencent.rfw.barrage.core.a {

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f434931j;

    /* renamed from: k, reason: collision with root package name */
    protected int f434932k;

    /* renamed from: l, reason: collision with root package name */
    protected List<List<com.tencent.rfw.barrage.data.a>> f434933l;

    /* renamed from: m, reason: collision with root package name */
    private int f434934m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f434935n;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.rfw.barrage.data.a[] f434936o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f434937p;

    /* renamed from: q, reason: collision with root package name */
    private float f434938q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f434939r;

    public c(i iVar, com.tencent.rfw.barrage.core.f fVar, Comparator<com.tencent.rfw.barrage.data.a> comparator, vz3.c cVar, vz3.a aVar) {
        super(iVar, fVar, comparator, cVar, aVar);
        this.f434931j = new AtomicBoolean();
        this.f434937p = false;
        this.f434938q = 1.0f;
        this.f434939r = true;
        this.f434937p = uq3.c.X0("qqcircle", "qqcircle_barrage_static_draw_enabled", 1).intValue() == 1;
    }

    private void A(com.tencent.rfw.barrage.data.a aVar) {
        int size;
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f434933l;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        if (size == 0) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            List<List<com.tencent.rfw.barrage.data.a>> list2 = this.f434933l;
            if (list2 != null) {
                list2.get(i3).remove(aVar);
            }
        }
    }

    private void B(String str, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, com.tencent.rfw.barrage.data.a aVar) {
        String str2;
        if (!TextUtils.isEmpty(str) && feedCloudMeta$StBarrage != null && aVar != null) {
            FeedCloudMeta$StBarrage t16 = t(aVar);
            m70.a aVar2 = null;
            if (t16 == null) {
                str2 = null;
            } else {
                str2 = t16.f398446id.get();
            }
            if (TextUtils.equals(str, str2)) {
                Object l3 = aVar.l();
                if (l3 instanceof m70.a) {
                    aVar2 = (m70.a) l3;
                }
                if (aVar2 == null) {
                    QLog.d("TVideoBarrageR2LWindow", 4, "[replaceFakeBarragePBData] holder param should not be null.");
                    return;
                }
                aVar2.e(true);
                aVar2.d(feedCloudMeta$StBarrage);
                aVar.l0(aVar2);
                return;
            }
            return;
        }
        QLog.d("TVideoBarrageR2LWindow", 4, "[replaceFakeBarragePBData] fakeBarrageId: " + str + " | barrage: " + feedCloudMeta$StBarrage + " | renderNode: " + aVar + ", param illegality\u3002");
    }

    private void D(List<List<com.tencent.rfw.barrage.data.a>> list) {
        if (this.f365027i == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<com.tencent.rfw.barrage.data.a> list2 = list.get(i3);
            if (list2 != null) {
                for (com.tencent.rfw.barrage.data.a aVar : list2) {
                    if (!(aVar instanceof com.tencent.rfw.barrage.data.d)) {
                        return;
                    }
                    if (!aVar.N()) {
                        M((com.tencent.rfw.barrage.data.d) aVar);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009d, code lost:
    
        r5 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H() {
        if (this.f365027i != null && this.f365020b != null) {
            int u16 = u();
            Iterator<com.tencent.rfw.barrage.data.a> it = this.f365020b.iterator();
            while (true) {
                boolean z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.rfw.barrage.data.a next = it.next();
                it.remove();
                if (!next.U() || next.k() == -1.0f) {
                    com.tencent.rfw.barrage.core.e.c(this.f365024f, next);
                }
                Pair<Integer, Integer> r16 = r(next);
                int intValue = ((Integer) r16.first).intValue();
                int intValue2 = ((Integer) r16.second).intValue();
                boolean w3 = w(next);
                if (next.N()) {
                    z16 = true;
                }
                if (intValue < 0 && !w3 && !z16 && !l.h(next)) {
                    A(next);
                    this.f365021c.add(next);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("TVideoBarrageR2LWindow", 4, "[updateAllBarrageLayout] barrage collision, remove barrage = " + s(next) + " | noneCollisionLine: " + intValue);
                    }
                } else {
                    if (next instanceof tx2.c) {
                        ((tx2.c) next).N0(intValue);
                    }
                    J(u16, next, intValue);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("TVideoBarrageR2LWindow", 4, "[updateAllBarrageLayout] update barrage layout barrage: " + s(next) + " | noneCollisionLine: " + intValue);
                    }
                }
            }
            if (this.f434931j.get()) {
                this.f434931j.set(false);
                D(this.f434933l);
            }
        }
    }

    private void I(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null) {
            return;
        }
        if (j70.a.b()) {
            aVar.q0(false);
        } else {
            aVar.q0(true);
        }
    }

    private void J(int i3, com.tencent.rfw.barrage.data.a aVar, int i16) {
        int i17;
        if (i16 < -1) {
            return;
        }
        com.tencent.rfw.barrage.data.a[] aVarArr = this.f434936o;
        if (aVarArr != null && i16 <= aVarArr.length - 1) {
            aVarArr[i16] = aVar;
        }
        List list = (List) RFSafeListUtils.get(this.f434933l, i16);
        if (list == null) {
            QLog.e("TVideoBarrageR2LWindow", 1, "[updateBarrageLayout] current channel barrage list is empty, flow end.");
            return;
        }
        list.add(aVar);
        this.f365019a++;
        int[] iArr = this.f434935n;
        if (iArr != null && i16 <= iArr.length - 1) {
            i17 = iArr[i16];
        } else {
            i17 = -1;
        }
        if (i17 != -1) {
            x(aVar, i17, i3);
        }
        QLog.d("TVideoBarrageR2LWindow", 1, "[updateSingleBarrageLayout] layout line: " + i16 + ",idleLineTop:" + i17 + ",barrage:" + aVar);
    }

    private void K(k kVar) {
        if (this.f434935n != null && this.f434934m == kVar.i()) {
            return;
        }
        int i3 = kVar.i();
        this.f434934m = i3;
        this.f434935n = new int[i3];
        com.tencent.rfw.barrage.data.a[] aVarArr = new com.tencent.rfw.barrage.data.a[i3];
        com.tencent.rfw.barrage.data.a[] aVarArr2 = this.f434936o;
        if (aVarArr2 != null) {
            System.arraycopy(aVarArr2, 0, aVarArr, 0, Math.min(i3, aVarArr2.length));
        }
        this.f434936o = aVarArr;
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f434933l;
        if (list == null) {
            this.f434933l = new ArrayList(this.f434934m);
            for (int i16 = 0; i16 < this.f434934m; i16++) {
                this.f434933l.add(new LinkedList());
            }
            return;
        }
        int size = list.size();
        if (size < this.f434934m) {
            while (size < this.f434934m) {
                this.f434933l.add(new LinkedList());
                size++;
            }
        } else {
            while (true) {
                size--;
                if (size >= this.f434934m) {
                    this.f434933l.remove(size);
                } else {
                    return;
                }
            }
        }
    }

    private void M(com.tencent.rfw.barrage.data.d dVar) {
        int i3;
        long a16 = this.f365027i.a();
        int u16 = (int) (u() - ((((float) (a16 - (dVar.H() + dVar.o()))) * dVar.G()) - dVar.k()));
        if (u16 == 0) {
            i3 = 0;
        } else {
            i3 = (int) (u16 / (-dVar.G()));
        }
        long j3 = a16 - i3;
        dVar.u0(j3);
        dVar.d0(a16);
        QLog.d("TVideoBarrageR2LWindow", 1, "[updateSingleBarrageProp] newFirstDrawTime: " + j3 + " | currTime: " + a16 + "| r2lBarrage: " + dVar);
    }

    private void n() {
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f434933l;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            p(this.f434933l.get(i3).iterator(), i3);
        }
    }

    private void p(@NonNull Iterator<com.tencent.rfw.barrage.data.a> it, int i3) {
        while (it.hasNext()) {
            com.tencent.rfw.barrage.data.a next = it.next();
            if (!next.N()) {
                if (next.D() > 0.0f) {
                    return;
                }
                if (next.S(this.f365027i.a()) || next.O() || !next.X()) {
                    com.tencent.rfw.barrage.data.a[] aVarArr = this.f434936o;
                    if (next == aVarArr[i3]) {
                        aVarArr[i3] = null;
                    }
                    it.remove();
                    this.f365019a--;
                    this.f365021c.add(next);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("TVideoBarrageR2LWindow", 4, "[clearSingleChannelTimeOutBarrage] delete: " + next.hashCode());
                    }
                }
            }
        }
    }

    private Pair<Integer, Integer> r(com.tencent.rfw.barrage.data.a aVar) {
        com.tencent.rfw.barrage.data.a aVar2;
        if (this.f434933l != null && this.f365027i != null) {
            int i3 = 0;
            int i16 = 0;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            while (i16 < this.f434933l.size()) {
                List<com.tencent.rfw.barrage.data.a> list = this.f434933l.get(i16);
                if (RFSafeListUtils.isEmpty(list) || (aVar2 = (com.tencent.rfw.barrage.data.a) RFSafeListUtils.get(list, list.size() - 1)) == null) {
                    i18 = i16;
                    break;
                }
                int d16 = wz3.d.d(aVar2, aVar, this.f365027i.a());
                if (Math.round(i17) > Math.round(d16) || aVar2.N()) {
                    i19 = i16;
                    i17 = d16;
                }
                if (d16 <= -1 || aVar2.N()) {
                    i18 = i16;
                }
                i16++;
            }
            i16 = i19;
            if (i16 != -1) {
                i3 = i16;
            }
            return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i3));
        }
        return new Pair<>(-1, -1);
    }

    private String s(@NonNull com.tencent.rfw.barrage.data.a aVar) {
        FeedCloudMeta$StBarrage t16 = t(aVar);
        if (t16 == null) {
            return "null";
        }
        return "[id=" + t16.f398446id.get() + "," + t16.content.get() + "]";
    }

    private FeedCloudMeta$StBarrage t(@NonNull com.tencent.rfw.barrage.data.a aVar) {
        Object l3 = aVar.l();
        if (!(l3 instanceof m70.a)) {
            return null;
        }
        return ((m70.a) l3).a();
    }

    private int u() {
        return l.d().getWidth();
    }

    private boolean v(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage2) {
        if (feedCloudMeta$StBarrage != null && feedCloudMeta$StBarrage2 != null) {
            return TextUtils.equals(feedCloudMeta$StBarrage.f398446id.get(), feedCloudMeta$StBarrage2.f398446id.get());
        }
        return false;
    }

    private boolean w(com.tencent.rfw.barrage.data.a aVar) {
        Object l3 = aVar.l();
        if (!(l3 instanceof m70.a)) {
            return false;
        }
        return i70.b.a((m70.a) l3);
    }

    private void x(com.tencent.rfw.barrage.data.a aVar, int i3, int i16) {
        vz3.c cVar;
        if (aVar == null || (cVar = this.f365026h) == null || this.f365027i == null) {
            return;
        }
        aVar.c0(i16, i3, cVar.a(), this.f365027i.a());
    }

    private void z(k kVar) {
        String str;
        K(kVar);
        int h16 = this.f365024f.h();
        StringBuilder sb5 = new StringBuilder("[");
        for (int i3 = 0; i3 < this.f434934m; i3++) {
            int[] iArr = this.f434935n;
            int i16 = (i3 * h16) + this.f434932k;
            iArr[i3] = i16;
            sb5.append(i16);
            if (i3 != this.f434934m - 1) {
                str = ", ";
            } else {
                str = "";
            }
            sb5.append(str);
        }
        sb5.append("]");
        QLog.d("TVideoBarrageR2LWindow", 1, "[relayoutBarrageLines], mRowCount: " + this.f434934m + " | mMarginTop: " + this.f434932k + " | lineHeight: " + h16 + " | lineTops: " + ((Object) sb5));
        y(this.f434933l, this.f434935n);
    }

    public void C() {
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f434933l;
        if (list == null) {
            return;
        }
        int size = list.size();
        boolean z16 = false;
        for (int i3 = 0; i3 < size; i3++) {
            List<com.tencent.rfw.barrage.data.a> list2 = this.f434933l.get(i3);
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                for (com.tencent.rfw.barrage.data.a aVar : list2) {
                    if (!aVar.N()) {
                        arrayList.add(aVar);
                    } else {
                        z16 = true;
                    }
                }
                list2.removeAll(arrayList);
            }
        }
        if (z16) {
            this.f365019a = 1;
        } else {
            this.f365019a = 0;
        }
    }

    public void E(boolean z16) {
        this.f434939r = z16;
    }

    public void F() {
        this.f434931j.set(true);
    }

    public void G(float f16) {
        if (this.f434933l == null || this.f434938q == f16) {
            return;
        }
        this.f434938q = f16;
        for (int i3 = 0; i3 < this.f434933l.size(); i3++) {
            List<com.tencent.rfw.barrage.data.a> list = this.f434933l.get(i3);
            if (list != null) {
                for (int i16 = 0; i16 < list.size(); i16++) {
                    com.tencent.rfw.barrage.data.a aVar = list.get(i16);
                    if (aVar instanceof tx2.c) {
                        tx2.c cVar = (tx2.c) aVar;
                        cVar.M0();
                        cVar.s0(1.0f / this.f434938q);
                        long a16 = this.f365027i.a();
                        int t16 = (int) cVar.t();
                        g(cVar);
                        cVar.u0(a16 - ((int) ((u() - t16) / (-cVar.G()))));
                        cVar.D0(t16);
                        cVar.b();
                    }
                }
            }
        }
    }

    public void L(String str, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f434933l;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<com.tencent.rfw.barrage.data.a> list2 = this.f434933l.get(i3);
            if (list2 != null) {
                Iterator<com.tencent.rfw.barrage.data.a> it = list2.iterator();
                while (it.hasNext()) {
                    B(str, feedCloudMeta$StBarrage, it.next());
                }
            }
        }
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void c() {
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f434933l;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<com.tencent.rfw.barrage.data.a> list2 = this.f434933l.get(i3);
            if (list2 != null) {
                Iterator<com.tencent.rfw.barrage.data.a> it = list2.iterator();
                while (it.hasNext()) {
                    com.tencent.rfw.barrage.data.a next = it.next();
                    if (!next.N()) {
                        it.remove();
                        this.f365019a--;
                        this.f365021c.add(next);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.rfw.barrage.core.a
    public void e(Canvas canvas, com.tencent.rfw.barrage.data.a aVar) {
        i iVar;
        if (canvas == null || aVar == null || (iVar = this.f365024f) == null) {
            return;
        }
        uz3.f e16 = iVar.e(aVar);
        uz3.d dVar = this.f365022d;
        if (dVar != null) {
            dVar.a(canvas, aVar, this.f365024f, e16);
        }
        if (!aVar.N()) {
            aVar.a();
        }
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void g(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.p0(true);
        aVar.w0(true);
        float y16 = aVar.y();
        com.tencent.rfw.barrage.core.e.c(this.f365024f, aVar);
        aVar.s0((aVar.y() + u()) / (y16 + u()));
    }

    @Override // com.tencent.rfw.barrage.core.a
    public boolean i() {
        return this.f434937p;
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void j() {
        H();
        n();
    }

    @Override // com.tencent.rfw.barrage.core.a
    public com.tencent.rfw.barrage.data.a k(h hVar) {
        return null;
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void l(Canvas canvas, long j3) {
        if (RFSafeListUtils.isEmpty(this.f434933l)) {
            QLog.d("TVideoBarrageR2LWindow", 1, "[onDraw] current barrage lines empty...");
            return;
        }
        int size = this.f434933l.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<com.tencent.rfw.barrage.data.a> list = this.f434933l.get(i3);
            if (list != null) {
                for (com.tencent.rfw.barrage.data.a aVar : list) {
                    aVar.e0(this.f365027i.b(), this.f365027i.a());
                    if (this.f434939r || l.h(aVar)) {
                        if (!aVar.R(this.f365027i.a()) || aVar.N()) {
                            I(aVar);
                            e(canvas, aVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void m() {
        k l3 = i.l();
        this.f434932k = l3.m();
        z(l3);
        this.f434939r = true;
    }

    public void o() {
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f434933l;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<com.tencent.rfw.barrage.data.a> list2 = this.f434933l.get(i3);
            if (list2 != null) {
                for (com.tencent.rfw.barrage.data.a aVar : list2) {
                    if (aVar != null) {
                        aVar.n0(null);
                    }
                }
            }
        }
    }

    public com.tencent.rfw.barrage.data.a q(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f434933l;
        com.tencent.rfw.barrage.data.a aVar = null;
        if (list != null && feedCloudMeta$StBarrage != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                List<com.tencent.rfw.barrage.data.a> list2 = this.f434933l.get(i3);
                if (list2 != null) {
                    Iterator<com.tencent.rfw.barrage.data.a> it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.tencent.rfw.barrage.data.a next = it.next();
                            if (v(feedCloudMeta$StBarrage, t(next))) {
                                aVar = next;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public void y(List<List<com.tencent.rfw.barrage.data.a>> list, int[] iArr) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<com.tencent.rfw.barrage.data.a> list2 = list.get(i3);
            if (list2 != null) {
                Iterator<com.tencent.rfw.barrage.data.a> it = list2.iterator();
                while (it.hasNext()) {
                    com.tencent.rfw.barrage.data.d dVar = (com.tencent.rfw.barrage.data.d) it.next();
                    dVar.c();
                    long a16 = this.f365027i.a();
                    int t16 = (int) dVar.t();
                    g(dVar);
                    dVar.u0(a16 - ((int) ((u() - t16) / (-dVar.G()))));
                    dVar.F0(iArr[i3]);
                    dVar.D0(t16);
                }
            }
        }
    }
}
