package tencent.im.s2c.msgtype0x210.submsgtype0xfe;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xfe$MsgBody extends MessageMicro<submsgtype0xfe$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"bytes_wording", "uint32_inner_unread_num", "uint32_box_unread_num", "uint32_update_time"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0}, submsgtype0xfe$MsgBody.class);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_inner_unread_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_box_unread_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
}
