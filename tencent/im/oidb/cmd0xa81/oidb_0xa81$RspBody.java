package tencent.im.oidb.cmd0xa81;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa81$RspBody extends MessageMicro<oidb_0xa81$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_err_msg"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xa81$RspBody.class);
    public final PBBytesField str_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
