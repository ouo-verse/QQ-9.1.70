package ud1;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lud1/f;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "b", "toString", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;", "setOpenKuiklyInfo", "(Lorg/json/JSONObject;)V", "openKuiklyInfo", "<init>", "()V", "e", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ud1.f, reason: from toString */
/* loaded from: classes12.dex */
public final class MetaDreamInteractMsgTabConfig implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private JSONObject openKuiklyInfo;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final JSONObject getOpenKuiklyInfo() {
        return this.openKuiklyInfo;
    }

    public final void b(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("MetaDreamInteractMsgTabConfig", 1, "parse config: " + content);
        try {
            this.openKuiklyInfo = new JSONObject(content).optJSONObject("openKuiklyInfo");
        } catch (Exception e16) {
            QLog.e("MetaDreamInteractMsgTabConfig", 1, "parse error:", e16);
        }
    }

    @NotNull
    public String toString() {
        return "MetaDreamInteractMsgTabConfig(openKuiklyInfo=" + this.openKuiklyInfo + ')';
    }
}
