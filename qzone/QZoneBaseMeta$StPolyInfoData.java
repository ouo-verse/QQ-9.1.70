package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StPolyInfoData extends MessageMicro<QZoneBaseMeta$StPolyInfoData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info"}, new Object[]{null}, QZoneBaseMeta$StPolyInfoData.class);
    public QZoneBaseMeta$StPolyLike info = new MessageMicro<QZoneBaseMeta$StPolyLike>() { // from class: qzone.QZoneBaseMeta$StPolyLike
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56, 66, 74, 82, 90, 98, 106}, new String[]{"poly_like_id", "article_type", "poly_name", "poly_source", "poly_icon_url", "poly_under_pic_url", "price", "busi_data", "full_screen_url", "full_screen_url_and", "poly_txt_color", "poly_under_color", "dynamic_pic_url"}, new Object[]{"", 0, "", "", "", "", 0, ByteStringMicro.EMPTY, "", "", "", "", ""}, QZoneBaseMeta$StPolyLike.class);
        public final PBStringField poly_like_id = PBField.initString("");
        public final PBEnumField article_type = PBField.initEnum(0);
        public final PBStringField poly_name = PBField.initString("");
        public final PBStringField poly_source = PBField.initString("");
        public final PBStringField poly_icon_url = PBField.initString("");
        public final PBStringField poly_under_pic_url = PBField.initString("");
        public final PBUInt32Field price = PBField.initUInt32(0);
        public final PBBytesField busi_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField full_screen_url = PBField.initString("");
        public final PBStringField full_screen_url_and = PBField.initString("");
        public final PBStringField poly_txt_color = PBField.initString("");
        public final PBStringField poly_under_color = PBField.initString("");
        public final PBStringField dynamic_pic_url = PBField.initString("");
    };
}
