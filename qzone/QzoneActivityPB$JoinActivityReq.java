package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$JoinActivityReq extends MessageMicro<QzoneActivityPB$JoinActivityReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 162}, new String[]{"join_scene", "tid", "kf_infos", "cookie"}, new Object[]{"", "", null, ""}, QzoneActivityPB$JoinActivityReq.class);
    public final PBStringField join_scene = PBField.initString("");
    public final PBStringField tid = PBField.initString("");
    public final PBRepeatMessageField<QzoneActivityPB$KVInfo> kf_infos = PBField.initRepeatMessage(QzoneActivityPB$KVInfo.class);
    public final PBStringField cookie = PBField.initString("");
}
