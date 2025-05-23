package qqcircle;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumsRsp extends MessageMicro<QQCircleFeedAlbum$GetAlbumsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"album_info", PictureConst.KEY_HAS_MORE, "attach_info", "total"}, new Object[]{null, Boolean.FALSE, "", 0}, QQCircleFeedAlbum$GetAlbumsRsp.class);
    public final PBRepeatMessageField<QQCircleFeedAlbum$AlbumInfo> album_info = PBField.initRepeatMessage(QQCircleFeedAlbum$AlbumInfo.class);
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt32Field total = PBField.initInt32(0);
}
