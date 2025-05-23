package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$Trans211TmpMsg extends MessageMicro<im_msg_body$Trans211TmpMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_msg_body", "uint32_c2c_cmd"}, new Object[]{ByteStringMicro.EMPTY, 0}, im_msg_body$Trans211TmpMsg.class);
    public final PBBytesField bytes_msg_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_c2c_cmd = PBField.initUInt32(0);
}
