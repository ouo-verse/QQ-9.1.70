package t30;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends t30.a {
    private final String D;
    private final a E;
    private b F;
    private com.tencent.biz.qqcircle.bizparts.a<e30.b> G;
    private int H;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        int a();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(UIStateData<List<e30.b>> uIStateData);
    }

    public f(String str, a aVar, MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData) {
        this.D = str;
        this.E = aVar;
        N1(mutableLiveData);
    }

    public static a S1(final RecyclerView recyclerView) {
        return new a() { // from class: t30.e
            @Override // t30.f.a
            public final int a() {
                int W1;
                W1 = f.W1(RecyclerView.this);
                return W1;
            }
        };
    }

    public static a T1(final ViewPager2 viewPager2) {
        return new a() { // from class: t30.d
            @Override // t30.f.a
            public final int a() {
                int X1;
                X1 = f.X1(ViewPager2.this);
                return X1;
            }
        };
    }

    public static a U1(final com.tencent.biz.qqcircle.bizparts.a aVar) {
        return new a() { // from class: t30.c
            @Override // t30.f.a
            public final int a() {
                int Z1;
                Z1 = f.Z1(com.tencent.biz.qqcircle.bizparts.a.this);
                return Z1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int W1(RecyclerView recyclerView) {
        View childAt;
        if (recyclerView == null || (childAt = recyclerView.getChildAt(0)) == null) {
            return 0;
        }
        return recyclerView.getChildAdapterPosition(childAt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int X1(ViewPager2 viewPager2) {
        if (viewPager2 != null) {
            return viewPager2.getCurrentItem();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Z1(com.tencent.biz.qqcircle.bizparts.a aVar) {
        RecyclerView recyclerView;
        View childAt;
        if (aVar == null || (recyclerView = aVar.getRecyclerView()) == null || (childAt = recyclerView.getChildAt(0)) == null) {
            return 0;
        }
        return recyclerView.getChildAdapterPosition(childAt);
    }

    @Override // t30.b
    public int J() {
        a aVar = this.E;
        if (aVar != null) {
            return aVar.a();
        }
        return -1;
    }

    @Override // t30.a
    public int L1() {
        return this.H;
    }

    @Override // t30.a, t30.b
    public void U0(@NonNull List<e30.b> list) {
        if (this.G != null) {
            UIStateData<List<e30.b>> dataList = UIStateData.obtainModify().setLoadMore(false).setDataList(list);
            b bVar = this.F;
            if (bVar != null) {
                bVar.a(dataList);
                return;
            }
            return;
        }
        super.U0(list);
    }

    public void a2(int i3) {
        this.H = i3;
    }

    @Override // t30.a, t30.b
    public List<e30.b> getFeedList() {
        com.tencent.biz.qqcircle.bizparts.a<e30.b> aVar = this.G;
        if (aVar != null) {
            List<e30.b> dataList = aVar.getDataList();
            if (dataList == null) {
                dataList = new ArrayList<>();
            }
            return new ArrayList(dataList);
        }
        return super.getFeedList();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return this.D;
    }

    public f(String str, com.tencent.biz.qqcircle.bizparts.a<e30.b> aVar, b bVar) {
        this.D = str;
        this.G = aVar;
        this.F = bVar;
        this.E = U1(aVar);
    }
}
