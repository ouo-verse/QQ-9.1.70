package qa0;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lqa0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "c", "()Landroid/view/View;", "guideLineView", "b", "I", "d", "()I", "margin", "", UserInfo.SEX_FEMALE, "e", "()F", "ratio", "anchorView", "align", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qa0.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class GuidLineOption {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final View guideLineView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int margin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float ratio;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final View anchorView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int align;

    /* renamed from: a, reason: from getter */
    public final int getAlign() {
        return this.align;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final View getAnchorView() {
        return this.anchorView;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final View getGuideLineView() {
        return this.guideLineView;
    }

    /* renamed from: d, reason: from getter */
    public final int getMargin() {
        return this.margin;
    }

    /* renamed from: e, reason: from getter */
    public final float getRatio() {
        return this.ratio;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuidLineOption)) {
            return false;
        }
        GuidLineOption guidLineOption = (GuidLineOption) other;
        if (Intrinsics.areEqual(this.guideLineView, guidLineOption.guideLineView) && this.margin == guidLineOption.margin && Float.compare(this.ratio, guidLineOption.ratio) == 0 && Intrinsics.areEqual(this.anchorView, guidLineOption.anchorView) && this.align == guidLineOption.align) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.guideLineView.hashCode() * 31) + this.margin) * 31) + Float.floatToIntBits(this.ratio)) * 31) + this.anchorView.hashCode()) * 31) + this.align;
    }

    @NotNull
    public String toString() {
        return "GuidLineOption(guideLineView=" + this.guideLineView + ", margin=" + this.margin + ", ratio=" + this.ratio + ", anchorView=" + this.anchorView + ", align=" + this.align + ")";
    }
}
