package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$FollowRecommendFeedsInfo extends MessageMicro<oidb_cmd0x8c8$FollowRecommendFeedsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 88, 96, 104, 112, 120, 128}, new String[]{"uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "uint32_biu_count", "uint32_myself_follow_status", "uint32_follow_counts"}, new Object[]{0L, 0, 0L, 0, 0, 0, 0, 0, 0}, oidb_cmd0x8c8$FollowRecommendFeedsInfo.class);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
}
