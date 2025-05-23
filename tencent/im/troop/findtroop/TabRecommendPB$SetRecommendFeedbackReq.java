package tencent.im.troop.findtroop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class TabRecommendPB$SetRecommendFeedbackReq extends MessageMicro<TabRecommendPB$SetRecommendFeedbackReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "id"}, new Object[]{0, ""}, TabRecommendPB$SetRecommendFeedbackReq.class);
    public final PBUInt32Field type = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f436057id = PBField.initString("");
}
