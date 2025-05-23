package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ReadActivityConfRsp extends MessageMicro<QzoneActivityPB$ReadActivityConfRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ext_infos"}, new Object[]{null}, QzoneActivityPB$ReadActivityConfRsp.class);
    public final PBRepeatMessageField<QzoneActivityPB$KVInfo> ext_infos = PBField.initRepeatMessage(QzoneActivityPB$KVInfo.class);
}
