package qshadow;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCList$FeedInfo extends MessageMicro<ShadowAIGCList$FeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 74, 82, 90, 98, 104, 112, 122}, new String[]{"img_trace_id", "feed_id", "prompt", "aigc_img_url", "aigc_img_share_url", "feed_status", "busi_id", "style", "feed_jump_schema", "contest_info", "uid", "publish_time", QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "img_size_type", "aigc_img_croped_url"}, new Object[]{"", "", "", "", "", 0, "", "", "", null, "", "", 0, 0, ""}, ShadowAIGCList$FeedInfo.class);
    public final PBStringField img_trace_id = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField aigc_img_url = PBField.initString("");
    public final PBStringField aigc_img_share_url = PBField.initString("");
    public final PBEnumField feed_status = PBField.initEnum(0);
    public final PBStringField busi_id = PBField.initString("");
    public final PBStringField style = PBField.initString("");
    public final PBStringField feed_jump_schema = PBField.initString("");
    public ShadowAIGCList$ContestInfo contest_info = new MessageMicro<ShadowAIGCList$ContestInfo>() { // from class: qshadow.ShadowAIGCList$ContestInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"name", "rank", "id", "icon_url"}, new Object[]{"", 0, "", ""}, ShadowAIGCList$ContestInfo.class);
        public final PBStringField name = PBField.initString("");
        public final PBInt32Field rank = PBField.initInt32(0);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f429488id = PBField.initString("");
        public final PBStringField icon_url = PBField.initString("");
    };
    public final PBStringField uid = PBField.initString("");
    public final PBStringField publish_time = PBField.initString("");
    public final PBEnumField source_type = PBField.initEnum(0);
    public final PBEnumField img_size_type = PBField.initEnum(0);
    public final PBStringField aigc_img_croped_url = PBField.initString("");
}
