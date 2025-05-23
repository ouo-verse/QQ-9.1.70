package wq0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.config.AppSetting;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010<\u001a\u00020;\u0012\b\b\u0002\u0010=\u001a\u00020\u001a\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J \u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0012\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\bH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010)\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000fH\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\rH\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u00102\u001a\u000201H\u0016J\u0010\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\rH\u0016R\u0017\u0010:\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b,\u00107\u001a\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lwq0/k;", "Lwq0/l;", "Landroid/view/View;", "getView", "", "text", "", "key", "", "f", "Landroid/content/res/ColorStateList;", "color", "setTextColor", "", "setLinkTextColor", "", "size", "setTextSize", LayoutAttrDefine.Gravity.Gravity, "setGravity", "i", "c", tl.h.F, "e", "Lcom/tencent/aio/widget/textView/view/b;", "movement", "", "enableClick", "d", "width", "Lkotlin/Pair;", "Lcom/tencent/aio/widget/textView/param/b;", "Landroid/text/Layout;", "g", "Lcom/tencent/aio/widget/textView/view/a;", TtmlNode.TAG_SPAN, "b", "Landroid/text/TextPaint;", "j", "k", "getText", "getLayout", "Lwq0/m;", "callback", "a", NodeProps.LETTER_SPACING, "setLetterSpacing", "maxLines", "setMaxLines", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "setEllipsize", "weight", CanvasView.ACTION_SET_FONT_WEIGHT, "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "gestureEnabled", "<init>", "(Landroid/content/Context;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class k implements l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textView;

    public k(@NotNull Context context, boolean z16) {
        TextView createGuildETTextView;
        Intrinsics.checkNotNullParameter(context, "context");
        if (z16) {
            createGuildETTextView = ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).createGestureTextView(context);
        } else {
            createGuildETTextView = ((IGuildTextViewFactoryApi) QRoute.api(IGuildTextViewFactoryApi.class)).createGuildETTextView(context);
        }
        this.textView = createGuildETTextView;
        createGuildETTextView.setSpannableFactory(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmoSpanFactory());
        ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).fixTextViewANRForAnd10(createGuildETTextView);
        createGuildETTextView.setAutoLinkMask(AppSetting.f99565y ? 3 : 0);
    }

    @Override // wq0.l
    public void a(@NotNull m callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // wq0.l
    public void c(float size) {
        this.textView.setLineSpacing(size, 1.0f);
    }

    @Override // wq0.l
    public void d(@Nullable com.tencent.aio.widget.textView.view.b movement, boolean enableClick) {
        TextView textView = this.textView;
        textView.setMovementMethod(movement);
        if (!enableClick) {
            textView.setFocusable(false);
            textView.setClickable(false);
            textView.setLongClickable(false);
        }
    }

    @Override // wq0.l
    public float e() {
        return this.textView.getLineSpacingMultiplier();
    }

    @Override // wq0.l
    public void f(@NotNull CharSequence text, @NotNull String key) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(key, "key");
        this.textView.setText(text);
    }

    @Override // wq0.l
    @Nullable
    public Pair<com.tencent.aio.widget.textView.param.b, Layout> g(int width) {
        return null;
    }

    @Override // wq0.l
    @Nullable
    public Layout getLayout() {
        return this.textView.getLayout();
    }

    @Override // wq0.l
    @Nullable
    public CharSequence getText() {
        return this.textView.getText();
    }

    @Override // wq0.l
    @NotNull
    public View getView() {
        return this.textView;
    }

    @Override // wq0.l
    public float h() {
        return this.textView.getLineSpacingExtra();
    }

    @Override // wq0.l
    public void i() {
        this.textView.setSingleLine();
    }

    @Override // wq0.l
    @NotNull
    public TextPaint j() {
        TextPaint paint = this.textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "textView.paint");
        return paint;
    }

    @Override // wq0.l
    public void setEllipsize(@NotNull TextUtils.TruncateAt ellipsize) {
        Intrinsics.checkNotNullParameter(ellipsize, "ellipsize");
        this.textView.setEllipsize(ellipsize);
    }

    @Override // wq0.l
    public void setFontWeight(int weight) {
        Typeface create;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                TextView textView = this.textView;
                create = Typeface.create(null, weight, false);
                textView.setTypeface(create);
            }
        } catch (Exception e16) {
            QLog.e("GuildAioTextView", 1, "setTypeface error:", e16);
        }
    }

    @Override // wq0.l
    public void setGravity(int gravity) {
        this.textView.setGravity(gravity);
    }

    @Override // wq0.l
    public void setLetterSpacing(float letterSpacing) {
        this.textView.setLetterSpacing(letterSpacing);
    }

    @Override // wq0.l
    public void setLinkTextColor(@NotNull ColorStateList color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.textView.setLinkTextColor(color);
    }

    @Override // wq0.l
    public void setMaxLines(int maxLines) {
        this.textView.setMaxLines(maxLines);
    }

    @Override // wq0.l
    public void setTextColor(@NotNull ColorStateList color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.textView.setTextColor(color);
    }

    @Override // wq0.l
    public void setTextSize(float size) {
        this.textView.setTextSize(size);
    }

    @Override // wq0.l
    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public /* synthetic */ k(Context context, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? false : z16);
    }

    @Override // wq0.l
    public void k() {
    }

    @Override // wq0.l
    public void b(@Nullable com.tencent.aio.widget.textView.view.a span) {
    }
}
