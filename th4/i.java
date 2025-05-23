package th4;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJD\u0010\u0015\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lth4/i;", "", "", "url", "Lcom/tencent/image/URLImageView;", "igv", "", "e", "txtColor", "Landroid/widget/TextView;", "txv", "d", "", NodeProps.COLORS, "", "topLeftRadius", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "Landroid/view/View;", "view", "b", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "a", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "defaultColorDrawable", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f436350a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ColorDrawable defaultColorDrawable = new ColorDrawable(16052712);

    i() {
    }

    public static /* synthetic */ void c(i iVar, List list, float f16, float f17, float f18, float f19, View view, int i3, Object obj) {
        float f26;
        float f27;
        float f28;
        float f29;
        if ((i3 & 2) != 0) {
            f26 = 0.0f;
        } else {
            f26 = f16;
        }
        if ((i3 & 4) != 0) {
            f27 = 0.0f;
        } else {
            f27 = f17;
        }
        if ((i3 & 8) != 0) {
            f28 = 0.0f;
        } else {
            f28 = f18;
        }
        if ((i3 & 16) != 0) {
            f29 = 0.0f;
        } else {
            f29 = f19;
        }
        iVar.b(list, f26, f27, f28, f29, view);
    }

    @NotNull
    public final URLDrawable.URLDrawableOptions a(@NotNull URLImageView igv) {
        Drawable drawable;
        Drawable drawable2;
        Intrinsics.checkNotNullParameter(igv, "igv");
        URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
        if (igv.getDrawable() != null) {
            drawable = igv.getDrawable();
        } else {
            drawable = defaultColorDrawable;
        }
        options.mLoadingDrawable = drawable;
        if (igv.getDrawable() != null) {
            drawable2 = igv.getDrawable();
        } else {
            drawable2 = defaultColorDrawable;
        }
        options.mFailedDrawable = drawable2;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    public final void b(@NotNull List<String> colors, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius, @NotNull View view) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(view, "view");
        if (colors.size() == 1) {
            fh4.g.e(fh4.g.c(view, fh4.c.a(colors.get(0)), fh4.c.a(colors.get(0))), topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);
        } else if (colors.size() > 1) {
            fh4.g.e(fh4.g.c(view, fh4.c.a(colors.get(0)), fh4.c.a(colors.get(1))), topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);
        }
    }

    public final void d(@NotNull String txtColor, @NotNull TextView txv) {
        Intrinsics.checkNotNullParameter(txtColor, "txtColor");
        Intrinsics.checkNotNullParameter(txv, "txv");
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "setColorToTextView txtColor:" + txtColor + ", txv:" + txv);
        txv.setTextColor(fh4.c.a(txtColor));
    }

    public final void e(@Nullable String url, @NotNull URLImageView igv) {
        Intrinsics.checkNotNullParameter(igv, "igv");
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "setUrlToIgv url:" + url + ", igv:" + igv);
        if (!TextUtils.isEmpty(url)) {
            Intrinsics.checkNotNull(url);
            com.tencent.timi.game.utils.b.g(igv, url, a(igv));
        }
    }
}
