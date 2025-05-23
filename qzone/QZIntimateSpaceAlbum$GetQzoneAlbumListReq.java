package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$GetQzoneAlbumListReq extends MessageMicro<QZIntimateSpaceAlbum$GetQzoneAlbumListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"attach_info", "space_id"}, new Object[]{"", ""}, QZIntimateSpaceAlbum$GetQzoneAlbumListReq.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBStringField space_id = PBField.initString("");
}
