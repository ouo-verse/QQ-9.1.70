package xq0;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0000J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010$\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010&\u001a\u0004\b\u0013\u0010'\"\u0004\b(\u0010)R2\u00102\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010.\u001a\u0004\b\u001b\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lxq0/b;", "", "", "size", "", "f", "a", h.F, "Lcom/tencent/aio/widget/textView/param/b;", "layoutParam", "i", "", "g", "Z", "getMIsValid", "()Z", "setMIsValid", "(Z)V", "mIsValid", "b", "I", "getMLayoutParamHashCode", "()I", "setMLayoutParamHashCode", "(I)V", "mLayoutParamHashCode", "", "c", "[F", "d", "()[F", "setMeasuredTextWidths", "([F)V", "measuredTextWidths", "e", "setXPosArray", "xPosArray", "", "[Z", "()[Z", "setDrawStartIndexes", "([Z)V", "drawStartIndexes", "Ljava/util/ArrayList;", "Lxq0/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setLineInfos", "(Ljava/util/ArrayList;)V", "lineInfos", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mIsValid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mLayoutParamHashCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private float[] measuredTextWidths;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private float[] xPosArray;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private boolean[] drawStartIndexes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<LineInfo> lineInfos = new ArrayList<>();

    @NotNull
    public final b a() {
        float[] fArr;
        float[] fArr2;
        b bVar = new b();
        bVar.mIsValid = this.mIsValid;
        bVar.mLayoutParamHashCode = this.mLayoutParamHashCode;
        float[] fArr3 = this.measuredTextWidths;
        boolean[] zArr = null;
        if (fArr3 != null) {
            fArr = Arrays.copyOf(fArr3, fArr3.length);
            Intrinsics.checkNotNullExpressionValue(fArr, "copyOf(this, size)");
        } else {
            fArr = null;
        }
        bVar.measuredTextWidths = fArr;
        float[] fArr4 = this.xPosArray;
        if (fArr4 != null) {
            fArr2 = Arrays.copyOf(fArr4, fArr4.length);
            Intrinsics.checkNotNullExpressionValue(fArr2, "copyOf(this, size)");
        } else {
            fArr2 = null;
        }
        bVar.xPosArray = fArr2;
        boolean[] zArr2 = this.drawStartIndexes;
        if (zArr2 != null) {
            zArr = Arrays.copyOf(zArr2, zArr2.length);
            Intrinsics.checkNotNullExpressionValue(zArr, "copyOf(this, size)");
        }
        bVar.drawStartIndexes = zArr;
        bVar.lineInfos = new ArrayList<>(this.lineInfos);
        return bVar;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final boolean[] getDrawStartIndexes() {
        return this.drawStartIndexes;
    }

    @NotNull
    public final ArrayList<LineInfo> c() {
        return this.lineInfos;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final float[] getMeasuredTextWidths() {
        return this.measuredTextWidths;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final float[] getXPosArray() {
        return this.xPosArray;
    }

    public final void f(int size) {
        h();
        this.measuredTextWidths = new float[size];
        this.xPosArray = new float[size];
        this.drawStartIndexes = new boolean[size];
    }

    public final boolean g(@NotNull com.tencent.aio.widget.textView.param.b layoutParam) {
        Intrinsics.checkNotNullParameter(layoutParam, "layoutParam");
        if (this.mLayoutParamHashCode == layoutParam.hashCode() && this.mIsValid) {
            return true;
        }
        return false;
    }

    public final void h() {
        this.mIsValid = false;
        this.mLayoutParamHashCode = 0;
        this.measuredTextWidths = null;
        this.xPosArray = null;
        this.drawStartIndexes = null;
        this.lineInfos.clear();
    }

    public final void i(@NotNull com.tencent.aio.widget.textView.param.b layoutParam) {
        Intrinsics.checkNotNullParameter(layoutParam, "layoutParam");
        this.mLayoutParamHashCode = layoutParam.hashCode();
        this.mIsValid = true;
    }
}
