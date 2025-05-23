package yl;

import com.qzone.common.business.service.media.c;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import cooperation.qzone.media.QZoneMediaBusiness;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends tl.a {
    @Override // tl.a
    public int c() {
        return 9;
    }

    @Override // tl.a
    public QZoneMediaBusiness d() {
        return QZoneMediaBusiness.QZONE_PUBLISH_INTIMATE_MOOD;
    }

    @Override // tl.a
    public boolean i() {
        return true;
    }

    @Override // tl.a
    public void l(c cVar, DynamicGridView dynamicGridView) {
        RFWLog.d("QZoneIntimateSelectPhotoParams", RFWLog.USR, "reportSelectPhotoClk");
        fo.c.b("dt_clck", dynamicGridView, "em_qz_add_video_pictures", null);
    }

    @Override // tl.a
    public void j(int i3) {
    }

    @Override // tl.a
    public void k(int i3) {
    }
}
