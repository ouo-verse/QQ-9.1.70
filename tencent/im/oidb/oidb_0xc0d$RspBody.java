package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc0d$RspBody extends MessageMicro<oidb_0xc0d$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_completed_task_stamp", "bytes_err_msg"}, new Object[]{0L, ByteStringMicro.EMPTY}, oidb_0xc0d$RspBody.class);
    public final PBUInt64Field uint64_completed_task_stamp = PBField.initUInt64(0);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
