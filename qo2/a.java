package qo2;

import android.view.ViewGroup;
import com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView;
import com.tencent.mobileqq.search.business.qcircle.video.common.QCircleSearchCommonVideoItemView;
import com.tencent.widget.HorizontalListView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends no2.a {
    public a(HorizontalListView horizontalListView, mo2.a aVar, com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a aVar2, com.tencent.mobileqq.search.business.qcircle.video.base.a aVar3) {
        super(horizontalListView, aVar, aVar2, aVar3);
    }

    @Override // no2.a
    protected QCircleSearchDoubleVideoItemView c(ViewGroup viewGroup) {
        return new QCircleSearchCommonVideoItemView(viewGroup.getContext());
    }
}
