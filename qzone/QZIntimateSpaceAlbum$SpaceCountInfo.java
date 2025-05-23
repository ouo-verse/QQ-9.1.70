package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$SpaceCountInfo extends MessageMicro<QZIntimateSpaceAlbum$SpaceCountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"space_id", "album_count", "medias_count"}, new Object[]{"", 0L, 0L}, QZIntimateSpaceAlbum$SpaceCountInfo.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBUInt64Field album_count = PBField.initUInt64(0);
    public final PBUInt64Field medias_count = PBField.initUInt64(0);
}
