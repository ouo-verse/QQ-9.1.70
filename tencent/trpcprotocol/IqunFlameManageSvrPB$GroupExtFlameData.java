package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class IqunFlameManageSvrPB$GroupExtFlameData extends MessageMicro<IqunFlameManageSvrPB$GroupExtFlameData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"switch_value", "state", "day_num", "version", "update_time", "is_display_day_num"}, new Object[]{0, 0, 0, 0, 0L, Boolean.FALSE}, IqunFlameManageSvrPB$GroupExtFlameData.class);
    public final PBUInt32Field switch_value = PBField.initUInt32(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBRepeatField<Integer> day_num = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt64Field update_time = PBField.initUInt64(0);
    public final PBBoolField is_display_day_num = PBField.initBool(false);
}
