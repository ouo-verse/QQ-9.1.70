package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$EnhanceFaceReq extends MessageMicro<SuperResolution$EnhanceFaceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "lloc", "url", "scale", "enhance_type", "face_enhance_max_face", "task_id"}, new Object[]{"", "", "", 0, 0, 0, ""}, SuperResolution$EnhanceFaceReq.class);
    public final PBStringField album_id = PBField.initString("");
    public final PBStringField lloc = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field scale = PBField.initUInt32(0);
    public final PBEnumField enhance_type = PBField.initEnum(0);
    public final PBUInt32Field face_enhance_max_face = PBField.initUInt32(0);
    public final PBStringField task_id = PBField.initString("");
}
