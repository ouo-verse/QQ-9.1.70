package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFriendFeedMomentReader$SsoReadRsp extends MessageMicro<QQCircleFriendFeedMomentReader$SsoReadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, QQCircleFriendFeedMomentReader$SsoReadRsp.class);
    public final PBRepeatMessageField<QQCircleFriendFeedMomentReader$Item> items = PBField.initRepeatMessage(QQCircleFriendFeedMomentReader$Item.class);
}
