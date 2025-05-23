package rm1;

import fm1.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lrm1/a;", "Lpm1/a;", "Lorg/json/JSONObject;", "contentJson", "", "b", "patternJson", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements pm1.a {
    private final String b(JSONObject contentJson) {
        JSONArray jSONArray = contentJson.getJSONArray("vecImageUrl");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject.getInt("levelType") == 3) {
                String string = jSONObject.getString("url");
                Intrinsics.checkNotNullExpressionValue(string, "imageUrlJson.getString(\"url\")");
                return string;
            }
        }
        String string2 = contentJson.getString("picUrl");
        Intrinsics.checkNotNullExpressionValue(string2, "contentJson.getString(\"picUrl\")");
        return string2;
    }

    @Override // pm1.a
    public void a(@NotNull JSONObject contentJson, @NotNull JSONObject patternJson, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(patternJson, "patternJson");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        String b16 = b(contentJson);
        int i3 = contentJson.getInt("width");
        int i16 = contentJson.getInt("height");
        String taskId = contentJson.getString("picId");
        String svrUrl = contentJson.getString("picUrl");
        boolean optBoolean = contentJson.optBoolean("is_gif");
        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
        Intrinsics.checkNotNullExpressionValue(svrUrl, "svrUrl");
        String jSONObject = contentJson.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "contentJson.toString()");
        restoreResult.b().add(new e(0, b16, 0L, i3, i16, taskId, svrUrl, optBoolean, "", jSONObject));
    }
}
