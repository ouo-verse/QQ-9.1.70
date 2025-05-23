package tencent.im.s2c.msgtype0x210.submsgtype0x111;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x111$Label extends MessageMicro<SubMsgType0x111$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"bytes_name", "text_color", "edging_color", "uint32_label_type"}, new Object[]{ByteStringMicro.EMPTY, null, null, 0}, SubMsgType0x111$Label.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x111$Color text_color = new SubMsgType0x111$Color();
    public SubMsgType0x111$Color edging_color = new SubMsgType0x111$Color();
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
}
