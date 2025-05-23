package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaTeamBindBattleEvent extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaTeamBindBattleEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"team_id", "team_entity"}, new Object[]{null, null}, YoloBattleSmobaOuterClass$YoloSmobaTeamBindBattleEvent.class);
    public SmobaDataOuterClass$YoloTeamID team_id = new SmobaDataOuterClass$YoloTeamID();
    public YoloBattleSmobaOuterClass$YoloSmobaBattleEntity team_entity = new YoloBattleSmobaOuterClass$YoloSmobaBattleEntity();
}
