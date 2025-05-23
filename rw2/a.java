package rw2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends e {

    /* renamed from: h, reason: collision with root package name */
    private f f432632h;

    public a(AdOrderItem adOrderItem) {
        super(adOrderItem);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.QAdVRPlayReporter, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.d
    public void a(f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.f304100a == 9 && fVar != this.f432632h) {
            n.e("QAdImmersivePlayerEventReporter", "onUpdatePlayState:" + fVar.f304100a);
            this.f432632h = fVar;
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.QAdVRPlayReporter, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.d
    public void b(f fVar) {
        if (this.f432632h != null && fVar != null) {
            n.e("QAdImmersivePlayerEventReporter", "onUpdatePlayProgress:" + fVar.f304101b);
            f fVar2 = this.f432632h;
            fVar2.f304101b = fVar.f304101b;
            a(fVar2);
            this.f432632h = null;
        }
    }
}
