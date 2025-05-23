package ud1;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lud1/d;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "b", "toString", "", "d", "I", "a", "()I", "setFrameworkType", "(I)V", "frameworkType", "<init>", "()V", "e", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ud1.d, reason: from toString */
/* loaded from: classes12.dex */
public final class MetaDreamFrameworkConfig implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int frameworkType;

    /* renamed from: a, reason: from getter */
    public final int getFrameworkType() {
        return this.frameworkType;
    }

    public final void b(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("MetaDreamFrameworkConfig", 1, "parse config: " + content);
        try {
            this.frameworkType = new JSONObject(content).optInt("tabFrameworkType", 0);
        } catch (Exception e16) {
            QLog.e("MetaDreamFrameworkConfig", 1, "parse error:", e16);
        }
    }

    @NotNull
    public String toString() {
        return "MetaDreamFrameworkConfig(frameworkType=" + this.frameworkType + ')';
    }
}
