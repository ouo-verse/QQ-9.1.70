package qm1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pm1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lqm1/a;", "Lpm1/b;", "Lorg/json/JSONObject;", "jsonObject", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements b {
    @Override // pm1.b
    public void a(@NotNull JSONObject jsonObject, @NotNull om1.b restoreResult, @Nullable RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        if (restoreInfo == null) {
            return;
        }
        restoreInfo.a().h().J(jsonObject.optInt("media_lock_count", 0));
    }
}
