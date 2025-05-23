package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* loaded from: classes29.dex */
public final class AvGamePlay$AnswerReq extends MessageMicro<AvGamePlay$AnswerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 74}, new String[]{"uin", "play_game_id", "question_index", "answer_index", VRReportDefine$ReportParam.SCENE_TYPE, "answer_duration", "trans_mod", "trans_cost", "answer"}, new Object[]{0L, "", 0, 0, 0, 0, 0, 0, ""}, AvGamePlay$AnswerReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField play_game_id = PBField.initString("");
    public final PBUInt32Field question_index = PBField.initUInt32(0);
    public final PBUInt32Field answer_index = PBField.initUInt32(0);
    public final PBEnumField scene_type = PBField.initEnum(0);
    public final PBUInt32Field answer_duration = PBField.initUInt32(0);
    public final PBUInt32Field trans_mod = PBField.initUInt32(0);
    public final PBUInt32Field trans_cost = PBField.initUInt32(0);
    public final PBStringField answer = PBField.initString("");
}
