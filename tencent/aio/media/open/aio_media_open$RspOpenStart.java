package tencent.aio.media.open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media_open$RspOpenStart extends MessageMicro<aio_media_open$RspOpenStart> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_result", "enum_jump_type", "bytes_jump_url"}, new Object[]{null, 1, ByteStringMicro.EMPTY}, aio_media_open$RspOpenStart.class);
    public aio_media_open$ResultInfo msg_result = new aio_media_open$ResultInfo();
    public final PBEnumField enum_jump_type = PBField.initEnum(1);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
}
