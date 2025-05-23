package yl;

import com.qzone.common.business.service.media.c;
import com.qzone.reborn.configx.g;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import cooperation.qzone.media.QZoneMediaBusiness;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends b {
    public static int o() {
        return g.f53821a.h().E();
    }

    @Override // yl.b, tl.a
    public int c() {
        return o();
    }

    @Override // yl.b, tl.a
    public QZoneMediaBusiness d() {
        return QZoneMediaBusiness.QZONE_INTIMATE_UPLOAD_ALBUM;
    }

    @Override // yl.b, tl.a
    public void l(c cVar, DynamicGridView dynamicGridView) {
        fo.c.b("dt_clck", dynamicGridView, "em_qz_upload_pictures_videos", null);
    }
}
