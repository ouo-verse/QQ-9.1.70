package r04;

import com.tencent.bugly.BuildConfigWrapper;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UrlMeta;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lr04/a;", "Ljavax/net/ssl/HostnameVerifier;", "", "hostname", "Ljavax/net/ssl/SSLSession;", SessionDbHelper.SESSION_ID, "", "verify", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String hostname, @NotNull SSLSession session) {
        Intrinsics.checkParameterIsNotNull(hostname, "hostname");
        Intrinsics.checkParameterIsNotNull(session, "session");
        try {
            URL url = new URL(BuildConfigWrapper.getDomain());
            URL url2 = new URL(BuildConfigWrapper.getAttaUrl());
            UrlMeta urlMeta = BaseInfo.urlMeta;
            URL url3 = new URL(urlMeta.rmonitorDomain);
            URL url4 = new URL(urlMeta.getAttaUrl());
            if (!Intrinsics.areEqual(hostname, url.getHost()) && !Intrinsics.areEqual(hostname, url2.getHost()) && !Intrinsics.areEqual(hostname, url3.getHost())) {
                if (!Intrinsics.areEqual(hostname, url4.getHost())) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }
}
