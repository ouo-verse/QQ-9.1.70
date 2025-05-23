package ri3;

import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpRspData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lri3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "a", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "b", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "reqOp", "Lcom/tencent/filament/zplan/scene/xwconnect/data/c;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/c;", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/c;", "data", "<init>", "(Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;Lcom/tencent/filament/zplan/scene/xwconnect/data/c;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ri3.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class FlowerOpRsp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final FlowerOpType reqOp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final FlowerOpRspData data;

    public FlowerOpRsp() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final FlowerOpRspData getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final FlowerOpType getReqOp() {
        return this.reqOp;
    }

    public int hashCode() {
        int hashCode = this.reqOp.hashCode() * 31;
        FlowerOpRspData flowerOpRspData = this.data;
        return hashCode + (flowerOpRspData == null ? 0 : flowerOpRspData.hashCode());
    }

    public String toString() {
        return "FlowerOpRsp(reqOp=" + this.reqOp + ", data=" + this.data + ")";
    }

    public FlowerOpRsp(FlowerOpType reqOp, FlowerOpRspData flowerOpRspData) {
        Intrinsics.checkNotNullParameter(reqOp, "reqOp");
        this.reqOp = reqOp;
        this.data = flowerOpRspData;
    }

    public /* synthetic */ FlowerOpRsp(FlowerOpType flowerOpType, FlowerOpRspData flowerOpRspData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? FlowerOpType.INVALID_OP : flowerOpType, (i3 & 2) != 0 ? null : flowerOpRspData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowerOpRsp)) {
            return false;
        }
        FlowerOpRsp flowerOpRsp = (FlowerOpRsp) other;
        return this.reqOp == flowerOpRsp.reqOp && Intrinsics.areEqual(this.data, flowerOpRsp.data);
    }
}
