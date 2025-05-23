package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$CheckSafetyReq extends MessageMicro<SuperResolution$CheckSafetyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "lloc", "url"}, new Object[]{"", "", ""}, SuperResolution$CheckSafetyReq.class);
    public final PBStringField album_id = PBField.initString("");
    public final PBStringField lloc = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
