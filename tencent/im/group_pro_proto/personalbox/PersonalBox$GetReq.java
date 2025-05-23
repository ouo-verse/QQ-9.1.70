package tencent.im.group_pro_proto.personalbox;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalBox$GetReq extends MessageMicro<PersonalBox$GetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"biz_types"}, new Object[]{0L}, PersonalBox$GetReq.class);
    public final PBRepeatField<Long> biz_types = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
