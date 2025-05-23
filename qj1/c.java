package qj1;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lqj1/c;", "", "", "getChannelId", "getGuildId", "", "B", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getGuildName", "getGuildIcon", "K", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface c {
    boolean B();

    boolean K();

    long getChannelId();

    @NotNull
    String getGuildIcon();

    long getGuildId();

    @NotNull
    String getGuildName();

    @Nullable
    String q();
}
