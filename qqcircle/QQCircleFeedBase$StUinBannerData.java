package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StUinBannerData extends MessageMicro<QQCircleFeedBase$StUinBannerData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"text", WadlProxyConsts.KEY_JUMP_URL, "userList"}, new Object[]{"", "", null}, QQCircleFeedBase$StUinBannerData.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userList = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
}
