package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$DeleteMediasReq extends MessageMicro<QZIntimateSpaceAlbum$DeleteMediasReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"space_id", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "media_list"}, new Object[]{"", "", null}, QZIntimateSpaceAlbum$DeleteMediasReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField album_id = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StMedia> media_list = PBField.initRepeatMessage(QZoneBaseMeta$StMedia.class);
}
