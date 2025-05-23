package tencent.im.oidb.cmd0x799;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x799$RspBody extends MessageMicro<oidb_0x799$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "astLongNickInfoList"}, new Object[]{0, null}, oidb_0x799$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x799$LongNickInfo> astLongNickInfoList = PBField.initRepeatMessage(oidb_0x799$LongNickInfo.class);
}
