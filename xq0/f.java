package xq0;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J4\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\r\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J$\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000f\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R0\u0010\u0015\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lxq0/f;", "", "", "a", "Landroid/text/Spanned;", "spanned", "", "start", "end", "e", "T", "Ljava/lang/Class;", "classType", "Lxq0/d;", "b", "Lxq0/e;", "c", "", "d", "", "Ljava/util/Map;", "spansMap", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<? extends Object>, e<? extends Object>> spansMap;

    public f() {
        Map<Class<? extends Object>, e<? extends Object>> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(ReplacementSpan.class, new e(ReplacementSpan.class)), TuplesKt.to(AbsoluteSizeSpan.class, new e(AbsoluteSizeSpan.class)), TuplesKt.to(LineHeightSpan.class, new e(LineHeightSpan.class)), TuplesKt.to(ForegroundColorSpan.class, new e(ForegroundColorSpan.class)), TuplesKt.to(BackgroundColorSpan.class, new e(BackgroundColorSpan.class)), TuplesKt.to(LineBackgroundSpan.class, new e(LineBackgroundSpan.class)), TuplesKt.to(RelativeSizeSpan.class, new e(RelativeSizeSpan.class)), TuplesKt.to(ClickableSpan.class, new e(ClickableSpan.class)));
        this.spansMap = mapOf;
    }

    private final void a() {
        Iterator<Map.Entry<Class<? extends Object>, e<? extends Object>>> it = this.spansMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().e();
        }
    }

    @Nullable
    public final <T> SpanInfo<? extends Object> b(@NotNull Class<T> classType, int start, int end) {
        e<? extends Object> eVar;
        Intrinsics.checkNotNullParameter(classType, "classType");
        if (!this.spansMap.containsKey(classType) || (eVar = this.spansMap.get(classType)) == null) {
            return null;
        }
        return eVar.a(start, end);
    }

    @Nullable
    public final <T> e<? extends Object> c(@NotNull Class<T> classType) {
        Intrinsics.checkNotNullParameter(classType, "classType");
        if (this.spansMap.containsKey(classType)) {
            return this.spansMap.get(classType);
        }
        return null;
    }

    public final boolean d(int start, int end) {
        Iterator<Map.Entry<Class<? extends Object>, e<? extends Object>>> it = this.spansMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().a(start, end) != null) {
                return true;
            }
        }
        return false;
    }

    public final void e(@NotNull Spanned spanned, int start, int end) {
        Intrinsics.checkNotNullParameter(spanned, "spanned");
        a();
        Iterator<Map.Entry<Class<? extends Object>, e<? extends Object>>> it = this.spansMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().d(spanned, start, end);
        }
    }
}
