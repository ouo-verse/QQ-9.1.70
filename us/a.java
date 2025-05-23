package us;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.runtime.message.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;
import ts.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H'J\b\u0010\u0019\u001a\u00020\u0004H&J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0016\u00a8\u0006\u001f"}, d2 = {"Lus/a;", "", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "a", "", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "action", "i", "l", "", "onBackPressed", "Landroidx/fragment/app/Fragment;", h.F, "Lts/e;", "g", "Landroidx/fragment/app/FragmentManager;", "fm", "j", "f", "Landroid/graphics/drawable/Drawable;", "drawable", "k", "clearAIOCache", "fitSystemWindows", "d", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "e", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface a {
    void a(@NotNull MsgIntent msgIntent);

    void clearAIOCache();

    void d(boolean fitSystemWindows);

    void e(@NotNull Rect rect);

    void f(@NotNull FragmentManager fm5);

    @NotNull
    e g();

    @NotNull
    Fragment h();

    void i(@NotNull String actionCode, @NotNull b action);

    void j(@NotNull FragmentManager fm5);

    @Deprecated(message = "\u5e9f\u5f03")
    void k(@NotNull Drawable drawable);

    void l(@NotNull String actionCode, @NotNull b action);

    boolean onBackPressed();
}
