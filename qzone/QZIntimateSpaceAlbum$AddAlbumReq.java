package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$AddAlbumReq extends MessageMicro<QZIntimateSpaceAlbum$AddAlbumReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"album_info", "clock_time"}, new Object[]{null, 0}, QZIntimateSpaceAlbum$AddAlbumReq.class);
    public QZoneBaseAlbumMeta$AlbumInfo album_info = new QZoneBaseAlbumMeta$AlbumInfo();
    public final PBUInt32Field clock_time = PBField.initUInt32(0);
}
