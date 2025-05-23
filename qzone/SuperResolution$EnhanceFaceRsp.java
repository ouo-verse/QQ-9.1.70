package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$EnhanceFaceRsp extends MessageMicro<SuperResolution$EnhanceFaceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"is_support_end_cloud", "task_id", "face_outputs"}, new Object[]{Boolean.FALSE, "", null}, SuperResolution$EnhanceFaceRsp.class);
    public final PBBoolField is_support_end_cloud = PBField.initBool(false);
    public final PBStringField task_id = PBField.initString("");
    public final PBRepeatMessageField<SuperResolution$FaceOutput> face_outputs = PBField.initRepeatMessage(SuperResolution$FaceOutput.class);
}
