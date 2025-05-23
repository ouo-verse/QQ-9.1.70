package um1;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import fm1.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lum1/b;", "Lum1/a;", "Lfm1/i;", "mediaInfo", "", "displayIndex", "Lorg/json/JSONObject;", "b", "a", "Ljava/lang/Integer;", "mPatternId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mPatternId;

    @Override // um1.a
    @Nullable
    public JSONObject a(@NotNull i mediaInfo, int displayIndex) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 6);
        jSONObject.put("width", mediaInfo.getWidth());
        jSONObject.put("height", mediaInfo.getHeight());
        jSONObject.put("widthPercent", 100);
        jSONObject.put("fileId", mediaInfo.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        if (!mediaInfo.f()) {
            jSONObject.put("url", mediaInfo.getDocUrl());
        }
        jSONObject.put("id", String.valueOf(this.mPatternId));
        jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, mediaInfo.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        jSONObject.put("status", 0);
        jSONObject.put("isInline", true);
        return jSONObject;
    }

    @Override // um1.a
    @Nullable
    public JSONObject b(@NotNull i mediaInfo, int displayIndex) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        this.mPatternId = Integer.valueOf(sm1.a.f433976a.a());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pattern_id", String.valueOf(this.mPatternId));
        if (!mediaInfo.f()) {
            jSONObject.put("picUrl", mediaInfo.getDocUrl());
        }
        jSONObject.put("picId", mediaInfo.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        jSONObject.put("width", mediaInfo.getWidth());
        jSONObject.put("height", mediaInfo.getHeight());
        jSONObject.put("display_index", displayIndex);
        return jSONObject;
    }
}
