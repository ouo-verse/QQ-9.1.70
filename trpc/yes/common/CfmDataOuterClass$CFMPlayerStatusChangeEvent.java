package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes30.dex */
public final class CfmDataOuterClass$CFMPlayerStatusChangeEvent extends MessageMicro<CfmDataOuterClass$CFMPlayerStatusChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"player_info", "player_status"}, new Object[]{null, 1}, CfmDataOuterClass$CFMPlayerStatusChangeEvent.class);
    public CfmDataOuterClass$CFMPlayerInfo player_info = new CfmDataOuterClass$CFMPlayerInfo();
    public final PBEnumField player_status = PBField.initEnum(1);
}
