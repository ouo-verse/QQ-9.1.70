package zd0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lzd0/d;", "Lzd0/b;", "Lcom/tencent/biz/qui/noticebar/d;", "", "iconId", "setIcon", "Landroid/graphics/drawable/Drawable;", "icon", "j", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "iconView", "p", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class d extends b<com.tencent.biz.qui.noticebar.d> implements com.tencent.biz.qui.noticebar.d {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final ImageView iconView;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Drawable iconDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context) {
        super(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(getRes().e());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int c16 = com.tencent.biz.qui.quicommon.e.c(24.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c16, c16);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        imageView.setLayoutParams(layoutParams);
        getIconLayout().addView(imageView);
        this.iconView = imageView;
    }

    @Override // com.tencent.biz.qui.noticebar.b
    public int j() {
        return 0;
    }

    @Override // com.tencent.biz.qui.noticebar.d
    @NotNull
    public com.tencent.biz.qui.noticebar.d setIcon(@DrawableRes int iconId) {
        return setIcon(iconId == 0 ? null : ContextCompat.getDrawable(getContext(), iconId));
    }

    @Override // com.tencent.biz.qui.noticebar.d
    @NotNull
    public com.tencent.biz.qui.noticebar.d setIcon(@Nullable Drawable icon) {
        this.iconDrawable = icon;
        if (icon == null) {
            this.iconView.setImageDrawable(getRes().e());
        } else {
            this.iconView.setImageDrawable(icon);
        }
        return this;
    }
}
