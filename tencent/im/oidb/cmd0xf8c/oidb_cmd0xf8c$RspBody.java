package tencent.im.oidb.cmd0xf8c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf8c$RspBody extends MessageMicro<oidb_cmd0xf8c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"irest", "giftmsg"}, new Object[]{0, null}, oidb_cmd0xf8c$RspBody.class);
    public final PBUInt32Field irest = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xf8c$GiftMsg> giftmsg = PBField.initRepeatMessage(oidb_cmd0xf8c$GiftMsg.class);
}
