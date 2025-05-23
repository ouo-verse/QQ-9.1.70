package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameAutoUpdateTask$CircleGameConfig extends MessageMicro<QQGameAutoUpdateTask$CircleGameConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"has_new_version", "next_time", "circle_start_time", "circle_end_time", "circle_gap_duration"}, new Object[]{Boolean.FALSE, 0L, 0L, 0L, 0L}, QQGameAutoUpdateTask$CircleGameConfig.class);
    public final PBBoolField has_new_version = PBField.initBool(false);
    public final PBInt64Field next_time = PBField.initInt64(0);
    public final PBInt64Field circle_start_time = PBField.initInt64(0);
    public final PBInt64Field circle_end_time = PBField.initInt64(0);
    public final PBInt64Field circle_gap_duration = PBField.initInt64(0);
}
