package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$AlbumInfoWithFeed extends MessageMicro<QQCircleFeedAlbum$AlbumInfoWithFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"album_info", "feeds"}, new Object[]{null, null}, QQCircleFeedAlbum$AlbumInfoWithFeed.class);
    public QQCircleFeedAlbum$AlbumInfo album_info = new QQCircleFeedAlbum$AlbumInfo();
    public final PBRepeatMessageField<QQCircleFeedAlbum$FeedItem> feeds = PBField.initRepeatMessage(QQCircleFeedAlbum$FeedItem.class);
}
