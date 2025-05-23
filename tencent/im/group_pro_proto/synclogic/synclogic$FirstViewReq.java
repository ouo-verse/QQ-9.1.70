package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$FirstViewReq extends MessageMicro<synclogic$FirstViewReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"last_msg_time", "udc_flag", "seq", "direct_message_flag", "no_need_msg"}, new Object[]{0L, 0, 0, 0, 0}, synclogic$FirstViewReq.class);
    public final PBUInt64Field last_msg_time = PBField.initUInt64(0);
    public final PBUInt32Field udc_flag = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field direct_message_flag = PBField.initUInt32(0);
    public final PBUInt32Field no_need_msg = PBField.initUInt32(0);
}
