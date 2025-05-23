package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$BatchGetUidByTinyIdReq extends MessageMicro<UserProxyCmdOuterClass$BatchGetUidByTinyIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"tiny_id_list"}, new Object[]{0L}, UserProxyCmdOuterClass$BatchGetUidByTinyIdReq.class);
    public final PBRepeatField<Long> tiny_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
