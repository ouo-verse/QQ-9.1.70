package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$CheckAudioHasMusicRsp extends MessageMicro<QQCircleSmartMatchMusic$CheckAudioHasMusicRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"has_music"}, new Object[]{Boolean.FALSE}, QQCircleSmartMatchMusic$CheckAudioHasMusicRsp.class);
    public final PBBoolField has_music = PBField.initBool(false);
}
