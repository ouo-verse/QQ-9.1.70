package v23;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0018\b\u0016\u0018\u0000 \u00062\u00020\u0001:\u0001\nB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010%B=\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010&J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018R(\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u001a\u0010\rR$\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010 \u001a\u0004\b\u0016\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lv23/a;", "", "preNode", "", h.F, "Lorg/json/JSONObject;", "g", "", "toString", "", "a", "I", "e", "()I", "stage", "", "<set-?>", "b", "J", "f", "()J", "startTime", "c", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "ext", "d", "Ljava/lang/Object;", "getTransparentField", "()Ljava/lang/Object;", "transparentField", "preStage", "Lv23/a;", "()Lv23/a;", "setPreNode", "(Lv23/a;)V", "<init>", "(I)V", "(IJLorg/json/JSONObject;Ljava/lang/Object;I)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: v23.a, reason: from toString */
/* loaded from: classes20.dex */
public class Node {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final JSONObject f440811h = new JSONObject();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int stage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long startTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private JSONObject ext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Object transparentField;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int preStage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Node preNode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lv23/a$a;", "", "Lorg/json/JSONObject;", "DEF_JSON", "Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: v23.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JSONObject a() {
            return Node.f440811h;
        }

        Companion() {
        }
    }

    public Node(int i3) {
        this.startTime = System.currentTimeMillis();
        this.ext = f440811h;
        this.preStage = -10000;
        this.stage = i3;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final JSONObject getExt() {
        return this.ext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: c, reason: from getter */
    public final Node getPreNode() {
        return this.preNode;
    }

    /* renamed from: d, reason: from getter */
    public final int getPreStage() {
        return this.preStage;
    }

    /* renamed from: e, reason: from getter */
    public final int getStage() {
        return this.stage;
    }

    /* renamed from: f, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public JSONObject g() {
        int i3;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportConstant.COSTREPORT_PREFIX, this.stage);
        jSONObject.put("st", this.startTime);
        Node node = this.preNode;
        long j3 = 0;
        if (node != null) {
            long j16 = this.startTime;
            if (node != null) {
                j3 = node.startTime;
            }
            j3 = j16 - j3;
        }
        jSONObject.put("c", j3);
        JSONObject jSONObject2 = this.ext;
        if (jSONObject2 != null) {
            i3 = jSONObject2.length();
        } else {
            i3 = 0;
        }
        if (i3 > 0 && !Intrinsics.areEqual(f440811h, this.ext)) {
            jSONObject.put("ext", this.ext);
        }
        return jSONObject;
    }

    public final void h(@NotNull Node preNode) {
        Intrinsics.checkNotNullParameter(preNode, "preNode");
        this.preNode = preNode;
    }

    @NotNull
    public String toString() {
        return "Node(stage=" + this.stage + ", startTime=" + this.startTime + ", ext=" + this.ext + ", transparentField=" + this.transparentField + ")";
    }

    public /* synthetic */ Node(int i3, long j3, JSONObject jSONObject, Object obj, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? System.currentTimeMillis() : j3, (i17 & 4) != 0 ? f440811h : jSONObject, (i17 & 8) != 0 ? null : obj, (i17 & 16) != 0 ? -10000 : i16);
    }

    public Node(int i3, long j3, @Nullable JSONObject jSONObject, @Nullable Object obj, int i16) {
        System.currentTimeMillis();
        this.stage = i3;
        this.startTime = j3;
        this.ext = jSONObject;
        this.transparentField = obj;
        this.preStage = i16;
    }
}
