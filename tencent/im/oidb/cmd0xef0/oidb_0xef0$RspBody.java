package tencent.im.oidb.cmd0xef0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef0$RspBody extends MessageMicro<oidb_0xef0$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_rsp_detail"}, new Object[]{null}, oidb_0xef0$RspBody.class);
    public final PBRepeatMessageField<oidb_0xef0$RspDetail> rpt_msg_rsp_detail = PBField.initRepeatMessage(oidb_0xef0$RspDetail.class);
}
