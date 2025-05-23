package sq0;

import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u000b"}, d2 = {"Lsq0/a;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "b", "c", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f434200a = new a();

    a() {
    }

    public final int a() {
        if (UIUtil.f112434a.A()) {
            return R.color.qui_common_icon_nav_secondary;
        }
        return R.color.qui_common_icon_primary;
    }

    public final void b(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        rootView.setBackground(null);
        if (UIUtil.f112434a.A()) {
            rootView.setBackground(ResourcesCompat.getDrawable(rootView.getResources(), R.drawable.skin_header_bar_bg, null));
        } else {
            rootView.setBackgroundColor(ie0.a.f().g(rootView.getContext(), R.color.qui_common_bg_bottom_standard, 1000));
        }
    }

    public final void c(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        rootView.setBackground(null);
        if (QQTheme.isNowSimpleUI()) {
            rootView.setBackgroundColor(ie0.a.f().g(rootView.getContext(), R.color.qui_common_bg_nav_aio, 1000));
        } else if (UIUtil.f112434a.A()) {
            rootView.setBackground(ResourcesCompat.getDrawable(rootView.getResources(), R.drawable.skin_header_bar_bg, null));
        } else {
            rootView.setBackgroundColor(ie0.a.f().g(rootView.getContext(), R.color.qui_common_bg_bottom_standard, 1000));
        }
    }
}
