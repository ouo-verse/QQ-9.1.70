package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$AlbumCommData extends MessageMicro<QZIntimateSpaceAlbum$AlbumCommData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_member", "empty_message"}, new Object[]{Boolean.FALSE, ""}, QZIntimateSpaceAlbum$AlbumCommData.class);
    public final PBBoolField is_member = PBField.initBool(false);
    public final PBStringField empty_message = PBField.initString("");
}
