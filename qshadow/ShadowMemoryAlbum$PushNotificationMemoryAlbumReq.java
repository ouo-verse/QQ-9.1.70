package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class ShadowMemoryAlbum$PushNotificationMemoryAlbumReq extends MessageMicro<ShadowMemoryAlbum$PushNotificationMemoryAlbumReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"jump_url", "content"}, new Object[]{"", ""}, ShadowMemoryAlbum$PushNotificationMemoryAlbumReq.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField content = PBField.initString("");
}
