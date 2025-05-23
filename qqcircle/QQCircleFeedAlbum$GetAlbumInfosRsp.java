package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumInfosRsp extends MessageMicro<QQCircleFeedAlbum$GetAlbumInfosRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"album_infos"}, new Object[]{null}, QQCircleFeedAlbum$GetAlbumInfosRsp.class);
    public final PBRepeatMessageField<QQCircleFeedAlbum$AlbumInfoEntry> album_infos = PBField.initRepeatMessage(QQCircleFeedAlbum$AlbumInfoEntry.class);
}
