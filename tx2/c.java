package tx2;

import com.tencent.mobileqq.tvideo.danmaku.manager.l;
import com.tencent.oskplayer.contrib.ImageHashError;
import com.tencent.rfw.barrage.data.RFWViewBarrage;
import tz3.i;
import vz3.f;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends RFWViewBarrage {
    private int M;

    public c(i iVar) {
        super(iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.rfw.barrage.data.d
    public float C0(long j3) {
        return super.C0(j3) + cy2.b.e().d();
    }

    @Override // com.tencent.rfw.barrage.data.a
    public int E() {
        return l.d().getHeight();
    }

    @Override // com.tencent.rfw.barrage.data.d
    public void E0(float f16) {
        super.E0(f16 * ((this.M * 0.2f) + 1.1f));
    }

    @Override // com.tencent.rfw.barrage.data.a
    public int F() {
        return l.g();
    }

    @Override // com.tencent.rfw.barrage.data.RFWViewBarrage, com.tencent.rfw.barrage.data.a
    public int J() {
        return ImageHashError.ERROR_DECODE_FLOW;
    }

    public void M0() {
        f fVar = this.f365063d;
        if (fVar != null) {
            fVar.b();
        }
    }

    public void N0(int i3) {
        this.M = i3;
        E0((F() + this.f365068i) / ((float) this.f365063d.d()));
    }

    @Override // com.tencent.rfw.barrage.data.d, com.tencent.rfw.barrage.data.a
    public void b() {
        super.b();
        E0((F() + this.f365068i) / ((float) this.f365063d.d()));
    }
}
