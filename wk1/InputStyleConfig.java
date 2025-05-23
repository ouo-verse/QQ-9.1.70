package wk1;

import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u0012\u0006\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u0013\u0010\u001fR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010!\u001a\u0004\b\u000e\u0010\"\u00a8\u0006&"}, d2 = {"Lwk1/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "backgroundColor", "b", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "iconColor", "c", "e", "hintTextColor", "d", "hintTextBackground", "", "Ljava/lang/Long;", "g", "()Ljava/lang/Long;", "likeVibrate", "", UserInfo.SEX_FEMALE, "()F", "dividingLineHeight", "I", "()I", "dividingLineDrawableRes", "<init>", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Long;FI)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wk1.m, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class InputStyleConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Drawable backgroundColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer iconColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer hintTextColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Drawable hintTextBackground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long likeVibrate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float dividingLineHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int dividingLineDrawableRes;

    public InputStyleConfig(@Nullable Drawable drawable, @Nullable Integer num, @Nullable Integer num2, @Nullable Drawable drawable2, @Nullable Long l3, float f16, int i3) {
        this.backgroundColor = drawable;
        this.iconColor = num;
        this.hintTextColor = num2;
        this.hintTextBackground = drawable2;
        this.likeVibrate = l3;
        this.dividingLineHeight = f16;
        this.dividingLineDrawableRes = i3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Drawable getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: b, reason: from getter */
    public final int getDividingLineDrawableRes() {
        return this.dividingLineDrawableRes;
    }

    /* renamed from: c, reason: from getter */
    public final float getDividingLineHeight() {
        return this.dividingLineHeight;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Drawable getHintTextBackground() {
        return this.hintTextBackground;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Integer getHintTextColor() {
        return this.hintTextColor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputStyleConfig)) {
            return false;
        }
        InputStyleConfig inputStyleConfig = (InputStyleConfig) other;
        if (Intrinsics.areEqual(this.backgroundColor, inputStyleConfig.backgroundColor) && Intrinsics.areEqual(this.iconColor, inputStyleConfig.iconColor) && Intrinsics.areEqual(this.hintTextColor, inputStyleConfig.hintTextColor) && Intrinsics.areEqual(this.hintTextBackground, inputStyleConfig.hintTextBackground) && Intrinsics.areEqual(this.likeVibrate, inputStyleConfig.likeVibrate) && Float.compare(this.dividingLineHeight, inputStyleConfig.dividingLineHeight) == 0 && this.dividingLineDrawableRes == inputStyleConfig.dividingLineDrawableRes) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Integer getIconColor() {
        return this.iconColor;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Long getLikeVibrate() {
        return this.likeVibrate;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        Drawable drawable = this.backgroundColor;
        int i3 = 0;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num = this.iconColor;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Integer num2 = this.hintTextColor;
        if (num2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Drawable drawable2 = this.hintTextBackground;
        if (drawable2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = drawable2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Long l3 = this.likeVibrate;
        if (l3 != null) {
            i3 = l3.hashCode();
        }
        return ((((i19 + i3) * 31) + Float.floatToIntBits(this.dividingLineHeight)) * 31) + this.dividingLineDrawableRes;
    }

    @NotNull
    public String toString() {
        return "InputStyleConfig(backgroundColor=" + this.backgroundColor + ", iconColor=" + this.iconColor + ", hintTextColor=" + this.hintTextColor + ", hintTextBackground=" + this.hintTextBackground + ", likeVibrate=" + this.likeVibrate + ", dividingLineHeight=" + this.dividingLineHeight + ", dividingLineDrawableRes=" + this.dividingLineDrawableRes + ")";
    }
}
