package s62;

import com.tencent.luggage.wxa.gg.c;
import com.tencent.mobileqq.kandian.biz.share.f;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014JO\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\b\"\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0004H\u0016R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Ls62/b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "getNameSpace", "", "Lcom/tencent/mobileqq/kandian/biz/share/f;", "d", "Ljava/util/Map;", "processMap", "<init>", "()V", "e", "a", "b", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, f> processMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Ls62/b$a;", "", "Ls62/b;", "d", "Ls62/b;", "a", "()Ls62/b;", "plugin", "<init>", "(Ls62/b;)V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static abstract class a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final b plugin;

        public a(b plugin) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            this.plugin = plugin;
        }

        /* renamed from: a, reason: from getter */
        public final b getPlugin() {
            return this.plugin;
        }
    }

    public b() {
        Map<String, f> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(c.NAME, new f(this)));
        this.processMap = mapOf;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "tribe";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener listener, String url, String pkgName, String method, String... args) {
        f fVar;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(args, "args");
        if (!(method == null || method.length() == 0) && (fVar = this.processMap.get(method)) != null) {
            if (!(args.length == 0)) {
                jSONObject = new JSONObject(args[0]);
            } else {
                jSONObject = new JSONObject();
            }
            fVar.d(jSONObject);
            return true;
        }
        return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
    }
}
