package zd1;

import android.text.Spanned;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AbsoluteSizeSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lzd1/a;", "", "Landroid/text/Spanned;", "spanned", "", "start", "end", "c", "", "", "d", "", "defaultTextSize", "b", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a {
    private final int c(Spanned spanned, int start, int end) {
        while (start < end) {
            if (d(spanned.charAt(start))) {
                return start;
            }
            start++;
        }
        return -1;
    }

    private final boolean d(char c16) {
        boolean z16;
        if (c16 == '\u200b' || c16 == '\uffef') {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        return true;
    }

    public final float b(@NotNull Spanned spanned, int start, int end, float defaultTextSize) {
        boolean z16;
        Intrinsics.checkNotNullParameter(spanned, "spanned");
        int c16 = c(spanned, start, end);
        if (c16 >= 0) {
            AbsoluteSizeSpan[] absoluteSizeSpans = (AbsoluteSizeSpan[]) spanned.getSpans(c16, c16, AbsoluteSizeSpan.class);
            Intrinsics.checkNotNullExpressionValue(absoluteSizeSpans, "absoluteSizeSpans");
            if (absoluteSizeSpans.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return absoluteSizeSpans[absoluteSizeSpans.length - 1].getValue().intValue();
            }
        }
        return defaultTextSize;
    }
}
