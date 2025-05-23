package xj0;

import com.tencent.pts.core.PTSComposer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lxj0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "c", "(Lorg/json/JSONObject;)V", "jsonData", "Lcom/tencent/pts/core/PTSComposer;", "b", "Lcom/tencent/pts/core/PTSComposer;", "()Lcom/tencent/pts/core/PTSComposer;", "d", "(Lcom/tencent/pts/core/PTSComposer;)V", "ptsComposer", "<init>", "(Lorg/json/JSONObject;Lcom/tencent/pts/core/PTSComposer;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: xj0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class RankGoodsInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private JSONObject jsonData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private PTSComposer ptsComposer;

    public RankGoodsInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final JSONObject getJsonData() {
        return this.jsonData;
    }

    /* renamed from: b, reason: from getter */
    public final PTSComposer getPtsComposer() {
        return this.ptsComposer;
    }

    public final void c(JSONObject jSONObject) {
        this.jsonData = jSONObject;
    }

    public final void d(PTSComposer pTSComposer) {
        this.ptsComposer = pTSComposer;
    }

    public int hashCode() {
        JSONObject jSONObject = this.jsonData;
        int hashCode = (jSONObject != null ? jSONObject.hashCode() : 0) * 31;
        PTSComposer pTSComposer = this.ptsComposer;
        return hashCode + (pTSComposer != null ? pTSComposer.hashCode() : 0);
    }

    public String toString() {
        return "RankGoodsInfo(jsonData=" + this.jsonData + ", ptsComposer=" + this.ptsComposer + ")";
    }

    public RankGoodsInfo(JSONObject jSONObject, PTSComposer pTSComposer) {
        this.jsonData = jSONObject;
        this.ptsComposer = pTSComposer;
    }

    public /* synthetic */ RankGoodsInfo(JSONObject jSONObject, PTSComposer pTSComposer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : jSONObject, (i3 & 2) != 0 ? null : pTSComposer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RankGoodsInfo)) {
            return false;
        }
        RankGoodsInfo rankGoodsInfo = (RankGoodsInfo) other;
        return Intrinsics.areEqual(this.jsonData, rankGoodsInfo.jsonData) && Intrinsics.areEqual(this.ptsComposer, rankGoodsInfo.ptsComposer);
    }
}
