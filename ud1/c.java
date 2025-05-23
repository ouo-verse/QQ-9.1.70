package ud1;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lud1/c;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "b", "", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "setRobotList", "(Ljava/util/List;)V", "robotList", "<init>", "()V", "e", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> robotList = new ArrayList();

    @NotNull
    public final List<String> a() {
        return this.robotList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[Catch: Exception -> 0x0059, TRY_LEAVE, TryCatch #0 {Exception -> 0x0059, blocks: (B:3:0x001f, B:5:0x0039, B:7:0x003f, B:12:0x004b), top: B:2:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(@NotNull String content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("GameRobotConfig", 1, "parse config: " + content);
        try {
            JSONArray optJSONArray = new JSONObject(content).optJSONArray("gameRobots");
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "configRootJson.optJSONAr\u2026y(CONFIG_KEY_GAME_ROBOTS)");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String robotUin = optJSONArray.optString(i3);
                if (robotUin != null && robotUin.length() != 0) {
                    z16 = false;
                    if (z16) {
                        List<String> list = this.robotList;
                        Intrinsics.checkNotNullExpressionValue(robotUin, "robotUin");
                        list.add(robotUin);
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
        } catch (Exception e16) {
            QLog.e("GameRobotConfig", 1, "parse error:", e16);
        }
    }
}
