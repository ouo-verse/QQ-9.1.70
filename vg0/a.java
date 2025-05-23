package vg0;

import android.app.Application;
import com.tencent.ecommerce.base.runtime.api.IECRuntime;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lvg0/a;", "Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "Landroid/app/Application;", "getExternalApplicationContext", "", "isDebug", "isPublicVersion", "", "", "getDeviceInfo", "isMainProcess", "isTestEnv", "appVersion", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECRuntime {
    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    @NotNull
    public String appVersion() {
        return "";
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    @NotNull
    public Map<String, String> getDeviceInfo() {
        throw new IllegalArgumentException("IECRuntime getDeviceInfo not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    @NotNull
    public Application getExternalApplicationContext() {
        throw new IllegalArgumentException("IECRuntime getApplicationContext not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public boolean isDebug() {
        throw new IllegalArgumentException("IECRuntime isDebug not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public boolean isMainProcess() {
        throw new IllegalArgumentException("IECRuntime isMainProcess not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public boolean isPublicVersion() {
        throw new IllegalArgumentException("IECRuntime isPublishVersion not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public boolean isTestEnv() {
        throw new IllegalArgumentException("IECRuntime isTestEnv not yet implemented");
    }
}
