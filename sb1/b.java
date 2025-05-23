package sb1;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lsb1/b;", "", "", "a", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "switchValue", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "c", "(Lorg/json/JSONObject;)V", "configJson", "<init>", "()V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean switchValue;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject configJson;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final JSONObject getConfigJson() {
        return this.configJson;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Boolean getSwitchValue() {
        return this.switchValue;
    }

    public final void c(@Nullable JSONObject jSONObject) {
        this.configJson = jSONObject;
    }

    public final void d(@Nullable Boolean bool) {
        this.switchValue = bool;
    }
}
