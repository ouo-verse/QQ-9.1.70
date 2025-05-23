package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumFeedExplicitReq extends MessageMicro<QQCircleFeedAlbum$GetAlbumFeedExplicitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"album_feed_sign"}, new Object[]{null}, QQCircleFeedAlbum$GetAlbumFeedExplicitReq.class);
    public final PBRepeatMessageField<QQCircleFeedAlbum$AlbumFeedSign> album_feed_sign = PBField.initRepeatMessage(QQCircleFeedAlbum$AlbumFeedSign.class);
}
