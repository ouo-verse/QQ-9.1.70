package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloCfmRoomParams extends MessageMicro<YoloRoomOuterClass$YoloCfmRoomParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"play_mode", "map_id", "match_type", "mode_type"}, new Object[]{0, 0, 0, 0}, YoloRoomOuterClass$YoloCfmRoomParams.class);
    public final PBInt32Field play_mode = PBField.initInt32(0);
    public final PBInt32Field map_id = PBField.initInt32(0);
    public final PBInt32Field match_type = PBField.initInt32(0);
    public final PBInt32Field mode_type = PBField.initInt32(0);
}
