package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$CleanUserDataReq extends MessageMicro<QzoneActivityPB$CleanUserDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"clearPKOnly"}, new Object[]{Boolean.FALSE}, QzoneActivityPB$CleanUserDataReq.class);
    public final PBBoolField clearPKOnly = PBField.initBool(false);
}
