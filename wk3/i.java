package wk3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lwk3/i;", "", "", "toString", "", "enableFilamentPortalShadow", "Z", "b", "()Z", "enableFilamentDrawerShadow", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    @SerializedName("zplan_filament_drawer_shadow")
    private final boolean enableFilamentDrawerShadow;

    @SerializedName("zplan_filament_portal_shadow")
    private final boolean enableFilamentPortalShadow;

    /* renamed from: a, reason: from getter */
    public final boolean getEnableFilamentDrawerShadow() {
        return this.enableFilamentDrawerShadow;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableFilamentPortalShadow() {
        return this.enableFilamentPortalShadow;
    }

    @NotNull
    public String toString() {
        return "ZPlanFilamentShadowConfig enableFilamentPortalShadow: " + this.enableFilamentPortalShadow + ", enableFilamentDrawerShadow: " + this.enableFilamentDrawerShadow + TokenParser.SP;
    }
}
