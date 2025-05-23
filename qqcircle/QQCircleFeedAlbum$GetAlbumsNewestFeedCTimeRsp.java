package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumsNewestFeedCTimeRsp extends MessageMicro<QQCircleFeedAlbum$GetAlbumsNewestFeedCTimeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"albums_newest_feed_ctime"}, new Object[]{null}, QQCircleFeedAlbum$GetAlbumsNewestFeedCTimeRsp.class);
    public final PBRepeatMessageField<QQCircleFeedAlbum$AlbumNewestFeedCTimeEntry> albums_newest_feed_ctime = PBField.initRepeatMessage(QQCircleFeedAlbum$AlbumNewestFeedCTimeEntry.class);
}
