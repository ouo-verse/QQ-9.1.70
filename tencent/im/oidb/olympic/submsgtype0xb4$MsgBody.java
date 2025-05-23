package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xb4$MsgBody extends MessageMicro<submsgtype0xb4$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "msg_body_type"}, new Object[]{0, null}, submsgtype0xb4$MsgBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public submsgtype0xb4$BodyType msg_body_type = new MessageMicro<submsgtype0xb4$BodyType>() { // from class: tencent.im.oidb.olympic.submsgtype0xb4$BodyType
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_torchbearer"}, new Object[]{null}, submsgtype0xb4$BodyType.class);
        public torch_transfer$TorchbearerInfo msg_torchbearer = new torch_transfer$TorchbearerInfo();
    };
}
