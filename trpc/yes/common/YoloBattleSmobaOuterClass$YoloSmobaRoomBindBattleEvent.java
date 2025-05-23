package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaRoomBindBattleEvent extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaRoomBindBattleEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{AudienceReportConst.ROOM_ID, "room_entity"}, new Object[]{null, null}, YoloBattleSmobaOuterClass$YoloSmobaRoomBindBattleEvent.class);
    public SmobaDataOuterClass$RoomID room_id = new SmobaDataOuterClass$RoomID();
    public YoloBattleSmobaOuterClass$YoloSmobaBattleEntity room_entity = new YoloBattleSmobaOuterClass$YoloSmobaBattleEntity();
}
