package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe07$RspBody extends MessageMicro<cmd0xe07$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 82}, new String[]{"retCode", "errMsg", "wording", "ocrRspBody"}, new Object[]{0, "", "", null}, cmd0xe07$RspBody.class);
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
    public cmd0xe07$OCRRspBody ocrRspBody = new cmd0xe07$OCRRspBody();
}
