package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$AlbumSpaceInfo extends MessageMicro<QZIntimateSpaceAlbum$AlbumSpaceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"album_list", "space_id", "desc", "users", "space_type"}, new Object[]{null, "", "", null, 0}, QZIntimateSpaceAlbum$AlbumSpaceInfo.class);
    public QZIntimateSpaceAlbum$GetAlbumListRsp album_list = new QZIntimateSpaceAlbum$GetAlbumListRsp();
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> users = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBEnumField space_type = PBField.initEnum(0);
}
