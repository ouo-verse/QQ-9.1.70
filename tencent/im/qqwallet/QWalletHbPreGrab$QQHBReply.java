package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QWalletHbPreGrab$QQHBReply extends MessageMicro<QWalletHbPreGrab$QQHBReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"retCode", "retMsg", "rspText", "rspBody"}, new Object[]{"", "", "", ByteStringMicro.EMPTY}, QWalletHbPreGrab$QQHBReply.class);
    public final PBStringField retCode = PBField.initString("");
    public final PBStringField retMsg = PBField.initString("");
    public final PBStringField rspText = PBField.initString("");
    public final PBBytesField rspBody = PBField.initBytes(ByteStringMicro.EMPTY);
}
