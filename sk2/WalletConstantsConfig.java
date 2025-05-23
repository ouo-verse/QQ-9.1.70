package sk2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\f\u0011B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lsk2/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lsk2/c$b;", "content", "Lsk2/c$b;", "b", "()Lsk2/c$b;", "<init>", "(Lsk2/c$b;)V", "a", "c", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sk2.c, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class WalletConstantsConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<String> f433924b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<String> f433925c;

    @SerializedName("walletConstants")
    @NotNull
    private final Content content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lsk2/c$a;", "", "", "", "DEFAULT_NATIVE_PAY_PREFIX_URLS", "Ljava/util/List;", "a", "()Ljava/util/List;", "DEFAULT_PREFIX_URLS", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sk2.c$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<String> a() {
            return WalletConstantsConfig.f433925c;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lsk2/c$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "title", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "url", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sk2.c$c, reason: collision with other inner class name and from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class NormalQuestion {

        @SerializedName("title")
        @NotNull
        private final String title;

        @SerializedName("url")
        @NotNull
        private final String url;

        public NormalQuestion() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NormalQuestion)) {
                return false;
            }
            NormalQuestion normalQuestion = (NormalQuestion) other;
            if (Intrinsics.areEqual(this.title, normalQuestion.title) && Intrinsics.areEqual(this.url, normalQuestion.url)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "NormalQuestion(title=" + this.title + ", url=" + this.url + ')';
        }

        public NormalQuestion(@NotNull String title, @NotNull String url) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(url, "url");
            this.title = title;
            this.url = url;
        }

        public /* synthetic */ NormalQuestion(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    static {
        List<String> listOf;
        List<String> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"wxp://f2f", "https://wx.tenpay.com/f2f", "https://payapp.weixin.qq.com/qr/"});
        f433924b = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf("weixin://wxpay/bizpayurl");
        f433925c = listOf2;
    }

    public WalletConstantsConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Content getContent() {
        return this.content;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof WalletConstantsConfig) && Intrinsics.areEqual(this.content, ((WalletConstantsConfig) other).content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "WalletConstantsConfig(content=" + this.content + ')';
    }

    public WalletConstantsConfig(@NotNull Content content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    public /* synthetic */ WalletConstantsConfig(Content content, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Content(null, f433924b, f433925c, null, null, null, 57, null) : content);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lsk2/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "payInstructionUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "wxQRCodePrefixUrls", "Ljava/util/List;", "f", "()Ljava/util/List;", "nativePayQRCodePrefixUrls", "b", "Lsk2/c$c;", "normalQuestion", "Lsk2/c$c;", "c", "()Lsk2/c$c;", "unableVerifyIdentify", "e", "accountQuestion", "a", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lsk2/c$c;Lsk2/c$c;Lsk2/c$c;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sk2.c$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Content {

        @SerializedName("accountQuestion")
        @Nullable
        private final NormalQuestion accountQuestion;

        @SerializedName("nativePayQRCodePrefixUrls")
        @Nullable
        private final List<String> nativePayQRCodePrefixUrls;

        @SerializedName("normalQuestion")
        @NotNull
        private final NormalQuestion normalQuestion;

        @SerializedName("payInstructionUrl")
        @NotNull
        private final String payInstructionUrl;

        @SerializedName("unableVerifyIdentify")
        @Nullable
        private final NormalQuestion unableVerifyIdentify;

        @SerializedName("wxQRCodePrefixUrls")
        @NotNull
        private final List<String> wxQRCodePrefixUrls;

        public Content(@NotNull String payInstructionUrl, @NotNull List<String> wxQRCodePrefixUrls, @Nullable List<String> list, @NotNull NormalQuestion normalQuestion, @Nullable NormalQuestion normalQuestion2, @Nullable NormalQuestion normalQuestion3) {
            Intrinsics.checkNotNullParameter(payInstructionUrl, "payInstructionUrl");
            Intrinsics.checkNotNullParameter(wxQRCodePrefixUrls, "wxQRCodePrefixUrls");
            Intrinsics.checkNotNullParameter(normalQuestion, "normalQuestion");
            this.payInstructionUrl = payInstructionUrl;
            this.wxQRCodePrefixUrls = wxQRCodePrefixUrls;
            this.nativePayQRCodePrefixUrls = list;
            this.normalQuestion = normalQuestion;
            this.unableVerifyIdentify = normalQuestion2;
            this.accountQuestion = normalQuestion3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final NormalQuestion getAccountQuestion() {
            return this.accountQuestion;
        }

        @Nullable
        public final List<String> b() {
            return this.nativePayQRCodePrefixUrls;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final NormalQuestion getNormalQuestion() {
            return this.normalQuestion;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getPayInstructionUrl() {
            return this.payInstructionUrl;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final NormalQuestion getUnableVerifyIdentify() {
            return this.unableVerifyIdentify;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Content)) {
                return false;
            }
            Content content = (Content) other;
            if (Intrinsics.areEqual(this.payInstructionUrl, content.payInstructionUrl) && Intrinsics.areEqual(this.wxQRCodePrefixUrls, content.wxQRCodePrefixUrls) && Intrinsics.areEqual(this.nativePayQRCodePrefixUrls, content.nativePayQRCodePrefixUrls) && Intrinsics.areEqual(this.normalQuestion, content.normalQuestion) && Intrinsics.areEqual(this.unableVerifyIdentify, content.unableVerifyIdentify) && Intrinsics.areEqual(this.accountQuestion, content.accountQuestion)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final List<String> f() {
            return this.wxQRCodePrefixUrls;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3 = ((this.payInstructionUrl.hashCode() * 31) + this.wxQRCodePrefixUrls.hashCode()) * 31;
            List<String> list = this.nativePayQRCodePrefixUrls;
            int i3 = 0;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            int hashCode4 = (((hashCode3 + hashCode) * 31) + this.normalQuestion.hashCode()) * 31;
            NormalQuestion normalQuestion = this.unableVerifyIdentify;
            if (normalQuestion == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = normalQuestion.hashCode();
            }
            int i16 = (hashCode4 + hashCode2) * 31;
            NormalQuestion normalQuestion2 = this.accountQuestion;
            if (normalQuestion2 != null) {
                i3 = normalQuestion2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "Content(payInstructionUrl=" + this.payInstructionUrl + ", wxQRCodePrefixUrls=" + this.wxQRCodePrefixUrls + ", nativePayQRCodePrefixUrls=" + this.nativePayQRCodePrefixUrls + ", normalQuestion=" + this.normalQuestion + ", unableVerifyIdentify=" + this.unableVerifyIdentify + ", accountQuestion=" + this.accountQuestion + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Content(String str, List list, List list2, NormalQuestion normalQuestion, NormalQuestion normalQuestion2, NormalQuestion normalQuestion3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, list, list2, (i3 & 8) != 0 ? new NormalQuestion(null, 0 == true ? 1 : 0, r15, 0 == true ? 1 : 0) : normalQuestion, (i3 & 16) != 0 ? new NormalQuestion(0 == true ? 1 : 0, 0 == true ? 1 : 0, r15, 0 == true ? 1 : 0) : normalQuestion2, (i3 & 32) != 0 ? new NormalQuestion(0 == true ? 1 : 0, 0 == true ? 1 : 0, r15, 0 == true ? 1 : 0) : normalQuestion3);
            int i16 = 3;
        }
    }
}
