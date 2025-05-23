package wi2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Ltrpc/yes/common/CommonOuterClass$QQUserId;", "", "a", "qq-live-widget-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        Intrinsics.checkNotNullParameter(commonOuterClass$QQUserId, "<this>");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(commonOuterClass$QQUserId.uid.get());
        sb5.append(util.base64_pad_url);
        sb5.append(commonOuterClass$QQUserId.yes_uid.get());
        return sb5.toString();
    }
}
