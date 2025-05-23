package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicLike$SubCmd_FeedsItem_ReqInfo_Like extends MessageMicro<DynamicLike$SubCmd_FeedsItem_ReqInfo_Like> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"LikeList"}, new Object[]{null}, DynamicLike$SubCmd_FeedsItem_ReqInfo_Like.class);
    public final PBRepeatMessageField<DynamicLike$FeedsItem_Like> LikeList = PBField.initRepeatMessage(DynamicLike$FeedsItem_Like.class);
}
