package qk2;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tenpay.sdk.Cgi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B+\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lqk2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "errorDialogFinishList", "Ljava/util/List;", "c", "()Ljava/util/List;", "errorToastFinishList", "d", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "a", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class CgiErrorFinishConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<String> f429002b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<String> f429003c;

    @SerializedName("error_dialog_finish_list")
    @Nullable
    private final List<String> errorDialogFinishList;

    @SerializedName("error_toast_finish_list")
    @Nullable
    private final List<String> errorToastFinishList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007R\"\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00030\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00030\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lqk2/b$a;", "", "", "", "a", "b", "kotlin.jvm.PlatformType", "DEFAULT_DIALOG_LIST", "Ljava/util/List;", "DEFAULT_TOAST_LIST", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final List<String> a() {
            List<String> c16 = ((CgiErrorFinishConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_ERROR_FINISH_CGI_LIST, new CgiErrorFinishConfig(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0))).c();
            if (c16 == null) {
                return CgiErrorFinishConfig.f429002b;
            }
            return c16;
        }

        @JvmStatic
        @NotNull
        public final List<String> b() {
            List<String> d16 = ((CgiErrorFinishConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_ERROR_FINISH_CGI_LIST, new CgiErrorFinishConfig(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0))).d();
            if (d16 == null) {
                return CgiErrorFinishConfig.f429003c;
            }
            return d16;
        }

        Companion() {
        }
    }

    static {
        List<String> listOf;
        List<String> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Cgi.URI_PAY_GATE, Cgi.URI_QUERY_USER, Cgi.URI_HB_NA_MCH_GRAP, Cgi.URI_HB_NA_PRE_GRAP, Cgi.URI_MINORREG_QUERY, Cgi.URI_HB_NA_QR_GRAP});
        f429002b = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Cgi.URI_PAY_GATE, Cgi.URI_QUERY_USER, Cgi.URI_HB_NA_MCH_GRAP, Cgi.URI_HB_NA_PRE_GRAP, Cgi.URI_MINORREG_QUERY, Cgi.URI_HB_NA_QR_GRAP});
        f429003c = listOf2;
    }

    public CgiErrorFinishConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @JvmStatic
    @NotNull
    public static final List<String> e() {
        return INSTANCE.a();
    }

    @JvmStatic
    @NotNull
    public static final List<String> f() {
        return INSTANCE.b();
    }

    @Nullable
    public final List<String> c() {
        return this.errorDialogFinishList;
    }

    @Nullable
    public final List<String> d() {
        return this.errorToastFinishList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CgiErrorFinishConfig)) {
            return false;
        }
        CgiErrorFinishConfig cgiErrorFinishConfig = (CgiErrorFinishConfig) other;
        if (Intrinsics.areEqual(this.errorDialogFinishList, cgiErrorFinishConfig.errorDialogFinishList) && Intrinsics.areEqual(this.errorToastFinishList, cgiErrorFinishConfig.errorToastFinishList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        List<String> list = this.errorDialogFinishList;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i16 = hashCode * 31;
        List<String> list2 = this.errorToastFinishList;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "CgiErrorFinishConfig(errorDialogFinishList=" + this.errorDialogFinishList + ", errorToastFinishList=" + this.errorToastFinishList + ')';
    }

    public CgiErrorFinishConfig(@Nullable List<String> list, @Nullable List<String> list2) {
        this.errorDialogFinishList = list;
        this.errorToastFinishList = list2;
    }

    public /* synthetic */ CgiErrorFinishConfig(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list, (i3 & 2) != 0 ? null : list2);
    }
}
