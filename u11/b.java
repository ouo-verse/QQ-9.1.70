package u11;

import com.tencent.localedit.fakenative.resource.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lu11/b;", "", "", "init", "dispose", "Lcom/tencent/localedit/fakenative/resource/e;", "cache", "Lcom/tencent/localedit/fakenative/resource/e;", "getCache", "()Lcom/tencent/localedit/fakenative/resource/e;", "setCache", "(Lcom/tencent/localedit/fakenative/resource/e;)V", "Lcom/tencent/localedit/fakenative/localserver/b;", "localServer", "Lcom/tencent/localedit/fakenative/localserver/b;", "getLocalServer", "()Lcom/tencent/localedit/fakenative/localserver/b;", "setLocalServer", "(Lcom/tencent/localedit/fakenative/localserver/b;)V", "Lcom/tencent/localedit/fakenative/packages/a;", "packageManager", "Lcom/tencent/localedit/fakenative/packages/a;", "getPackageManager", "()Lcom/tencent/localedit/fakenative/packages/a;", "setPackageManager", "(Lcom/tencent/localedit/fakenative/packages/a;)V", "Lcom/tencent/localedit/fakenative/convert/c;", "convert", "Lcom/tencent/localedit/fakenative/convert/c;", "getConvert", "()Lcom/tencent/localedit/fakenative/convert/c;", "setConvert", "(Lcom/tencent/localedit/fakenative/convert/c;)V", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class b {
    public e cache;
    public com.tencent.localedit.fakenative.convert.c convert;
    public com.tencent.localedit.fakenative.localserver.b localServer;
    public com.tencent.localedit.fakenative.packages.a packageManager;

    @NotNull
    public final e getCache() {
        e eVar = this.cache;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cache");
        return null;
    }

    @NotNull
    public final com.tencent.localedit.fakenative.convert.c getConvert() {
        com.tencent.localedit.fakenative.convert.c cVar = this.convert;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("convert");
        return null;
    }

    @NotNull
    public final com.tencent.localedit.fakenative.localserver.b getLocalServer() {
        com.tencent.localedit.fakenative.localserver.b bVar = this.localServer;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localServer");
        return null;
    }

    @NotNull
    public final com.tencent.localedit.fakenative.packages.a getPackageManager() {
        com.tencent.localedit.fakenative.packages.a aVar = this.packageManager;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("packageManager");
        return null;
    }

    public final void setCache(@NotNull e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.cache = eVar;
    }

    public final void setConvert(@NotNull com.tencent.localedit.fakenative.convert.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.convert = cVar;
    }

    public final void setLocalServer(@NotNull com.tencent.localedit.fakenative.localserver.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.localServer = bVar;
    }

    public final void setPackageManager(@NotNull com.tencent.localedit.fakenative.packages.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.packageManager = aVar;
    }

    public void dispose() {
    }

    public void init() {
    }
}
