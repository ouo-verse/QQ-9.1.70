package y72;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR'\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ly72/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "matchGender", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "pickIds", "<init>", "(ILjava/util/ArrayList;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final /* data */ class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int matchGender;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Integer> pickIds;

    public g(int i3, ArrayList<Integer> pickIds) {
        Intrinsics.checkNotNullParameter(pickIds, "pickIds");
        this.matchGender = i3;
        this.pickIds = pickIds;
    }

    /* renamed from: a, reason: from getter */
    public final int getMatchGender() {
        return this.matchGender;
    }

    public final ArrayList<Integer> b() {
        return this.pickIds;
    }

    public int hashCode() {
        return (this.matchGender * 31) + this.pickIds.hashCode();
    }

    public String toString() {
        String str = "[QQStrangerMatchSettingModel]gender=" + this.matchGender + ",pickIds=[";
        Iterator<T> it = this.pickIds.iterator();
        while (it.hasNext()) {
            str = ((Object) str) + ((Number) it.next()).intValue() + ",";
        }
        return ((Object) str) + "]";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        return this.matchGender == gVar.matchGender && Intrinsics.areEqual(this.pickIds, gVar.pickIds);
    }
}
