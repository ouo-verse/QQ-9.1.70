package qqcircle;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$FeedSign extends MessageMicro<QQCircleFeedAlbum$FeedSign> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"id", "poster_id", AlbumCacheData.CREATE_TIME, "source_index"}, new Object[]{"", "", 0L, 0}, QQCircleFeedAlbum$FeedSign.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429304id = PBField.initString("");
    public final PBStringField poster_id = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBInt32Field source_index = PBField.initInt32(0);
}
