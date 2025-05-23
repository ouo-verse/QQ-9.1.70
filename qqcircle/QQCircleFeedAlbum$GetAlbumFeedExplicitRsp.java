package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumFeedExplicitRsp extends MessageMicro<QQCircleFeedAlbum$GetAlbumFeedExplicitRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"albums"}, new Object[]{null}, QQCircleFeedAlbum$GetAlbumFeedExplicitRsp.class);
    public final PBRepeatMessageField<QQCircleFeedAlbum$AlbumInfoWithFeed> albums = PBField.initRepeatMessage(QQCircleFeedAlbum$AlbumInfoWithFeed.class);
}
