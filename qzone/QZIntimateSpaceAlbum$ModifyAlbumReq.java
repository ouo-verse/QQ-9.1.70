package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$ModifyAlbumReq extends MessageMicro<QZIntimateSpaceAlbum$ModifyAlbumReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"album_info", "mask"}, new Object[]{null, 0}, QZIntimateSpaceAlbum$ModifyAlbumReq.class);
    public QZoneBaseAlbumMeta$AlbumInfo album_info = new QZoneBaseAlbumMeta$AlbumInfo();
    public final PBRepeatField<Integer> mask = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
