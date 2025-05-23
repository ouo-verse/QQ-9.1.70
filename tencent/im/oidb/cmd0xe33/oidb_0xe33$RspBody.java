package tencent.im.oidb.cmd0xe33;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe33$RspBody extends MessageMicro<oidb_0xe33$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"topic_info_set_rsp"}, new Object[]{null}, oidb_0xe33$RspBody.class);
    public oidb_0xe33$TopicInfoSetRsp topic_info_set_rsp = new MessageMicro<oidb_0xe33$TopicInfoSetRsp>() { // from class: tencent.im.oidb.cmd0xe33.oidb_0xe33$TopicInfoSetRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"topic_id", "ret_code", "err_msg"}, new Object[]{0, 0, ""}, oidb_0xe33$TopicInfoSetRsp.class);
        public final PBUInt32Field topic_id = PBField.initUInt32(0);
        public final PBEnumField ret_code = PBField.initEnum(0);
        public final PBStringField err_msg = PBField.initString("");
    };
}
