package yh3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&BM\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014\u00a8\u0006'"}, d2 = {"Lyh3/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "currentType", "I", "getCurrentType", "()I", "setCurrentType", "(I)V", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "msg", "getMsg", "setMsg", "needRetry", "getNeedRetry", "setNeedRetry", "luaId", "getLuaId", "setLuaId", "errorCode", "getErrorCode", "setErrorCode", "errorMsg", "getErrorMsg", "setErrorMsg", "<init>", "(ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yh3.f, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanLoadingErrorInfo {

    @SerializedName("CurrentType")
    private int currentType;

    @SerializedName("ErrorCode")
    private int errorCode;

    @SerializedName("ErrorMsg")
    @NotNull
    private String errorMsg;

    @SerializedName("LuaId")
    private int luaId;

    @SerializedName("Msg")
    @NotNull
    private String msg;

    @SerializedName("NeedRetry")
    private int needRetry;

    @SerializedName("Title")
    @NotNull
    private String title;

    public ZPlanLoadingErrorInfo() {
        this(0, null, null, 0, 0, 0, null, 127, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanLoadingErrorInfo)) {
            return false;
        }
        ZPlanLoadingErrorInfo zPlanLoadingErrorInfo = (ZPlanLoadingErrorInfo) other;
        if (this.currentType == zPlanLoadingErrorInfo.currentType && Intrinsics.areEqual(this.title, zPlanLoadingErrorInfo.title) && Intrinsics.areEqual(this.msg, zPlanLoadingErrorInfo.msg) && this.needRetry == zPlanLoadingErrorInfo.needRetry && this.luaId == zPlanLoadingErrorInfo.luaId && this.errorCode == zPlanLoadingErrorInfo.errorCode && Intrinsics.areEqual(this.errorMsg, zPlanLoadingErrorInfo.errorMsg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.currentType * 31) + this.title.hashCode()) * 31) + this.msg.hashCode()) * 31) + this.needRetry) * 31) + this.luaId) * 31) + this.errorCode) * 31) + this.errorMsg.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZPlanLoadingErrorInfo(currentType=" + this.currentType + ", title=" + this.title + ", msg=" + this.msg + ", needRetry=" + this.needRetry + ", luaId=" + this.luaId + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
    }

    public ZPlanLoadingErrorInfo(int i3, @NotNull String title, @NotNull String msg2, int i16, int i17, int i18, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.currentType = i3;
        this.title = title;
        this.msg = msg2;
        this.needRetry = i16;
        this.luaId = i17;
        this.errorCode = i18;
        this.errorMsg = errorMsg;
    }

    public /* synthetic */ ZPlanLoadingErrorInfo(int i3, String str, String str2, int i16, int i17, int i18, String str3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? "" : str, (i19 & 4) != 0 ? "" : str2, (i19 & 8) != 0 ? 0 : i16, (i19 & 16) != 0 ? 0 : i17, (i19 & 32) == 0 ? i18 : 0, (i19 & 64) != 0 ? "" : str3);
    }
}
