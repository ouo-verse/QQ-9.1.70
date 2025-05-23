package qp2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f\u00a8\u0006*"}, d2 = {"Lqp2/e;", "", "", "c", "", "toString", "", "hashCode", "other", "equals", "query", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "searchId", "b", h.F, "parentSearchId", "getParentSearchId", "e", "scene", "I", "getScene", "()I", "g", "(I)V", "reqBusinessType", "getReqBusinessType", "setReqBusinessType", "businessType", "getBusinessType", "setBusinessType", "actionType", "getActionType", "d", "sessionId", "getSessionId", "i", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;)V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qp2.e, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SearchActionReportParam {

    @SerializedName("actionType")
    private int actionType;

    @SerializedName("businessType")
    private int businessType;

    @SerializedName("parentSearchId")
    @NotNull
    private String parentSearchId;

    @SerializedName("query")
    @NotNull
    private String query;

    @SerializedName("reqBusinessType")
    private int reqBusinessType;

    @SerializedName("scene")
    private int scene;

    @SerializedName("searchId")
    @NotNull
    private String searchId;

    @SerializedName("sessionId")
    @NotNull
    private String sessionId;

    public SearchActionReportParam() {
        this(null, null, null, 0, 0, 0, 0, null, 255, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSearchId() {
        return this.searchId;
    }

    public final boolean c() {
        if (this.searchId.length() > 0) {
            return true;
        }
        return false;
    }

    public final void d(int i3) {
        this.actionType = i3;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parentSearchId = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchActionReportParam)) {
            return false;
        }
        SearchActionReportParam searchActionReportParam = (SearchActionReportParam) other;
        if (Intrinsics.areEqual(this.query, searchActionReportParam.query) && Intrinsics.areEqual(this.searchId, searchActionReportParam.searchId) && Intrinsics.areEqual(this.parentSearchId, searchActionReportParam.parentSearchId) && this.scene == searchActionReportParam.scene && this.reqBusinessType == searchActionReportParam.reqBusinessType && this.businessType == searchActionReportParam.businessType && this.actionType == searchActionReportParam.actionType && Intrinsics.areEqual(this.sessionId, searchActionReportParam.sessionId)) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.query = str;
    }

    public final void g(int i3) {
        this.scene = i3;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchId = str;
    }

    public int hashCode() {
        return (((((((((((((this.query.hashCode() * 31) + this.searchId.hashCode()) * 31) + this.parentSearchId.hashCode()) * 31) + this.scene) * 31) + this.reqBusinessType) * 31) + this.businessType) * 31) + this.actionType) * 31) + this.sessionId.hashCode();
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    @NotNull
    public String toString() {
        return "SearchActionReportParam(query=" + this.query + ", searchId=" + this.searchId + ", parentSearchId=" + this.parentSearchId + ", scene=" + this.scene + ", reqBusinessType=" + this.reqBusinessType + ", businessType=" + this.businessType + ", actionType=" + this.actionType + ", sessionId=" + this.sessionId + ')';
    }

    public SearchActionReportParam(@NotNull String query, @NotNull String searchId, @NotNull String parentSearchId, int i3, int i16, int i17, int i18, @NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(parentSearchId, "parentSearchId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.query = query;
        this.searchId = searchId;
        this.parentSearchId = parentSearchId;
        this.scene = i3;
        this.reqBusinessType = i16;
        this.businessType = i17;
        this.actionType = i18;
        this.sessionId = sessionId;
    }

    public /* synthetic */ SearchActionReportParam(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? "" : str, (i19 & 2) != 0 ? "" : str2, (i19 & 4) != 0 ? "" : str3, (i19 & 8) != 0 ? -1 : i3, (i19 & 16) != 0 ? 64 : i16, (i19 & 32) != 0 ? 9999 : i17, (i19 & 64) == 0 ? i18 : -1, (i19 & 128) == 0 ? str4 : "");
    }
}
