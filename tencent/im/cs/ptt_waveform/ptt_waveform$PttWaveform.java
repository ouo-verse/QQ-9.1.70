package tencent.im.cs.ptt_waveform;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class ptt_waveform$PttWaveform extends MessageMicro<ptt_waveform$PttWaveform> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin32_size", "bytes_amplitudes"}, new Object[]{0, ByteStringMicro.EMPTY}, ptt_waveform$PttWaveform.class);
    public final PBUInt32Field uin32_size = PBField.initUInt32(0);
    public final PBBytesField bytes_amplitudes = PBField.initBytes(ByteStringMicro.EMPTY);
}
