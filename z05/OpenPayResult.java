package z05;

import com.google.gson.annotations.SerializedName;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lz05/b;", "", "", "toString", "", "hashCode", "other", "", "equals", QzoneIPCModule.RESULT_CODE, "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setResultCode", "(Ljava/lang/Integer;)V", "resultMsg", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setResultMsg", "(Ljava/lang/String;)V", "Lz05/c;", "rspData", "Lz05/c;", "c", "()Lz05/c;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lz05/c;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: z05.b, reason: from toString */
/* loaded from: classes28.dex */
public final /* data */ class OpenPayResult {

    @SerializedName(QzoneIPCModule.RESULT_CODE)
    @Nullable
    private Integer resultCode;

    @SerializedName("retmsg")
    @Nullable
    private String resultMsg;

    @SerializedName("data")
    @Nullable
    private final c rspData;

    public OpenPayResult(@Nullable Integer num, @Nullable String str, @Nullable c cVar) {
        this.resultCode = num;
        this.resultMsg = str;
        this.rspData = cVar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getResultCode() {
        return this.resultCode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getResultMsg() {
        return this.resultMsg;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final c getRspData() {
        return this.rspData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenPayResult)) {
            return false;
        }
        OpenPayResult openPayResult = (OpenPayResult) other;
        if (Intrinsics.areEqual(this.resultCode, openPayResult.resultCode) && Intrinsics.areEqual(this.resultMsg, openPayResult.resultMsg) && Intrinsics.areEqual(this.rspData, openPayResult.rspData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Integer num = this.resultCode;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.resultMsg;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        c cVar = this.rspData;
        if (cVar != null) {
            i3 = cVar.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "OpenPayResult(resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", rspData=" + this.rspData + ")";
    }

    public /* synthetic */ OpenPayResult(Integer num, String str, c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -11001 : num, str, (i3 & 4) != 0 ? null : cVar);
    }
}
