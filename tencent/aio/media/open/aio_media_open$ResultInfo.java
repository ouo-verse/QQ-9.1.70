package tencent.aio.media.open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media_open$ResultInfo extends MessageMicro<aio_media_open$ResultInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_result", "bytes_errmsg", "bool_show_err"}, new Object[]{0, ByteStringMicro.EMPTY, Boolean.FALSE}, aio_media_open$ResultInfo.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField bool_show_err = PBField.initBool(false);
}
