package qzone;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ReadUserActivityInfoRsp extends MessageMicro<QzoneActivityPB$ReadUserActivityInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_info"}, new Object[]{null}, QzoneActivityPB$ReadUserActivityInfoRsp.class);
    public QzoneActivityPB$UserActivityInfo user_info = new QzoneActivityPB$UserActivityInfo();
}
