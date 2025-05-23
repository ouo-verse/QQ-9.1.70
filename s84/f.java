package s84;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Ls84/f;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "d", "Ljava/lang/String;", "getConfig", "()Ljava/lang/String;", DownloadInfo.spKey_Config, "<init>", "(Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String config;

    public f(String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* renamed from: toString, reason: from getter */
    public String getConfig() {
        return this.config;
    }
}
