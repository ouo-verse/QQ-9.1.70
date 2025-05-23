package qzone;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$AddAlbumRsp extends MessageMicro<QZIntimateSpaceAlbum$AddAlbumRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"album_info", "ext"}, new Object[]{null, null}, QZIntimateSpaceAlbum$AddAlbumRsp.class);
    public QZoneBaseAlbumMeta$AlbumInfo album_info = new QZoneBaseAlbumMeta$AlbumInfo();
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
}
