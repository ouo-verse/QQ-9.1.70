package qqcircle;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumFeedsRsp extends MessageMicro<QQCircleFeedAlbum$GetAlbumFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"album_info", "feed_items", "attach_info", PictureConst.KEY_HAS_MORE}, new Object[]{null, null, "", Boolean.FALSE}, QQCircleFeedAlbum$GetAlbumFeedsRsp.class);
    public QQCircleFeedAlbum$AlbumInfo album_info = new QQCircleFeedAlbum$AlbumInfo();
    public final PBRepeatMessageField<QQCircleFeedAlbum$FeedItem> feed_items = PBField.initRepeatMessage(QQCircleFeedAlbum$FeedItem.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField has_more = PBField.initBool(false);
}
