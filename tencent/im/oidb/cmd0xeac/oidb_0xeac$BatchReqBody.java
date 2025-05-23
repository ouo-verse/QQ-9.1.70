package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeac$BatchReqBody extends MessageMicro<oidb_0xeac$BatchReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_code", "msgs"}, new Object[]{0L, null}, oidb_0xeac$BatchReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0xeac$MsgInfo> msgs = PBField.initRepeatMessage(oidb_0xeac$MsgInfo.class);
}
