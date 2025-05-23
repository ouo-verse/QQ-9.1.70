package tencent.im.user.set;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class NewMsgNotifySwitchPb$RspBody extends MessageMicro<NewMsgNotifySwitchPb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_error_code", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, NewMsgNotifySwitchPb$RspBody.class);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
