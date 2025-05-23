package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloTeamDestroyReq extends MessageMicro<YoloTeamOuterClass$YoloTeamDestroyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"team_id"}, new Object[]{0L}, YoloTeamOuterClass$YoloTeamDestroyReq.class);
    public final PBUInt64Field team_id = PBField.initUInt64(0);
}
