package tencent.im.oidb.cmd0xc13;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc13$EncryptUinReqBody extends MessageMicro<oidb_0xc13$EncryptUinReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_uin"}, new Object[]{0L}, oidb_0xc13$EncryptUinReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
