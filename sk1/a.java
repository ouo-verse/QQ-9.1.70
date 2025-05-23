package sk1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000b"}, d2 = {"Lsk1/a;", "", "", "iconType", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f433915a = new a();

    a() {
    }

    public static /* synthetic */ Drawable b(a aVar, int i3, Context context, Drawable drawable, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            drawable = ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_default);
        }
        return aVar.a(i3, context, drawable);
    }

    @Nullable
    public final Drawable a(int iconType, @NotNull Context context, @Nullable Drawable defaultDrawable) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (iconType) {
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_tencentdocs_doc);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_tencentdocs_xls);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_tencentdocs_slide);
            case 4:
                return ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_tencentdocs_form);
            case 5:
                return ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_tencentdocs_smartcanvas);
            case 6:
                return ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_tencentdocs_mindmap);
            case 7:
                return ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_tencentdocs_flowchart);
            default:
                return defaultDrawable;
        }
    }
}
