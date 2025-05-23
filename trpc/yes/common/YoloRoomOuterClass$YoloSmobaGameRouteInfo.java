package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloSmobaGameRouteInfo extends MessageMicro<YoloRoomOuterClass$YoloSmobaGameRouteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 834}, new String[]{"base_info", "smoba_schema", "create_type", "team_info", "battle_room_info", "battle_entity", "battle_begin_event_info"}, new Object[]{null, null, 0, null, null, null, null}, YoloRoomOuterClass$YoloSmobaGameRouteInfo.class);
    public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
    public YoloBattleSmobaOuterClass$YoloSmobaSchema smoba_schema = new YoloBattleSmobaOuterClass$YoloSmobaSchema();
    public final PBInt32Field create_type = PBField.initInt32(0);
    public SmobaDataOuterClass$YoloTeamInfo team_info = new SmobaDataOuterClass$YoloTeamInfo();
    public SmobaDataOuterClass$YoloBattleRoomInfo battle_room_info = new SmobaDataOuterClass$YoloBattleRoomInfo();
    public YoloBattleSmobaOuterClass$YoloSmobaBattleEntity battle_entity = new YoloBattleSmobaOuterClass$YoloSmobaBattleEntity();
    public YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent battle_begin_event_info = new MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent>() { // from class: trpc.yes.common.YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 72, 82, 90}, new String[]{"game_id", "game_type", "map_acnt_num", "map_type", "level_id", "start_time", "battle_id", "is_warm_battle", "create_type", "camps", "ob_schema"}, new Object[]{0, 0, 0, 0, 0, 0, "", 0, 0, null, ""}, YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent.class);
        public final PBInt32Field game_id = PBField.initInt32(0);
        public final PBInt32Field game_type = PBField.initInt32(0);
        public final PBInt32Field map_acnt_num = PBField.initInt32(0);
        public final PBInt32Field map_type = PBField.initInt32(0);
        public final PBInt32Field level_id = PBField.initInt32(0);
        public final PBUInt32Field start_time = PBField.initUInt32(0);
        public final PBStringField battle_id = PBField.initString("");
        public final PBInt32Field is_warm_battle = PBField.initInt32(0);
        public final PBInt32Field create_type = PBField.initInt32(0);
        public final PBRepeatMessageField<SmobaDataOuterClass$OneCamp> camps = PBField.initRepeatMessage(SmobaDataOuterClass$OneCamp.class);
        public final PBStringField ob_schema = PBField.initString("");
    };
}
