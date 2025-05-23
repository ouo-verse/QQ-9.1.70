package s94;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qu4.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000bB-\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0012\u0010\u001b\"\u0004\b\u0019\u0010\u001c\u00a8\u0006 "}, d2 = {"Ls94/b;", "", "Lorg/json/JSONObject;", "f", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "e", "(I)V", "slotId", "b", "getSelectedPointIndex", "selectedPointIndex", "Z", "isSide", "()Z", "Lqu4/j;", "d", "Lqu4/j;", "()Lqu4/j;", "(Lqu4/j;)V", "faceInfo", "<init>", "(IIZLqu4/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: s94.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class FaceInfoSyncData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final FaceInfoSyncData f433542f = new FaceInfoSyncData(-1, -1, false, new j());

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int slotId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectedPointIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSide;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private j faceInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Ls94/b$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Ls94/b;", "a", "Lqu4/j;", "faceInfo", "b", "DEFAULT", "Ls94/b;", "", "UNDEFINED", "I", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s94.b$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FaceInfoSyncData a(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            return new FaceInfoSyncData(jsonObject.optInt("SlotId"), jsonObject.optInt("SelectPointIndex"), jsonObject.optBoolean("IsSide"), r94.c.e(jsonObject.optJSONObject("FaceInfo")));
        }

        Companion() {
        }

        public final FaceInfoSyncData b(j faceInfo) {
            if (faceInfo != null) {
                FaceInfoSyncData.f433542f.d(faceInfo);
            }
            return FaceInfoSyncData.f433542f;
        }
    }

    public FaceInfoSyncData(int i3, int i16, boolean z16, j faceInfo) {
        Intrinsics.checkNotNullParameter(faceInfo, "faceInfo");
        this.slotId = i3;
        this.selectedPointIndex = i16;
        this.isSide = z16;
        this.faceInfo = faceInfo;
    }

    /* renamed from: b, reason: from getter */
    public final j getFaceInfo() {
        return this.faceInfo;
    }

    /* renamed from: c, reason: from getter */
    public final int getSlotId() {
        return this.slotId;
    }

    public final void d(j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.faceInfo = jVar;
    }

    public final void e(int i3) {
        this.slotId = i3;
    }

    public final JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SlotId", this.slotId);
        jSONObject.put("SelectPointIndex", this.selectedPointIndex);
        jSONObject.put("FaceInfo", r94.c.n(this.faceInfo));
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((this.slotId * 31) + this.selectedPointIndex) * 31;
        boolean z16 = this.isSide;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((i3 + i16) * 31) + this.faceInfo.hashCode();
    }

    public String toString() {
        return "FaceInfoSyncData(slotId=" + this.slotId + ", selectedPointIndex=" + this.selectedPointIndex + ", isSide=" + this.isSide + ", faceInfo=" + this.faceInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceInfoSyncData)) {
            return false;
        }
        FaceInfoSyncData faceInfoSyncData = (FaceInfoSyncData) other;
        return this.slotId == faceInfoSyncData.slotId && this.selectedPointIndex == faceInfoSyncData.selectedPointIndex && this.isSide == faceInfoSyncData.isSide && Intrinsics.areEqual(this.faceInfo, faceInfoSyncData.faceInfo);
    }
}
