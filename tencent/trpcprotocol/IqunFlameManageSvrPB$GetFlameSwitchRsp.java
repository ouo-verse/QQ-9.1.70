package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class IqunFlameManageSvrPB$GetFlameSwitchRsp extends MessageMicro<IqunFlameManageSvrPB$GetFlameSwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"switch_value"}, new Object[]{0}, IqunFlameManageSvrPB$GetFlameSwitchRsp.class);
    public final PBUInt32Field switch_value = PBField.initUInt32(0);
}
