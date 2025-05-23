package r50;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends RFWLayerBaseScroller {

    /* renamed from: a, reason: collision with root package name */
    private int f430753a;

    public int d() {
        return this.f430753a;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller
    public void onSelected(RFWFeedSelectInfo rFWFeedSelectInfo, RecyclerView.ViewHolder viewHolder) {
        super.onSelected(rFWFeedSelectInfo, viewHolder);
        this.f430753a = rFWFeedSelectInfo.getPosition();
    }
}
