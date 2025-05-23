package u11;

import androidx.annotation.CallSuper;
import com.tencent.localedit.fakenative.meta.WebResourceReq;
import com.tencent.localedit.fakenative.meta.WebResourceResp;
import com.tencent.localedit.fakenative.resource.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H$J\b\u0010\u0005\u001a\u00020\u0004H$J\b\u0010\u0007\u001a\u00020\u0006H$J\b\u0010\t\u001a\u00020\bH$J\b\u0010\u000b\u001a\u00020\nH$J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH$J\b\u0010\u0011\u001a\u00020\u0010H\u0017J\b\u0010\u0012\u001a\u00020\u0010H\u0017R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lu11/d;", "Lu11/b;", "Lcom/tencent/localedit/fakenative/convert/c;", "c", "Lcom/tencent/localedit/fakenative/resource/e;", "a", "Lv11/a;", "b", "Lcom/tencent/localedit/fakenative/localserver/b;", "d", "Lcom/tencent/localedit/fakenative/packages/a;", "f", "Lcom/tencent/localedit/fakenative/intercept/c;", "Lcom/tencent/localedit/fakenative/meta/WebResourceReq;", "Lcom/tencent/localedit/fakenative/meta/WebResourceResp;", "e", "", "init", "dispose", "Lv11/a;", h.F, "()Lv11/a;", "j", "(Lv11/a;)V", "jsBridgeManager", "Lcom/tencent/localedit/fakenative/intercept/c;", "g", "()Lcom/tencent/localedit/fakenative/intercept/c;", "i", "(Lcom/tencent/localedit/fakenative/intercept/c;)V", "interceptManager", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class d extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public v11.a jsBridgeManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public com.tencent.localedit.fakenative.intercept.c<WebResourceReq, WebResourceResp> interceptManager;

    @NotNull
    protected abstract e a();

    @NotNull
    protected abstract v11.a b();

    @NotNull
    protected abstract com.tencent.localedit.fakenative.convert.c c();

    @NotNull
    protected abstract com.tencent.localedit.fakenative.localserver.b d();

    @NotNull
    protected abstract com.tencent.localedit.fakenative.intercept.c<WebResourceReq, WebResourceResp> e();

    @NotNull
    protected abstract com.tencent.localedit.fakenative.packages.a f();

    @NotNull
    public final com.tencent.localedit.fakenative.intercept.c<WebResourceReq, WebResourceResp> g() {
        com.tencent.localedit.fakenative.intercept.c<WebResourceReq, WebResourceResp> cVar = this.interceptManager;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("interceptManager");
        return null;
    }

    @NotNull
    public final v11.a h() {
        v11.a aVar = this.jsBridgeManager;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        return null;
    }

    public final void i(@NotNull com.tencent.localedit.fakenative.intercept.c<WebResourceReq, WebResourceResp> cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.interceptManager = cVar;
    }

    @Override // u11.b
    @CallSuper
    public void init() {
        setConvert(c());
        setCache(a());
        j(b());
        setLocalServer(d());
        setPackageManager(f());
        i(e());
    }

    public final void j(@NotNull v11.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.jsBridgeManager = aVar;
    }

    @Override // u11.b
    @CallSuper
    public void dispose() {
    }
}
