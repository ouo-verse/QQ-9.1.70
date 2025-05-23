package sz;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi.event.WSDramaVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.player.e;
import com.tencent.biz.pubaccount.weishi.util.x;
import kz.k;
import mz.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends a {
    private void G0(d dVar) {
        WSDramaVideoPlayEvent wSDramaVideoPlayEvent = new WSDramaVideoPlayEvent();
        wSDramaVideoPlayEvent.setDramaId(dVar.d());
        wSDramaVideoPlayEvent.setEpisodeNum(dVar.a());
        wSDramaVideoPlayEvent.setEpisodeId(dVar.f());
        wSDramaVideoPlayEvent.setDramaInfo(dVar.e());
        wSDramaVideoPlayEvent.setDramaPreviewPage(true);
        wz.b.b().a(wSDramaVideoPlayEvent);
        x.j("WSDramaForCommonPresenterLog", "[WSDramaForCommonPresenter.java][dispatchEventForDramaVideoPlay] event:" + wSDramaVideoPlayEvent);
    }

    private void H0(WSDramaVideoExposureEvent wSDramaVideoExposureEvent) {
        d dVar;
        stSimpleMetaFeed feedInfo = wSDramaVideoExposureEvent.getFeedInfo();
        pz.b A0 = A0();
        if (A0 != null && (dVar = A0.f428078f) != null) {
            dVar.n(feedInfo);
        }
        x.j("WSDramaForCommonPresenterLog", "[WSDramaForCommonPresenter.java][handleEventForDramaVideoExposure] event:" + wSDramaVideoExposureEvent);
    }

    private void I0(int i3) {
        d dVar;
        x.i("WSDramaForCommonPresenterLog", "reportDramaWatchRecord() scene = " + i3);
        pz.b A0 = A0();
        if (A0 == null || (dVar = A0.f428078f) == null) {
            return;
        }
        k.b(dVar.d(), dVar.f(), dVar.a(), (int) (z0().q().j0() / 1000));
    }

    private void J0() {
        d dVar;
        pz.b A0 = A0();
        if (A0 == null || (dVar = A0.f428078f) == null) {
            return;
        }
        G0(dVar);
    }

    @Override // sz.a, com.tencent.biz.pubaccount.weishi.drama.b
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        super.b(wSSimpleBaseEvent);
        if (wSSimpleBaseEvent instanceof WSDramaVideoExposureEvent) {
            H0((WSDramaVideoExposureEvent) wSSimpleBaseEvent);
        }
    }

    @Override // sz.a, com.tencent.biz.pubaccount.weishi.drama.b
    public void d(e eVar) {
        super.d(eVar);
        J0();
        I0(1);
    }

    @Override // sz.a, com.tencent.biz.pubaccount.weishi.drama.b
    public void doOnPause() {
        super.doOnPause();
        I0(3);
    }

    @Override // sz.a
    public boolean y0(boolean z16, boolean z17, String str) {
        com.tencent.biz.pubaccount.weishi.drama.c x06 = x0();
        if (x06 == null) {
            return false;
        }
        kz.c.d().c(x06.k0(), z16, z17, str, this);
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.b
    public void a(e eVar, boolean z16) {
        I0(2);
    }
}
