package qi;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.groupalbum.event.GroupAlbumFeedExposureEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends hh.b {
    private boolean C = true;
    private int D;

    /* renamed from: m, reason: collision with root package name */
    private int f428956m;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        int i3;
        int i16;
        int[] b16 = b();
        if (b16 == null || b16.length < 2 || (i3 = b16[1]) < (i16 = b16[0])) {
            return;
        }
        t(this.f404911e, i16, i3);
        this.f428956m = b16[1];
    }

    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "QZoneFeedReportScroller";
    }

    @Override // hh.b
    public void l(RecyclerView recyclerView, int i3, int i16, boolean z16, int i17, int i18, int i19, int i26) {
        super.l(recyclerView, i3, i16, z16, i17, i18, i19, i26);
        if (this.D == 0) {
            return;
        }
        int i27 = this.f428956m;
        if (i18 > i27) {
            t(recyclerView, i27 + 1, i18);
        }
        this.f428956m = i18;
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        super.m(recyclerView, i3, layoutManager, i16, i17, i18, i19, z16);
        this.D = i3;
    }

    @Override // hh.b
    public void onResume() {
        super.onResume();
        if (this.C) {
            this.C = false;
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: qi.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.s();
                }
            }, 300L);
        }
    }

    private void t(RecyclerView recyclerView, int i3, int i16) {
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        while (i3 <= i16) {
            View findViewByPosition = layoutManager.findViewByPosition(i3);
            if (findViewByPosition instanceof QZoneBaseFeedItemView) {
                QZoneBaseFeedItemView qZoneBaseFeedItemView = (QZoneBaseFeedItemView) findViewByPosition;
                BusinessFeedData data = qZoneBaseFeedItemView.getData();
                arrayList.add(data);
                QLog.i("QZoneFeedReportScroller", 1, "reportFeedExposure | i = " + i3 + " | pos = " + qZoneBaseFeedItemView.getDataPosInList() + " | feedKey = " + data.getFeedCommInfo().feedskey);
            }
            i3++;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumFeedExposureEvent(1, arrayList));
    }
}
