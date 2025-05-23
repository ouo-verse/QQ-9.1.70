package s94;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uv4.am;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Ls94/a;", "", "Lorg/json/JSONObject;", "c", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getSlotId", "()I", "slotId", "b", "Z", "isSide", "()Z", "getSex", "sex", "Luv4/am;", "d", "Luv4/am;", "()Luv4/am;", "cameraCfg", "<init>", "(IZILuv4/am;)V", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: s94.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class FaceControlPointData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final FaceControlPointData f433536f = new FaceControlPointData(-1, false, 0, new am());

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int slotId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSide;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final am cameraCfg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Ls94/a$a;", "", "Ls94/a;", "sCloseUeUiData", "Ls94/a;", "a", "()Ls94/a;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s94.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FaceControlPointData a() {
            return FaceControlPointData.f433536f;
        }

        Companion() {
        }
    }

    public FaceControlPointData(int i3, boolean z16, int i16, am cameraCfg) {
        Intrinsics.checkNotNullParameter(cameraCfg, "cameraCfg");
        this.slotId = i3;
        this.isSide = z16;
        this.sex = i16;
        this.cameraCfg = cameraCfg;
    }

    /* renamed from: b, reason: from getter */
    public final am getCameraCfg() {
        return this.cameraCfg;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SlotId", this.slotId);
        jSONObject.put("IsSide", this.isSide);
        jSONObject.put("Sex", this.sex);
        jSONObject.put("CameraInfo", r94.c.u(this.cameraCfg));
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.slotId * 31;
        boolean z16 = this.isSide;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((((i3 + i16) * 31) + this.sex) * 31) + this.cameraCfg.hashCode();
    }

    public String toString() {
        return "FaceControlPointData(slotId=" + this.slotId + ", isSide=" + this.isSide + ", sex=" + this.sex + ", cameraCfg=" + this.cameraCfg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceControlPointData)) {
            return false;
        }
        FaceControlPointData faceControlPointData = (FaceControlPointData) other;
        return this.slotId == faceControlPointData.slotId && this.isSide == faceControlPointData.isSide && this.sex == faceControlPointData.sex && Intrinsics.areEqual(this.cameraCfg, faceControlPointData.cameraCfg);
    }
}
