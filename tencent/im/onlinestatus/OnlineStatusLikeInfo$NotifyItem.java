package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$NotifyItem extends MessageMicro<OnlineStatusLikeInfo$NotifyItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50}, new String[]{"business_type", "uin", "time", "like_items", "scene", "self_like_items"}, new Object[]{0, 0L, 0L, null, 0, null}, OnlineStatusLikeInfo$NotifyItem.class);
    public final PBUInt32Field business_type = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field time = PBField.initUInt64(0);
    public final PBRepeatMessageField<OnlineStatusLikeInfo$LikeItem> like_items = PBField.initRepeatMessage(OnlineStatusLikeInfo$LikeItem.class);
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public final PBRepeatMessageField<OnlineStatusLikeInfo$LikeItem> self_like_items = PBField.initRepeatMessage(OnlineStatusLikeInfo$LikeItem.class);
}
