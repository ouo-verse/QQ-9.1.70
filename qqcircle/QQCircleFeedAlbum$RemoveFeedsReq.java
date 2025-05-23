package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$RemoveFeedsReq extends MessageMicro<QQCircleFeedAlbum$RemoveFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feed_signs"}, new Object[]{null}, QQCircleFeedAlbum$RemoveFeedsReq.class);
    public final PBRepeatMessageField<QQCircleFeedAlbum$FeedSign> feed_signs = PBField.initRepeatMessage(QQCircleFeedAlbum$FeedSign.class);
}
