package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecommendWords$GetClassifyReq extends MessageMicro<GetRecommendWords$GetClassifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"subchannel", "ver"}, new Object[]{0, 0}, GetRecommendWords$GetClassifyReq.class);
    public final PBInt32Field subchannel = PBField.initInt32(0);
    public final PBInt32Field ver = PBField.initInt32(0);
}
