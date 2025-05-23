package t40;

import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface a extends b {
    List<e30.b> getFeedList();

    int getFeedPosition();

    Fragment getHostFragment();

    QCircleInitBean getInitBean();

    Drawable getTransitionLoadingDrawable();

    String getViewModelKey();

    boolean isContainerOnScreen();

    void triggerFeedReplace(e30.b bVar, int i3);
}
