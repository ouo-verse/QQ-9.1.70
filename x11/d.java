package x11;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lx11/d;", "", "", "eventType", "Lorg/json/JSONObject;", "ext", "", "eventCode", "eventElapsed", "", "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ void a(d dVar, String str, JSONObject jSONObject, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 4) != 0) {
                    i3 = 0;
                }
                if ((i17 & 8) != 0) {
                    i16 = 0;
                }
                dVar.a(str, jSONObject, i3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
        }
    }

    void a(@NotNull String eventType, @NotNull JSONObject ext, int eventCode, int eventElapsed);
}
