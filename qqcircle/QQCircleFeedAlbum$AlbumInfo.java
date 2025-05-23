package qqcircle;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$AlbumInfo extends MessageMicro<QQCircleFeedAlbum$AlbumInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88}, new String[]{"id", "title", "owner_id", "cover_url", "description", "version_number", AlbumCacheData.CREATE_TIME, "last_modified_time", "item_count", "status", "source"}, new Object[]{0L, "", "", "", "", 0L, 0L, 0L, 0L, 0, 0}, QQCircleFeedAlbum$AlbumInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f429303id = PBField.initUInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField owner_id = PBField.initString("");
    public final PBStringField cover_url = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBUInt64Field version_number = PBField.initUInt64(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field last_modified_time = PBField.initInt64(0);
    public final PBInt64Field item_count = PBField.initInt64(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBEnumField source = PBField.initEnum(0);
}
