package rm1;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lrm1/c;", "Lpm1/b;", "Lorg/json/JSONObject;", "jsonObject", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "Lrm1/a;", "Lrm1/a;", "mImageProcessor", "Lrm1/d;", "b", "Lrm1/d;", "mVideoProcessor", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements pm1.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mImageProcessor = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mVideoProcessor = new d();

    @Override // pm1.b
    public void a(@NotNull JSONObject jsonObject, @NotNull om1.b restoreResult, @Nullable RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        if (restoreInfo == null) {
            return;
        }
        String string = jsonObject.getString("patternInfo");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (jsonObject.has("images")) {
            JSONArray jSONArray = jsonObject.getJSONArray("images");
            JSONObject lastPatternInfoJson = new JSONArray(string).getJSONObject(r2.length() - 1);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                a aVar = this.mImageProcessor;
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "imageJsonArray.getJSONObject(index)");
                Intrinsics.checkNotNullExpressionValue(lastPatternInfoJson, "lastPatternInfoJson");
                aVar.a(jSONObject, lastPatternInfoJson, restoreResult, restoreInfo);
            }
        }
        if (jsonObject.has("videos")) {
            JSONArray jSONArray2 = jsonObject.getJSONArray("videos");
            JSONObject lastPatternInfoJson2 = new JSONArray(string).getJSONObject(r1.length() - 1);
            int length2 = jSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                d dVar = this.mVideoProcessor;
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "videoJsonArray.getJSONObject(index)");
                Intrinsics.checkNotNullExpressionValue(lastPatternInfoJson2, "lastPatternInfoJson");
                dVar.a(jSONObject2, lastPatternInfoJson2, restoreResult, restoreInfo);
            }
        }
    }
}
