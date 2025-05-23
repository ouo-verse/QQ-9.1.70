package rc1;

import common.config.service.QzoneConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "secondKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "qq-flock-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull String secondKey, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String config = QzoneConfig.getInstance().getConfig("qqevent", secondKey, defaultValue);
        Intrinsics.checkNotNullExpressionValue(config, "getInstance().getConfig(\u2026 secondKey, defaultValue)");
        return config;
    }
}
