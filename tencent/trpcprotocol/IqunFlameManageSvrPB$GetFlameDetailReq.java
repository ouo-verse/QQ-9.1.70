package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class IqunFlameManageSvrPB$GetFlameDetailReq extends MessageMicro<IqunFlameManageSvrPB$GetFlameDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_code"}, new Object[]{0L}, IqunFlameManageSvrPB$GetFlameDetailReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
