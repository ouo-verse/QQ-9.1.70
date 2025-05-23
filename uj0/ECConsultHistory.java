package uj0;

import com.tencent.ecommerce.biz.commission.forecast.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\t\u0010\u001d\u00a8\u0006!"}, d2 = {"Luj0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "status", "b", "roleType", "c", "Ljava/lang/String;", "title", "d", "picUrl", "", "e", "J", "time", "f", "content", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "g", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "imgs", "<init>", "(IILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/ArrayList;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: uj0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECConsultHistory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int roleType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String picUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final long time;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String content;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<String> imgs;

    public ECConsultHistory(int i3, int i16, String str, String str2, long j3, String str3, ArrayList<String> arrayList) {
        this.status = i3;
        this.roleType = i16;
        this.title = str;
        this.picUrl = str2;
        this.time = j3;
        this.content = str3;
        this.imgs = arrayList;
    }

    public final ArrayList<String> a() {
        return this.imgs;
    }

    public int hashCode() {
        int i3 = ((this.status * 31) + this.roleType) * 31;
        String str = this.title;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.picUrl;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + b.a(this.time)) * 31;
        String str3 = this.content;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ArrayList<String> arrayList = this.imgs;
        return hashCode3 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public String toString() {
        return "ECConsultHistory(status=" + this.status + ", roleType=" + this.roleType + ", title=" + this.title + ", picUrl=" + this.picUrl + ", time=" + this.time + ", content=" + this.content + ", imgs=" + this.imgs + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECConsultHistory)) {
            return false;
        }
        ECConsultHistory eCConsultHistory = (ECConsultHistory) other;
        return this.status == eCConsultHistory.status && this.roleType == eCConsultHistory.roleType && Intrinsics.areEqual(this.title, eCConsultHistory.title) && Intrinsics.areEqual(this.picUrl, eCConsultHistory.picUrl) && this.time == eCConsultHistory.time && Intrinsics.areEqual(this.content, eCConsultHistory.content) && Intrinsics.areEqual(this.imgs, eCConsultHistory.imgs);
    }
}
