package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$GetMediasListRsp extends MessageMicro<QZIntimateSpaceAlbum$GetMediasListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<QZoneBaseAlbumMeta$BatchInfo> batch_list = PBField.initRepeatMessage(QZoneBaseAlbumMeta$BatchInfo.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StMedia> medias = PBField.initRepeatMessage(QZoneBaseMeta$StMedia.class);
    public QZoneBaseAlbumMeta$AlbumInfo album_info = new QZoneBaseAlbumMeta$AlbumInfo();
    public QZIntimateSpaceAlbum$AlbumCommData comm_data = new QZIntimateSpaceAlbum$AlbumCommData();
    public final PBStringField prev_attach_info = PBField.initString("");
    public final PBStringField next_attach_info = PBField.initString("");
    public final PBBoolField prev_has_more = PBField.initBool(false);
    public final PBBoolField next_has_more = PBField.initBool(false);
    public final PBUInt32Field medias_index = PBField.initUInt32(0);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72, 82}, new String[]{"batch_list", "medias", "album_info", "comm_data", "prev_attach_info", "next_attach_info", "prev_has_more", "next_has_more", "medias_index", "ext"}, new Object[]{null, null, null, null, "", "", bool, bool, 0, null}, QZIntimateSpaceAlbum$GetMediasListRsp.class);
    }
}
