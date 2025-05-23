package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class IqunFlameManageSvrPB$GetRankListReq extends MessageMicro<IqunFlameManageSvrPB$GetRankListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"rank_type", "group_code"}, new Object[]{0, 0L}, IqunFlameManageSvrPB$GetRankListReq.class);
    public final PBUInt32Field rank_type = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
