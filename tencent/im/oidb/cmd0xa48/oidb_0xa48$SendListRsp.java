package tencent.im.oidb.cmd0xa48;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa48$SendListRsp extends MessageMicro<oidb_0xa48$SendListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rpt_today_birth", "rpt_send_gift", "rpt_recv_gift"}, new Object[]{null, null, null}, oidb_0xa48$SendListRsp.class);
    public final PBRepeatMessageField<oidb_0xa48$SendItem> rpt_today_birth = PBField.initRepeatMessage(oidb_0xa48$SendItem.class);
    public final PBRepeatMessageField<oidb_0xa48$SendItem> rpt_send_gift = PBField.initRepeatMessage(oidb_0xa48$SendItem.class);
    public final PBRepeatMessageField<oidb_0xa48$SendItem> rpt_recv_gift = PBField.initRepeatMessage(oidb_0xa48$SendItem.class);
}
