package tencent.im.opengroup;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class jstoken$ReqBody extends MessageMicro<jstoken$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_openid;
    public final PBBytesField bytes_jstoken;
    public final PBBytesField bytes_url;
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_appid", "bytes_group_openid", "bytes_url", "bytes_jstoken"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro}, jstoken$ReqBody.class);
    }

    public jstoken$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_group_openid = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.bytes_jstoken = PBField.initBytes(byteStringMicro);
    }
}
