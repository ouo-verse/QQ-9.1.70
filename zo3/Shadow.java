package zo3;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yo3.Offset;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\nB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R \u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR \u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R \u0010\u001b\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0018\u0012\u0004\b\u001a\u0010\u000f\u001a\u0004\b\n\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lzo3/f;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/kuikly/core/base/h;", "a", "Lcom/tencent/kuikly/core/base/h;", "b", "()Lcom/tencent/kuikly/core/base/h;", "getColor$annotations", "()V", "color", "Lyo3/a;", "Lyo3/a;", "c", "()Lyo3/a;", "getOffset$annotations", "offset", "", UserInfo.SEX_FEMALE, "()F", "getBlurRadius$annotations", "blurRadius", "<init>", "(Lcom/tencent/kuikly/core/base/h;Lyo3/a;F)V", "d", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zo3.f, reason: from toString */
/* loaded from: classes36.dex */
public final class Shadow {

    /* renamed from: e, reason: collision with root package name */
    private static final Shadow f452903e = new Shadow(null, null, 0.0f, 7, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final com.tencent.kuikly.core.base.h color;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Offset offset;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float blurRadius;

    public Shadow() {
        this(null, null, 0.0f, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* renamed from: b, reason: from getter */
    public final com.tencent.kuikly.core.base.h getColor() {
        return this.color;
    }

    /* renamed from: c, reason: from getter */
    public final Offset getOffset() {
        return this.offset;
    }

    public int hashCode() {
        return (((this.color.hashCode() * 31) + this.offset.hashCode()) * 31) + Float.floatToIntBits(this.blurRadius);
    }

    public String toString() {
        return "Shadow(color=" + this.color + ", offset=" + this.offset + ", blurRadius=" + this.blurRadius + ')';
    }

    public Shadow(com.tencent.kuikly.core.base.h color, Offset offset, float f16) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.color = color;
        this.offset = offset;
        this.blurRadius = f16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) other;
        if (Intrinsics.areEqual(this.color.toString(), shadow.color.toString()) && Intrinsics.areEqual(this.offset, shadow.offset)) {
            return (this.blurRadius > shadow.blurRadius ? 1 : (this.blurRadius == shadow.blurRadius ? 0 : -1)) == 0;
        }
        return false;
    }

    public /* synthetic */ Shadow(com.tencent.kuikly.core.base.h hVar, Offset offset, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new com.tencent.kuikly.core.base.h(4278190080L) : hVar, (i3 & 2) != 0 ? Offset.INSTANCE.a() : offset, (i3 & 4) != 0 ? 0.0f : f16);
    }
}
