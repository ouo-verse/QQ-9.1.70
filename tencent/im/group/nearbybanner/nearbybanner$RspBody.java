package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearbybanner$RspBody extends MessageMicro<nearbybanner$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_error", "msg_banners"}, new Object[]{0, ByteStringMicro.EMPTY, null}, nearbybanner$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_error = PBField.initBytes(ByteStringMicro.EMPTY);
    public nearbybanner$Banners msg_banners = new nearbybanner$Banners();
}
