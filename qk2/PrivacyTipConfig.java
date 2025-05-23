package qk2;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0005\f\u001c\u0011\u0017 BA\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lqk2/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqk2/j$a;", "alertContent", "Lqk2/j$a;", "a", "()Lqk2/j$a;", "Lqk2/j$d;", "serviceContent", "Lqk2/j$d;", "c", "()Lqk2/j$d;", "", "Lqk2/j$e;", "sourceContentMap", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "", "queryStateIntervals", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "(Lqk2/j$a;Lqk2/j$d;Ljava/util/Map;Ljava/util/List;)V", "e", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.j, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class PrivacyTipConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("privacyAlertContent")
    @NotNull
    private final AlertContent alertContent;

    @SerializedName("queryStateIntervals")
    @NotNull
    private final List<Integer> queryStateIntervals;

    @SerializedName("marketingServiceContent")
    @NotNull
    private final ServiceContent serviceContent;

    @SerializedName("sourceContent")
    @NotNull
    private final Map<String, SourceContent> sourceContentMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lqk2/j$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "retMsg", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "e", "rButton", "c", "lButton", "b", "", "Lqk2/j$c;", "agreement", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.j$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AlertContent {

        @SerializedName("agreement")
        @NotNull
        private final List<Protocol> agreement;

        @SerializedName(FakeUrl.FAKE_LBUTTON)
        @NotNull
        private final String lButton;

        @SerializedName(FakeUrl.FAKE_RBUTTON)
        @NotNull
        private final String rButton;

        @SerializedName("retmsg")
        @NotNull
        private final String retMsg;

        @SerializedName("title")
        @NotNull
        private final String title;

        public AlertContent() {
            this(null, null, null, null, null, 31, null);
        }

        @NotNull
        public final List<Protocol> a() {
            return this.agreement;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getLButton() {
            return this.lButton;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getRButton() {
            return this.rButton;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getRetMsg() {
            return this.retMsg;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AlertContent)) {
                return false;
            }
            AlertContent alertContent = (AlertContent) other;
            if (Intrinsics.areEqual(this.retMsg, alertContent.retMsg) && Intrinsics.areEqual(this.title, alertContent.title) && Intrinsics.areEqual(this.rButton, alertContent.rButton) && Intrinsics.areEqual(this.lButton, alertContent.lButton) && Intrinsics.areEqual(this.agreement, alertContent.agreement)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.retMsg.hashCode() * 31) + this.title.hashCode()) * 31) + this.rButton.hashCode()) * 31) + this.lButton.hashCode()) * 31) + this.agreement.hashCode();
        }

        @NotNull
        public String toString() {
            return "AlertContent(retMsg=" + this.retMsg + ", title=" + this.title + ", rButton=" + this.rButton + ", lButton=" + this.lButton + ", agreement=" + this.agreement + ")";
        }

        public AlertContent(@NotNull String retMsg, @NotNull String title, @NotNull String rButton, @NotNull String lButton, @NotNull List<Protocol> agreement) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(rButton, "rButton");
            Intrinsics.checkNotNullParameter(lButton, "lButton");
            Intrinsics.checkNotNullParameter(agreement, "agreement");
            this.retMsg = retMsg;
            this.title = title;
            this.rButton = rButton;
            this.lButton = lButton;
            this.agreement = agreement;
        }

        public /* synthetic */ AlertContent(String str, String str2, String str3, String str4, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "\u5c0a\u656c\u7684QQ\u94b1\u5305\u652f\u4ed8\u7528\u6237\uff0c\u4e3a\u4e86\u4fdd\u969c\u4f60\u7684\u5408\u6cd5\u6743\u76ca\uff0c\u66f4\u597d\u5730\u5411\u4f60\u63d0\u4f9b\u5b89\u5168\u3001\u5feb\u6377\u3001\u4fbf\u5229\u7684QQ\u94b1\u5305\u652f\u4ed8\u670d\u52a1\uff0c\u8d22\u4ed8\u901a\u516c\u53f8\u4f9d\u7167\u56fd\u5bb6\u6cd5\u5f8b\u6cd5\u89c4\uff0c\u5bf9\u652f\u4ed8\u8d26\u6237\u8fdb\u884c\u5b9e\u540d\u5236\u7ba1\u7406\u3001\u5c65\u884c\u53cd\u6d17\u94b1\u804c\u8d23\u5e76\u91c7\u53d6\u98ce\u9669\u9632\u63a7\u63aa\u65bd\u3002\u4f60\u9700\u8981\u5411\u8d22\u4ed8\u901a\u516c\u53f8\u63d0\u4ea4\u8eab\u4efd\u4fe1\u606f\u3001\u8054\u7cfb\u65b9\u5f0f\u7b49\u4fe1\u606f\u4ee5\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1\u64cd\u4f5c\u3002\n\u8d22\u4ed8\u901a\u516c\u53f8\u5c06\u4e25\u683c\u4f9d\u636e\u56fd\u5bb6\u6cd5\u5f8b\u6cd5\u89c4\u6536\u96c6\u3001\u5b58\u50a8\u3001\u4f7f\u7528\u4f60\u7684\u4e2a\u4eba\u4fe1\u606f\uff0c\u786e\u4fdd\u4fe1\u606f\u5b89\u5168\u3002\n\u8bf7\u4f60\u5ba1\u614e\u9605\u8bfb\u5e76\u5145\u5206\u7406\u89e3<title=\"\u300a\u8d22\u4ed8\u901a\u670d\u52a1\u534f\u8bae\u300b\",url=\"https://posts.tenpay.com/posts/3b020ca36008eb660046aad41d458236.html\"> <title=\"\u300aQQ\u94b1\u5305\u652f\u4ed8\u7528\u6237\u670d\u52a1\u534f\u8bae\u300b\",url=\"https://www.tenpay.com/v2/html5/basic/public/agreement/protocol_mqq_pay.shtml\">\u53ca<title=\"\u300a\u8d22\u4ed8\u901a\u9690\u79c1\u653f\u7b56\u300b\",url=\"https://posts.tenpay.com/posts/18ed0968618e3db204d4931651708953.html\"><title=\"\u300a\u8d22\u4ed8\u901a\u513f\u7ae5\u9690\u79c1\u4fdd\u62a4\u58f0\u660e\u300b\",url=\"https://www.tenpay.com/v3/helpcenter/low/privacy_child.shtml\">\uff0c\u82e5\u4f60\u540c\u610f\u63a5\u53d7\u524d\u8ff0\u534f\u8bae\uff0c\u8bf7\u70b9\u51fb\u201c\u540c\u610f\u201d\u5e76\u7ee7\u7eed\u5f00\u901aQQ\u94b1\u5305\u652f\u4ed8\u8d26\u6237\u670d\u52a1\uff0c\u5426\u5219\uff0c\u8bf7\u70b9\u51fb\u201c\u4e0d\u540c\u610f\u201d\uff0c\u4e2d\u6b62\u5f00\u901aQQ\u94b1\u5305\u652f\u4ed8\u8d26\u6237\u670d\u52a1\u3002" : str, (i3 & 2) != 0 ? "QQ\u94b1\u5305\u652f\u4ed8\u7528\u6237\u670d\u52a1\u534f\u8bae\u53ca\u9690\u79c1\u653f\u7b56" : str2, (i3 & 4) != 0 ? "\u540c\u610f" : str3, (i3 & 8) != 0 ? "\u4e0d\u540c\u610f" : str4, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{new Protocol("\u8d22\u4ed8\u901a\u670d\u52a1\u534f\u8bae", "https://posts.tenpay.com/posts/3b020ca36008eb660046aad41d458236.html", "20220829\u7248"), new Protocol("QQ\u94b1\u5305\u652f\u4ed8\u7528\u6237\u670d\u52a1\u534f\u8bae", "https://www.tenpay.com/v2/html5/basic/public/agreement/protocol_mqq_pay.shtml", "20240206\u7248"), new Protocol("\u8d22\u4ed8\u901a\u9690\u79c1\u653f\u7b56", "https://posts.tenpay.com/posts/79550af2600935010054d2976f75afc5.html", "20211114\u7248"), new Protocol("\u8d22\u4ed8\u901a\u513f\u7ae5\u9690\u79c1\u4fdd\u62a4\u58f0\u660e", "https://www.tenpay.com/v3/helpcenter/low/privacy_child.shtml", "20211114\u7248")}) : list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ \u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lqk2/j$b;", "", "", "", "requestMap", "", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.j$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Map<String, String> requestMap) {
            Intrinsics.checkNotNullParameter(requestMap, "requestMap");
            AlertContent alertContent = ((PrivacyTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_PRIVACY_TIP_CONFIG, new PrivacyTipConfig(null, null, null, null, 15, null))).getAlertContent();
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = alertContent.a().iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(new GsonBuilder().create().toJson((Protocol) it.next()));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("agreement", jSONArray);
            requestMap.put("agreement", jSONObject.toString());
            QLog.i("PrivacyTipConfig", 1, "putAgreement: " + jSONObject);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lqk2/j$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "url", "getUrl", "version", "getVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.j$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Protocol {

        @SerializedName("name")
        @NotNull
        private final String name;

        @SerializedName("url")
        @NotNull
        private final String url;

        @SerializedName("version")
        @NotNull
        private final String version;

        public Protocol(@NotNull String name, @NotNull String url, @NotNull String version) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(version, "version");
            this.name = name;
            this.url = url;
            this.version = version;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Protocol)) {
                return false;
            }
            Protocol protocol2 = (Protocol) other;
            if (Intrinsics.areEqual(this.name, protocol2.name) && Intrinsics.areEqual(this.url, protocol2.url) && Intrinsics.areEqual(this.version, protocol2.version)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.url.hashCode()) * 31) + this.version.hashCode();
        }

        @NotNull
        public String toString() {
            return "Protocol(name=" + this.name + ", url=" + this.url + ", version=" + this.version + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lqk2/j$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "retMsg", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "d", "switchTitle", "c", "defaultSwitch", "I", "a", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.j$d, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class ServiceContent {

        @SerializedName("defaultSwitch")
        private final int defaultSwitch;

        @SerializedName("retmsg")
        @NotNull
        private final String retMsg;

        @SerializedName("switchTitle")
        @NotNull
        private final String switchTitle;

        @SerializedName("title")
        @NotNull
        private final String title;

        public ServiceContent() {
            this(null, null, null, 0, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getDefaultSwitch() {
            return this.defaultSwitch;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getRetMsg() {
            return this.retMsg;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getSwitchTitle() {
            return this.switchTitle;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServiceContent)) {
                return false;
            }
            ServiceContent serviceContent = (ServiceContent) other;
            if (Intrinsics.areEqual(this.retMsg, serviceContent.retMsg) && Intrinsics.areEqual(this.title, serviceContent.title) && Intrinsics.areEqual(this.switchTitle, serviceContent.switchTitle) && this.defaultSwitch == serviceContent.defaultSwitch) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.retMsg.hashCode() * 31) + this.title.hashCode()) * 31) + this.switchTitle.hashCode()) * 31) + this.defaultSwitch;
        }

        @NotNull
        public String toString() {
            return "ServiceContent(retMsg=" + this.retMsg + ", title=" + this.title + ", switchTitle=" + this.switchTitle + ", defaultSwitch=" + this.defaultSwitch + ")";
        }

        public ServiceContent(@NotNull String retMsg, @NotNull String title, @NotNull String switchTitle, int i3) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(switchTitle, "switchTitle");
            this.retMsg = retMsg;
            this.title = title;
            this.switchTitle = switchTitle;
            this.defaultSwitch = i3;
        }

        public /* synthetic */ ServiceContent(String str, String str2, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "\u4e3a\u4e86\u63d0\u5347\u670d\u52a1\u8d28\u91cf\uff0c\u6211\u4eec\u4f1a\u5c06\u4f60\u7684\u4fe1\u606f\u7528\u4e8e\u8425\u9500\u3001\u7528\u6237\u4f53\u9a8c\u6539\u8fdb\u6216\u8005\u5e02\u573a\u8c03\u67e5\u7528\u9014\u3002\u5982\u4f60\u4e0d\u540c\u610f\uff0c\u6211\u4eec\u4e0d\u4f1a\u5c06\u4f60\u7684\u4e2a\u4eba\u4fe1\u606f\u7528\u4e8e\u4e0a\u8ff0\u7528\u9014\uff0c\u4f60\u53ef\u4ee5\u70b9\u51fb\u4e0b\u8ff0\u6309\u94ae\u5173\u95ed\uff0c\u4f46\u4f60\u4ecd\u53ef\u6839\u636e\u534f\u8bae\u6b63\u5e38\u4f7f\u7528\u6211\u4eec\u7684\u5176\u4ed6\u4ea7\u54c1\u6216\u670d\u52a1\u3002\u5982\u4f60\u540c\u610f\uff0c\u4f60\u53ef\u80fd\u4f1a\u6536\u5230\u6211\u4eec\u901a\u8fc7\u77ed\u4fe1\u3001\u90ae\u4ef6\u3001\u516c\u4f17\u53f7\u7b49\u6e20\u9053\u53d1\u9001\u7684\u611f\u5174\u8da3\u7684\u8425\u9500\u4fe1\u606f\uff0c\u6216\u83b7\u5f97\u66f4\u597d\u7684\u7528\u6237\u4f53\u9a8c\uff0c\u6216\u901a\u8fc7\u524d\u8ff0\u6e20\u9053\u53c2\u4e0e\u5e02\u573a\u8c03\u67e5\u6d3b\u52a8\uff1b\u4f60\u540c\u610f\u540e\u4e5f\u53ef\u4ee5\u5728\u70b9\u51fb\u3010\u7528\u6237\u6743\u76ca\u4fdd\u62a4\u4e2d\u5fc3\u3011\u540e\u7684\u9875\u9762\u4e2d\u8fdb\u884c\u5173\u95ed\u3002" : str, (i16 & 2) != 0 ? "\u8425\u9500\u670d\u52a1" : str2, (i16 & 4) != 0 ? "\u8425\u9500\u63a8\u9001\u670d\u52a1" : str3, (i16 & 8) != 0 ? 1 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lqk2/j$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "statementTip", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "finishTitle", "c", "finishTip", "b", "finishBtnText", "a", "hideSupportCertificate", "Z", "d", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.j$e, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class SourceContent {

        @SerializedName("finishBtnText")
        @NotNull
        private final String finishBtnText;

        @SerializedName("finishTip")
        @NotNull
        private final String finishTip;

        @SerializedName("finishTitle")
        @NotNull
        private final String finishTitle;

        @SerializedName("hideSupportCertificate")
        private final boolean hideSupportCertificate;

        @SerializedName("statementTip")
        @NotNull
        private final String statementTip;

        public SourceContent() {
            this(null, null, null, null, false, 31, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getFinishBtnText() {
            return this.finishBtnText;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFinishTip() {
            return this.finishTip;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getFinishTitle() {
            return this.finishTitle;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getHideSupportCertificate() {
            return this.hideSupportCertificate;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getStatementTip() {
            return this.statementTip;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SourceContent)) {
                return false;
            }
            SourceContent sourceContent = (SourceContent) other;
            if (Intrinsics.areEqual(this.statementTip, sourceContent.statementTip) && Intrinsics.areEqual(this.finishTitle, sourceContent.finishTitle) && Intrinsics.areEqual(this.finishTip, sourceContent.finishTip) && Intrinsics.areEqual(this.finishBtnText, sourceContent.finishBtnText) && this.hideSupportCertificate == sourceContent.hideSupportCertificate) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.statementTip.hashCode() * 31) + this.finishTitle.hashCode()) * 31) + this.finishTip.hashCode()) * 31) + this.finishBtnText.hashCode()) * 31;
            boolean z16 = this.hideSupportCertificate;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "SourceContent(statementTip=" + this.statementTip + ", finishTitle=" + this.finishTitle + ", finishTip=" + this.finishTip + ", finishBtnText=" + this.finishBtnText + ", hideSupportCertificate=" + this.hideSupportCertificate + ")";
        }

        public SourceContent(@NotNull String statementTip, @NotNull String finishTitle, @NotNull String finishTip, @NotNull String finishBtnText, boolean z16) {
            Intrinsics.checkNotNullParameter(statementTip, "statementTip");
            Intrinsics.checkNotNullParameter(finishTitle, "finishTitle");
            Intrinsics.checkNotNullParameter(finishTip, "finishTip");
            Intrinsics.checkNotNullParameter(finishBtnText, "finishBtnText");
            this.statementTip = statementTip;
            this.finishTitle = finishTitle;
            this.finishTip = finishTip;
            this.finishBtnText = finishBtnText;
            this.hideSupportCertificate = z16;
        }

        public /* synthetic */ SourceContent(String str, String str2, String str3, String str4, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "\u6839\u636e\u592e\u884c\u76d1\u7ba1\u89c4\u5b9a\uff0c\u4f60\u9700\u8981\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1\u624d\u80fd\u4f7f\u7528\u7ea2\u5305\u3001\u8f6c\u8d26\u3001\u8d2d\u4e70\u5546\u54c1\u7b49QQ\u652f\u4ed8\u529f\u80fd\u3002" : str, (i3 & 2) != 0 ? "\u5df2\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "\u5b8c\u6210" : str4, (i3 & 16) != 0 ? false : z16);
        }
    }

    public PrivacyTipConfig() {
        this(null, null, null, null, 15, null);
    }

    @JvmStatic
    public static final void e(@NotNull Map<String, String> map) {
        INSTANCE.a(map);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AlertContent getAlertContent() {
        return this.alertContent;
    }

    @NotNull
    public final List<Integer> b() {
        return this.queryStateIntervals;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ServiceContent getServiceContent() {
        return this.serviceContent;
    }

    @NotNull
    public final Map<String, SourceContent> d() {
        return this.sourceContentMap;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivacyTipConfig)) {
            return false;
        }
        PrivacyTipConfig privacyTipConfig = (PrivacyTipConfig) other;
        if (Intrinsics.areEqual(this.alertContent, privacyTipConfig.alertContent) && Intrinsics.areEqual(this.serviceContent, privacyTipConfig.serviceContent) && Intrinsics.areEqual(this.sourceContentMap, privacyTipConfig.sourceContentMap) && Intrinsics.areEqual(this.queryStateIntervals, privacyTipConfig.queryStateIntervals)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.alertContent.hashCode() * 31) + this.serviceContent.hashCode()) * 31) + this.sourceContentMap.hashCode()) * 31) + this.queryStateIntervals.hashCode();
    }

    @NotNull
    public String toString() {
        return "PrivacyTipConfig(alertContent=" + this.alertContent + ", serviceContent=" + this.serviceContent + ", sourceContentMap=" + this.sourceContentMap + ", queryStateIntervals=" + this.queryStateIntervals + ")";
    }

    public PrivacyTipConfig(@NotNull AlertContent alertContent, @NotNull ServiceContent serviceContent, @NotNull Map<String, SourceContent> sourceContentMap, @NotNull List<Integer> queryStateIntervals) {
        Intrinsics.checkNotNullParameter(alertContent, "alertContent");
        Intrinsics.checkNotNullParameter(serviceContent, "serviceContent");
        Intrinsics.checkNotNullParameter(sourceContentMap, "sourceContentMap");
        Intrinsics.checkNotNullParameter(queryStateIntervals, "queryStateIntervals");
        this.alertContent = alertContent;
        this.serviceContent = serviceContent;
        this.sourceContentMap = sourceContentMap;
        this.queryStateIntervals = queryStateIntervals;
    }

    public /* synthetic */ PrivacyTipConfig(AlertContent alertContent, ServiceContent serviceContent, Map map, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new AlertContent(null, null, null, null, null, 31, null) : alertContent, (i3 & 2) != 0 ? new ServiceContent(null, null, null, 0, 15, null) : serviceContent, (i3 & 4) != 0 ? new HashMap() : map, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
