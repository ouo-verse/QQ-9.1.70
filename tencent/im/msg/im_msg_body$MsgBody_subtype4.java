package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$MsgBody_subtype4 extends MessageMicro<im_msg_body$MsgBody_subtype4> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_not_online_file", "uint32_msg_time"}, new Object[]{null, 0}, im_msg_body$MsgBody_subtype4.class);
    public im_msg_body$NotOnlineFile msg_not_online_file = new im_msg_body$NotOnlineFile();
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
}
