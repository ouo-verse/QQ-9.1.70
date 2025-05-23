package tencent.im.group_pro_proto.channel_share;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ChannelShareRequest$FeedParam extends MessageMicro<ChannelShareRequest$FeedParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"feed_id", AlbumCacheData.CREATE_TIME, "poster_tiny_id"}, new Object[]{"", 0L, 0L}, ChannelShareRequest$FeedParam.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBUInt64Field poster_tiny_id = PBField.initUInt64(0);
}
