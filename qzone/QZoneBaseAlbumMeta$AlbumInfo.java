package qzone;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tenpay.sdk.util.QWSoterConstans;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseAlbumMeta$AlbumInfo extends MessageMicro<QZoneBaseAlbumMeta$AlbumInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 74, 82, 88, 96, 104}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "owner", "name", "desc", AlbumCacheData.CREATE_TIME, "modify_time", "last_upload_time", "upload_number", "cover", "creator", "top_flag", QWSoterConstans.CGI_KEY_BUSI_TYPE, "status"}, new Object[]{"", "", "", "", 0L, 0L, 0L, 0L, null, null, 0L, 0, 0}, QZoneBaseAlbumMeta$AlbumInfo.class);
    public final PBStringField album_id = PBField.initString("");
    public final PBStringField owner = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBUInt64Field modify_time = PBField.initUInt64(0);
    public final PBUInt64Field last_upload_time = PBField.initUInt64(0);
    public final PBUInt64Field upload_number = PBField.initUInt64(0);
    public QZoneBaseMeta$StMedia cover = new QZoneBaseMeta$StMedia();
    public QZoneBaseMeta$StUser creator = new QZoneBaseMeta$StUser();
    public final PBUInt64Field top_flag = PBField.initUInt64(0);
    public final PBEnumField busi_type = PBField.initEnum(0);
    public final PBEnumField status = PBField.initEnum(0);
}
