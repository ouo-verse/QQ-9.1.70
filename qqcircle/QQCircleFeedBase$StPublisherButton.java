package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import feedcloud.FeedCloudCommon$Entry;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StPublisherButton extends MessageMicro<QQCircleFeedBase$StPublisherButton> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 7994}, new String[]{"title", WadlProxyConsts.KEY_JUMP_URL, "fontColor", "bgColor", MiniBoxNoticeInfo.KEY_ICON_URL, "extInfo"}, new Object[]{"", "", "", "", "", null}, QQCircleFeedBase$StPublisherButton.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField fontColor = PBField.initString("");
    public final PBStringField bgColor = PBField.initString("");
    public final PBStringField iconURL = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> extInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
