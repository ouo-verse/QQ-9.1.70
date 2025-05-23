package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes30.dex */
public final class CfmDataOuterClass$CFMParamChangeEvent extends MessageMicro<CfmDataOuterClass$CFMParamChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"change_reason", "game_mode", "map_id", "private_status", "match_module"}, new Object[]{1, 0, 0, 0, 0}, CfmDataOuterClass$CFMParamChangeEvent.class);
    public final PBEnumField change_reason = PBField.initEnum(1);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBInt32Field map_id = PBField.initInt32(0);
    public final PBInt32Field private_status = PBField.initInt32(0);
    public final PBInt32Field match_module = PBField.initInt32(0);
}
