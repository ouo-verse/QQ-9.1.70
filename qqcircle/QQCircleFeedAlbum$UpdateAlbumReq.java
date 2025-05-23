package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$UpdateAlbumReq extends MessageMicro<QQCircleFeedAlbum$UpdateAlbumReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"filter", "album_info", "feed_rerank_info"}, new Object[]{null, null, null}, QQCircleFeedAlbum$UpdateAlbumReq.class);
    public QQCircleFeedAlbum$UpdateAlbumReqFilter filter = new MessageMicro<QQCircleFeedAlbum$UpdateAlbumReqFilter>() { // from class: qqcircle.QQCircleFeedAlbum$UpdateAlbumReqFilter
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField UpdateAlbumInfo = PBField.initBool(false);
        public final PBBoolField UpdateAlbumFeeds = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"UpdateAlbumInfo", "UpdateAlbumFeeds"}, new Object[]{bool, bool}, QQCircleFeedAlbum$UpdateAlbumReqFilter.class);
        }
    };
    public QQCircleFeedAlbum$AlbumInfo album_info = new QQCircleFeedAlbum$AlbumInfo();
    public QQCircleFeedAlbum$FeedRerankInfo feed_rerank_info = new MessageMicro<QQCircleFeedAlbum$FeedRerankInfo>() { // from class: qqcircle.QQCircleFeedAlbum$FeedRerankInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"interval_start_feed_sign", "interval_end_feed_sign", "feed_signs"}, new Object[]{null, null, null}, QQCircleFeedAlbum$FeedRerankInfo.class);
        public QQCircleFeedAlbum$FeedSign interval_start_feed_sign = new QQCircleFeedAlbum$FeedSign();
        public QQCircleFeedAlbum$FeedSign interval_end_feed_sign = new QQCircleFeedAlbum$FeedSign();
        public final PBRepeatMessageField<QQCircleFeedAlbum$FeedSign> feed_signs = PBField.initRepeatMessage(QQCircleFeedAlbum$FeedSign.class);
    };
}
