package rx4;

import com.tencent.filament.zplan.animation.ZPlanAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lrx4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "a", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "()Lcom/tencent/filament/zplan/animation/ZPlanAction;", "breathAction", "b", "c", "stretchAction", "refreshAction", "<init>", "(Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/filament/zplan/animation/ZPlanAction;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rx4.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class DynamicAnimationModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanAction breathAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanAction stretchAction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanAction refreshAction;

    public DynamicAnimationModel(ZPlanAction breathAction, ZPlanAction stretchAction, ZPlanAction refreshAction) {
        Intrinsics.checkNotNullParameter(breathAction, "breathAction");
        Intrinsics.checkNotNullParameter(stretchAction, "stretchAction");
        Intrinsics.checkNotNullParameter(refreshAction, "refreshAction");
        this.breathAction = breathAction;
        this.stretchAction = stretchAction;
        this.refreshAction = refreshAction;
    }

    /* renamed from: a, reason: from getter */
    public final ZPlanAction getBreathAction() {
        return this.breathAction;
    }

    /* renamed from: b, reason: from getter */
    public final ZPlanAction getRefreshAction() {
        return this.refreshAction;
    }

    /* renamed from: c, reason: from getter */
    public final ZPlanAction getStretchAction() {
        return this.stretchAction;
    }

    public int hashCode() {
        return (((this.breathAction.hashCode() * 31) + this.stretchAction.hashCode()) * 31) + this.refreshAction.hashCode();
    }

    public String toString() {
        return "DynamicAnimationModel(breathAction=" + this.breathAction + ", stretchAction=" + this.stretchAction + ", refreshAction=" + this.refreshAction + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DynamicAnimationModel)) {
            return false;
        }
        DynamicAnimationModel dynamicAnimationModel = (DynamicAnimationModel) other;
        return Intrinsics.areEqual(this.breathAction, dynamicAnimationModel.breathAction) && Intrinsics.areEqual(this.stretchAction, dynamicAnimationModel.stretchAction) && Intrinsics.areEqual(this.refreshAction, dynamicAnimationModel.refreshAction);
    }
}
