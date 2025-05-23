package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class AvGamePkManager$PKOperationRsp extends MessageMicro<AvGamePkManager$PKOperationRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBUInt32Field pool_id = PBField.initUInt32(0);
    public final PBUInt32Field start_user_num = PBField.initUInt32(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBBoolField mav_closed = PBField.initBool(false);
    public final PBStringField biz_title_pic_idx = PBField.initString("");
    public final PBStringField biz_titel_pic_url = PBField.initString("");
    public final PBStringField biz_ad_wording = PBField.initString("");
    public final PBStringField biz_ad_tip = PBField.initString("");
    public final PBStringField answer_tip = PBField.initString("");
    public final PBUInt32Field sponsor_id = PBField.initUInt32(0);
    public final PBUInt32Field curRound = PBField.initUInt32(0);
    public final PBBoolField close_realtime_report = PBField.initBool(false);
    public final PBUInt32Field wait_res_timeout = PBField.initUInt32(0);
    public final PBStringField waiting_background_url = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 104, 112, 122}, new String[]{"res", "pool_id", "start_user_num", "scene", "mav_closed", "biz_title_pic_idx", "biz_titel_pic_url", "biz_ad_wording", "biz_ad_tip", "answer_tip", "sponsor_id", "curRound", "close_realtime_report", "wait_res_timeout", "waiting_background_url"}, new Object[]{null, 0, 0, 0, bool, "", "", "", "", "", 0, 0, bool, 0, ""}, AvGamePkManager$PKOperationRsp.class);
    }
}
