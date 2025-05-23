package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$UploadCompletedReq extends MessageMicro<oidb_0xfc2$UploadCompletedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_fileid", "uint64_random", "bytes_ext"}, new Object[]{"", 0L, ByteStringMicro.EMPTY}, oidb_0xfc2$UploadCompletedReq.class);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt64Field uint64_random = PBField.initUInt64(0);
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
}
