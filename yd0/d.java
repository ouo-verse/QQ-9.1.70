package yd0;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lyd0/d;", "Lyd0/a;", "", "g", "Landroid/graphics/drawable/Drawable;", "e", "c", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public class d extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // yd0.a
    @NotNull
    public Drawable c() {
        String str;
        if (je0.a.a(getContext())) {
            str = "#6A272B";
        } else {
            str = "#FFEFF1";
        }
        return new ColorDrawable(Color.parseColor(str));
    }

    @Override // yd0.a
    @NotNull
    public Drawable e() {
        Drawable o16 = ie0.a.f().o(getContext(), R.drawable.qui_info_filled, R.color.qui_common_feedback_error, 1000);
        Intrinsics.checkNotNullExpressionValue(o16, "QUITokenThemeManager.get\u2026  QUITokenConstants.SKIN)");
        return o16;
    }

    @Override // yd0.a
    public int g() {
        String str;
        if (je0.a.a(getContext())) {
            str = "#80FFFFFF";
        } else {
            str = "#80000000";
        }
        return Color.parseColor(str);
    }
}
