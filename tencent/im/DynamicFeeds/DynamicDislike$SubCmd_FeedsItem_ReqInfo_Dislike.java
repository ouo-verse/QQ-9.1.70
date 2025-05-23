package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicDislike$SubCmd_FeedsItem_ReqInfo_Dislike extends MessageMicro<DynamicDislike$SubCmd_FeedsItem_ReqInfo_Dislike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"DislikeList"}, new Object[]{null}, DynamicDislike$SubCmd_FeedsItem_ReqInfo_Dislike.class);
    public final PBRepeatMessageField<DynamicDislike$FeedsItem_Dislike> DislikeList = PBField.initRepeatMessage(DynamicDislike$FeedsItem_Dislike.class);
}
