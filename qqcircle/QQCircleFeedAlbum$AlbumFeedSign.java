package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$AlbumFeedSign extends MessageMicro<QQCircleFeedAlbum$AlbumFeedSign> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "feed_sign"}, new Object[]{0L, null}, QQCircleFeedAlbum$AlbumFeedSign.class);
    public final PBUInt64Field album_id = PBField.initUInt64(0);
    public QQCircleFeedAlbum$FeedSign feed_sign = new QQCircleFeedAlbum$FeedSign();
}
