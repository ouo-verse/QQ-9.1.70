package yd0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R$\u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u0014\u0010'\u001a\u00020%8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&\u00a8\u0006,"}, d2 = {"Lyd0/c;", "Lyd0/a;", "Landroid/graphics/drawable/Drawable;", "a", "", "g", "b", "Landroid/content/res/ColorStateList;", "f", "e", "c", "i", "Landroid/graphics/drawable/Drawable;", "getArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "setArrowDrawable", "(Landroid/graphics/drawable/Drawable;)V", "arrowDrawable", "Ljava/lang/Integer;", "getMsgTextColor", "()Ljava/lang/Integer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Integer;)V", "msgTextColor", "d", "getCloseDrawable", "k", "closeDrawable", "Landroid/content/res/ColorStateList;", "getLinkBtnTextColor", "()Landroid/content/res/ColorStateList;", "l", "(Landroid/content/res/ColorStateList;)V", "linkBtnTextColor", "getBgDrawable", "j", "bgDrawable", "", "Ljava/lang/String;", "btnColorStr", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable arrowDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer msgTextColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable closeDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ColorStateList linkBtnTextColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable bgDrawable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String btnColorStr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.btnColorStr = "#8C6029";
    }

    @Override // yd0.a
    @Nullable
    public Drawable a() {
        Drawable drawable = this.arrowDrawable;
        if (drawable != null) {
            return drawable;
        }
        int parseColor = Color.parseColor(this.btnColorStr);
        Drawable drawable2 = ContextCompat.getDrawable(getContext(), R.drawable.qui_arrow_right);
        if (drawable2 != null) {
            Intrinsics.checkNotNullExpressionValue(drawable2, "ContextCompat.getDrawabl\u2026row_right) ?: return null");
            return b.f450165a.e(drawable2, parseColor);
        }
        return null;
    }

    @Override // yd0.a
    @Nullable
    public Drawable b() {
        Drawable drawable = this.closeDrawable;
        if (drawable != null) {
            return drawable;
        }
        int parseColor = Color.parseColor(this.btnColorStr);
        Drawable drawable2 = ContextCompat.getDrawable(getContext(), R.drawable.qui_close);
        if (drawable2 != null) {
            Intrinsics.checkNotNullExpressionValue(drawable2, "ContextCompat.getDrawabl\u2026qui_close) ?: return null");
            return b.f450165a.c(drawable2, parseColor);
        }
        return null;
    }

    @Override // yd0.a
    @NotNull
    public Drawable c() {
        Drawable drawable = this.bgDrawable;
        if (drawable == null) {
            return new ColorDrawable(Color.parseColor("#FCF5EA"));
        }
        return drawable;
    }

    @Override // yd0.a
    @Nullable
    public Drawable e() {
        return null;
    }

    @Override // yd0.a
    @NotNull
    public ColorStateList f() {
        ColorStateList colorStateList = this.linkBtnTextColor;
        if (colorStateList != null) {
            return colorStateList;
        }
        int parseColor = Color.parseColor(this.btnColorStr);
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{b.f450165a.a(parseColor, 0.5f), parseColor});
    }

    @Override // yd0.a
    public int g() {
        Integer num = this.msgTextColor;
        if (num != null) {
            return num.intValue();
        }
        return Color.parseColor("#000000");
    }

    @Override // yd0.a
    public int i() {
        return 0;
    }

    public final void j(@Nullable Drawable drawable) {
        this.bgDrawable = drawable;
    }

    public final void k(@Nullable Drawable drawable) {
        this.closeDrawable = drawable;
    }

    public final void l(@Nullable ColorStateList colorStateList) {
        this.linkBtnTextColor = colorStateList;
    }

    public final void m(@Nullable Integer num) {
        this.msgTextColor = num;
    }
}
