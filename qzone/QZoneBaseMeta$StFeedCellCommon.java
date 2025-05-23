package qzone;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import s4.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeedCellCommon extends MessageMicro<QZoneBaseMeta$StFeedCellCommon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 66, 74, 82, 90, 96, 104, 114, 122, 128, 136}, new String[]{"app_id", "sub_id", "time", "feed_id", "cur_like_key", QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "client_key", ReportDataBuilder.KEY_EXTEND_INFO, c.UGCKEY, "unused_str", QCircleDaTongConstant.ElementParamValue.PERMISSION, QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_sub_type", "ext_info", "union_id", "feed_biz_type", "feature_flag"}, new Object[]{0, 0, 0L, "", "", 0, "", null, "", "", null, 0, 0, ByteStringMicro.EMPTY, null, 0, 0}, QZoneBaseMeta$StFeedCellCommon.class);
    public final PBInt32Field app_id = PBField.initInt32(0);
    public final PBInt32Field sub_id = PBField.initInt32(0);
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField cur_like_key = PBField.initString("");
    public final PBEnumField biz_id = PBField.initEnum(0);
    public final PBStringField client_key = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseCommon$BytesEntry> extend_info = PBField.initRepeatMessage(QZoneBaseCommon$BytesEntry.class);
    public final PBStringField ugckey = PBField.initString("");
    public final PBStringField unused_str = PBField.initString("");
    public QZoneBaseMeta$AccessPermission permission = new MessageMicro<QZoneBaseMeta$AccessPermission>() { // from class: qzone.QZoneBaseMeta$AccessPermission
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"permission_type"}, new Object[]{0}, QZoneBaseMeta$AccessPermission.class);
        public final PBEnumField permission_type = PBField.initEnum(0);
    };
    public final PBEnumField feed_type = PBField.initEnum(0);
    public final PBEnumField feed_sub_type = PBField.initEnum(0);
    public final PBBytesField ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public QZoneBaseMeta$UnionID union_id = new MessageMicro<QZoneBaseMeta$UnionID>() { // from class: qzone.QZoneBaseMeta$UnionID
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"uf_key", "ugc_id", "feed_id", "ext_ids"}, new Object[]{"", "", "", null}, QZoneBaseMeta$UnionID.class);
        public final PBStringField uf_key = PBField.initString("");
        public final PBStringField ugc_id = PBField.initString("");
        public final PBStringField feed_id = PBField.initString("");
        public final PBRepeatMessageField<QZoneBaseMeta$UnionExtID> ext_ids = PBField.initRepeatMessage(QZoneBaseMeta$UnionExtID.class);
    };
    public final PBUInt32Field feed_biz_type = PBField.initUInt32(0);
    public final PBInt32Field feature_flag = PBField.initInt32(0);
}
