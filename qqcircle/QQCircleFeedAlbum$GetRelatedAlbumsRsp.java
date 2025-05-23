package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetRelatedAlbumsRsp extends MessageMicro<QQCircleFeedAlbum$GetRelatedAlbumsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"feed_info", "is_finish", "attach_info", "last_feed"}, new Object[]{null, 0, "", null}, QQCircleFeedAlbum$GetRelatedAlbumsRsp.class);
    public final PBRepeatMessageField<QQCircleFeedAlbum$StVideoAlbumFeedInfo> feed_info = PBField.initRepeatMessage(QQCircleFeedAlbum$StVideoAlbumFeedInfo.class);
    public final PBUInt32Field is_finish = PBField.initUInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public QQCircleFeedAlbum$StFeedDetail last_feed = new QQCircleFeedAlbum$StFeedDetail();
}
