package zd0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lzd0/e;", "Lzd0/b;", "Lcom/tencent/biz/qui/noticebar/e;", "", "iconId", "setIcon", "Landroid/graphics/drawable/Drawable;", "icon", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "drawable", h.F, "color", "d", "Landroid/content/res/ColorStateList;", "setLinkTextColor", "l", "j", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "iconView", "p", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "Landroid/content/Context;", "context", "Lyd0/c;", "res", "<init>", "(Landroid/content/Context;Lyd0/c;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class e extends b<com.tencent.biz.qui.noticebar.e> implements com.tencent.biz.qui.noticebar.e {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final ImageView iconView;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Drawable iconDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Context context, @NotNull yd0.c res) {
        super(context, res);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(res, "res");
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(res.e());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int c16 = com.tencent.biz.qui.quicommon.e.c(24.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c16, c16);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        imageView.setLayoutParams(layoutParams);
        getIconLayout().addView(imageView);
        this.iconView = imageView;
    }

    @Override // com.tencent.biz.qui.noticebar.e
    @NotNull
    public com.tencent.biz.qui.noticebar.e d(int color) {
        yd0.a res = getRes();
        if (res != null) {
            ((yd0.c) res).m(Integer.valueOf(color));
            getMsgView().setTextColor(getRes().g());
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.biz.qui.noticebar.util.QUINoticeBarVasResource");
    }

    @Override // com.tencent.biz.qui.noticebar.e
    @NotNull
    public com.tencent.biz.qui.noticebar.e h(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        yd0.a res = getRes();
        if (res != null) {
            ((yd0.c) res).j(drawable);
            u();
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.biz.qui.noticebar.util.QUINoticeBarVasResource");
    }

    @Override // com.tencent.biz.qui.noticebar.b
    public int j() {
        return 3;
    }

    @Override // com.tencent.biz.qui.noticebar.e
    @NotNull
    public com.tencent.biz.qui.noticebar.e l(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        yd0.a res = getRes();
        if (res != null) {
            ((yd0.c) res).k(drawable);
            x();
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.biz.qui.noticebar.util.QUINoticeBarVasResource");
    }

    @Override // com.tencent.biz.qui.noticebar.e
    @NotNull
    public com.tencent.biz.qui.noticebar.e setIcon(@DrawableRes int iconId) {
        Drawable drawable;
        if (iconId == 0) {
            drawable = null;
        } else {
            drawable = ContextCompat.getDrawable(getContext(), iconId);
        }
        return z(drawable);
    }

    @Override // com.tencent.biz.qui.noticebar.e
    @NotNull
    public com.tencent.biz.qui.noticebar.e setLinkTextColor(@NotNull ColorStateList color) {
        Intrinsics.checkNotNullParameter(color, "color");
        yd0.a res = getRes();
        if (res != null) {
            ((yd0.c) res).l(color);
            getLinkBtnView().setTextColor(getRes().f());
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.biz.qui.noticebar.util.QUINoticeBarVasResource");
    }

    @NotNull
    public com.tencent.biz.qui.noticebar.e z(@Nullable Drawable icon) {
        this.iconDrawable = icon;
        if (icon == null) {
            this.iconView.setImageDrawable(getRes().e());
        } else {
            this.iconView.setImageDrawable(icon);
        }
        return this;
    }
}
