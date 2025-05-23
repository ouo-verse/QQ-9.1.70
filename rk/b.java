package rk;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b\u00a8\u0006\""}, d2 = {"Lrk/b;", "Lrk/a;", "", "i", "I", "r", "()I", "v", "(I)V", "maxSelectCount", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "j", "Ljava/util/ArrayList;", "t", "()Ljava/util/ArrayList;", "y", "(Ljava/util/ArrayList;)V", "selectedPics", "", "k", "Z", "u", "()Z", "w", "(Z)V", "isNumberCheckBox", "l", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "pageMode", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int maxSelectCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isNumberCheckBox;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ArrayList<String> selectedPics = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int pageMode = 1;

    /* renamed from: r, reason: from getter */
    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    /* renamed from: s, reason: from getter */
    public final int getPageMode() {
        return this.pageMode;
    }

    public final ArrayList<String> t() {
        return this.selectedPics;
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsNumberCheckBox() {
        return this.isNumberCheckBox;
    }

    public final void v(int i3) {
        this.maxSelectCount = i3;
    }

    public final void w(boolean z16) {
        this.isNumberCheckBox = z16;
    }

    public final void x(int i3) {
        this.pageMode = i3;
    }

    public final void y(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selectedPics = arrayList;
    }
}
