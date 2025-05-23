package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloTeamEnterCondition extends MessageMicro<YoloTeamOuterClass$YoloTeamEnterCondition> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56}, new String[]{"game_id", "qq_live_room_config", "smoba_live_join_config", "show_info", "smoba_team_params", "guild_join_config", "type_source"}, new Object[]{0, null, null, null, null, null, 0}, YoloTeamOuterClass$YoloTeamEnterCondition.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public YoloRoomOuterClass$QQLiveRoomConfig qq_live_room_config = new YoloRoomOuterClass$QQLiveRoomConfig();
    public YoloTeamOuterClass$SmobaLiveJoinCondition smoba_live_join_config = new MessageMicro<YoloTeamOuterClass$SmobaLiveJoinCondition>() { // from class: trpc.yes.common.YoloTeamOuterClass$SmobaLiveJoinCondition
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"openid", GdtGetUserInfoHandler.KEY_AREA, "partition", "appid", "join_type"}, new Object[]{"", 0, 0, "", 0}, YoloTeamOuterClass$SmobaLiveJoinCondition.class);
        public final PBStringField openid = PBField.initString("");
        public final PBUInt32Field area = PBField.initUInt32(0);
        public final PBUInt32Field partition = PBField.initUInt32(0);
        public final PBStringField appid = PBField.initString("");
        public final PBInt32Field join_type = PBField.initInt32(0);
    };
    public YoloTeamOuterClass$YoloTeamUserShowInfo show_info = new YoloTeamOuterClass$YoloTeamUserShowInfo();
    public YoloTeamOuterClass$YoloSmobaTeamParams smoba_team_params = new YoloTeamOuterClass$YoloSmobaTeamParams();
    public YoloTeamOuterClass$GuildLiveRoomJoinCondition guild_join_config = new YoloTeamOuterClass$GuildLiveRoomJoinCondition();
    public final PBInt32Field type_source = PBField.initInt32(0);
}
