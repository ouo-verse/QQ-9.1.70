package tencent.im.oidb.cmd0x6b5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6b5$RspBody extends MessageMicro<oidb_0x6b5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_errmsg", "msg_grab_result"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x6b5$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6b5$Player msg_grab_result = new oidb_0x6b5$Player();
}
