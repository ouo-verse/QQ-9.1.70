package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$TaskConsumerReq extends MessageMicro<QZonePhotoDegrade$TaskConsumerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"task_type", "uin", "modify_photo_status_req", "exts"}, new Object[]{0, "", null, null}, QZonePhotoDegrade$TaskConsumerReq.class);
    public final PBEnumField task_type = PBField.initEnum(0);
    public final PBStringField uin = PBField.initString("");
    public QZonePhotoDegrade$ModifyPhotoStatusReq modify_photo_status_req = new MessageMicro<QZonePhotoDegrade$ModifyPhotoStatusReq>() { // from class: qzone.QZonePhotoDegrade$ModifyPhotoStatusReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"status", "time_period"}, new Object[]{0, null}, QZonePhotoDegrade$ModifyPhotoStatusReq.class);
        public final PBEnumField status = PBField.initEnum(0);
        public QZonePhotoDegrade$TimePeriod time_period = new QZonePhotoDegrade$TimePeriod();
    };
    public QZonePhotoDegrade$ExtInfo exts = new MessageMicro<QZonePhotoDegrade$ExtInfo>() { // from class: qzone.QZonePhotoDegrade$ExtInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField key;
        public final PBBytesField value;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{byteStringMicro, byteStringMicro}, QZonePhotoDegrade$ExtInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.key = PBField.initBytes(byteStringMicro);
            this.value = PBField.initBytes(byteStringMicro);
        }
    };
}
