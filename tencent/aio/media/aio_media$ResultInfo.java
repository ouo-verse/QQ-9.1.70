package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ResultInfo extends MessageMicro<aio_media$ResultInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_result", "bytes_errmsg", "uint32_svr_time", "uint64_svr_time"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0L}, aio_media$ResultInfo.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint32_svr_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_svr_time = PBField.initUInt64(0);
}
