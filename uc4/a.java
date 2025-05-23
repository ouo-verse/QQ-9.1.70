package uc4;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vc4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u000e\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0006B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b&\u0010'J\b\u0010\b\u001a\u00020\u0007H&J\u0017\u0010\n\u001a\u00028\u00022\u0006\u0010\t\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fJ\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0010H\u0016R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u001aj\b\u0012\u0004\u0012\u00028\u0001`\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR6\u0010%\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020 j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002`!8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Luc4/a;", "G", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "T", "Lvc4/h;", "P", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "g", "data", "d", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;)Lvc4/h;", "", "dataList", "", "f", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "getFm", "()Landroidx/fragment/app/FragmentManager;", "fm", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "mDataList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getMPagePool", "()Ljava/util/HashMap;", "mPagePool", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a<G, T extends BaseZPlanTabTitleData<G>, P extends h<G>> extends FragmentPagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FragmentManager fm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<T> mDataList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashMap<G, P> mPagePool;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FragmentManager fm5) {
        super(fm5, 1);
        Intrinsics.checkNotNullParameter(fm5, "fm");
        this.fm = fm5;
        this.mDataList = new ArrayList<>();
        this.mPagePool = new HashMap<>();
    }

    public abstract P d(T data);

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<T> e() {
        return this.mDataList;
    }

    public final void f(List<? extends T> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.mDataList.clear();
        this.mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public abstract String g();

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.mDataList.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        QLog.i(g(), 1, "getItem position:" + position);
        T t16 = this.mDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(t16, "mDataList[position]");
        T t17 = t16;
        P p16 = this.mPagePool.get(t17.getId());
        if (p16 == null) {
            p16 = d(t17);
        }
        Intrinsics.checkNotNullExpressionValue(p16, "mPagePool[data.id] ?: buildPage(data)");
        this.mPagePool.put(t17.getId(), p16);
        return p16.getFragment();
    }
}
