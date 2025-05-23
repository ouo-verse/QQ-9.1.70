package rm1;

import android.text.TextUtils;
import fm1.c;
import fm1.e;
import fm1.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lrm1/b;", "Lpm1/b;", "Lorg/json/JSONObject;", "mediaJson", "Lfm1/i;", "b", "c", "jsonObject", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements pm1.b {
    private final i b(JSONObject mediaJson) {
        String mediaInfo = mediaJson.getString("mediaInfo");
        c.Companion companion = fm1.c.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(mediaInfo, "mediaInfo");
        return companion.a(mediaInfo);
    }

    private final i c(JSONObject mediaJson) {
        String mediaInfo = mediaJson.getString("mediaInfo");
        if (TextUtils.isEmpty(mediaInfo)) {
            return null;
        }
        e.Companion companion = e.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(mediaInfo, "mediaInfo");
        return companion.a(mediaInfo);
    }

    @Override // pm1.b
    public void a(@NotNull JSONObject jsonObject, @NotNull om1.b restoreResult, @Nullable RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        JSONArray optJSONArray = jsonObject.optJSONArray("medias");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject mediaJson = optJSONArray.getJSONObject(i3);
            if (mediaJson.getBoolean("localType")) {
                Intrinsics.checkNotNullExpressionValue(mediaJson, "mediaJson");
                restoreResult.b().add(b(mediaJson));
            } else {
                Intrinsics.checkNotNullExpressionValue(mediaJson, "mediaJson");
                i c16 = c(mediaJson);
                if (c16 != null) {
                    restoreResult.b().add(c16);
                }
            }
        }
    }
}
