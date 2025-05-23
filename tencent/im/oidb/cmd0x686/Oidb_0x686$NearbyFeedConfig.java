package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x686$NearbyFeedConfig extends MessageMicro<Oidb_0x686$NearbyFeedConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"uint32_publish_feed_min_level", "str_publish_feed_tips", "str_unable_publish_feed_tips", "uint32_publish_comment_min_level", "str_unable_publish_comment_tips"}, new Object[]{0, "", "", 0, ""}, Oidb_0x686$NearbyFeedConfig.class);
    public final PBUInt32Field uint32_publish_feed_min_level = PBField.initUInt32(0);
    public final PBStringField str_publish_feed_tips = PBField.initString("");
    public final PBStringField str_unable_publish_feed_tips = PBField.initString("");
    public final PBUInt32Field uint32_publish_comment_min_level = PBField.initUInt32(0);
    public final PBStringField str_unable_publish_comment_tips = PBField.initString("");
}
