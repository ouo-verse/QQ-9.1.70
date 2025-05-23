package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_head$InstCtrl extends MessageMicro<im_msg_head$InstCtrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst"}, new Object[]{null, null, null}, im_msg_head$InstCtrl.class);
    public final PBRepeatMessageField<im_msg_head$InstInfo> rpt_msg_send_to_inst = PBField.initRepeatMessage(im_msg_head$InstInfo.class);
    public final PBRepeatMessageField<im_msg_head$InstInfo> rpt_msg_exclude_inst = PBField.initRepeatMessage(im_msg_head$InstInfo.class);
    public im_msg_head$InstInfo msg_from_inst = new im_msg_head$InstInfo();
}
