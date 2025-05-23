package tencent.im.oidb.cmd0xc13;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc13$EncryptUinRspBody extends MessageMicro<oidb_0xc13$EncryptUinRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_encrypt_result"}, new Object[]{null}, oidb_0xc13$EncryptUinRspBody.class);
    public final PBRepeatMessageField<oidb_0xc13$EncryptUinResult> rpt_msg_encrypt_result = PBField.initRepeatMessage(oidb_0xc13$EncryptUinResult.class);
}
