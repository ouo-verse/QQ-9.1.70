package yd0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lyd0/a;", "", "Landroid/graphics/drawable/Drawable;", "a", "b", "e", "", "g", "i", "c", h.F, "Landroid/content/res/ColorStateList;", "f", "Landroid/content/Context;", "Landroid/content/Context;", "d", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Nullable
    public Drawable a() {
        return ContextCompat.getDrawable(this.context, R.drawable.qui_chevron_right_icon_secondary_01);
    }

    @Nullable
    public Drawable b() {
        return ContextCompat.getDrawable(this.context, R.drawable.qui_close_icon_secondary_01_selector);
    }

    @NotNull
    public Drawable c() {
        return new ColorDrawable(this.context.getColor(R.color.qui_common_fill_light_primary));
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public Drawable e() {
        return ie0.a.f().o(this.context, R.drawable.qui_info_filled, R.color.qui_common_brand_standard, 1000);
    }

    @NotNull
    public ColorStateList f() {
        ColorStateList colorStateList = this.context.getColorStateList(R.color.qui_common_text_link_selector);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateLis\u2026ommon_text_link_selector)");
        return colorStateList;
    }

    public int g() {
        return this.context.getColor(R.color.qui_common_text_secondary);
    }

    public int h() {
        return this.context.getColor(R.color.qui_common_overlay_standard_primary);
    }

    public int i() {
        return this.context.getColor(R.color.qui_common_border_light);
    }
}
