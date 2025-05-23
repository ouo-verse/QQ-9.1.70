package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$BlessingMessage extends MessageMicro<im_msg_body$BlessingMessage> {
    public static final int ETypeBlessing = 1;
    public static final int ETypeNormal = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_msg_type", "uint32_ex_flag"}, new Object[]{0, 0}, im_msg_body$BlessingMessage.class);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ex_flag = PBField.initUInt32(0);
}
