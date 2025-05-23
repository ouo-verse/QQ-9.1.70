package qj1;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lqj1/t;", "", "", "getUrlType", "()I", "urlType", "", "getCoverUrl", "()Ljava/lang/String;", "coverUrl", "", "getDuration", "()J", "duration", "getJumpUrl", WadlProxyConsts.KEY_JUMP_URL, "a", "platformIconUrl", "getPlatformName", "platformName", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface t {
    @NotNull
    String a();

    @NotNull
    String getCoverUrl();

    long getDuration();

    @NotNull
    String getJumpUrl();

    @NotNull
    String getPlatformName();

    int getUrlType();
}
