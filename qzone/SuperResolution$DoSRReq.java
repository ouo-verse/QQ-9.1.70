package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$DoSRReq extends MessageMicro<SuperResolution$DoSRReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "lloc", "url", "task_id"}, new Object[]{"", "", "", ""}, SuperResolution$DoSRReq.class);
    public final PBStringField album_id = PBField.initString("");
    public final PBStringField lloc = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField task_id = PBField.initString("");
}
