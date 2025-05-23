package qzone;

import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneTagFeedList$ShareTagInfo extends MessageMicro<QZoneTagFeedList$ShareTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "share_pic", "sign_ark", "share_intro"}, new Object[]{"", "", "", ""}, QZoneTagFeedList$ShareTagInfo.class);
    public final PBStringField share_url = PBField.initString("");
    public final PBStringField share_pic = PBField.initString("");
    public final PBStringField sign_ark = PBField.initString("");
    public final PBStringField share_intro = PBField.initString("");
}
