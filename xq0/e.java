package xq0;

import android.text.Spanned;
import com.qzone.misc.network.uploader.report.BusinessReport;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\u0004\b(\u0010)J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R6\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010!\u001a\u0004\b\u0019\u0010\"\"\u0004\b#\u0010$R$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\u0010\u0010\"\"\u0004\b&\u0010$\u00a8\u0006*"}, d2 = {"Lxq0/e;", "T", "", "Landroid/text/Spanned;", "spanned", "", "start", "end", "", "d", "Lxq0/d;", "a", "e", "Ljava/lang/Class;", "Ljava/lang/Class;", "classType", "b", "I", "getNumberOfSpans", "()I", "setNumberOfSpans", "(I)V", "numberOfSpans", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "getSpans", "()Ljava/util/ArrayList;", "setSpans", "(Ljava/util/ArrayList;)V", "spans", "", "[I", "()[I", "setSpanStarts", "([I)V", "spanStarts", "setSpanEnds", "spanEnds", "<init>", "(Ljava/lang/Class;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<T> classType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int numberOfSpans;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<T> spans;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] spanStarts;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] spanEnds;

    public e(@NotNull Class<T> classType) {
        Intrinsics.checkNotNullParameter(classType, "classType");
        this.classType = classType;
    }

    @Nullable
    public final SpanInfo<T> a(int start, int end) {
        if (this.spanStarts != null && this.spanEnds != null && this.spans != null) {
            int i3 = this.numberOfSpans;
            for (int i16 = 0; i16 < i3; i16++) {
                int[] iArr = this.spanStarts;
                Intrinsics.checkNotNull(iArr);
                if (iArr[i16] < end) {
                    int[] iArr2 = this.spanEnds;
                    Intrinsics.checkNotNull(iArr2);
                    if (iArr2[i16] > start) {
                        int[] iArr3 = this.spanStarts;
                        Intrinsics.checkNotNull(iArr3);
                        int i17 = iArr3[i16];
                        int[] iArr4 = this.spanEnds;
                        Intrinsics.checkNotNull(iArr4);
                        int i18 = iArr4[i16];
                        ArrayList<T> arrayList = this.spans;
                        Intrinsics.checkNotNull(arrayList);
                        return new SpanInfo<>(i17, i18, arrayList.get(i16));
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final int[] getSpanEnds() {
        return this.spanEnds;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final int[] getSpanStarts() {
        return this.spanStarts;
    }

    public final void d(@NotNull Spanned spanned, int start, int end) {
        boolean z16;
        Intrinsics.checkNotNullParameter(spanned, "spanned");
        Object[] spans = spanned.getSpans(start, end, this.classType);
        boolean z17 = true;
        if (spans != null) {
            if (spans.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = false;
            }
        }
        if (z17) {
            return;
        }
        this.numberOfSpans = spans.length;
        BusinessReport.AnonymousClass1 anonymousClass1 = (ArrayList<T>) new ArrayList(this.numberOfSpans);
        int i3 = this.numberOfSpans;
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            Object obj = spans[i16];
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (spanStart < spanEnd) {
                anonymousClass1.add((BusinessReport.AnonymousClass1) obj);
                iArr[i16] = spanStart;
                iArr2[i16] = spanEnd;
            }
        }
        this.spans = anonymousClass1;
        this.spanStarts = iArr;
        this.spanEnds = iArr2;
    }

    public final void e() {
        this.numberOfSpans = 0;
        this.spans = null;
        this.spanStarts = null;
        this.spanEnds = null;
    }
}
