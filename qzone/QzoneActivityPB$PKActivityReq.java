package qzone;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$PKActivityReq extends MessageMicro<QzoneActivityPB$PKActivityReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"target_user"}, new Object[]{null}, QzoneActivityPB$PKActivityReq.class);
    public QZoneBaseMeta$StUser target_user = new QZoneBaseMeta$StUser();
}
