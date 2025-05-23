package t14;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lt14/d;", "", "", "expandOrNot", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setExpandOrNot", "(Ljava/lang/String;)V", "robotGuideOrNot", "b", "setRobotGuideOrNot", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    @SerializedName("disableAutoExpand")
    @NotNull
    private String expandOrNot = "0";

    @SerializedName("disableGuideFeature")
    @NotNull
    private String robotGuideOrNot = "0";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getExpandOrNot() {
        return this.expandOrNot;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRobotGuideOrNot() {
        return this.robotGuideOrNot;
    }
}
