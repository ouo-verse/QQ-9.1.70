package w42;

import com.tencent.mobileqq.icgame.data.message.LiveMessageData;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k implements f {

    /* renamed from: d, reason: collision with root package name */
    public LiveMessageData.SpeakerInfo f444579d;

    /* renamed from: e, reason: collision with root package name */
    private i f444580e = new i();

    public k(LiveMessageData.SpeakerInfo speakerInfo) {
        this.f444579d = speakerInfo;
    }

    public String toString() {
        return "ShareMsg{SpeakerName=" + this.f444579d.mSpeakerName + '}';
    }
}
