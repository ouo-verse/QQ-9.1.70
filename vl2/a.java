package vl2;

import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static a f441828d;

    /* renamed from: a, reason: collision with root package name */
    PlayerConfig f441829a;

    /* renamed from: b, reason: collision with root package name */
    private int f441830b = -1;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<Integer, SegmentVideoInfo.StreamInfo> f441831c = null;

    public a(PlayerConfig playerConfig) {
        this.f441829a = playerConfig;
    }

    public static a a() {
        if (f441828d == null) {
            synchronized (a.class) {
                if (f441828d == null) {
                    f441828d = new a(PlayerConfig.g());
                }
            }
        }
        return f441828d;
    }

    public synchronized Map<Integer, SegmentVideoInfo.StreamInfo> b() {
        return this.f441831c;
    }

    public void c(int i3) {
        this.f441830b = i3;
    }
}
