package rg0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.qqlivesso.api.IECQQLiveSSORequest;
import com.tencent.ecommerce.base.qqlivesso.api.IECQQLiveSSORequestCallback;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lrg0/a;", "", "", "service", "method", "reqParam", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequestCallback;", "callback", "", "a", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;", "sender", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f431441b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IECQQLiveSSORequest sender = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqLiveSSORequest();

    a() {
    }

    public final void a(String service, String method, String reqParam, IECQQLiveSSORequestCallback callback) {
        IECQQLiveSSORequest iECQQLiveSSORequest = sender;
        if (iECQQLiveSSORequest == null || iECQQLiveSSORequest == null) {
            return;
        }
        iECQQLiveSSORequest.sendRequest(service, method, reqParam, callback);
    }
}
