package qk2;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0003\f\u0010\u0011B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lqk2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqk2/a$a;", "alert", "Lqk2/a$a;", "a", "()Lqk2/a$a;", "<init>", "(Lqk2/a$a;)V", "b", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class BindCardTipConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("bindBankPrivacyAlert")
    @NotNull
    private final Alert alert;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lqk2/a$a;", "", "", "a", "b", "c", "d", "toString", "", "hashCode", "other", "", "equals", "retMsg", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "title", "i", "rButton", "g", "lButton", "f", "", "Lqk2/a$c;", "agreement", "Ljava/util/List;", "e", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Alert {

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

        public Alert() {
            this(null, null, null, null, null, 31, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getRetMsg() {
            return this.retMsg;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getRButton() {
            return this.rButton;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getLButton() {
            return this.lButton;
        }

        @NotNull
        public final List<Protocol> e() {
            return this.agreement;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Alert)) {
                return false;
            }
            Alert alert = (Alert) other;
            if (Intrinsics.areEqual(this.retMsg, alert.retMsg) && Intrinsics.areEqual(this.title, alert.title) && Intrinsics.areEqual(this.rButton, alert.rButton) && Intrinsics.areEqual(this.lButton, alert.lButton) && Intrinsics.areEqual(this.agreement, alert.agreement)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String f() {
            return this.lButton;
        }

        @NotNull
        public final String g() {
            return this.rButton;
        }

        @NotNull
        public final String h() {
            return this.retMsg;
        }

        public int hashCode() {
            return (((((((this.retMsg.hashCode() * 31) + this.title.hashCode()) * 31) + this.rButton.hashCode()) * 31) + this.lButton.hashCode()) * 31) + this.agreement.hashCode();
        }

        @NotNull
        public final String i() {
            return this.title;
        }

        @NotNull
        public String toString() {
            return "Alert(retMsg=" + this.retMsg + ", title=" + this.title + ", rButton=" + this.rButton + ", lButton=" + this.lButton + ", agreement=" + this.agreement + ")";
        }

        public Alert(@NotNull String retMsg, @NotNull String title, @NotNull String rButton, @NotNull String lButton, @NotNull List<Protocol> agreement) {
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

        public /* synthetic */ Alert(String str, String str2, String str3, String str4, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "<title=\"\u300aQQ\u94b1\u5305\u652f\u4ed8\u7528\u6237\u670d\u52a1\u534f\u8bae\u300b\",url=\"https://www.tenpay.com/v2/html5/basic/public/agreement/protocol_mqq_pay.shtml\">\n<title=\"\u300a\u8d22\u4ed8\u901a\u9690\u79c1\u653f\u7b56\u300b\",url=\"https://posts.tenpay.com/posts/18ed0968618e3db204d4931651708953.html\">\n<title=\"\u300a\u8d22\u4ed8\u901a\u513f\u7ae5\u9690\u79c1\u4fdd\u62a4\u58f0\u660e\u300b\",url=\"https://www.tenpay.com/v3/helpcenter/low/privacy_child.shtml\">" : str, (i3 & 2) != 0 ? "\u6dfb\u52a0\u94f6\u884c\u5361\u9700\u540c\u610f\u4ee5\u4e0b\u534f\u8bae" : str2, (i3 & 4) != 0 ? "\u540c\u610f" : str3, (i3 & 8) != 0 ? "\u4e0d\u540c\u610f" : str4, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{new Protocol("QQ\u94b1\u5305\u652f\u4ed8\u7528\u6237\u670d\u52a1\u534f\u8bae", "https://www.tenpay.com/v2/html5/basic/public/agreement/protocol_mqq_pay.shtml", "20240206\u7248"), new Protocol("\u8d22\u4ed8\u901a\u9690\u79c1\u653f\u7b56", "https://posts.tenpay.com/posts/79550af2600935010054d2976f75afc5.html", "20211114\u7248"), new Protocol("\u8d22\u4ed8\u901a\u513f\u7ae5\u9690\u79c1\u4fdd\u62a4\u58f0\u660e", "https://www.tenpay.com/v3/helpcenter/low/privacy_child.shtml", "20211114\u7248")}) : list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lqk2/a$b;", "", "", "", "requestMap", "", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.a$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Map<String, String> requestMap) {
            Intrinsics.checkNotNullParameter(requestMap, "requestMap");
            Alert alert = ((BindCardTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_BIND_BANK_TIP_CONFIG, new BindCardTipConfig(null, 1, 0 == true ? 1 : 0))).getAlert();
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = alert.e().iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(new GsonBuilder().create().toJson((Protocol) it.next()));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("agreement", jSONArray);
            requestMap.put("agreement", jSONObject.toString());
            QLog.i("BindCardTipConfig", 1, "putAgreement: " + jSONObject);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lqk2/a$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "url", "getUrl", "version", "getVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.a$c, reason: from toString */
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

    public BindCardTipConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @JvmStatic
    public static final void b(@NotNull Map<String, String> map) {
        INSTANCE.a(map);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Alert getAlert() {
        return this.alert;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof BindCardTipConfig) && Intrinsics.areEqual(this.alert, ((BindCardTipConfig) other).alert)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.alert.hashCode();
    }

    @NotNull
    public String toString() {
        return "BindCardTipConfig(alert=" + this.alert + ")";
    }

    public BindCardTipConfig(@NotNull Alert alert) {
        Intrinsics.checkNotNullParameter(alert, "alert");
        this.alert = alert;
    }

    public /* synthetic */ BindCardTipConfig(Alert alert, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Alert(null, null, null, null, null, 31, null) : alert);
    }
}
