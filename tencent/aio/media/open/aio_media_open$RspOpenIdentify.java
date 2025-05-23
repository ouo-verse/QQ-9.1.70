package tencent.aio.media.open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media_open$RspOpenIdentify extends MessageMicro<aio_media_open$RspOpenIdentify> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_button_text;
    public final PBBytesField bytes_confirm_text;
    public final PBBytesField bytes_introduce_text;
    public final PBBytesField bytes_introduce_title;
    public aio_media_open$ResultInfo msg_result = new aio_media_open$ResultInfo();
    public final PBUInt32Field uint32_business_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"msg_result", "bytes_button_text", "bytes_confirm_text", "bytes_introduce_title", "bytes_introduce_text", "uint32_business_type"}, new Object[]{null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, aio_media_open$RspOpenIdentify.class);
    }

    public aio_media_open$RspOpenIdentify() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_button_text = PBField.initBytes(byteStringMicro);
        this.bytes_confirm_text = PBField.initBytes(byteStringMicro);
        this.bytes_introduce_title = PBField.initBytes(byteStringMicro);
        this.bytes_introduce_text = PBField.initBytes(byteStringMicro);
        this.uint32_business_type = PBField.initUInt32(0);
    }
}
