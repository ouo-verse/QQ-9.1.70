package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$EventNoticRsp extends MessageMicro<QzoneActivityPB$EventNoticRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"event_res", "bytes_event_res"}, new Object[]{null, ""}, QzoneActivityPB$EventNoticRsp.class);
    public QzoneActivityPB$EventRes event_res = new MessageMicro<QzoneActivityPB$EventRes>() { // from class: qzone.QzoneActivityPB$EventRes
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26, 34, 42}, new String[]{"play_rid", "nickname_res_info", "tips_info"}, new Object[]{"", null, null}, QzoneActivityPB$EventRes.class);
        public final PBStringField play_rid = PBField.initString("");
        public QzoneActivityPB$ResourceInfo nickname_res_info = new QzoneActivityPB$ResourceInfo();
        public QzoneActivityPB$ResourceInfo tips_info = new QzoneActivityPB$ResourceInfo();
    };
    public final PBStringField bytes_event_res = PBField.initString("");
}
