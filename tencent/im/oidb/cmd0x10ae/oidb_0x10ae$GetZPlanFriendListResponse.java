package tencent.im.oidb.cmd0x10ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x10ae$GetZPlanFriendListResponse extends MessageMicro<oidb_0x10ae$GetZPlanFriendListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uins"}, new Object[]{0L}, oidb_0x10ae$GetZPlanFriendListResponse.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
