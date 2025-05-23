package vd3;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qv4.aw;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u0015\u0010\u001c\u00a8\u0006 "}, d2 = {"Lvd3/f;", "", "", "e", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "a", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "b", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "enterJson", "Lqv4/aw;", "c", "Lqv4/aw;", "d", "()Lqv4/aw;", "updateInfo", "Lvd3/e;", "Lvd3/e;", "()Lvd3/e;", NotificationCompat.CATEGORY_ERROR, "<init>", "(Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;Lorg/json/JSONObject;Lqv4/aw;Lvd3/e;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vd3.f, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class PrepareResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaEnterParams enterParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final JSONObject enterJson;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final aw updateInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final PrepareErr err;

    public PrepareResult(ZootopiaEnterParams enterParams, JSONObject enterJson, aw awVar, PrepareErr prepareErr) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        this.enterParams = enterParams;
        this.enterJson = enterJson;
        this.updateInfo = awVar;
        this.err = prepareErr;
    }

    /* renamed from: a, reason: from getter */
    public final JSONObject getEnterJson() {
        return this.enterJson;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaEnterParams getEnterParams() {
        return this.enterParams;
    }

    /* renamed from: c, reason: from getter */
    public final PrepareErr getErr() {
        return this.err;
    }

    /* renamed from: d, reason: from getter */
    public final aw getUpdateInfo() {
        return this.updateInfo;
    }

    public final boolean e() {
        return this.err == null;
    }

    public int hashCode() {
        int hashCode = ((this.enterParams.hashCode() * 31) + this.enterJson.hashCode()) * 31;
        aw awVar = this.updateInfo;
        int hashCode2 = (hashCode + (awVar == null ? 0 : awVar.hashCode())) * 31;
        PrepareErr prepareErr = this.err;
        return hashCode2 + (prepareErr != null ? prepareErr.hashCode() : 0);
    }

    public String toString() {
        return "PrepareResult(enterParams=" + this.enterParams + ", enterJson=" + this.enterJson + ", updateInfo=" + this.updateInfo + ", err=" + this.err + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrepareResult)) {
            return false;
        }
        PrepareResult prepareResult = (PrepareResult) other;
        return Intrinsics.areEqual(this.enterParams, prepareResult.enterParams) && Intrinsics.areEqual(this.enterJson, prepareResult.enterJson) && Intrinsics.areEqual(this.updateInfo, prepareResult.updateInfo) && Intrinsics.areEqual(this.err, prepareResult.err);
    }

    public /* synthetic */ PrepareResult(ZootopiaEnterParams zootopiaEnterParams, JSONObject jSONObject, aw awVar, PrepareErr prepareErr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(zootopiaEnterParams, jSONObject, (i3 & 4) != 0 ? null : awVar, (i3 & 8) != 0 ? null : prepareErr);
    }
}
