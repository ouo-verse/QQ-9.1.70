package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$CreateAlbumReq extends MessageMicro<QQCircleFeedAlbum$CreateAlbumReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"album_info", "feed_signs", "draft_album"}, new Object[]{null, null, Boolean.FALSE}, QQCircleFeedAlbum$CreateAlbumReq.class);
    public QQCircleFeedAlbum$AlbumInfo album_info = new QQCircleFeedAlbum$AlbumInfo();
    public final PBRepeatMessageField<QQCircleFeedAlbum$FeedSign> feed_signs = PBField.initRepeatMessage(QQCircleFeedAlbum$FeedSign.class);
    public final PBBoolField draft_album = PBField.initBool(false);
}
