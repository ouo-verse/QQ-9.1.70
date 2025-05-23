package wk3;

import com.google.gson.annotations.SerializedName;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lwk3/e;", "", "", ZPlanPublishSource.FROM_SCHEME, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    @SerializedName(ZPlanPublishSource.FROM_SCHEME)
    @NotNull
    private final String scheme = "mqqapi://zplan/openPage?src_type=app&version=1.0&subReferer=em_zplan_emote_detail_click_to_mall&pageID=12";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }
}
