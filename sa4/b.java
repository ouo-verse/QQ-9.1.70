package sa4;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.portal.home.banner.Banner;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends LinearLayoutManager {

    /* renamed from: d, reason: collision with root package name */
    private final Banner f433599d;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForDeceleration(int i3) {
            return b.this.f433599d.getMScrollTime();
        }
    }

    public b(Banner banner, LinearLayoutManager linearLayoutManager) {
        super(banner.getContext(), linearLayoutManager.getOrientation(), false);
        this.f433599d = banner;
    }

    public static void r(Banner banner) {
        if (banner.getMScrollTime() < 100) {
            return;
        }
        try {
            ViewPager2 E = banner.E();
            RecyclerView recyclerView = (RecyclerView) E.getChildAt(0);
            recyclerView.setOverScrollMode(2);
            b bVar = new b(banner, (LinearLayoutManager) recyclerView.getLayoutManager());
            recyclerView.setLayoutManager(bVar);
            Field declaredField = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField.setAccessible(true);
            declaredField.set(E, bVar);
            Field declaredField2 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(E);
            if (obj != null) {
                Field declaredField3 = obj.getClass().getDeclaredField("mLayoutManager");
                declaredField3.setAccessible(true);
                declaredField3.set(obj, bVar);
            }
            Field declaredField4 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
            declaredField4.setAccessible(true);
            Object obj2 = declaredField4.get(E);
            if (obj2 != null) {
                Field declaredField5 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField5.setAccessible(true);
                declaredField5.set(obj2, bVar);
            }
        } catch (Exception e16) {
            QLog.e("ScrollSpeedManger", 1, e16, new Object[0]);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i3);
        startSmoothScroll(aVar);
    }
}
