package wg0;

import android.app.Application;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.plugin.ECPluginApplication;
import com.tencent.ecommerce.base.runtime.api.IECRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lwg0/a;", "", "Landroid/app/Application;", "a", "", "b", "Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "runtime", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f445621b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECRuntime runtime = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime();

    a() {
    }

    @JvmStatic
    public static final Application a() {
        return ECPluginApplication.INSTANCE.a();
    }

    @JvmStatic
    public static final boolean b() {
        return runtime.isDebug();
    }
}
