package t3;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import q3.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements AppBarLayout.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r3.a f435347a;

        a(r3.a aVar) {
            this.f435347a = aVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
            boolean z16;
            r3.a aVar = this.f435347a;
            boolean z17 = true;
            if (i3 >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (appBarLayout.p() + i3 > 0) {
                z17 = false;
            }
            aVar.c(z16, z17);
        }
    }

    public static void a(View view, e eVar, r3.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                eVar.getRefreshLayout().i(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).e(new a(aVar));
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
