package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* loaded from: classes29.dex */
public final class AvGamePlay$StartGameReq extends MessageMicro<AvGamePlay$StartGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 72}, new String[]{"uin", "roomid", "type", "question_class", "pk_id", VRReportDefine$ReportParam.SCENE_TYPE, "pk_round", "game_mode", "trans_mod"}, new Object[]{0L, 0L, 0, "", 0, 0, 0, 0, 0}, AvGamePlay$StartGameReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField question_class = PBField.initString("");
    public final PBUInt32Field pk_id = PBField.initUInt32(0);
    public final PBEnumField scene_type = PBField.initEnum(0);
    public final PBUInt32Field pk_round = PBField.initUInt32(0);
    public final PBUInt32Field game_mode = PBField.initUInt32(0);
    public final PBUInt32Field trans_mod = PBField.initUInt32(0);
}
