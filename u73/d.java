package u73;

import com.google.gson.GsonBuilder;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.util.RFWUrlUtils;
import com.tencent.mobileqq.wink.explore.builder.FrameTypeAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000\u00a8\u0006\b"}, d2 = {"", ark.ARKMETADATA_JSON, "Lu73/e;", "b", "Lu73/g;", "c", "url", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {
    @NotNull
    public static final String a(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return v73.a.EXPLORE_MATERIAL_DOWNLOAD_PATH + RFWUrlUtils.getFileNameFromUrl(url);
    }

    @NotNull
    public static final JsonContent b(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object fromJson = new GsonBuilder().registerTypeAdapter(Frame.class, new FrameTypeAdapter()).create().fromJson(json, (Class<Object>) JsonContent.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(json, JsonContent::class.java)");
        return (JsonContent) fromJson;
    }

    @NotNull
    public static final RecommendMemeData c(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object fromJson = new GsonBuilder().create().fromJson(json, (Class<Object>) RecommendMemeData.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(json, RecommendMemeData::class.java)");
        return (RecommendMemeData) fromJson;
    }
}
