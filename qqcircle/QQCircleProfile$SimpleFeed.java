package qqcircle;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$SimpleFeed extends MessageMicro<QQCircleProfile$SimpleFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"uid", "feed_id", AlbumCacheData.CREATE_TIME}, new Object[]{"", "", 0L}, QQCircleProfile$SimpleFeed.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
}
