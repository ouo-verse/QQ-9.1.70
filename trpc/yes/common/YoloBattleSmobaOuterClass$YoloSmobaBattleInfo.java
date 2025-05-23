package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaBattleInfo extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82, 90, 98, 106, 800, 810}, new String[]{"status", "smoba_config", "battle_entity", "team_info", AegisLogger.ROOM_INFO, "smoba_schema", "last_event_type", "last_event"}, new Object[]{1, null, null, null, null, null, 0, null}, YoloBattleSmobaOuterClass$YoloSmobaBattleInfo.class);
    public final PBEnumField status = PBField.initEnum(1);
    public YoloBattleSmobaOuterClass$YoloSmobaBattleConfig smoba_config = new YoloBattleSmobaOuterClass$YoloSmobaBattleConfig();
    public YoloBattleSmobaOuterClass$YoloSmobaBattleEntity battle_entity = new YoloBattleSmobaOuterClass$YoloSmobaBattleEntity();
    public SmobaDataOuterClass$YoloTeamInfo team_info = new SmobaDataOuterClass$YoloTeamInfo();
    public SmobaDataOuterClass$YoloBattleRoomInfo room_info = new SmobaDataOuterClass$YoloBattleRoomInfo();
    public YoloBattleSmobaOuterClass$YoloSmobaSchema smoba_schema = new YoloBattleSmobaOuterClass$YoloSmobaSchema();
    public final PBEnumField last_event_type = PBField.initEnum(0);
    public YoloBattleSmobaOuterClass$YoloOneSmobaBattleEvent last_event = new YoloBattleSmobaOuterClass$YoloOneSmobaBattleEvent();
}
