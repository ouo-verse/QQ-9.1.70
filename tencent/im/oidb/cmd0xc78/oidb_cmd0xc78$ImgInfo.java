package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc78$ImgInfo extends MessageMicro<oidb_cmd0xc78$ImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"md5", "sha1", "width", "height", "qr_decode_type", "qr_code_result"}, new Object[]{"", "", 0, 0, "", ""}, oidb_cmd0xc78$ImgInfo.class);
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField sha1 = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField qr_decode_type = PBField.initString("");
    public final PBStringField qr_code_result = PBField.initString("");
}
