package rj2;

import androidx.annotation.VisibleForTesting;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sj2.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u00192\u00020\u0001:\u0003$\u001e\u0015B\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160)8\u0006\u00a2\u0006\f\n\u0004\b$\u0010*\u001a\u0004\b+\u0010,R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000f0.j\b\u0012\u0004\u0012\u00020\u000f`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00100R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00102R\u0016\u00105\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00107\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00106R\"\u0010=\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00108R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010@R\u0014\u0010A\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u0010:\u00a8\u0006D"}, d2 = {"Lrj2/a;", "", "", "r", "", "px", ReportConstant.COSTREPORT_PREFIX, "space", "", "index", "Lkotlin/Pair;", "l", "k", "timeUs", "v", "Lsj2/d;", "sizeParam", "w", "", "o", "f", "c", "Lrj2/b;", "scalePoint", "", "j", "i", "e", "t", "scaleFactor", "b", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Lrj2/a$c;", "scaleView", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lrj2/a$b;", "dataProvider", DomainData.DOMAIN_NAME, "", "Ljava/util/List;", h.F, "()Ljava/util/List;", "scaleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sizeParamArrayList", "J", "startTimeUs", "d", "endTimeUs", "Lsj2/d;", "currSizeParam", UserInfo.SEX_FEMALE, "g", "()F", "setPerSpace", "(F)V", "perSpace", "maxSpace", "minSpace", "Lrj2/a$c;", "currentScrollX", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long startTimeUs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long endTimeUs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d currSizeParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c scaleView;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ScalePoint> scaleList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<d> sizeParamArrayList = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float perSpace = 93.0f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float maxSpace = 93.0f;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float minSpace = 72.0f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lrj2/a$b;", "", "", "Lsj2/d;", "a", "", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        @NotNull
        List<d> a();

        int b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lrj2/a$c;", "", "", HippyTKDListViewAdapter.X, "", "a", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface c {
        void a(int x16);

        /* renamed from: b */
        int getCurrentScrollX();
    }

    public a() {
        n(new sj2.a());
    }

    private final float d() {
        if (this.scaleView != null) {
            return r0.getCurrentScrollX();
        }
        return 0.0f;
    }

    private final Pair<Integer, Integer> k(float space, int index) {
        if (space >= this.maxSpace) {
            if (index == 0) {
                return TuplesKt.to(1, Integer.valueOf(index));
            }
            return TuplesKt.to(0, Integer.valueOf(index - 1));
        }
        return TuplesKt.to(2, Integer.valueOf(index));
    }

    private final Pair<Integer, Integer> l(float space, int index) {
        int lastIndex;
        if (space <= this.minSpace) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.sizeParamArrayList);
            if (index == lastIndex) {
                return TuplesKt.to(1, Integer.valueOf(index));
            }
            return TuplesKt.to(0, Integer.valueOf(index + 1));
        }
        return TuplesKt.to(2, Integer.valueOf(index));
    }

    private final void r() {
        int i3;
        d dVar = this.currSizeParam;
        if (dVar != null) {
            this.scaleList.clear();
            int a16 = ((int) dVar.a((float) (this.endTimeUs - this.startTimeUs))) + 1;
            for (int i16 = 0; i16 < a16; i16++) {
                if (i16 % 2 == 0) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                this.scaleList.add(new ScalePoint(i16, i3));
            }
        }
    }

    private final float s(float px5) {
        d dVar = this.currSizeParam;
        if (dVar != null) {
            return ((float) this.startTimeUs) + dVar.c(px5, this.perSpace);
        }
        return (float) this.startTimeUs;
    }

    private final float v(float timeUs) {
        d dVar = this.currSizeParam;
        if (dVar != null) {
            return w(dVar, timeUs);
        }
        return 0.0f;
    }

    private final float w(d sizeParam, float timeUs) {
        return this.perSpace * sizeParam.a(timeUs);
    }

    public final void a(@NotNull c scaleView) {
        Intrinsics.checkNotNullParameter(scaleView, "scaleView");
        this.scaleView = scaleView;
    }

    @VisibleForTesting
    @NotNull
    public final Pair<Integer, Integer> b(float scaleFactor) {
        int indexOf;
        boolean z16;
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends d>) ((List<? extends Object>) this.sizeParamArrayList), this.currSizeParam);
        if (scaleFactor == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return TuplesKt.to(1, Integer.valueOf(indexOf));
        }
        float f16 = this.perSpace * scaleFactor;
        if (scaleFactor > 1.0f) {
            return k(f16, indexOf);
        }
        return l(f16, indexOf);
    }

    public final int c() {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(v((float) this.endTimeUs));
        return roundToInt;
    }

    public final long e() {
        return s(d());
    }

    /* renamed from: f, reason: from getter */
    public final long getEndTimeUs() {
        return this.endTimeUs;
    }

    /* renamed from: g, reason: from getter */
    public final float getPerSpace() {
        return this.perSpace;
    }

    @NotNull
    public final List<ScalePoint> h() {
        return this.scaleList;
    }

    public final long i(@NotNull ScalePoint scalePoint) {
        long roundToLong;
        Intrinsics.checkNotNullParameter(scalePoint, "scalePoint");
        d dVar = this.currSizeParam;
        if (dVar != null) {
            long j3 = this.startTimeUs;
            float position = scalePoint.getPosition();
            float f16 = this.perSpace;
            roundToLong = MathKt__MathJVMKt.roundToLong(dVar.c(position * f16, f16));
            return j3 + roundToLong;
        }
        return 0L;
    }

    @NotNull
    public final String j(@NotNull ScalePoint scalePoint) {
        Intrinsics.checkNotNullParameter(scalePoint, "scalePoint");
        d dVar = this.currSizeParam;
        if (dVar != null) {
            return dVar.b(i(scalePoint));
        }
        return "";
    }

    public final void m(float scaleFactor) {
        int roundToInt;
        float s16 = s(d());
        Pair<Integer, Integer> b16 = b(scaleFactor);
        int intValue = b16.component1().intValue();
        b16.component2().intValue();
        if (intValue != 1) {
            this.perSpace *= scaleFactor;
            float v3 = v(s16);
            c cVar = this.scaleView;
            if (cVar != null) {
                roundToInt = MathKt__MathJVMKt.roundToInt(v3);
                cVar.a(roundToInt);
            }
        }
    }

    public final void n(@NotNull b dataProvider) {
        boolean z16;
        d dVar;
        int lastIndex;
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        List<d> a16 = dataProvider.a();
        if (a16 != null && !a16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ArrayList<d> arrayList = this.sizeParamArrayList;
        arrayList.clear();
        arrayList.addAll(dataProvider.a());
        int b16 = dataProvider.b();
        if (b16 >= 0) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (b16 <= lastIndex) {
                dVar = arrayList.get(b16);
                this.currSizeParam = dVar;
            }
        }
        d dVar2 = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(dVar2, "this[0]");
        dVar = dVar2;
        this.currSizeParam = dVar;
    }

    public final void o(long timeUs) {
        this.endTimeUs = timeUs;
        r();
    }

    public final void p(float space) {
        this.maxSpace = space;
        this.perSpace = space;
    }

    public final void q(float space) {
        this.minSpace = space;
    }

    public final long t(float px5) {
        return s(px5);
    }

    public final int u(long timeUs) {
        return (int) v((float) timeUs);
    }
}
