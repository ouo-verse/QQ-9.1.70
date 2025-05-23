package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$SearchText extends MessageMicro<QQCircleFeedBase$SearchText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 42}, new String[]{"text", "ext_info"}, new Object[]{"", null}, QQCircleFeedBase$SearchText.class);
    public final PBStringField text = PBField.initString("");
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
