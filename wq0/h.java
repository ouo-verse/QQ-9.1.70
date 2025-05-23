package wq0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aio.widget.textView.api.a;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.guild.aio.util.ui.staticlayout.justify.JustifyTextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u001a\u0010\u001f\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J \u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010!2\u0006\u0010 \u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\bH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010)\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0012H\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u00102\u001a\u000201H\u0016J\u0010\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0010H\u0016R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u00107\u00a8\u0006="}, d2 = {"Lwq0/h;", "Lwq0/l;", "Landroid/view/View;", "getView", "", "text", "", "key", "", "f", "Lcom/tencent/aio/widget/textView/view/a;", TtmlNode.TAG_SPAN, "b", "Landroid/content/res/ColorStateList;", "color", "setTextColor", "", "setLinkTextColor", "", "size", "setTextSize", LayoutAttrDefine.Gravity.Gravity, "setGravity", "i", "c", tl.h.F, "e", "Lcom/tencent/aio/widget/textView/view/b;", "movement", "", "enableClick", "d", "width", "Lkotlin/Pair;", "Lcom/tencent/aio/widget/textView/param/b;", "Landroid/text/Layout;", "g", "Landroid/text/TextPaint;", "j", "k", "getText", "getLayout", "Lwq0/m;", "callback", "a", NodeProps.LETTER_SPACING, "setLetterSpacing", "maxLines", "setMaxLines", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "setEllipsize", "weight", CanvasView.ACTION_SET_FONT_WEIGHT, "Lcom/tencent/guild/aio/util/ui/staticlayout/justify/JustifyTextView;", "Lcom/tencent/guild/aio/util/ui/staticlayout/justify/JustifyTextView;", "justifyTextView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h implements l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JustifyTextView justifyTextView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"wq0/h$a", "Lcom/tencent/aio/widget/textView/api/d;", "Ljava/util/concurrent/Executor;", "c", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.aio.widget.textView.api.d {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Runnable runnable) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(Runnable runnable) {
            runnable.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Runnable runnable) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                runnable.run();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(runnable);
            }
        }

        @Override // com.tencent.aio.widget.textView.api.d
        @NotNull
        public Executor a() {
            return new Executor() { // from class: wq0.e
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    h.a.g(runnable);
                }
            };
        }

        @Override // com.tencent.aio.widget.textView.api.d
        @NotNull
        public Executor b() {
            return new Executor() { // from class: wq0.g
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    h.a.i(runnable);
                }
            };
        }

        @Override // com.tencent.aio.widget.textView.api.d
        @NotNull
        public Executor c() {
            return new Executor() { // from class: wq0.f
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    h.a.h(runnable);
                }
            };
        }
    }

    static {
        a.Companion.d(com.tencent.aio.widget.textView.api.a.INSTANCE, new a(), null, 2, null);
    }

    public h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JustifyTextView justifyTextView = new JustifyTextView(context, null, 0, 6, null);
        justifyTextView.setSyncCreateLayout();
        justifyTextView.q().setAntiAlias(true);
        this.justifyTextView = justifyTextView;
    }

    @Override // wq0.l
    public void a(@NotNull m callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.justifyTextView.setOnMeasureDoneCallback(callback);
    }

    @Override // wq0.l
    public void b(@Nullable com.tencent.aio.widget.textView.view.a span) {
        this.justifyTextView.setSpanCallBack(span);
    }

    @Override // wq0.l
    public void c(float size) {
        this.justifyTextView.setSpacingAdd(size);
    }

    @Override // wq0.l
    public void d(@Nullable com.tencent.aio.widget.textView.view.b movement, boolean enableClick) {
        if (movement != null) {
            this.justifyTextView.setMovementMethod(movement);
        }
    }

    @Override // wq0.l
    public float e() {
        return this.justifyTextView.m();
    }

    @Override // wq0.l
    public void f(@NotNull CharSequence text, @NotNull String key) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(key, "key");
        this.justifyTextView.setText(text, key);
    }

    @Override // wq0.l
    @Nullable
    public Pair<com.tencent.aio.widget.textView.param.b, Layout> g(int width) {
        return this.justifyTextView.v(width);
    }

    @Override // wq0.l
    @Nullable
    public Layout getLayout() {
        return this.justifyTextView.i();
    }

    @Override // wq0.l
    @Nullable
    public CharSequence getText() {
        return this.justifyTextView.o();
    }

    @Override // wq0.l
    @NotNull
    public View getView() {
        return this.justifyTextView;
    }

    @Override // wq0.l
    public float h() {
        return this.justifyTextView.l();
    }

    @Override // wq0.l
    public void i() {
        this.justifyTextView.setMaxLines(1);
    }

    @Override // wq0.l
    @NotNull
    public TextPaint j() {
        return this.justifyTextView.q();
    }

    @Override // wq0.l
    public void k() {
        this.justifyTextView.setNeedDoubleCheck(true);
    }

    @Override // wq0.l
    public void setEllipsize(@NotNull TextUtils.TruncateAt ellipsize) {
        Intrinsics.checkNotNullParameter(ellipsize, "ellipsize");
        this.justifyTextView.setEllipsize(ellipsize);
    }

    @Override // wq0.l
    public void setFontWeight(int weight) {
        Typeface create;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                JustifyTextView justifyTextView = this.justifyTextView;
                create = Typeface.create(null, weight, false);
                Intrinsics.checkNotNullExpressionValue(create, "create(null, weight, false)");
                justifyTextView.setTypeface(create);
            }
        } catch (Exception e16) {
            QLog.e("GuildAioTextView", 1, "setTypeface error:", e16);
        }
    }

    @Override // wq0.l
    public void setGravity(int gravity) {
        this.justifyTextView.setGravity(gravity);
    }

    @Override // wq0.l
    public void setLetterSpacing(float letterSpacing) {
        this.justifyTextView.setLetterSpacing(letterSpacing);
    }

    @Override // wq0.l
    public void setLinkTextColor(@NotNull ColorStateList color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.justifyTextView.setLinkTextColor(color);
    }

    @Override // wq0.l
    public void setMaxLines(int maxLines) {
        this.justifyTextView.setMaxLines(maxLines);
    }

    @Override // wq0.l
    public void setTextColor(@NotNull ColorStateList color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.justifyTextView.setTextColor(color);
    }

    @Override // wq0.l
    public void setTextSize(float size) {
        this.justifyTextView.setTextSize(ViewUtils.spToPx(size));
    }

    @Override // wq0.l
    public void setTextColor(int color) {
        JustifyTextView justifyTextView = this.justifyTextView;
        ColorStateList valueOf = ColorStateList.valueOf(color);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(color)");
        justifyTextView.setTextColor(valueOf);
    }
}
