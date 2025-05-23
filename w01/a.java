package w01;

import com.tencent.libra.util.LibraConfigUtil;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\n\u0010\u0016\"\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lw01/a;", "", "", "a", "Z", "d", "()Z", h.F, "(Z)V", "isSupportIpDirectFirst", "b", "c", "g", "isSupportIpBlacklist", "f", "setSupportIpv6AndIpv4Interweave", "isSupportIpv6AndIpv4Interweave", "e", "i", "isSupportIpRaceStrategy", "", "I", "()I", "setMaxTcpConsumingTimeInMs", "(I)V", "maxTcpConsumingTimeInMs", "setMinDownloadSpeedStandardInKb", "minDownloadSpeedStandardInKb", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isSupportIpDirectFirst;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isSupportIpBlacklist;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isSupportIpRaceStrategy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isSupportIpv6AndIpv4Interweave = LibraConfigUtil.INSTANCE.isSortByInetPhotoAlternately();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int maxTcpConsumingTimeInMs = 300;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int minDownloadSpeedStandardInKb = 800;

    /* renamed from: a, reason: from getter */
    public final int getMaxTcpConsumingTimeInMs() {
        return this.maxTcpConsumingTimeInMs;
    }

    /* renamed from: b, reason: from getter */
    public final int getMinDownloadSpeedStandardInKb() {
        return this.minDownloadSpeedStandardInKb;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSupportIpBlacklist() {
        return this.isSupportIpBlacklist;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSupportIpDirectFirst() {
        return this.isSupportIpDirectFirst;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSupportIpRaceStrategy() {
        return this.isSupportIpRaceStrategy;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSupportIpv6AndIpv4Interweave() {
        return this.isSupportIpv6AndIpv4Interweave;
    }

    public final void g(boolean z16) {
        this.isSupportIpBlacklist = z16;
    }

    public final void h(boolean z16) {
        this.isSupportIpDirectFirst = z16;
    }

    public final void i(boolean z16) {
        this.isSupportIpRaceStrategy = z16;
    }
}
