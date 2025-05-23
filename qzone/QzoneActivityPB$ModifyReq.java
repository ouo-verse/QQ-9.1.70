package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ModifyReq extends MessageMicro<QzoneActivityPB$ModifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"modify_flag", "modify_info"}, new Object[]{null, null}, QzoneActivityPB$ModifyReq.class);
    public QzoneActivityPB$ModifyFlag modify_flag = new MessageMicro<QzoneActivityPB$ModifyFlag>() { // from class: qzone.QzoneActivityPB$ModifyFlag
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField show_status = PBField.initBool(false);
        public final PBBoolField dragon_id = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"show_status", "dragon_id"}, new Object[]{bool, bool}, QzoneActivityPB$ModifyFlag.class);
        }
    };
    public QzoneActivityPB$ModifyInfo modify_info = new MessageMicro<QzoneActivityPB$ModifyInfo>() { // from class: qzone.QzoneActivityPB$ModifyInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"show_status", "dragon_id"}, new Object[]{0, ""}, QzoneActivityPB$ModifyInfo.class);
        public final PBInt32Field show_status = PBField.initInt32(0);
        public final PBStringField dragon_id = PBField.initString("");
    };
}
