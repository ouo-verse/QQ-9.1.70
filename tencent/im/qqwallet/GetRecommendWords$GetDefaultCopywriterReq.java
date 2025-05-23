package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecommendWords$GetDefaultCopywriterReq extends MessageMicro<GetRecommendWords$GetDefaultCopywriterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"subchannel", "fromtype"}, new Object[]{0, 0}, GetRecommendWords$GetDefaultCopywriterReq.class);
    public final PBEnumField subchannel = PBField.initEnum(0);
    public final PBInt32Field fromtype = PBField.initInt32(0);
}
