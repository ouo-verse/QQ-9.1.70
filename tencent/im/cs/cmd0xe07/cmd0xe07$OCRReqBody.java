package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe07$OCRReqBody extends MessageMicro<cmd0xe07$OCRReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82, 90, 96, 104, 112, 120}, new String[]{"imageUrl", "languageType", "scene", "originMd5", "afterCompressMd5", "afterCompressFileSize", "afterCompressWeight", "afterCompressHeight", "isCut"}, new Object[]{"", "", "", "", "", 0, 0, 0, Boolean.FALSE}, cmd0xe07$OCRReqBody.class);
    public final PBStringField imageUrl = PBField.initString("");
    public final PBStringField languageType = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
    public final PBStringField originMd5 = PBField.initString("");
    public final PBStringField afterCompressMd5 = PBField.initString("");
    public final PBUInt32Field afterCompressFileSize = PBField.initUInt32(0);
    public final PBUInt32Field afterCompressWeight = PBField.initUInt32(0);
    public final PBUInt32Field afterCompressHeight = PBField.initUInt32(0);
    public final PBBoolField isCut = PBField.initBool(false);
}
