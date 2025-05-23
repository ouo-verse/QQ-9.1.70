package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class IqunFlameManageSvrPB$SetFlameSwitchReq extends MessageMicro<IqunFlameManageSvrPB$SetFlameSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "switch_value"}, new Object[]{0L, 0}, IqunFlameManageSvrPB$SetFlameSwitchReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field switch_value = PBField.initUInt32(0);
}
