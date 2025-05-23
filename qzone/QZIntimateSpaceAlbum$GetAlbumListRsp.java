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
public final class QZIntimateSpaceAlbum$GetAlbumListRsp extends MessageMicro<QZIntimateSpaceAlbum$GetAlbumListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<QZoneBaseAlbumMeta$AlbumInfo> album_list = PBField.initRepeatMessage(QZoneBaseAlbumMeta$AlbumInfo.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBBoolField enable_sync_from_qzone = PBField.initBool(false);
    public final PBUInt32Field album_num = PBField.initUInt32(0);
    public QZIntimateSpaceAlbum$AlbumCommData comm_data = new QZIntimateSpaceAlbum$AlbumCommData();
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();

    static {
        String[] strArr = {"album_list", "attach_info", PictureConst.KEY_HAS_MORE, "enable_sync_from_qzone", "album_num", "comm_data", "ext"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58}, strArr, new Object[]{null, "", bool, bool, 0, null, null}, QZIntimateSpaceAlbum$GetAlbumListRsp.class);
    }
}
