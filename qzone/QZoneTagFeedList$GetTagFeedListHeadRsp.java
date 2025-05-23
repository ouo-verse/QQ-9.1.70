package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneTagFeedList$GetTagFeedListHeadRsp extends MessageMicro<QZoneTagFeedList$GetTagFeedListHeadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 90, 98, 106, 114, 120}, new String[]{"tag_id", "tag_name", "corner_tag_type", "popularity", "tag_image", "tag_cover", "publish_button", "shareinfo", "opmasks", "tag_intro", "tag_uin", "tag_cover_dark_mode", "corner_tag_text_color", "corner_tag_background_color", "is_operation_tag"}, new Object[]{"", "", "", null, "", "", null, null, 0, "", "", "", "", "", Boolean.FALSE}, QZoneTagFeedList$GetTagFeedListHeadRsp.class);
    public final PBStringField tag_id = PBField.initString("");
    public final PBStringField tag_name = PBField.initString("");
    public final PBStringField corner_tag_type = PBField.initString("");
    public QZoneTagFeedList$PopularityInfo popularity = new QZoneTagFeedList$PopularityInfo();
    public final PBStringField tag_image = PBField.initString("");
    public final PBStringField tag_cover = PBField.initString("");
    public QZoneBaseMeta$StButton publish_button = new QZoneBaseMeta$StButton();
    public QZoneTagFeedList$ShareTagInfo shareinfo = new QZoneTagFeedList$ShareTagInfo();
    public final PBRepeatField<Integer> opmasks = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBStringField tag_intro = PBField.initString("");
    public final PBStringField tag_uin = PBField.initString("");
    public final PBStringField tag_cover_dark_mode = PBField.initString("");
    public final PBStringField corner_tag_text_color = PBField.initString("");
    public final PBStringField corner_tag_background_color = PBField.initString("");
    public final PBBoolField is_operation_tag = PBField.initBool(false);
}
