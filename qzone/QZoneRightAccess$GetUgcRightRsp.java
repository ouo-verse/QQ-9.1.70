package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneRightAccess$GetUgcRightRsp extends MessageMicro<QZoneRightAccess$GetUgcRightRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"right_flag", "uin_list"}, new Object[]{0, 0L}, QZoneRightAccess$GetUgcRightRsp.class);
    public final PBEnumField right_flag = PBField.initEnum(0);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
