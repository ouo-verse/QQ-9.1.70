package vo2;

import androidx.lifecycle.MutableLiveData;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a {
    private final d D = new d();

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a
    public void T1(List<FeedCloudMeta$StFeed> list) {
        this.D.d2(list);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a
    public boolean U1(Object obj) {
        boolean U1 = super.U1(obj);
        if (U1) {
            this.D.f2();
        }
        return U1;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.D.getDisplaySurfaceData(objArr);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QCircleSearchUserViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        this.D.loadMoreForDisplaySurface(objArr);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a
    public void W1(String str) {
    }
}
