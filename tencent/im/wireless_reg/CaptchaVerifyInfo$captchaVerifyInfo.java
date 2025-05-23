package tencent.im.wireless_reg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CaptchaVerifyInfo$captchaVerifyInfo extends MessageMicro<CaptchaVerifyInfo$captchaVerifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_ticket", "str_randstr"}, new Object[]{ByteStringMicro.EMPTY, ""}, CaptchaVerifyInfo$captchaVerifyInfo.class);
    public final PBBytesField bytes_ticket = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_randstr = PBField.initString("");
}
