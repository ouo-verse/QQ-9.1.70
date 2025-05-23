package xi4;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.ui.widget.RedView;
import com.tencent.timi.game.utils.l;
import fh4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0010\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lxi4/a;", "", "Landroid/view/View;", "tabView", "", "a", "Lcom/tencent/timi/game/ui/widget/RedView;", "view", "", "c", "", "content", "redType", "", "canClickClose", "d", "b", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f448033a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "TimiAudienceRedDotShowUtil";

    a() {
    }

    private final int a(View tabView) {
        int i3;
        RedView redView;
        RedView redView2;
        int i16 = 100;
        if (tabView != null && (redView2 = (RedView) tabView.findViewById(R.id.f72103py)) != null) {
            i3 = redView2.a();
        } else {
            i3 = 100;
        }
        if (tabView != null && (redView = (RedView) tabView.findViewById(R.id.f94905dj)) != null) {
            i16 = redView.a();
        }
        return Math.min(i3, i16);
    }

    private final void c(RedView view) {
        view.setDefaultBg(R.drawable.lqm);
        view.setTextSize(8.0f);
        int dpToPx = ViewUtils.dpToPx(4.0f);
        view.setTextPadding(dpToPx, 0, dpToPx, 0);
    }

    public final boolean b(@Nullable View tabView, int redType) {
        int a16 = a(tabView);
        if (redType > a16) {
            l.b(TAG, "canShowByType type error  " + redType + " " + a16 + " ");
            return false;
        }
        return true;
    }

    public final boolean d(@Nullable View tabView, @NotNull String content, int redType, boolean canClickClose) {
        RedView redView;
        RedView redView2;
        Intrinsics.checkNotNullParameter(content, "content");
        if (!b(tabView, redType)) {
            return false;
        }
        if (!TextUtils.isEmpty(content)) {
            l.b(TAG, "showTextDot " + content);
            if (tabView != null && (redView2 = (RedView) tabView.findViewById(R.id.f94905dj)) != null) {
                f448033a.c(redView2);
                g.o(redView2, true);
                redView2.setDotType(redType);
                redView2.setText(content);
                redView2.f380102h = canClickClose;
                RedView redView3 = (RedView) tabView.findViewById(R.id.f72103py);
                if (redView3 != null) {
                    Intrinsics.checkNotNullExpressionValue(redView3, "findViewById<RedView>(R.id.reddot)");
                    g.o(redView3, false);
                }
            }
        } else if (tabView != null && (redView = (RedView) tabView.findViewById(R.id.f94905dj)) != null) {
            g.o(redView, false);
        }
        return true;
    }
}
