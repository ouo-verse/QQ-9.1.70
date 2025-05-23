package trpc.qq_vgame.common;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$GameStatusInfo extends MessageMicro<AvGameCommon$GameStatusInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 56, 66, 72, 80, 88, 96, 106, 112, 120, 128, 138}, new String[]{"play_game_id", "game_status", "status_past_time", "actor_info", "question_info", "game_info", "game_past_time", "right_actor_info", LocalPhotoFaceInfo.SCORE, "actor_start_ts", "total", "index", "question_class", "pk_id", "game_mode", VRReportDefine$ReportParam.SCENE_TYPE, "score_list"}, new Object[]{"", 0, 0, null, null, null, 0, null, 0, 0L, 0, 0, "", 0, 0, 0, null}, AvGameCommon$GameStatusInfo.class);
    public final PBStringField play_game_id = PBField.initString("");
    public final PBEnumField game_status = PBField.initEnum(0);
    public final PBUInt32Field status_past_time = PBField.initUInt32(0);
    public AvGameCommon$RoomUserInfo actor_info = new AvGameCommon$RoomUserInfo();
    public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
    public AvGameCommon$GameInfo game_info = new AvGameCommon$GameInfo();
    public final PBUInt32Field game_past_time = PBField.initUInt32(0);
    public AvGameCommon$RoomUserInfo right_actor_info = new AvGameCommon$RoomUserInfo();
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBUInt64Field actor_start_ts = PBField.initUInt64(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBStringField question_class = PBField.initString("");
    public final PBUInt32Field pk_id = PBField.initUInt32(0);
    public final PBUInt32Field game_mode = PBField.initUInt32(0);
    public final PBEnumField scene_type = PBField.initEnum(0);
    public final PBRepeatMessageField<AvGameCommon$PKUserRankInfo> score_list = PBField.initRepeatMessage(AvGameCommon$PKUserRankInfo.class);
}
