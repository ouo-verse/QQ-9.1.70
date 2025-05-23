package tencent.im.oidb.cmd0xa4d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa4d$IMMRRsp extends MessageMicro<oidb_0xa4d$IMMRRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 810}, new String[]{"int32_ret", "int64_last_modified", "bytes_rsp_data"}, new Object[]{0, 0L, ByteStringMicro.EMPTY}, oidb_0xa4d$IMMRRsp.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBInt64Field int64_last_modified = PBField.initInt64(0);
    public final PBBytesField bytes_rsp_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
