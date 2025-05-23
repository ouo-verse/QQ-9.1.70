package sj0;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lsj0/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "title", "b", "key", "", "Lsj0/b;", "c", "Ljava/util/List;", "()Ljava/util/List;", "options", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: sj0.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECFilterOptionModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String key;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ECFilterOptionItem> options;

    public ECFilterOptionModel(String str, String str2, List<ECFilterOptionItem> list) {
        this.title = str;
        this.key = str2;
        this.options = list;
    }

    public final List<ECFilterOptionItem> a() {
        return this.options;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ECFilterOptionItem> list = this.options;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ECFilterOptionModel(title=" + this.title + ", key=" + this.key + ", options=" + this.options + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECFilterOptionModel)) {
            return false;
        }
        ECFilterOptionModel eCFilterOptionModel = (ECFilterOptionModel) other;
        return Intrinsics.areEqual(this.title, eCFilterOptionModel.title) && Intrinsics.areEqual(this.key, eCFilterOptionModel.key) && Intrinsics.areEqual(this.options, eCFilterOptionModel.options);
    }
}
