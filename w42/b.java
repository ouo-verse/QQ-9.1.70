package w42;

import com.tencent.mobileqq.icgame.data.message.LiveMessageData;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements f {

    /* renamed from: d, reason: collision with root package name */
    public LiveMessageData.SpeakerInfo f444565d;

    /* renamed from: e, reason: collision with root package name */
    private i f444566e = new i();

    public b(LiveMessageData.SpeakerInfo speakerInfo) {
        this.f444565d = speakerInfo;
    }

    public String toString() {
        return "EnterRoomMsg{SpeakerName=" + this.f444565d.mSpeakerName + '}';
    }
}
