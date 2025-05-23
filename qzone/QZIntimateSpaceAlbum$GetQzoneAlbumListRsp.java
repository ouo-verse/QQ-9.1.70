package qzone;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$GetQzoneAlbumListRsp extends MessageMicro<QZIntimateSpaceAlbum$GetQzoneAlbumListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"album_list", "attach_info", PictureConst.KEY_HAS_MORE, "album_num", "comm_data", "ext"}, new Object[]{null, "", Boolean.FALSE, 0, null, null}, QZIntimateSpaceAlbum$GetQzoneAlbumListRsp.class);
    public final PBRepeatMessageField<QZoneBaseAlbumMeta$AlbumInfo> album_list = PBField.initRepeatMessage(QZoneBaseAlbumMeta$AlbumInfo.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBUInt32Field album_num = PBField.initUInt32(0);
    public QZIntimateSpaceAlbum$AlbumCommData comm_data = new QZIntimateSpaceAlbum$AlbumCommData();
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
}
