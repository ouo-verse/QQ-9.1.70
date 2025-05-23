package xn4;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J<\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lxn4/b;", "Landroid/text/style/LineHeightSpan;", "", "text", "", "start", "end", "spanstartv", NodeProps.LINE_HEIGHT, "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "chooseHeight", "d", "I", "height", "<init>", "(I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b implements LineHeightSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int height;

    public b(int i3) {
        this.height = i3;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(@Nullable CharSequence text, int start, int end, int spanstartv, int lineHeight, @Nullable Paint.FontMetricsInt fm5) {
        int i3;
        int i16;
        int roundToInt;
        if (fm5 != null && (i16 = (i3 = fm5.descent) - fm5.ascent) >= 0) {
            roundToInt = MathKt__MathJVMKt.roundToInt(i3 * (this.height / i16));
            fm5.descent = roundToInt;
            fm5.ascent = roundToInt - this.height;
        }
    }
}
