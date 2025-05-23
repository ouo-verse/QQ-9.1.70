package t62;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tJ*\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0010R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001d\u00a8\u0006!"}, d2 = {"Lt62/e;", "", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "webViewPlugin", "", "e", "Lt62/c;", "action", "f", "", "name", "d", "jsCallbackFunc", "", "retCode", "msg", "Lorg/json/JSONObject;", "data", "a", "Lt62/d;", "jsMethodModel", "c", "func", "jsonObject", "b", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "mWebPlugin", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "map", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static WebViewPlugin mWebPlugin;

    /* renamed from: a, reason: collision with root package name */
    public static final e f435478a = new e();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, String> map = new HashMap<>();

    e() {
    }

    public final void a(String jsCallbackFunc, int retCode, String msg2, JSONObject data) {
        Intrinsics.checkNotNullParameter(jsCallbackFunc, "jsCallbackFunc");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        c(jsCallbackFunc, new JsMethodModel(retCode, msg2, data));
    }

    public final void b(String func, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(func, "func");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        WebViewPlugin webViewPlugin = mWebPlugin;
        if (webViewPlugin != null) {
            webViewPlugin.callJs(func, jsonObject.toString());
        }
    }

    public final void c(String jsCallbackFunc, JsMethodModel jsMethodModel) {
        Intrinsics.checkNotNullParameter(jsCallbackFunc, "jsCallbackFunc");
        Intrinsics.checkNotNullParameter(jsMethodModel, "jsMethodModel");
        b(jsCallbackFunc, jsMethodModel.a());
    }

    public final c d(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap<String, String> hashMap = map;
        if (!hashMap.containsKey(name)) {
            return null;
        }
        String str = hashMap.get(name);
        Intrinsics.checkNotNull(str);
        return (c) Class.forName(str).newInstance();
    }

    public final void e(WebViewPlugin webViewPlugin) {
        Intrinsics.checkNotNullParameter(webViewPlugin, "webViewPlugin");
        mWebPlugin = webViewPlugin;
    }

    public final void f(c action) {
        Intrinsics.checkNotNullParameter(action, "action");
        HashMap<String, String> hashMap = map;
        String name = action.getName();
        String name2 = action.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "action.javaClass.name");
        hashMap.put(name, name2);
    }
}
