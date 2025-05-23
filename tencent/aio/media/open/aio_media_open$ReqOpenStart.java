package tencent.aio.media.open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media_open$ReqOpenStart extends MessageMicro<aio_media_open$ReqOpenStart> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_data;
    public final PBBytesField bytes_req_sign;
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 34, 42}, new String[]{"enum_aio_type", "uint64_id", "bytes_req_data", "bytes_req_sign"}, new Object[]{1, 0L, byteStringMicro, byteStringMicro}, aio_media_open$ReqOpenStart.class);
    }

    public aio_media_open$ReqOpenStart() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_req_data = PBField.initBytes(byteStringMicro);
        this.bytes_req_sign = PBField.initBytes(byteStringMicro);
    }
}
