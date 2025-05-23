package wc3;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\fB)\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\f\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lwc3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lwc3/c;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "localUgcPaths", "Lwc3/b;", "Lwc3/b;", "()Lwc3/b;", "extraReportParams", "<init>", "(Ljava/util/ArrayList;Lwc3/b;)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wc3.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class AigcPreviewParams {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<LocalUgcPath> localUgcPaths;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ExtraReportParams extraReportParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lwc3/a$a;", "", "", "localUgcTexturePath", "Luv4/az;", "storeItem", "Lwc3/b;", "extraReportParams", "Lwc3/a;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wc3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AigcPreviewParams a(String localUgcTexturePath, az storeItem, ExtraReportParams extraReportParams) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(localUgcTexturePath, "localUgcTexturePath");
            Intrinsics.checkNotNullParameter(storeItem, "storeItem");
            Intrinsics.checkNotNullParameter(extraReportParams, "extraReportParams");
            if (new File(localUgcTexturePath).isDirectory()) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new LocalUgcPath(localUgcTexturePath, storeItem));
                return new AigcPreviewParams(arrayListOf, extraReportParams);
            }
            QLog.e("AigcPreviewParams", 1, "build localUgcTexturePath not exists " + localUgcTexturePath);
            return null;
        }

        Companion() {
        }
    }

    public AigcPreviewParams(ArrayList<LocalUgcPath> localUgcPaths, ExtraReportParams extraReportParams) {
        Intrinsics.checkNotNullParameter(localUgcPaths, "localUgcPaths");
        Intrinsics.checkNotNullParameter(extraReportParams, "extraReportParams");
        this.localUgcPaths = localUgcPaths;
        this.extraReportParams = extraReportParams;
    }

    /* renamed from: a, reason: from getter */
    public final ExtraReportParams getExtraReportParams() {
        return this.extraReportParams;
    }

    public final ArrayList<LocalUgcPath> b() {
        return this.localUgcPaths;
    }

    public int hashCode() {
        return (this.localUgcPaths.hashCode() * 31) + this.extraReportParams.hashCode();
    }

    public String toString() {
        return "AigcPreviewParams(localUgcPaths=" + this.localUgcPaths + ", extraReportParams=" + this.extraReportParams + ")";
    }

    public /* synthetic */ AigcPreviewParams(ArrayList arrayList, ExtraReportParams extraReportParams, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : arrayList, extraReportParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AigcPreviewParams)) {
            return false;
        }
        AigcPreviewParams aigcPreviewParams = (AigcPreviewParams) other;
        return Intrinsics.areEqual(this.localUgcPaths, aigcPreviewParams.localUgcPaths) && Intrinsics.areEqual(this.extraReportParams, aigcPreviewParams.extraReportParams);
    }
}
