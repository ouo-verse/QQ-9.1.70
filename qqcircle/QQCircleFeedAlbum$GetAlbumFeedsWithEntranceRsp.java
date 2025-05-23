package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumFeedsWithEntranceRsp extends MessageMicro<QQCircleFeedAlbum$GetAlbumFeedsWithEntranceRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public QQCircleFeedAlbum$AlbumInfo album_info = new QQCircleFeedAlbum$AlbumInfo();
    public final PBRepeatMessageField<QQCircleFeedAlbum$FeedItem> feed_items = PBField.initRepeatMessage(QQCircleFeedAlbum$FeedItem.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField has_more_next_feed = PBField.initBool(false);
    public final PBBoolField has_more_previous_feed = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"album_info", "feed_items", "attach_info", "has_more_next_feed", "has_more_previous_feed"}, new Object[]{null, null, "", bool, bool}, QQCircleFeedAlbum$GetAlbumFeedsWithEntranceRsp.class);
    }
}
