package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class QsmDataOuterClass$QSMIDIPPlayerPerLadderMatch extends MessageMicro<QsmDataOuterClass$QSMIDIPPlayerPerLadderMatch> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field race_game_type = PBField.initUInt32(0);
    public final PBUInt32Field vehicle_id = PBField.initUInt32(0);
    public final PBUInt64Field match_timestamps = PBField.initUInt64(0);
    public final PBInt32Field score_delta = PBField.initInt32(0);
    public final PBUInt32Field complete_time = PBField.initUInt32(0);
    public final PBUInt32Field rank = PBField.initUInt32(0);
    public final PBBoolField win = PBField.initBool(false);
    public final PBBoolField mvp = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"race_game_type", "vehicle_id", "match_timestamps", "score_delta", "complete_time", "rank", "win", "mvp"}, new Object[]{0, 0, 0L, 0, 0, 0, bool, bool}, QsmDataOuterClass$QSMIDIPPlayerPerLadderMatch.class);
    }
}
