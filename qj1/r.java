package qj1;

import cooperation.qzone.QZoneRequestEncoder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lqj1/r;", "", "", QZoneRequestEncoder.KEY_COVER_REQ, "()Ljava/lang/String;", "cover", "", "getDuration", "()J", "duration", "getIcon", "icon", "getPlatformName", "platformName", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface r {
    @NotNull
    String getCover();

    long getDuration();

    @NotNull
    String getIcon();

    @NotNull
    String getPlatformName();
}
