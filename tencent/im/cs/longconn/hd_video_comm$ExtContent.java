package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_comm$ExtContent extends MessageMicro<hd_video_comm$ExtContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_ext_content_type", "uint64_ext_content", "bytes_ext_content"}, new Object[]{0, 0L, ByteStringMicro.EMPTY}, hd_video_comm$ExtContent.class);
    public final PBUInt32Field uint32_ext_content_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ext_content = PBField.initUInt64(0);
    public final PBBytesField bytes_ext_content = PBField.initBytes(ByteStringMicro.EMPTY);
}
