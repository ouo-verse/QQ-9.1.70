package qk2;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u001dBY\u0012 \b\u0002\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R2\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lqk2/l;", "", "", "a", "b", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lqk2/l$c;", "Lkotlin/collections/ArrayList;", "tabbarList", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "tips", "Ljava/lang/String;", "getTips", "()Ljava/lang/String;", "wechatTips", "getWechatTips", "transferRecordUrl", "e", "Lqk2/l$b;", "paycodeProtocol", "Lqk2/l$b;", "c", "()Lqk2/l$b;", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lqk2/l$b;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.l, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QrcodeConfig {

    @SerializedName("paycode_protocol")
    @Nullable
    private final PaycodeProtocol paycodeProtocol;

    @SerializedName("qr_tabbar_list")
    @Nullable
    private final ArrayList<TabbarItem> tabbarList;

    @SerializedName("tips")
    @Nullable
    private final String tips;

    @SerializedName("transfer_record_url")
    @Nullable
    private final String transferRecordUrl;

    @SerializedName("wechat_tips")
    @Nullable
    private final String wechatTips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lqk2/l$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "protocolUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "protocolName", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.l$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PaycodeProtocol {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final PaycodeProtocol f429012b = new PaycodeProtocol("https://i.qianbao.qq.com/hybird/modules/document/paymentUserServiceAgreement.html", "\u300a\u652f\u4ed8\u4ed8\u6b3e\u7528\u6237\u670d\u52a1\u534f\u8bae\u300b");

        @SerializedName("protocol_name")
        @Nullable
        private final String protocolName;

        @SerializedName("protocol_url")
        @Nullable
        private final String protocolUrl;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lqk2/l$b$a;", "", "Lqk2/l$b;", "DEFAULT", "Lqk2/l$b;", "a", "()Lqk2/l$b;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: qk2.l$b$a, reason: from kotlin metadata */
        /* loaded from: classes16.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final PaycodeProtocol a() {
                return PaycodeProtocol.f429012b;
            }

            Companion() {
            }
        }

        public PaycodeProtocol() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getProtocolName() {
            return this.protocolName;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getProtocolUrl() {
            return this.protocolUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaycodeProtocol)) {
                return false;
            }
            PaycodeProtocol paycodeProtocol = (PaycodeProtocol) other;
            if (Intrinsics.areEqual(this.protocolUrl, paycodeProtocol.protocolUrl) && Intrinsics.areEqual(this.protocolName, paycodeProtocol.protocolName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.protocolUrl;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.protocolName;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "PaycodeProtocol(protocolUrl=" + this.protocolUrl + ", protocolName=" + this.protocolName + ")";
        }

        public PaycodeProtocol(@Nullable String str, @Nullable String str2) {
            this.protocolUrl = str;
            this.protocolName = str2;
        }

        public /* synthetic */ PaycodeProtocol(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lqk2/l$c;", "", "", "g", "", "e", "", "toString", "hashCode", "other", "equals", "id", "I", "b", "()I", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "imgUrl", "c", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "d", "elderModeForbidden", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.l$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class TabbarItem {

        @SerializedName("care_mode_forbidden")
        @Nullable
        private final Integer elderModeForbidden;

        @SerializedName("id")
        private final int id;

        @SerializedName("imgurl")
        @Nullable
        private final String imgUrl;

        @SerializedName(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)
        @Nullable
        private final String link;

        @SerializedName("title")
        @Nullable
        private final String title;

        public TabbarItem() {
            this(0, null, null, null, null, 31, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Integer getElderModeForbidden() {
            return this.elderModeForbidden;
        }

        /* renamed from: b, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getImgUrl() {
            return this.imgUrl;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        public final int e() {
            int i3 = this.id;
            if (i3 == 2) {
                return R.drawable.nvx;
            }
            if (i3 == 3) {
                return R.drawable.n9k;
            }
            if (i3 == 4) {
                return R.drawable.n9m;
            }
            if (i3 == 5) {
                return R.drawable.n9j;
            }
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TabbarItem)) {
                return false;
            }
            TabbarItem tabbarItem = (TabbarItem) other;
            if (this.id == tabbarItem.id && Intrinsics.areEqual(this.title, tabbarItem.title) && Intrinsics.areEqual(this.imgUrl, tabbarItem.imgUrl) && Intrinsics.areEqual(this.link, tabbarItem.link) && Intrinsics.areEqual(this.elderModeForbidden, tabbarItem.elderModeForbidden)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final boolean g() {
            int i3 = this.id;
            if (i3 >= 1 && i3 <= 5) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int i3 = this.id * 31;
            String str = this.title;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.imgUrl;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            String str3 = this.link;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i19 = (i18 + hashCode3) * 31;
            Integer num = this.elderModeForbidden;
            if (num != null) {
                i16 = num.hashCode();
            }
            return i19 + i16;
        }

        @NotNull
        public String toString() {
            return "TabbarItem(id=" + this.id + ", title=" + this.title + ", imgUrl=" + this.imgUrl + ", link=" + this.link + ", elderModeForbidden=" + this.elderModeForbidden + ")";
        }

        public TabbarItem(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num) {
            this.id = i3;
            this.title = str;
            this.imgUrl = str2;
            this.link = str3;
            this.elderModeForbidden = num;
        }

        public /* synthetic */ TabbarItem(int i3, String str, String str2, String str3, Integer num, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2, (i16 & 8) == 0 ? str3 : null, (i16 & 16) != 0 ? 0 : num);
        }
    }

    public QrcodeConfig() {
        this(null, null, null, null, null, 31, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getTips() {
        return this.tips;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getWechatTips() {
        return this.wechatTips;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final PaycodeProtocol getPaycodeProtocol() {
        return this.paycodeProtocol;
    }

    @Nullable
    public final ArrayList<TabbarItem> d() {
        return this.tabbarList;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getTransferRecordUrl() {
        return this.transferRecordUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrcodeConfig)) {
            return false;
        }
        QrcodeConfig qrcodeConfig = (QrcodeConfig) other;
        if (Intrinsics.areEqual(this.tabbarList, qrcodeConfig.tabbarList) && Intrinsics.areEqual(this.tips, qrcodeConfig.tips) && Intrinsics.areEqual(this.wechatTips, qrcodeConfig.wechatTips) && Intrinsics.areEqual(this.transferRecordUrl, qrcodeConfig.transferRecordUrl) && Intrinsics.areEqual(this.paycodeProtocol, qrcodeConfig.paycodeProtocol)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        ArrayList<TabbarItem> arrayList = this.tabbarList;
        int i3 = 0;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.tips;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.wechatTips;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.transferRecordUrl;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        PaycodeProtocol paycodeProtocol = this.paycodeProtocol;
        if (paycodeProtocol != null) {
            i3 = paycodeProtocol.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "QrcodeConfig(tabbarList=" + this.tabbarList + ", tips=" + this.tips + ", wechatTips=" + this.wechatTips + ", transferRecordUrl=" + this.transferRecordUrl + ", paycodeProtocol=" + this.paycodeProtocol + ")";
    }

    public QrcodeConfig(@Nullable ArrayList<TabbarItem> arrayList, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable PaycodeProtocol paycodeProtocol) {
        this.tabbarList = arrayList;
        this.tips = str;
        this.wechatTips = str2;
        this.transferRecordUrl = str3;
        this.paycodeProtocol = paycodeProtocol;
    }

    public /* synthetic */ QrcodeConfig(ArrayList arrayList, String str, String str2, String str3, PaycodeProtocol paycodeProtocol, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : arrayList, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) == 0 ? str3 : null, (i3 & 16) != 0 ? PaycodeProtocol.INSTANCE.a() : paycodeProtocol);
    }
}
