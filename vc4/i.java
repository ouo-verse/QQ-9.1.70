package vc4;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.List;
import kotlin.Metadata;
import vc4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\b\b\u0002\u0010\u0005*\u00020\u00042\u00020\u0006J \u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0014"}, d2 = {"Lvc4/i;", "T", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "D", "Lvc4/l;", "L", "", "", "titleList", "", "selectedPos", "", "setTitleData", "pageIndex", "a", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "b", "Landroid/view/View;", "getView", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface i<T, D extends BaseZPlanTabTitleData<T>, L extends l> {
    void a(int pageIndex);

    void b(ViewPager viewPager);

    View getView();

    void setTitleData(List<? extends D> titleList, int selectedPos);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public static final class a {
        public static /* synthetic */ void a(i iVar, List list, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                iVar.setTitleData(list, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitleData");
        }
    }
}
