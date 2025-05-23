package w43;

import android.net.Uri;
import android.webkit.URLUtil;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007R$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lw43/a;", "", "", "b", "", "d", "", "", "e", h.F, "c", "url", "g", "<set-?>", "Z", "f", "()Z", "isSupportStudyModeBlockUrl", "Ljava/util/Set;", "urlWhitelist", "Lmqq/app/IAccountCallback;", "Lmqq/app/IAccountCallback;", "accountCallback", "<init>", "()V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f444584a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isSupportStudyModeBlockUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile Set<String> urlWhitelist;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final IAccountCallback accountCallback;

    static {
        a aVar = new a();
        f444584a = aVar;
        isSupportStudyModeBlockUrl = true;
        C11460a c11460a = new C11460a();
        accountCallback = c11460a;
        aVar.h();
        MobileQQ.sMobileQQ.registerAccountCallback(c11460a);
    }

    a() {
    }

    private final boolean d() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).studyMode9165Switch();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        if (r0.length() > 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Set<String> e() {
        JSONArray jSONArray;
        if (!isSupportStudyModeBlockUrl) {
            QLog.d("StudyModeWebInterceptConfigManager", 1, "getUrlWhitelistFromConfig return null\uff0cisSupportStudyModeBlockUrl is false");
            return null;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105929", "");
        if (loadAsString.length() == 0) {
            QLog.d("StudyModeWebInterceptConfigManager", 1, "getUrlWhitelistFromConfig return null\uff0cjsonString isEmpty");
            return null;
        }
        try {
            jSONArray = new JSONObject(loadAsString).optJSONArray(CoverDBCacheData.URLS);
            if (jSONArray != null) {
            }
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getUrlWhitelistFromConfig JSON deserialization error\uff1a[e.message: ");
            String message = e16.getMessage();
            sb5.append(message != null ? message : "");
            sb5.append(']');
            QLog.d("StudyModeWebInterceptConfigManager", 1, sb5.toString());
        }
        jSONArray = null;
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = jSONArray.optString(i3);
                if (optString != null) {
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(i)");
                    if (!(optString.length() > 0)) {
                        optString = null;
                    }
                    if (optString != null) {
                        hashSet.add(optString);
                    }
                }
            }
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        return hashSet;
    }

    public final boolean c() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    public final boolean f() {
        return isSupportStudyModeBlockUrl;
    }

    public final boolean g(String url) {
        Object m476constructorimpl;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean areEqual;
        String removePrefix;
        boolean endsWith$default;
        String host;
        boolean z16 = true;
        if (!isSupportStudyModeBlockUrl) {
            QLog.d("StudyModeWebInterceptConfigManager", 1, "isUrlInWhitelist return false\uff0cisSupportStudyModeBlockUrl is false");
            return false;
        }
        Set<String> set = urlWhitelist;
        if (set == null || set.isEmpty()) {
            QLog.d("StudyModeWebInterceptConfigManager", 1, "isUrlInWhitelist return false\uff0curlWhitelist isNullOrEmpty");
            return false;
        }
        if (url == null || url.length() == 0) {
            QLog.d("StudyModeWebInterceptConfigManager", 1, "isUrlInWhitelist return false\uff0curl isNullOrEmpty]");
            return false;
        }
        String guessUrl = URLUtil.guessUrl(url);
        String str = "";
        if (guessUrl == null) {
            guessUrl = "";
        }
        if (guessUrl.length() == 0) {
            QLog.d("StudyModeWebInterceptConfigManager", 1, "isUrlInWhitelist return false\uff0cprocessedUrl isEmpty\uff1a[url: " + url + ']');
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(Uri.parse(guessUrl));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isUrlInWhitelist URI parse failed: [url: ");
            sb5.append(url);
            sb5.append(", e.message: ");
            String message = m479exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "";
            }
            sb5.append(message);
            sb5.append(']');
            QLog.d("StudyModeWebInterceptConfigManager", 1, sb5.toString());
            m476constructorimpl = null;
        }
        Uri uri = (Uri) m476constructorimpl;
        if (uri != null && (host = uri.getHost()) != null) {
            str = host;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "www.", false, 2, null);
        if (startsWith$default) {
            str = StringsKt__StringsKt.removePrefix(str, (CharSequence) "www.");
        }
        if (str.length() == 0) {
            QLog.d("StudyModeWebInterceptConfigManager", 1, "isUrlInWhitelist return false\uff0cdomain isEmpty\uff1a[url: " + url + ']');
            return false;
        }
        Set<String> set2 = urlWhitelist;
        if (set2 == null) {
            return false;
        }
        if (!set2.isEmpty()) {
            for (String str2 : set2) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str2, "*.", false, 2, null);
                if (startsWith$default2) {
                    removePrefix = StringsKt__StringsKt.removePrefix(str2, (CharSequence) "*.");
                    String str3 = '.' + removePrefix;
                    if (!Intrinsics.areEqual(str, removePrefix)) {
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, str3, false, 2, null);
                        if (!endsWith$default) {
                            areEqual = false;
                        }
                    }
                    areEqual = true;
                } else {
                    areEqual = Intrinsics.areEqual(str, str2);
                }
                if (areEqual) {
                    break;
                }
            }
        }
        z16 = false;
        return z16;
    }

    public final void h() {
        isSupportStudyModeBlockUrl = d();
        urlWhitelist = e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        isSupportStudyModeBlockUrl = true;
        urlWhitelist = null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"w43/a$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: w43.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11460a implements IAccountCallback {
        C11460a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
            a aVar = a.f444584a;
            aVar.h();
            QLog.i("StudyModeWebInterceptConfigManager", 1, "accountCallback onAccountChanged: " + aVar.f());
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
            a.f444584a.b();
            QLog.i("StudyModeWebInterceptConfigManager", 1, "accountCallback onLogout, reason = " + reason);
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
        }
    }
}
