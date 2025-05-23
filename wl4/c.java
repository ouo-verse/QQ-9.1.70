package wl4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends pl4.a {
    public static NewIntent d(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechReq yoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechReq = new YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechReq();
        yoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechReq.room_id.set(j3);
        yoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechReq.user_id.set(commonOuterClass$QQUserId);
        return a.C11028a.a(yoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechReq, c.class);
    }

    @Override // pl4.a
    protected int b() {
        return 934;
    }
}
