package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6ce$ReqBody extends MessageMicro<cmd0x6ce$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_read_req"}, new Object[]{null}, cmd0x6ce$ReqBody.class);
    public final PBRepeatMessageField<cmd0x6ce$ReadRedpointReq> rpt_msg_read_req = PBField.initRepeatMessage(cmd0x6ce$ReadRedpointReq.class);
}
