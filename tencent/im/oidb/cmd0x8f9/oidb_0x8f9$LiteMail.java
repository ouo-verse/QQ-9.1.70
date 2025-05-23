package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f9$LiteMail extends MessageMicro<oidb_0x8f9$LiteMail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_mail", "uint32_result"}, new Object[]{null, 0}, oidb_0x8f9$LiteMail.class);
    public oidb_0x8f9$GroupFeedsRecord msg_mail = new oidb_0x8f9$GroupFeedsRecord();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}
