package ui0;

import android.webkit.JavascriptInterface;
import com.tencent.ecommerce.biz.register.bridge.IECommerceBridgeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lui0/a;", "", "", "data", "", "onVerified", "onPageClose", "onPageReady", "Lcom/tencent/ecommerce/biz/register/bridge/IECommerceBridgeListener;", "bridgeListenerCallback", "a", "Lcom/tencent/ecommerce/biz/register/bridge/IECommerceBridgeListener;", "<init>", "()V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IECommerceBridgeListener bridgeListenerCallback;

    public final void a(IECommerceBridgeListener bridgeListenerCallback) {
        this.bridgeListenerCallback = bridgeListenerCallback;
    }

    @JavascriptInterface
    public final void onPageClose() {
        cg0.a.b("ECommerceJsBridge", "onPageClose");
        IECommerceBridgeListener iECommerceBridgeListener = this.bridgeListenerCallback;
        if (iECommerceBridgeListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bridgeListenerCallback");
        }
        iECommerceBridgeListener.onPageClose();
    }

    @JavascriptInterface
    public final void onPageReady(String data) {
        cg0.a.b("ECommerceJsBridge", "onPageReady");
        IECommerceBridgeListener iECommerceBridgeListener = this.bridgeListenerCallback;
        if (iECommerceBridgeListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bridgeListenerCallback");
        }
        iECommerceBridgeListener.onPageReady();
    }

    @JavascriptInterface
    public final void onVerified(String data) {
        cg0.a.b("ECommerceJsBridge", "onVerified data " + data);
        IECommerceBridgeListener iECommerceBridgeListener = this.bridgeListenerCallback;
        if (iECommerceBridgeListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bridgeListenerCallback");
        }
        iECommerceBridgeListener.onVerified(data);
    }
}
