package qg4;

import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveMixUserConfig;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveTranscodingConfig;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private IQQLiveAnchorTRTCRoom f428908a;

    /* renamed from: b, reason: collision with root package name */
    private QQLiveTranscodingConfig.Builder f428909b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, QQLiveMixUserConfig> f428910c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private long f428911d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f428912e;

    public a(IQQLiveAnchorTRTCRoom iQQLiveAnchorTRTCRoom) {
        this.f428908a = iQQLiveAnchorTRTCRoom;
        this.f428911d = iQQLiveAnchorTRTCRoom.getAnchorInfo().getAnchorUid();
        TRTCVideoQualityParams videoQuality = iQQLiveAnchorTRTCRoom.getVideoQuality();
        int videoResolution = videoQuality.getVideoResolution();
        QQLiveTranscodingConfig.Builder builder = new QQLiveTranscodingConfig.Builder();
        this.f428909b = builder;
        builder.setMode(1);
        this.f428909b.setVideoWidth(d(videoResolution));
        this.f428909b.setVideoHeight(c(videoResolution));
        this.f428909b.setVideoFrameRate(videoQuality.getVideoFps());
        this.f428909b.setVideoBitrate(videoQuality.getVideoBitRate());
        this.f428909b.setAudioSampleRate(48000);
        this.f428909b.setAudioBitRate(64);
        this.f428909b.setAudioChannels(1);
        this.f428909b.setVideoGOP(2);
    }

    private int c(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return 480;
                    }
                    return 1920;
                }
                return 1280;
            }
            return 960;
        }
        return 640;
    }

    private int d(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return 270;
                    }
                    return 1080;
                }
                return 720;
            }
            return 540;
        }
        return 360;
    }

    private void h() {
        int i3;
        if (this.f428912e && !this.f428910c.isEmpty()) {
            TRTCVideoQualityParams videoQuality = this.f428908a.getVideoQuality();
            if (videoQuality != null) {
                i3 = videoQuality.getVideoResolution();
            } else {
                i3 = 3;
            }
            QQLiveMixUserConfig.Builder builder = new QQLiveMixUserConfig.Builder();
            builder.setUserId(this.f428911d + "");
            builder.setRoomId(null);
            builder.setX(0);
            builder.setY(0);
            builder.setWidth(d(i3));
            builder.setHeight(c(i3));
            ArrayList<QQLiveMixUserConfig> arrayList = new ArrayList<>();
            arrayList.add(builder.build());
            Iterator<Map.Entry<String, QQLiveMixUserConfig>> it = this.f428910c.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            this.f428909b.setMixUsers(arrayList);
            this.f428908a.openMixTranscoding(this.f428909b.build());
            return;
        }
        this.f428908a.closeMixTranscoding();
    }

    public void a(long j3, String str) {
        if (str.equals(((ll4.a) mm4.b.b(ll4.a.class)).B())) {
            return;
        }
        String str2 = j3 + "_" + str;
        if (!this.f428910c.containsKey(str2)) {
            this.f428910c.put(str2, new QQLiveMixUserConfig.Builder().setRoomId(j3 + "").setUserId(str).setPureAudio(true).build());
            h();
        }
    }

    public void b() {
        g();
        this.f428910c.clear();
    }

    public void e(long j3, String str) {
        String str2 = j3 + "_" + str;
        if (this.f428910c.containsKey(str2)) {
            this.f428910c.remove(str2);
            h();
        }
    }

    public void f(boolean z16) {
        this.f428912e = z16;
        h();
    }

    public void g() {
        this.f428908a.closeMixTranscoding();
    }
}
