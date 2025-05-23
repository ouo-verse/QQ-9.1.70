package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$LightAppElem extends MessageMicro<im_msg_body$LightAppElem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data;
    public final PBBytesField bytes_msg_resid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_data", "bytes_msg_resid"}, new Object[]{byteStringMicro, byteStringMicro}, im_msg_body$LightAppElem.class);
    }

    public im_msg_body$LightAppElem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_data = PBField.initBytes(byteStringMicro);
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
    }
}
