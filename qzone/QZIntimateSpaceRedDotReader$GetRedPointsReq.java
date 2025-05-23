package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceRedDotReader$GetRedPointsReq extends MessageMicro<QZIntimateSpaceRedDotReader$GetRedPointsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"last_enter_time", "scene", "need_entrance_info", "frd_uin", "frd_uins"}, new Object[]{0L, 0, Boolean.FALSE, "", ""}, QZIntimateSpaceRedDotReader$GetRedPointsReq.class);
    public final PBInt64Field last_enter_time = PBField.initInt64(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBBoolField need_entrance_info = PBField.initBool(false);
    public final PBStringField frd_uin = PBField.initString("");
    public final PBRepeatField<String> frd_uins = PBField.initRepeat(PBStringField.__repeatHelper__);
}
