package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloGameDataInfo extends MessageMicro<YoloRoomOuterClass$YoloGameDataInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 42, 50, 58, 66, 74, 82}, new String[]{"smoba_game_data_info", "community_game_data_info", "pubg_game_data_info", "common_game_data_info", "qsm_game_data_info", "cfm_game_data_info", "codm_game_data_info"}, new Object[]{null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloGameDataInfo.class);
    public YoloRoomOuterClass$YoloSmobaGameDataInfo smoba_game_data_info = new YoloRoomOuterClass$YoloSmobaGameDataInfo();
    public YoloRoomOuterClass$YoloCommunityGameDataInfo community_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloCommunityGameDataInfo>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCommunityGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"game_id"}, new Object[]{0}, YoloRoomOuterClass$YoloCommunityGameDataInfo.class);
        public final PBInt32Field game_id = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloPubgGameDataInfo pubg_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloPubgGameDataInfo>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloPubgGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24}, new String[]{"min_role_level"}, new Object[]{0}, YoloRoomOuterClass$YoloPubgGameDataInfo.class);
        public final PBInt32Field min_role_level = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloCommonGameDataInfo common_game_data_info = new YoloRoomOuterClass$YoloCommonGameDataInfo();
    public YoloRoomOuterClass$YoloQsmGameDataInfo qsm_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloQsmGameDataInfo>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloQsmGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloQsmGameDataInfo.class);
    };
    public YoloRoomOuterClass$YoloCfmGameDataInfo cfm_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloCfmGameDataInfo>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCfmGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"play_mode", "map_id", "match_type", "mode_type"}, new Object[]{0, 0, 0, 0}, YoloRoomOuterClass$YoloCfmGameDataInfo.class);
        public final PBInt32Field play_mode = PBField.initInt32(0);
        public final PBInt32Field map_id = PBField.initInt32(0);
        public final PBInt32Field match_type = PBField.initInt32(0);
        public final PBInt32Field mode_type = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloCodmGameDataInfo codm_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloCodmGameDataInfo>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCodmGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"room_type", "play_list"}, new Object[]{0, ""}, YoloRoomOuterClass$YoloCodmGameDataInfo.class);
        public final PBUInt32Field room_type = PBField.initUInt32(0);
        public final PBRepeatField<String> play_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
