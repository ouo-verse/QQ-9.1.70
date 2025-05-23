package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloTeamQueryQrcodeRsp extends MessageMicro<YoloTeamOuterClass$YoloTeamQueryQrcodeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"enter_condition", "status"}, new Object[]{null, 0}, YoloTeamOuterClass$YoloTeamQueryQrcodeRsp.class);
    public YoloTeamOuterClass$YoloTeamEnterCondition enter_condition = new YoloTeamOuterClass$YoloTeamEnterCondition();
    public final PBInt32Field status = PBField.initInt32(0);
}
