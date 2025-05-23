package tencent.im.opengroup;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AppUrlOpenGroup$RspBody extends MessageMicro<AppUrlOpenGroup$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_name;
    public final PBBytesField bytes_company;
    public final PBBytesField bytes_err_info;
    public final PBBytesField bytes_info_url;
    public final PBBytesField bytes_share_url;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"uint32_result", "bytes_err_info", "bytes_app_name", "bytes_company", "bytes_share_url", "bytes_info_url"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, AppUrlOpenGroup$RspBody.class);
    }

    public AppUrlOpenGroup$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_err_info = PBField.initBytes(byteStringMicro);
        this.bytes_app_name = PBField.initBytes(byteStringMicro);
        this.bytes_company = PBField.initBytes(byteStringMicro);
        this.bytes_share_url = PBField.initBytes(byteStringMicro);
        this.bytes_info_url = PBField.initBytes(byteStringMicro);
    }
}
