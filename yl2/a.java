package yl2;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends d {

    /* renamed from: f, reason: collision with root package name */
    private static final String f450628f = "a";

    /* renamed from: e, reason: collision with root package name */
    private int f450629e;

    public a(int i3) {
        this.f450629e = i3;
    }

    private boolean g() {
        PlayerUtils.log(4, f450628f, "isLowSpeedNetwork nettype=" + this.f450629e);
        int i3 = this.f450629e;
        if (i3 == 4) {
            return false;
        }
        return i3 == 2 || i3 == 3;
    }

    private SegmentVideoInfo.StreamInfo h(SegmentVideoInfo segmentVideoInfo) {
        if (!c(segmentVideoInfo)) {
            return null;
        }
        this.f450642d = segmentVideoInfo;
        HashMap<Integer, SegmentVideoInfo.StreamInfo> streams = segmentVideoInfo.getStreams();
        Set<Integer> keySet = streams.keySet();
        String str = f450628f;
        PlayerUtils.log(4, str, "obtainLoStreamInfo rateList=" + Arrays.toString(keySet.toArray(new Integer[0])));
        ArrayList arrayList = new ArrayList(keySet);
        Collections.sort(arrayList);
        if (arrayList.size() > 0) {
            int intValue = ((Integer) arrayList.get(0)).intValue();
            PlayerUtils.log(4, str, "obtainLoStreamInfo rate=" + intValue);
            return this.f450642d.getStreamInfo(intValue);
        }
        if (keySet.contains(2)) {
            return streams.get(2);
        }
        if (keySet.contains(0)) {
            return streams.get(0);
        }
        if (keySet.contains(4)) {
            return streams.get(4);
        }
        return this.f450642d.getCurrentStreamInfo();
    }

    @Override // yl2.d, yl2.b
    public void a() {
        super.a();
    }

    @Override // yl2.d, yl2.b
    public void b() {
        if (g()) {
            return;
        }
        super.b();
    }

    @Override // yl2.d, yl2.b
    public SegmentVideoInfo.StreamInfo d(SegmentVideoInfo segmentVideoInfo) {
        return super.d(segmentVideoInfo);
    }

    @Override // yl2.d, yl2.b
    public SegmentVideoInfo.StreamInfo e(SegmentVideoInfo segmentVideoInfo) {
        if (g()) {
            return h(segmentVideoInfo);
        }
        return super.e(segmentVideoInfo);
    }

    @Override // yl2.d, yl2.b
    public void f(int i3) {
        super.f(i3);
    }

    public void i(int i3) {
        this.f450629e = i3;
    }
}
