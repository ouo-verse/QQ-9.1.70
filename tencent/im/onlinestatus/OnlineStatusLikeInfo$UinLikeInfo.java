package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$UinLikeInfo extends MessageMicro<OnlineStatusLikeInfo$UinLikeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "like_items"}, new Object[]{0L, null}, OnlineStatusLikeInfo$UinLikeInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<OnlineStatusLikeInfo$LikeItem> like_items = PBField.initRepeatMessage(OnlineStatusLikeInfo$LikeItem.class);
}
