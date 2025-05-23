package tencent.im.oidb.cmd0xe84;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe84$ReqBody extends MessageMicro<oidb_0xe84$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_appid", "msg_condi"}, new Object[]{0L, null}, oidb_0xe84$ReqBody.class);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0xe84$Condition> msg_condi = PBField.initRepeatMessage(oidb_0xe84$Condition.class);
}
