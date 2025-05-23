package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$UserActivityInfo extends MessageMicro<QzoneActivityPB$UserActivityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 34, 42, 50, 58, 66, 74, 80, 88, 98, 106, 114}, new String[]{"activity_state", "res_infos", "nickname_res_info", "cover_res_info", "text_res_info", "dragon_res_info", "fire_res_info", "grade", "badge_type", "list_badge", "three_layer_badge", "fusion_badge"}, new Object[]{0, null, null, null, null, null, null, 0, 0, null, null, null}, QzoneActivityPB$UserActivityInfo.class);
    public final PBUInt32Field activity_state = PBField.initUInt32(0);
    public final PBRepeatMessageField<QzoneActivityPB$ResourceInfo> res_infos = PBField.initRepeatMessage(QzoneActivityPB$ResourceInfo.class);
    public QzoneActivityPB$ResourceInfo nickname_res_info = new QzoneActivityPB$ResourceInfo();
    public QzoneActivityPB$ResourceInfo cover_res_info = new QzoneActivityPB$ResourceInfo();
    public QzoneActivityPB$ResourceInfo text_res_info = new QzoneActivityPB$ResourceInfo();
    public final PBUInt32Field grade = PBField.initUInt32(0);
    public final PBUInt32Field badge_type = PBField.initUInt32(0);
    public QzoneActivityPB$ResourceInfo dragon_res_info = new QzoneActivityPB$ResourceInfo();
    public QzoneActivityPB$ListBadgeResInfo list_badge = new MessageMicro<QzoneActivityPB$ListBadgeResInfo>() { // from class: qzone.QzoneActivityPB$ListBadgeResInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"list", "jump_url"}, new Object[]{null, ""}, QzoneActivityPB$ListBadgeResInfo.class);
        public final PBRepeatMessageField<QzoneActivityPB$ResourceInfo> list = PBField.initRepeatMessage(QzoneActivityPB$ResourceInfo.class);
        public final PBStringField jump_url = PBField.initString("");
    };
    public QzoneActivityPB$ThreeLayerBadgeResInfo three_layer_badge = new MessageMicro<QzoneActivityPB$ThreeLayerBadgeResInfo>() { // from class: qzone.QzoneActivityPB$ThreeLayerBadgeResInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bottom", "middle", "top", "jump_url"}, new Object[]{null, null, null, ""}, QzoneActivityPB$ThreeLayerBadgeResInfo.class);
        public QzoneActivityPB$ResourceInfo bottom = new QzoneActivityPB$ResourceInfo();
        public final PBRepeatMessageField<QzoneActivityPB$ResourceInfo> middle = PBField.initRepeatMessage(QzoneActivityPB$ResourceInfo.class);
        public QzoneActivityPB$ResourceInfo top = new QzoneActivityPB$ResourceInfo();
        public final PBStringField jump_url = PBField.initString("");
    };
    public QzoneActivityPB$ResourceInfo fusion_badge = new QzoneActivityPB$ResourceInfo();
    public QzoneActivityPB$ResourceInfo fire_res_info = new QzoneActivityPB$ResourceInfo();
}
