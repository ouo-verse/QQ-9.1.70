package wq0;

import android.content.res.ColorStateList;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000eH&J\b\u0010\u0015\u001a\u00020\bH&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0017\u001a\u00020\u0010H&J\b\u0010\u0018\u001a\u00020\u0010H&J\u001c\u0010\u001d\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH&J \u0010\"\u001a\u0012\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u000eH&J\u0012\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#H&J\b\u0010'\u001a\u00020&H&J\b\u0010(\u001a\u00020\bH&J\n\u0010)\u001a\u0004\u0018\u00010!H&J\u0010\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020*H&J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0010H&J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u000eH&J\u0010\u00103\u001a\u00020\b2\u0006\u00102\u001a\u000201H&J\u0010\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\u000eH&\u00a8\u00066"}, d2 = {"Lwq0/l;", "", "Landroid/view/View;", "getView", "", "text", "", "key", "", "f", "getText", "Landroid/content/res/ColorStateList;", "color", "setTextColor", "", "setLinkTextColor", "", "size", "setTextSize", LayoutAttrDefine.Gravity.Gravity, "setGravity", "i", "c", tl.h.F, "e", "Lcom/tencent/aio/widget/textView/view/b;", "movement", "", "enableClick", "d", "width", "Lkotlin/Pair;", "Lcom/tencent/aio/widget/textView/param/b;", "Landroid/text/Layout;", "g", "Lcom/tencent/aio/widget/textView/view/a;", TtmlNode.TAG_SPAN, "b", "Landroid/text/TextPaint;", "j", "k", "getLayout", "Lwq0/m;", "callback", "a", NodeProps.LETTER_SPACING, "setLetterSpacing", "maxLines", "setMaxLines", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "setEllipsize", "weight", CanvasView.ACTION_SET_FONT_WEIGHT, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface l {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ void a(l lVar, com.tencent.aio.widget.textView.view.b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                lVar.d(bVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMovementMethod");
        }
    }

    void a(@NotNull m callback);

    void b(@Nullable com.tencent.aio.widget.textView.view.a span);

    void c(float size);

    void d(@Nullable com.tencent.aio.widget.textView.view.b movement, boolean enableClick);

    float e();

    void f(@NotNull CharSequence text, @NotNull String key);

    @Nullable
    Pair<com.tencent.aio.widget.textView.param.b, Layout> g(int width);

    @Nullable
    Layout getLayout();

    @Nullable
    CharSequence getText();

    @NotNull
    View getView();

    float h();

    void i();

    @NotNull
    TextPaint j();

    void k();

    void setEllipsize(@NotNull TextUtils.TruncateAt ellipsize);

    void setFontWeight(int weight);

    void setGravity(int gravity);

    void setLetterSpacing(float letterSpacing);

    void setLinkTextColor(@NotNull ColorStateList color);

    void setMaxLines(int maxLines);

    void setTextColor(int color);

    void setTextColor(@NotNull ColorStateList color);

    void setTextSize(float size);
}
