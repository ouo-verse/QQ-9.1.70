package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SmobaMotorcadeSvrPB$IsUserInMotorcadeReq extends MessageMicro<SmobaMotorcadeSvrPB$IsUserInMotorcadeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_id"}, new Object[]{0L}, SmobaMotorcadeSvrPB$IsUserInMotorcadeReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
}
