package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ShareReq extends MessageMicro<QzoneActivityPB$ShareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"from", "frd_uin"}, new Object[]{0, ""}, QzoneActivityPB$ShareReq.class);
    public final PBEnumField from = PBField.initEnum(0);
    public final PBStringField frd_uin = PBField.initString("");
}
