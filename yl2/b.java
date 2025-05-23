package yl2;

import com.tencent.oskplayer.model.SegmentVideoInfo;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    int f450630a;

    /* renamed from: b, reason: collision with root package name */
    int f450631b;

    /* renamed from: c, reason: collision with root package name */
    int f450632c;

    public abstract void a();

    public abstract void b();

    public abstract SegmentVideoInfo.StreamInfo d(SegmentVideoInfo segmentVideoInfo);

    public abstract SegmentVideoInfo.StreamInfo e(SegmentVideoInfo segmentVideoInfo);

    public abstract void f(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(SegmentVideoInfo segmentVideoInfo) {
        return (segmentVideoInfo == null || segmentVideoInfo.getStreams() == null || segmentVideoInfo.getStreams().size() == 0) ? false : true;
    }
}
