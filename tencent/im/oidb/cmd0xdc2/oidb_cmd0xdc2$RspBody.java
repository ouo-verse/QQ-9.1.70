package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xdc2$RspBody extends MessageMicro<oidb_cmd0xdc2$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"batch_send_rsp"}, new Object[]{null}, oidb_cmd0xdc2$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xdc2$BatchSendRsp> batch_send_rsp = PBField.initRepeatMessage(oidb_cmd0xdc2$BatchSendRsp.class);
}
