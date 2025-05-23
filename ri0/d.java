package ri0;

import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B4\u0012+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R9\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lri0/d;", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "Lkotlin/jvm/functions/Function1;", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class d implements IECSchemeCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Function1<Object, Unit> callback;

    public d(Function1<Object, Unit> function1) {
        this.callback = function1;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
    public void onCallbackFinished(JSONObject data) {
        Function1<Object, Unit> function1 = this.callback;
        if (function1 != null) {
            function1.invoke(data.toString());
        }
    }
}
