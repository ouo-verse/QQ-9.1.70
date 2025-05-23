package w23;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x23.d;
import x23.e;
import x23.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lw23/c;", "Lx23/d;", "", "serviceName", "", "version", "a", "", WadlProxyConsts.PARAM_TIME_OUT, "Lx23/f;", "sample", "Ljava/lang/String;", "b", VasCommonJsbProxy.JSON_KEY_SET_KEY, "c", "I", "", "d", "Z", "isSample", "e", "J", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZJ)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String serviceName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String setKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int version;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSample;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long timeOut;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"w23/c$a", "Lx23/f;", "", "isUseDefSample", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements f {
        a() {
        }

        @Override // x23.f
        public boolean isUseDefSample() {
            return c.this.isSample;
        }
    }

    public c(@NotNull String serviceName, @NotNull String setKey, int i3, boolean z16, long j3) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        this.serviceName = serviceName;
        this.setKey = setKey;
        this.version = i3;
        this.isSample = z16;
        this.timeOut = j3;
    }

    @Override // x23.d
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getSetKey() {
        return this.setKey;
    }

    @Override // x23.d
    @NotNull
    public String connectChain() {
        return d.a.a(this);
    }

    @Override // x23.d
    @NotNull
    public x23.a getLogProxy() {
        return d.a.b(this);
    }

    @Override // x23.d
    @NotNull
    public x23.b getReportImpl() {
        return d.a.c(this);
    }

    @Override // x23.d
    @Nullable
    public List<e> interceptor() {
        return d.a.d(this);
    }

    @Override // x23.d
    @NotNull
    public f sample() {
        return new a();
    }

    @Override // x23.d
    @NotNull
    /* renamed from: serviceName, reason: from getter */
    public String getServiceName() {
        return this.serviceName;
    }

    @Override // x23.d
    /* renamed from: timeOut, reason: from getter */
    public long getTimeOut() {
        return this.timeOut;
    }

    @Override // x23.d
    /* renamed from: version, reason: from getter */
    public int getVersion() {
        return this.version;
    }

    public /* synthetic */ c(String str, String str2, int i3, boolean z16, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? com.tencent.qqnt.util.b.f362976b.isPublicVersion() : z16, (i16 & 16) != 0 ? -1L : j3);
    }
}
