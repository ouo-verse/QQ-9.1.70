package v23;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rBC\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lv23/c;", "Lv23/a;", "Lorg/json/JSONObject;", "g", "", "toString", "Lv23/b;", "i", "Lv23/b;", "status", "", "stage", "<init>", "(ILv23/b;)V", "", "startTime", "ext", "", "transparentField", "preStage", "(IJLorg/json/JSONObject;Ljava/lang/Object;ILv23/b;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: v23.c, reason: from toString */
/* loaded from: classes20.dex */
public final class StatusNode extends Node {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Status status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusNode(int i3, @NotNull Status status) {
        super(i3);
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
    }

    @Override // v23.Node
    @NotNull
    public JSONObject g() {
        int i3;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportConstant.COSTREPORT_PREFIX, getStage());
        jSONObject.put("st", getStartTime());
        JSONObject ext = getExt();
        if (ext != null) {
            i3 = ext.length();
        } else {
            i3 = 0;
        }
        if (i3 > 0 && !Intrinsics.areEqual(Node.INSTANCE.a(), getExt())) {
            jSONObject.put("ext", getExt());
        }
        long j3 = 0;
        if (getPreNode() != null) {
            long startTime = getStartTime();
            Node preNode = getPreNode();
            if (preNode != null) {
                j3 = preNode.getStartTime();
            }
            j3 = startTime - j3;
        }
        jSONObject.put("c", j3);
        jSONObject.put("status", this.status.a());
        return jSONObject;
    }

    @Override // v23.Node
    @NotNull
    public String toString() {
        return "StatusNode(status=" + this.status + ")";
    }

    public /* synthetic */ StatusNode(int i3, long j3, JSONObject jSONObject, Object obj, int i16, Status status, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? System.currentTimeMillis() : j3, (i17 & 4) != 0 ? Node.INSTANCE.a() : jSONObject, (i17 & 8) != 0 ? null : obj, (i17 & 16) != 0 ? -10000 : i16, status);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusNode(int i3, long j3, @NotNull JSONObject ext, @Nullable Object obj, int i16, @NotNull Status status) {
        super(i3, j3, ext, obj, i16);
        Intrinsics.checkNotNullParameter(ext, "ext");
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
    }
}
