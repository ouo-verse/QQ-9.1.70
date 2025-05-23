package yl2;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends b {

    /* renamed from: d, reason: collision with root package name */
    SegmentVideoInfo f450642d;

    @Override // yl2.b
    public void a() {
        if (c(this.f450642d) && this.f450630a != 0) {
            int i3 = this.f450632c;
            if (i3 == 0 || this.f450631b < i3) {
                int i16 = 0;
                for (Integer num : this.f450642d.getStreams().keySet()) {
                    if (num.intValue() < this.f450630a && num.intValue() > i16) {
                        i16 = num.intValue();
                    }
                }
                if (i16 == 0 || i16 <= 4) {
                    return;
                }
                this.f450630a = i16;
                this.f450631b++;
                PlayerUtils.log(4, "[VideoRate]", "decrease rate:" + this.f450630a);
            }
        }
    }

    @Override // yl2.b
    public void b() {
        if (c(this.f450642d)) {
            HashMap<Integer, SegmentVideoInfo.StreamInfo> streams = this.f450642d.getStreams();
            int i3 = this.f450630a;
            for (Integer num : streams.keySet()) {
                if (num.intValue() > i3) {
                    i3 = num.intValue();
                }
            }
            if (i3 == 0 || i3 <= 4) {
                return;
            }
            this.f450630a = i3;
            PlayerUtils.log(4, "[VideoRate]", "increase rate:" + this.f450630a);
        }
    }

    @Override // yl2.b
    public SegmentVideoInfo.StreamInfo d(SegmentVideoInfo segmentVideoInfo) {
        if (!c(segmentVideoInfo)) {
            return null;
        }
        if (this.f450631b > 0) {
            segmentVideoInfo.setMaxStreamRate(this.f450630a);
        }
        return segmentVideoInfo.getCurrentStreamInfo();
    }

    @Override // yl2.b
    public SegmentVideoInfo.StreamInfo e(SegmentVideoInfo segmentVideoInfo) {
        if (!c(segmentVideoInfo)) {
            return null;
        }
        this.f450642d = segmentVideoInfo;
        if (this.f450631b > 0) {
            segmentVideoInfo.setMaxStreamRate(this.f450630a);
        }
        this.f450630a = segmentVideoInfo.getCurrentStreamType();
        return this.f450642d.getCurrentStreamInfo();
    }

    @Override // yl2.b
    public void f(int i3) {
        this.f450632c = i3;
    }
}
