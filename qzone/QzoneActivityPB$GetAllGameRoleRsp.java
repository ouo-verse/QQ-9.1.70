package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$GetAllGameRoleRsp extends MessageMicro<QzoneActivityPB$GetAllGameRoleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"roles"}, new Object[]{null}, QzoneActivityPB$GetAllGameRoleRsp.class);
    public final PBRepeatMessageField<QzoneActivityPB$ServerRole> roles = PBField.initRepeatMessage(QzoneActivityPB$ServerRole.class);
}
