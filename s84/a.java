package s84;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\t\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010$\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010%\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b\u0012\u0010\r\u00a8\u0006("}, d2 = {"Ls84/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, h.F, "()F", "textSize", "b", "i", "width", "c", "height", "d", "f", "radius", "e", "I", "()I", "loadingBackgroundID", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "textColor", "Z", "j", "()Z", "isTextBold", "iconWidth", "iconHeight", "iconRightMargin", "<init>", "(FFFFILjava/lang/String;ZFFF)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float textSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float radius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int loadingBackgroundID;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String textColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isTextBold;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float iconWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float iconHeight;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final float iconRightMargin;

    public a(float f16, float f17, float f18, float f19, int i3, String textColor, boolean z16, float f26, float f27, float f28) {
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        this.textSize = f16;
        this.width = f17;
        this.height = f18;
        this.radius = f19;
        this.loadingBackgroundID = i3;
        this.textColor = textColor;
        this.isTextBold = z16;
        this.iconWidth = f26;
        this.iconHeight = f27;
        this.iconRightMargin = f28;
    }

    /* renamed from: a, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final float getIconHeight() {
        return this.iconHeight;
    }

    /* renamed from: c, reason: from getter */
    public final float getIconRightMargin() {
        return this.iconRightMargin;
    }

    /* renamed from: d, reason: from getter */
    public final float getIconWidth() {
        return this.iconWidth;
    }

    /* renamed from: e, reason: from getter */
    public final int getLoadingBackgroundID() {
        return this.loadingBackgroundID;
    }

    /* renamed from: f, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* renamed from: g, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    /* renamed from: h, reason: from getter */
    public final float getTextSize() {
        return this.textSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((((Float.floatToIntBits(this.textSize) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height)) * 31) + Float.floatToIntBits(this.radius)) * 31) + this.loadingBackgroundID) * 31) + this.textColor.hashCode()) * 31;
        boolean z16 = this.isTextBold;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((floatToIntBits + i3) * 31) + Float.floatToIntBits(this.iconWidth)) * 31) + Float.floatToIntBits(this.iconHeight)) * 31) + Float.floatToIntBits(this.iconRightMargin);
    }

    /* renamed from: i, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsTextBold() {
        return this.isTextBold;
    }

    public String toString() {
        return "testSize: " + this.textSize + ", width: " + this.width + ", height: " + this.height + " , radius: " + this.radius + ": loadingBackgroundId: " + this.loadingBackgroundID;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return Float.compare(this.textSize, aVar.textSize) == 0 && Float.compare(this.width, aVar.width) == 0 && Float.compare(this.height, aVar.height) == 0 && Float.compare(this.radius, aVar.radius) == 0 && this.loadingBackgroundID == aVar.loadingBackgroundID && Intrinsics.areEqual(this.textColor, aVar.textColor) && this.isTextBold == aVar.isTextBold && Float.compare(this.iconWidth, aVar.iconWidth) == 0 && Float.compare(this.iconHeight, aVar.iconHeight) == 0 && Float.compare(this.iconRightMargin, aVar.iconRightMargin) == 0;
    }

    public /* synthetic */ a(float f16, float f17, float f18, float f19, int i3, String str, boolean z16, float f26, float f27, float f28, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, f17, f18, f19, i3, (i16 & 32) != 0 ? "#000000" : str, (i16 & 64) != 0 ? false : z16, (i16 & 128) != 0 ? 0.0f : f26, (i16 & 256) != 0 ? 0.0f : f27, (i16 & 512) != 0 ? 0.0f : f28);
    }
}
