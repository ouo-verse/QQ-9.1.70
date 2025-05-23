package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp extends MessageMicro<QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"space_list", "ext"}, new Object[]{null, null}, QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp.class);
    public final PBRepeatMessageField<QZIntimateSpaceAlbum$AlbumSpaceInfo> space_list = PBField.initRepeatMessage(QZIntimateSpaceAlbum$AlbumSpaceInfo.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
}
