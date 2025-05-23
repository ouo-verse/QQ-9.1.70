package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa80$RspBody extends MessageMicro<oidb_cmd0xa80$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_rsp_group_info"}, new Object[]{null}, oidb_cmd0xa80$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xa80$RspGroupInfo> rpt_msg_rsp_group_info = PBField.initRepeatMessage(oidb_cmd0xa80$RspGroupInfo.class);
}
