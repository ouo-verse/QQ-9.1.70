package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class GatewayVerify$PicVerifyInfo extends MessageMicro<GatewayVerify$PicVerifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rand_key;
    public final PBBytesField bytes_verify_sig;
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_appid", "bytes_verify_sig", "bytes_rand_key"}, new Object[]{0L, byteStringMicro, byteStringMicro}, GatewayVerify$PicVerifyInfo.class);
    }

    public GatewayVerify$PicVerifyInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_verify_sig = PBField.initBytes(byteStringMicro);
        this.bytes_rand_key = PBField.initBytes(byteStringMicro);
    }
}
